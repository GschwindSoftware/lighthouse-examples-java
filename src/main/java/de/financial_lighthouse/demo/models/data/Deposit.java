package de.financial_lighthouse.demo.models.data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import org.springframework.lang.Nullable;

/**
 * Vorgang "Depot"
 */
@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "type")
public class Deposit extends PlanData {
    
    protected static final String TYPENAME = "Deposit";

    @JsonProperty("accountNumber")
    private String accountNumber;
    @JsonProperty("annualFeeMaximum")
    private double annualFeeMaximum;
    @JsonProperty("annualFeeRate")
    private double annualFeeRate;
    @JsonProperty("institute")
    private String institute;
    @JsonProperty("isFeeTaxable")
    private boolean isFeeTaxable;
    @JsonProperty("securities")
    private List<Security> securities;
    @JsonProperty("selling")
    private Sale sale = new Sale();
    @JsonProperty("taxableFeeRate")
    private double taxableFeeRate = 50.0;

    /**
     * Kontonu+mmer.
     */
    public @Nullable String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Kontonu+mmer.
     */
    public Deposit setAccountNumber(@Nullable String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    /**
     * Maximale Jahresgebühr (EUR).
     */
    public double getAnnualFeeMaximum() {
        return annualFeeMaximum;
    }

    /**
     * Maximale Jahresgebühr (EUR).
     */
    public Deposit setAnnualFeeMaximum(double annualFee) {
        this.annualFeeMaximum = annualFee;
        return this;
    }

    /**
     * Jährliche Gebühr in %.
     */
    public double getAnnualFeeRate() {
        return annualFeeRate;
    }

    /**
     * Jährliche Gebühr in %.
     */
    public Deposit setAnnualFeeRate(double annualFee) {
        this.annualFeeRate = annualFee;
        return this;
    }

    /**
     * Name des Instituts.
     */
    public @Nullable String getInstitute() {
        return institute;
    }

    /**
     * Name des Instituts.
     */
    public Deposit setInstitute(@Nullable String institute) {
        this.institute = institute;
        return this;
    }

    /**
     * Sind die Gebühren steuerlich relevant?.
     */
    public boolean getIsFeeTaxable() {
        return isFeeTaxable;
    }

    /**
     * Sind die Gebühren steuerlich relevant?.
     */
    public Deposit setIsFeeTaxable(boolean isFeeT) {
        this.isFeeTaxable = isFeeT;
        return this;
    }

    /**
     * Die enthaltenen Wertpapiere.
     */
    public @Nullable List<Security> getSecurities() {
        return securities;
    }

    /**
     * Die enthaltenen Wertpapiere.
     */
    public Deposit setSecurities(@Nullable List<Security> securities) {
        this.securities = securities;
        return this;
    }

    /**
     * Verkauf.
     */
    public Sale getSale() {
        return sale;
    }

    /**
     * Verkauf.
     */
    public Deposit setSale(Sale sal) {
        this.sale = sal;
        return this;
    }

    /**
     * Steuerlich zu berücksichtigender Anteil der Gebühren in %.
     */
    public double getTaxableFeeRate() {
        return taxableFeeRate;
    }

    /**
     * Steuerlich zu berücksichtigender Anteil der Gebühren in %.
     */
    public Deposit setTaxableFeeRate(double taxableFee) {
        this.taxableFeeRate = taxableFee;
        return this;
    }

}
