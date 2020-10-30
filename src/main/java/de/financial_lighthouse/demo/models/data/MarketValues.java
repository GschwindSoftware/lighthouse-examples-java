package de.financial_lighthouse.demo.models.data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.lang.Nullable;

/**
 * Marktwerte.
 */
public class MarketValues {
    
    @JsonProperty("increase")
    private double increase;
    @JsonProperty("values")
    private List<CashFlow> values;
    
    /**
     * Wertsteigerung nach dem letzten eingetragenen Verkehrswert
     */
    public double getIncrease() {
        return increase;
    }
    
    /**
     * Wertsteigerung nach dem letzten eingetragenen Verkehrswert
     */
    public MarketValues setIncrease(double increase) {
        this.increase = increase;
        return this;
    }

    /**
     * Zahlungsflüsse
     */
    public @Nullable List<CashFlow> getValues() {
        return values;
    }

    /**
     * Zahlungsflüsse
     */
    public MarketValues setValues(@Nullable List<CashFlow> values) {
        this.values = values;
        return this;
    }

}
