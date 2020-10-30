package de.financial_lighthouse.demo.models.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

/**
 * Vorgang "Geldwerter Vorteil".
 */
@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "type")
public class MonetaryAdvantage extends PlanData {

    protected static final String TYPENAME = "MonetaryAdvantage";
    
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
    public MonetaryAdvantage getCashFlows(CashFlows cashFlows) {
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
    public MonetaryAdvantage getPaymentMonth(int paymentMonth) {
        this.paymentMonth = paymentMonth;
        return this;
    }

}
