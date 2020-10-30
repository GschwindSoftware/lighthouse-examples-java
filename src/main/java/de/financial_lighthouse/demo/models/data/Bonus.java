package de.financial_lighthouse.demo.models.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

/**
 * Vorgang "Bonus".
 */
@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "type")
public class Bonus extends PlanData {

    protected static final String TYPENAME = "Bonus";
    
    @JsonProperty("cashFlows")
    private CashFlows cashFlows;
    @JsonProperty("paymentMonth")
    private int paymentMonth;

    /**
     * Bonuszahlungen.
     */
    public CashFlows getCashFlows() {
        return cashFlows;
    }

    /**
     * Bonuszahlungen.
     */
    public Bonus getCashFlows(CashFlows cashFlows) {
        this.cashFlows = cashFlows;
        return this;
    }

    /**
     * Monat der Zahlung.
     */
    public int getPaymentMonth() {
        return paymentMonth;
    }

    /**
     * Monat der Zahlung.
     */
    public Bonus getPaymentMonth(int paymentMonth) {
        this.paymentMonth = paymentMonth;
        return this;
    }

}
