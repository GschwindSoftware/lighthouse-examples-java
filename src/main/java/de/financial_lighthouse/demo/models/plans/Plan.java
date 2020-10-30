package de.financial_lighthouse.demo.models.plans;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.lang.Nullable;

import de.financial_lighthouse.demo.models.HasId;

/**
 * Ein Finanzplan, der zu einem <code>Client</code> gehört und alle relevanten Plandaten enthält.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Plan extends HasId<Integer> {

    @JsonProperty("type")
    private PlanType type = PlanType.FinancialEstate;
    @JsonProperty("clientGuid")
    private UUID clientContact;
    @JsonProperty("clientId")
    private int clientId;
    @JsonProperty("clientName")
    private String clientName;
    @JsonProperty("creationDate")
    private LocalDateTime creationDate;
    @JsonProperty("description")
    private String description;
    @JsonProperty("locked")
    private boolean locked;
    @JsonProperty("planningDate")
    private LocalDateTime planningDate = LocalDateTime.now();
    @JsonProperty("publish")
    private PublishType publish = PublishType.Invisible;
    @JsonProperty("userName")
    private String userName;

    /**
     * Der Typ des Plans.
     */
    public PlanType getType() {
        return type;
    }

    /**
     * Der Typ des Plans.
     */
    public Plan setType(PlanType type) {
        this.type = type;
        return this;
    }

    /**
     * Der eindeutige Schlüssel des Kunden, zu dem der Plan gehört.
     * @deprecated Wird in Zukunft mit {@link getClientId} zusammengelegt
     */
    public @Nullable UUID getClientContact() {
        return clientContact;
    }

    /**
     * Der eindeutige Schlüssel des Kunden in der Kundenverwalung.
     * @deprecated Wird in Zukunft mit {@link getClientId} zusammengelegt
     */
    public Plan setClientContact(@Nullable UUID clientContact) {
        this.clientContact = clientContact;
        return this;
    }

    /**
     * Der eindeutige Schlüssel des Kunden, zu dem der Plan gehört.
     */
    public int getClientId() {
        return clientId;
    }

    /**
     * Der vollständige Name des Kunden, zu dem der Plan gehört.
     */
    public @Nullable String getClientName() {
        return clientName;
    }

    /**
     * Das Datum, wann der Plan angelegt wurde.
     */
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    /**
     * Die Bezeichnung des Plans.
     */
    public @Nullable String getDescription() {
        return description;
    }

    /**
     * Die Bezeichnung des Plans.
     */
    public Plan setDescription(@Nullable String description) {
        this.description = description;
        return this;
    }

    /**
     * Der Status des Plans. Ein abgeschlossener Plan kann nicht verändert werden.
     */
    public boolean getLocked() {
        return locked;
    }

    /**
     * Der Status des Plans. Ein abgeschlossener Plan kann nicht verändert werden.
     */
    public Plan setLocked(boolean locked) {
        this.locked = locked;
        return this;
    }

    /**
     * Das Planungsdatum des Plans.
     */
    public LocalDateTime getPlanningDate() {
        return planningDate;
    }

    /**
     * Das Planungsdatum des Plans.
     */
    public Plan setPlanningDate(LocalDateTime planningDate) {
        this.planningDate = planningDate;
        return this;
    }

    /**
     * Der Veröffentlichungstyp des Plans.
     */
    public PublishType getPublish() {
        return publish;
    }

    /**
     * Der Veröffentlichungstyp des Plans.
     */
    public Plan setPublish(PublishType publish) {
        this.publish = publish;
        return this;
    }

    /**
     * Der Benutzer, der den Plan gespeichert hat.
     */
    public @Nullable String getUserName() {
        return userName;
    }

}
