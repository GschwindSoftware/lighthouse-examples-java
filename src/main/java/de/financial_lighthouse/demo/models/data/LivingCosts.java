package de.financial_lighthouse.demo.models.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

/**
 * Vorgang "Lebensunterhaltskosten"
 */
@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "type")
public class LivingCosts extends PlanData {
    
    protected static final String TYPENAME = "LivingCosts";

    @JsonProperty("cashFlows")
    private CashFlows cashFlows;
    @JsonProperty("termination")
    private Moment termination;

    /**
     * Zahlungen.
     */
    public CashFlows getCashFlows() {
        return cashFlows;
    }

    /**
     * Zahlungen.
     */
    public LivingCosts setCashFlows(CashFlows cashFlows) {
        this.cashFlows = cashFlows;
        return this;
    }

    /**
     * Ende der Zahlungen.
     */
    public Moment getTermination() {
        return termination;
    }

    /**
     * Ende der Zahlungen.
     */
    public LivingCosts setTermination(Moment termination) {
        this.termination = termination;
        return this;
    }

}
