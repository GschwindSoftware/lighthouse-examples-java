package de.financial_lighthouse.demo.models.data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * EIne Sammlung von Zahlungsströmen.
 */
public class CashFlows {
    
    @JsonProperty("increases")
    private List<CashFlow> increases;
    @JsonProperty("period")
    private PeriodType period = PeriodType.Yearly;
    @JsonProperty("values")
    private List<CashFlow> values;
    
    /**
     * Steigerungen zu Zeitpunkten.
     */
    public List<CashFlow> getIncreases() {
        return increases;
    }

    /**
     * Steigerungen zu Zeitpunkten.
     */
    public CashFlows setIncreases(List<CashFlow> increases) {
        this.increases = increases;
        return this;
    }

    /**
     * Der Zahlungsintervall
     */
    public PeriodType getPeriod() {
        return period;
    }

    /**
     * Der Zahlungsintervall
     */
    public CashFlows setPeriod(PeriodType period) {
        this.period = period;
        return this;
    }

    /**
     * Die Einkünfte ab den angegebenen Zeitpunkten.
     */
    public List<CashFlow> getValues() {
        return values;
    }

    /**
     * Die Einkünfte ab den angegebenen Zeitpunkten.
     */
    public CashFlows setValues(List<CashFlow> values) {
        this.values = values;
        return this;
    }

}
