package de.financial_lighthouse.demo.models.data;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import de.financial_lighthouse.demo.models.HasId;

/**
 * Ein Eingabedatum, auch "Vorgang" in der Software genannt. Mehrere dieser
 * Eingabedaten erfassen den Status Quo des Kunden in einem Plan und dienen als
 * eine der Berechnungsgrundlagen von Auswertungen.
 */
@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "type", defaultImpl = UnknownData.class)
@JsonSubTypes({
    @JsonSubTypes.Type(value = Bonus.class, name = Bonus.TYPENAME),
    @JsonSubTypes.Type(value = CompanyCar.class, name = CompanyCar.TYPENAME),
    @JsonSubTypes.Type(value = Deposit.class, name = Deposit.TYPENAME),
    @JsonSubTypes.Type(value = EmployedIncome.class, name = EmployedIncome.TYPENAME),
    @JsonSubTypes.Type(value = LivingCosts.class, name = LivingCosts.TYPENAME),
    @JsonSubTypes.Type(value = MaintenanceReserve.class, name = MaintenanceReserve.TYPENAME),
    @JsonSubTypes.Type(value = MonetaryAdvantage.class, name = MonetaryAdvantage.TYPENAME),
    @JsonSubTypes.Type(value = OperatingCosts.class, name = OperatingCosts.TYPENAME),
    @JsonSubTypes.Type(value = OwnerProperty.class, name = OwnerProperty.TYPENAME),
    @JsonSubTypes.Type(value = Security.class, name = Security.TYPENAME),
    @JsonSubTypes.Type(value = SelfEmployedIncome.class, name = SelfEmployedIncome.TYPENAME)
})
public abstract class PlanData extends HasId<UUID> {

    // @JsonProperty("type")
    // protected String type;
    @JsonProperty("name")
    protected String name;
    @JsonProperty("owner")
    protected Owner owner = new Owner();
    @JsonProperty("scenarioParameter")
    protected ScenarioParameters scenarioParameter;
    @JsonProperty("currency")
    protected Currency currency = Currency.EUR;

    // /**
    //  * Der Typ des Vorgangs.
    //  */
    // @JsonProperty("type")
    // public String getType() {
    //     return type;
    // }

    /**
     * Der Name des Vorgangs.
     */
    public String getName() {
        return name;
    }

    /**
     * Der Name des Vorgangs.
     */
    public PlanData setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Die Person, auf die sich der Vorgang bezieht.
     */
    public Owner getOwner() {
        return owner;
    }

    /**
     * Die Person, auf die sich der Vorgang bezieht.
     */
    public PlanData setOwner(Owner owner) {
        this.owner = owner;
        return this;
    }

    /**
     * Die Währung des Vorgangs.
     */
    public Currency getCurrency() {
        return currency;
    }

    /**
     * Die Währung des Vorgangs.
     */
    public PlanData setCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }

}
