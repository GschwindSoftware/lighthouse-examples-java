package de.financial_lighthouse.demo.models.data;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Parameter von Risikioszenarien.
 */
public class ScenarioParameters {

    @JsonProperty("death")
    private double death;
    @JsonProperty("disability")
    private double disability;
    @JsonProperty("illness")
    private double illness;
    @JsonProperty("normalCase")
    private double normal;
    @JsonProperty("nursingCase")
    private double nursing;

    /**
     * Veränderung im Szenario "Todesfall" in Prozent.
     */
    public double getDeath() {
        return death;
    }
    
    /**
     * Veränderung im Szenario "Todesfall" in Prozent.
     */
    public ScenarioParameters setDeath(double death) {
        this.death = death;
        return this;
    }

    /**
     * Veränderung im Szenario "Berufsunfähigkeit" in Prozent.
     */
    public double getDisability() {
        return disability;
    }
    
    /**
     * Veränderung im Szenario "Berufsunfähigkeit" in Prozent.
     */
    public ScenarioParameters setDisability(double disability) {
        this.disability = disability;
        return this;
    }

    /**
     * Veränderung im Szenario "Krankheit" in Prozent.
     */
    public double getIllness() {
        return illness;
    }
    
    /**
     * Veränderung im Szenario "Krankheit" in Prozent.
     */
    public ScenarioParameters setIllness(double illness) {
        this.illness = illness;
        return this;
    }

    /**
     * Veränderung im Normalfall in Prozent.
     */
    public double getNormal() {
        return normal;
    }
    
    /**
     * Veränderung im Normalfall in Prozent.
     */
    public ScenarioParameters setNormal(double normal) {
        this.normal = normal;
        return this;
    }

    /**
     * Veränderung im Szenario "Pflegefall" in Prozent.
     */
    public double getNursing() {
        return nursing;
    }
    
    /**
     * Veränderung im Szenario "Pflegefall" in Prozent.
     */
    public ScenarioParameters setNursing(double nursing) {
        this.nursing = nursing;
        return this;
    }
    
}
