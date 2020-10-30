package de.financial_lighthouse.demo.models.families;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

/**
 * 	Der Kunde innerhalb einer Familie. Jede Familie muss genau einen Kunden enthalten.
 */
@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "type")
public class ClientF extends FamilyMember {
    
    protected static final String TYPENAME = "Customer";

    @JsonProperty("churchTaxDuty")
    private boolean churchTaxDuty = true;
    @JsonProperty("healthInsurance")
    private HealthInsurance healthInsurance;
    @JsonProperty("isMarried")
    private boolean isMarried = true;
    @JsonProperty("jointTaxation")
    private boolean jointTaxation = true;
    @JsonProperty("occupationalGroup")
    private OccupationalGroup occupationalGroup = OccupationalGroup.Employee;
    @JsonProperty("retirementAge")
    private int retirementAge = 65;
    @JsonProperty("stateInsurances")
    private StateInsurance stateInsurances;

    /**
     * Wenn <code>true</code>, ist der Kunde kirchensteuerpflichtig
     */
    public boolean getChurchTaxDuty() {
        return churchTaxDuty;
    }

    /**
     * Wenn <code>true</code>, ist der Kunde kirchensteuerpflichtig
     */
    public ClientF setChurchTaxDuty(boolean churchTaxDuty) {
        this.churchTaxDuty = churchTaxDuty;
        return this;
    }

    /**
     * Krankenversicherung
     */
    public HealthInsurance getHealthInsurance() {
        return healthInsurance;
    }

    /**
     * Krankenversicherung
     */
    public ClientF setHealthInsurance(HealthInsurance healthInsurance) {
        this.healthInsurance = healthInsurance;
        return this;
    }

    /**
     * Wenn <code>true</code>, ist der Kunde mit dem Partner verheiratet
     */
    public boolean getIsMarried() {
        return isMarried;
    }

    /**
     * Wenn <code>true</code>, ist der Kunde mit dem Partner verheiratet
     */
    public ClientF setIsMarried(boolean isMarried) {
        this.isMarried = isMarried;
        return this;
    }

    /**
     * Wenn <code>true</code>, sind Kunde und Partner zusammenveranlagt
     */
    public boolean getJointTaxation() {
        return jointTaxation;
    }

    /**
     * Wenn <code>true</code>, sind Kunde und Partner zusammenveranlagt
     */
    public ClientF setJointTaxation(boolean jointTaxation) {
        this.jointTaxation = jointTaxation;
        return this;
    }

    /**
     * Die Berufsgruppe des Kunden
     */
    public OccupationalGroup getOccupationalGroup() {
        return occupationalGroup;
    }

    /**
     * Die Berufsgruppe des Kunden
     */
    public ClientF setOccupationalGroup(OccupationalGroup occupationalGroup) {
        this.occupationalGroup = occupationalGroup;
        return this;
    }

    /**
     * Alter bei Renteneintritt
     */
    public int getRetirementAge() {
        return retirementAge;
    }

    /**
     * Alter bei Renteneintritt
     */
    public ClientF setRetirementAge(int retirementAge) {
        this.retirementAge = retirementAge;
        return this;
    }

    /**
     * Gesetzliche Versicherungen
     */
    public StateInsurance getStateInsurances() {
        return stateInsurances;
    }

    /**
     * Gesetzliche Versicherungen
     */
    public ClientF setStateInsurances(StateInsurance stateInsurances) {
        this.stateInsurances = stateInsurances;
        return this;
    }


    public ClientF() { }

    public ClientF(String fullName) {
        this();
        var split = fullName.split(" ", 2);
        this.firstName = split[0];
        this.lastName = split[1];
    }

}
