package de.financial_lighthouse.demo.models.data;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Ein Zahlungsstrom.
 */
public class CashFlow {
    
    @JsonProperty("date")
    private LocalDateTime date;
    @JsonProperty("value")
    private double value;

    /**
     * Das Datum des Zahlungsstroms.
     */
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * Das Datum des Zahlungsstroms.
     */
    public CashFlow setDate(LocalDateTime date) {
        this.date = date;
        return this;
    }

    /**
     * Der Wert des Zahlungsstroms.
     */
    public double getValue() {
        return value;
    }

    /**
     * Das Datum des Zahlungsstroms.
     */
    public CashFlow setValue(double value) {
        this.value = value;
        return this;
    }

}
