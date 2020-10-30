package de.financial_lighthouse.demo.models.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

/**
 * Vorgang "Dienstwagen".
 */
@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "type")
public class CompanyCar extends PlanData {
    
    protected static final String TYPENAME = "CompanyCar";

    @JsonProperty("distanceToWork")
    private int distanceToWork;
    @JsonProperty("originalValue")
    private double originalValue;

    /**
     * Entfernung zum Arbeitsplatz in km.
     */
    public int getDistanceToWork() {
        return distanceToWork;
    }

    /**
     * Entfernung zum Arbeitsplatz in km.
     */
    public CompanyCar setDistanceToWork(int distanceToWork) {
        this.distanceToWork = distanceToWork;
        return this;
    }

    /**
     * Neuwert des Wagens.
     */
    public double getOriginalValue() {
        return originalValue;
    }

    /**
     * Neuwert des Wagens.
     */
    public CompanyCar setOriginalValue(double originalValue) {
        this.originalValue = originalValue;
        return this;
    }

}
