package de.financial_lighthouse.demo.models.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

/**
 * Vorgang "Einkunft aus selbständiger Arbeit"
 */
@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "type")
public class SelfEmployedIncome extends PlanData {

    protected static final String TYPENAME = "SelfEmployedIncome";
 
    @JsonProperty("cashFlows")
    private CashFlows cashFlows;
    @JsonProperty("termination")
    private Moment termination;

    /**
     * Die Einkünfte und Steigerungen.
     */
    public CashFlows getCashFlows() {
        return cashFlows;
    }

    /**
     * Die Einkünfte und Steigerungen.
     */
    public SelfEmployedIncome setCashFlows(CashFlows cashFlows) {
        this.cashFlows = cashFlows;
        return this;
    }

    /**
     * Das Ende der Beschäftigung.
     */
    public Moment getTermination() {
        return termination;
    }

    /**
     * Das Ende der Beschäftigung.
     */
    public SelfEmployedIncome setTermination(Moment termination) {
        this.termination = termination;
        return this;
    }

}
