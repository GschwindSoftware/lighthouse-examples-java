package de.financial_lighthouse.demo.models.data;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import org.springframework.lang.Nullable;

import de.financial_lighthouse.demo.util.Dates;

/**
 * Vorgang "Wertpapier"
 */
@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "type")
public class Security extends PlanData {
    
    protected static final String TYPENAME = "Security";

    @JsonProperty("agio")
    private double agio;
    @JsonProperty("appreciations")
    private List<CashFlow> appreciations;
    @JsonProperty("buying")
    private Purchase purchase;
    @JsonProperty("depotName")
    private String depotName;
    @JsonProperty("dividendPayout")
    private LocalDateTime dividendPayout = Dates.endOfYear();
    @JsonProperty("dividends")
    private List<CashFlow> dividends;
    @JsonProperty("industry")
    private String industry = "Sonstige";
    @JsonProperty("isin")
    private String isin;
    @JsonProperty("isTaxable")
    private boolean isTaxable = true;
    @JsonProperty("maturityDate")
    private LocalDateTime maturityDate;
    @JsonProperty("quantity")
    private double quantity;
    @JsonProperty("rating")
    private String rating;
    @JsonProperty("region")
    private String region = "Deutschland";
    @JsonProperty("riskLevel")
    private RiskLevel riskLevel = RiskLevel.NotCritical;
    @JsonProperty("securityPrice")
    private double securityPrice;
    @JsonProperty("securityType")
    private SecurityType securityType = SecurityType.Stock;
    @JsonProperty("selling")
    private Sale sale;
    @JsonProperty("valueDate")
    private LocalDateTime valueDate = LocalDateTime.now();

    /** 
     * Agio beim Kauf
     */
    public double getAgio() {
        return agio;
    }

    /** 
     * Agio beim Kauf
     */
    public Security setAgio(double agio) {
        this.agio = agio;
        return this;
    }

    /** 
     * Wertsteigerungen
     */
    public @Nullable List<CashFlow> getAppreciations() {
        return appreciations;
    }

    /** 
     * Wertsteigerungen
     */
    public Security setAppreciations(@Nullable List<CashFlow> appreciations) {
        this.appreciations = appreciations;
        return this;
    }

    /** 
     * Kauf
     */
    public Purchase getPurchase() {
        return purchase;
    }

    /** 
     * Kauf
     */
    public Security setPurchase(Purchase purchase) {
        this.purchase = purchase;
        return this;
    }

    /** 
     * Name des Depots
     */
    public @Nullable String getDepotName() {
        return depotName;
    }

    /** 
     * Name des Depots
     */
    public Security setDepotName(@Nullable String depotName) {
        this.depotName = depotName;
        return this;
    }

    /** 
     * Dividendenausschüttung
     */
    public LocalDateTime getDividendPayout() {
        return dividendPayout;
    }

    /** 
     * Dividendenausschüttung
     */
    public Security setDividendPayout(LocalDateTime dividendPayout) {
        this.dividendPayout = dividendPayout;
        return this;
    }

    /** 
     * Ausschüttungen
     */
    public List<CashFlow> getDividends() {
        return dividends;
    }

    /** 
     * Ausschüttungen
     */
    public Security setDividends(List<CashFlow> dividends) {
        this.dividends = dividends;
        return this;
    }

    /** 
     * Der Industriesektor des Wertpapieres.
     */
    public @Nullable String getIndustry() {
        return industry;
    }

    /** 
     * Der Industriesektor des Wertpapieres.
     */
    public Security setIndustry(@Nullable String industry) {
        this.industry = industry;
        return this;
    }

    /** 
     * Die ISIN-Nummer des Wertpapieres.
     */
    public @Nullable String getIsin() {
        return isin;
    }

    /** 
     * Die ISIN-Nummer des Wertpapieres.
     */
    public Security setIsin(@Nullable String isin) {
        this.isin = isin;
        return this;
    }

    /** 
     * Muss Wertsteigerung und Dividende versteuert werden?
     */
    public boolean getIsTaxable() {
        return isTaxable;
    }

    /** 
     * Muss Wertsteigerung und Dividende versteuert werden?
     */
    public Security setIsTaxable(boolean isTaxable) {
        this.isTaxable = isTaxable;
        return this;
    }

    /** 
     * Fälligkeitsdatum
     */
    public LocalDateTime getMaturityDate() {
        return maturityDate;
    }

    /** 
     * Fälligkeitsdatum
     */
    public Security setMaturityDate(LocalDateTime maturityDate) {
        this.maturityDate = maturityDate;
        return this;
    }

    /** 
     * Stückzahl bei Aktien / Nominalbetrag bei Anleihen
     */
    public double getQuantity() {
        return quantity;
    }

    /** 
     * Stückzahl bei Aktien / Nominalbetrag bei Anleihen
     */
    public Security setQuantity(double quantity) {
        this.quantity = quantity;
        return this;
    }

    /** 
     * Rating
     */
    public @Nullable String getRating() {
        return rating;
    }

    /** 
     * Rating
     */
    public Security setRating(@Nullable String rating) {
        this.rating = rating;
        return this;
    }

    /** 
     * Die Region des Wertpapieres.
     */
    public @Nullable String getRegion() {
        return region;
    }

    /** 
     * Die Region des Wertpapieres.
     */
    public Security setRegion(@Nullable String region) {
        this.region = region;
        return this;
    }

    /** 
     * Risikostufe
     */
    public RiskLevel getRiskLevel() {
        return riskLevel;
    }

    /** 
     * Risikostufe
     */
    public Security setRiskLevel(RiskLevel riskLevel) {
        this.riskLevel = riskLevel;
        return this;
    }

    /** 
     * Kurs
     */
    public double getSecurityPrice() {
        return securityPrice;
    }

    /** 
     * Kurs
     */
    public Security setSecurityPrice(double securityPrice) {
        this.securityPrice = securityPrice;
        return this;
    }

    /** 
     * Der Typ des Wertpapieres.
     */
    public SecurityType getSecurityType() {
        return securityType;
    }

    /** 
     * Der Typ des Wertpapieres.
     */
    public Security setSecurityType(SecurityType securityType) {
        this.securityType = securityType;
        return this;
    }

    /** 
     * Verkauf
     */
    public Sale getSale() {
        return sale;
    }

    /** 
     * Verkauf
     */
    public Security setSale(Sale sale) {
        this.sale = sale;
        return this;
    }

    /** 
     * Wertstellungsdatum
     */
    public LocalDateTime getValueDate() {
        return valueDate;
    }

    /** 
     * Wertstellungsdatum
     */
    public Security setValueDate(LocalDateTime valueDate) {
        this.valueDate = valueDate;
        return this;
    }

    public Security() {
        maturityDate = Dates.yearsFromNow(10);
    }

}
