package de.financial_lighthouse.demo;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.lang.Nullable;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;

import de.financial_lighthouse.demo.models.*;
import de.financial_lighthouse.demo.models.clients.Client;
import de.financial_lighthouse.demo.models.data.PlanData;
import de.financial_lighthouse.demo.models.families.FamilyTree;
import de.financial_lighthouse.demo.models.plans.Plan;
import de.financial_lighthouse.demo.models.reports.LiquidityReportType;
import de.financial_lighthouse.demo.models.reports.Report;
import de.financial_lighthouse.demo.models.reports.ReportParameters;
import de.financial_lighthouse.demo.query.Query;

/**
 * Kommuniziert mit der Financial Lighthouse API.
 */
public class LighthouseClient {

    private final String baseUrl = "https://api.financial-lighthouse.de/%s";
    private final Logger logger = LoggerFactory.getLogger(LighthouseClient.class);
    private final ClientCredentialsResourceDetails resourceDetails;

    /**
     * Erzeugt ein neues Objekt der {@link LighthouseClient}-Klasse.
     * @param resourceDetails Die Anmeldeinformationen des Clients.
     */
    public LighthouseClient(ClientCredentialsResourceDetails resourceDetails) {
        this.resourceDetails = resourceDetails;
    }

    // #region Hilfsmethoden

    private OAuth2RestTemplate restTemplate() {
        var template = new OAuth2RestTemplate(resourceDetails);
        for (var conv : template.getMessageConverters())
            if (conv instanceof MappingJackson2HttpMessageConverter) {
                var jacksonMapper = (MappingJackson2HttpMessageConverter)conv;
                var mapper = jacksonMapper.getObjectMapper()
                    .registerModule(new JavaTimeModule())
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                    .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                    .setSerializationInclusion(Include.NON_NULL)
                    .enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS);
                jacksonMapper.setObjectMapper(mapper);
            }
        
        return template;
    }

    private String getUrl(String path) {
        if (path.startsWith("/"))
            path = path.substring(1);

        return String.format(baseUrl, path);
    }

    private void logRequest(String url, HttpMethod method, ResponseEntity<?> response) {
        var status = response.getStatusCode();
        logger.info(String.format("%s %s: %d %s", method, url, status.value(), status.name()));
    }

    private @Nullable <T> T get(ParameterizedTypeReference<T> type, String pathTemplate, Object... pathArgs) {
        var url = getUrl(String.format(pathTemplate, pathArgs));
        var method = HttpMethod.GET;

        var response = restTemplate().exchange(url, method, null, type);
        logRequest(url, method, response);

        if (response.getStatusCode().is2xxSuccessful())
            return response.getBody();

        return null;
    }

    private <T> void update(ParameterizedTypeReference<T> type, T obj, String pathTemplate, Object... pathArgs) throws Exception {
        var url = getUrl(String.format(pathTemplate, pathArgs));
        var method = HttpMethod.PUT;

        var response = restTemplate().exchange(url, method, new HttpEntity<>(obj), type);
        logRequest(url, method, response);

        if (!response.getStatusCode().is2xxSuccessful())
            throw new Exception(response.getStatusCode().getReasonPhrase());
    }

    private <T> QueryResult<T> query(@Nullable Query q, String pathTemplate, Object... pathArgs) {
        if (q == null)
            q = new Query();

        var type = new ParameterizedTypeReference<QueryResult<T>>() {};
        var url = getUrl(String.format(pathTemplate, pathArgs));
        var method = HttpMethod.POST;

        var response = restTemplate().exchange(url, method, new HttpEntity<>(q), type);
        logRequest(url, method, response);

        return response.getBody();
    }

    private <T extends HasId<TId>, TId> TId createAndReturnId(ParameterizedTypeReference<T> type, T obj, String pathTemplate, Object... pathArgs) throws Exception {
        var url = getUrl(String.format(pathTemplate, pathArgs));
        var method = HttpMethod.POST;

        var response = restTemplate().exchange(url, method, new HttpEntity<>(obj), type);
        logRequest(url, method, response);
        
        if (response.getStatusCode().is2xxSuccessful())
            return response.getBody().getID();
        
        throw new Exception(response.getStatusCode().getReasonPhrase());
    }

    private <TBody, TResult> TResult createAndReturnContent(ParameterizedTypeReference<TResult> type, TBody obj, String pathTemplate, Object... pathArgs) throws Exception {
        var url = getUrl(String.format(pathTemplate, pathArgs));
        var method = HttpMethod.POST;

        var response = restTemplate().exchange(url, method, new HttpEntity<>(obj), type);
        logRequest(url, method, response);
        
        if (response.getStatusCode().is2xxSuccessful())
            return response.getBody();
        
        throw new Exception(response.getStatusCode().getReasonPhrase());
    }

    private <TId> void deleteById(String pathTemplate, Object... pathArgs) {
        var url = getUrl(String.format(pathTemplate, pathArgs));
        restTemplate().delete(url);
    }

    // #endregion

    // #region Clients

    /**
     * Ruft einen Kunden ab.
     * @param id Der eindeutige Schlüssel des Kundens.
     * @return Das gefundene Element oder <code>null</code>, falls nicht gefunden.
     */
    public @Nullable Client getClient(int id) {
        return get(new ParameterizedTypeReference<Client>() {}, "/fin/Clients/%d", id);
    }

    /**
     * Fragt Kunden ab.
     * @param q Die Suchkriterien.
     * @return Die Suchtreffer.
     */
    public QueryResult<Client> queryClients(@Nullable Query q) {
        return query(q, "/fin/Clients/Query");
    }

    /**
     * Legt einen neuen Kunden an.
     * @param c Der anzulegende Kunde.
     * @return Der eindeutige Schlüssel des angelegten Kundens.
     * @throws Exception Fehler beim Aufruf der API.
     */
    public int createClient(Client c) throws Exception {
        return createAndReturnId(new ParameterizedTypeReference<Client>() {},  c, "/fin/Clients");
    }

    /**
     * Aktualisiert einen bestehenden Kunden.
     * @param c Der abgeänderte Kunde.
     * @throws Exception Fehler beim Aufruf der API.
     */
    public void updateClient(Client c) throws Exception {
        update(new ParameterizedTypeReference<Client>() {}, c, "/fin/Clients/%d", c.getID());
    }

    /**
     * Löscht einen Kunden.
     * @param id Der eindeutige Schlüssel des zu löschenden Kundens.
     */
    public void deleteClient(int id) {
        deleteById("/fin/Clients/%d", id);
    }

    // #endregion

    // #region Plans

    /**
     * Ruft einen Finanzplan ab.
     * @param id Der eindeutige Schlüssel des Finanzplans.
     * @return Das gefundene Element oder <code>null</code>, falls nicht gefunden.
     */
    public @Nullable Plan getPlan(int id) {
        return get(new ParameterizedTypeReference<Plan>() {}, "/fin/Plans/%d", id);
    }

    /**
     * Fragt Finanzpläne ab.
     * @param q Die Suchkriterien.
     * @return Die Suchtreffer.
     */
    public QueryResult<Plan> queryPlans(@Nullable Query q) {
        return query(q, "/fin/Plans/Query");
    }

    /**
     * Legt einen neuen Finanzplan an.
     * @param clientID Der eindeutige Schlüssel des Kunden, zu dem der Finanzplan angelegt werden soll.
     * @param p Der anzulegende Finanzplan.
     * @return Der eindeutige Schlüssel des angelegten Plans.
     * @throws Exception Fehler beim Aufruf der API.
     */
    public int createPlan(int clientID, Plan p) throws Exception {
        return createAndReturnId(new ParameterizedTypeReference<Plan>() {}, p, "/fin/Plans/ByClient/%d", clientID);
    }

    /**
     * Aktualisiert einen bestehenden Finanzplan.
     * @param p Der abgeänderte Finanzplan.
     * @throws Exception Fehler beim Aufruf der API.
     */
    public void updatePlan(Plan p) throws Exception {
        update(new ParameterizedTypeReference<Plan>() {}, p, "/fin/Plans/%d", p.getID());
    }

    /**
     * Löscht einen Finanzplan.
     * @param id Der eindeutige Schlüssel des zu löschenden Finanzplans.
     */
    public void deletePlan(int id) {
        deleteById("/fin/Plans/%d", id);
    }

    // #endregion

    // #region Family

    /**
     * Ruft den Familienstammbaum in einem Finanzplan ab.
     * @param planID Der eindeutige Schlüssel des Finanzplans, aus dem der Familienstammbaum abgerufen werden soll.
     * @return Das gefundene Element oder <code>null</code>, falls nicht gefunden.
     */
    public @Nullable FamilyTree getFamily(int planID) {
        return get(new ParameterizedTypeReference<FamilyTree>() {}, "/fin/Plans/%d/Family", planID);
    }

    /**
     * Aktualisiert den Familienstammbaum in einem Finanzplan.
     * @param f Der abgeänderte Familienstammbaum.
     * @throws Exception Fehler beim Aufruf der API.
     */
    public void updateFamily(int planID, FamilyTree f) throws Exception {
        update(new ParameterizedTypeReference<FamilyTree>() {}, f, "/fin/Plans/%d/Family", planID);
    }

    // #endregion

    // #region Data

    /**
     * Ruft einen Finanzvorgang ab.
     * @param planID Der eindeutige Schlüssel des Finanzplans, in dem sich der Finanzvorgang befindet.
     * @param id Der eindeutige Schlüssel des Finanzvorgangs.
     * @return Das gefundene Element oder <code>null</code>, falls nicht gefunden.
     */
    public @Nullable PlanData getPlanData(int planID, UUID id) {
        return get(new ParameterizedTypeReference<PlanData>() {}, "/fin/Plans/%d/Data/%s", planID, id);
    }

    /**
     * Fragt Finanzvorgänge ab.
     * @param planID Der eindeutige Schlüssel des Finanzplans, in dem sich die Finanzvorgänge befinden.
     * @param q Die Suchkriterien.
     * @return Die Suchtreffer.
     */
    public QueryResult<PlanData> queryPlanData(int planID, @Nullable Query q) {
        return query(q, "/fin/Plans/%d/Data/Query", planID);
    }

    /**
     * Legt einen neuen Finanzvorgang an.
     * @param planID Der eindeutige Schlüssel des Finanzplans, in dem der Finanzvorgang angelegt werden soll.
     * @param p Der anzulegende Finanzvorgang.
     * @return Der eindeutige Schlüssel des angelegten Finanzvorgangs.
     * @throws Exception Fehler beim Aufruf der API.
     */
    public UUID createPlanData(int planID, PlanData p) throws Exception {
        return createAndReturnId(new ParameterizedTypeReference<PlanData>() {}, p, "/fin/Plans/%d/Data", planID);
    }

    /**
     * Aktualisiert einen bestehenden Finanzvorgang.
     * @param planID Der eindeutige Schlüssel des Finanzplans, in dem sich der Finanzvorgang befindet.
     * @param p Der abgeänderte Finanzvorgang.
     * @throws Exception Fehler beim Aufruf der API.
     */
    public void updatePlanData(int planID, PlanData p) throws Exception {
        update(new ParameterizedTypeReference<PlanData>() {}, p, "/fin/Plans/%d/Data/%s", planID, p.getID());
    }

    /**
     * Löscht einen Finanzvorgang.
     * @param planID Der eindeutige Schlüssel des Finanzplans, in dem sich der Finanzvorgang befindet.
     * @param id Der eindeutige Schlüssel des zu löschenden Finanzvorgang.
     */
    public void deletePlanData(int planID, UUID id) {
        deleteById("/fin/Plans/%d/Data/%s", planID, id);
    }

    // #endregion

    /**
     * Generiert eine Liquiditätsauswertung.
     * @param type Der Typ der Liquiditätsauswertung.
     * @param planID Der Finanzplan, für den die Auswertung berechnet wird.
     * @param parameters Parameter der Liquiditätsauswertung.
     * @return Die generierte Auswertung.
     */
    public @Nullable Report generateLiquidityReport(LiquidityReportType type, int planID, ReportParameters parameters) throws Exception {
        return createAndReturnContent(new ParameterizedTypeReference<Report>() {}, parameters, "/fin/Liquidity/%s/%d", type, planID);
    }

}
