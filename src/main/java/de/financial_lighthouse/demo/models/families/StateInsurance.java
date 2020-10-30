package de.financial_lighthouse.demo.models.families;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Angaben zum Versicherungsstatus einer Person.
 */
public class StateInsurance {

    @JsonProperty("health")
    private boolean health = true;
    @JsonProperty("pension")
    private boolean pension = true;
    @JsonProperty("unemployment")
    private boolean unemployment = true;

    /**
     * Wenn <code>true</code>, ist eine Krankenversicherung vorhanden.
     */
    public boolean getHealth() {
        return health;
    }

    /**
     * Wenn <code>true</code>, ist eine Krankenversicherung vorhanden.
     */
    public StateInsurance setHealth(boolean health) {
        this.health = health;
        return this;
    }

    /**
     * Wenn <code>true</code>, ist eine Rentenversicherung vorhanden.
     */
    public boolean getPension() {
        return pension;
    }

    /**
     * Wenn <code>true</code>, ist eine Rentenversicherung vorhanden.
     */
    public StateInsurance setPension(boolean pension) {
        this.pension = pension;
        return this;
    }

    /**
     * Wenn <code>true</code>, ist eine Arbeitslosenversicherung vorhanden.
     */
    public boolean getUnemployment() {
        return unemployment;
    }

    /**
     * Wenn <code>true</code>, ist eine Arbeitslosenversicherung vorhanden.
     */
    public StateInsurance setUnemployment(boolean unemployment) {
        this.unemployment = unemployment;
        return this;
    }

}
