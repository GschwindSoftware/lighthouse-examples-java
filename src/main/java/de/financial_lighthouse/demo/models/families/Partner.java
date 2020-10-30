package de.financial_lighthouse.demo.models.families;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

/**
 * Ein Partner vom Kunden im {@link FamilyTree}.
 */
@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "type")
public class Partner extends FamilyMember {
    
    protected static final String TYPENAME = "Partner";

    @JsonProperty("churchTaxDuty")
    private boolean churchTaxDuty = true;
    @JsonProperty("healthInsurance")
    private HealthInsurance healthInsurance;
    @JsonProperty("occupationalGroup")
    private OccupationalGroup occupationalGroup = OccupationalGroup.Employee;
    @JsonProperty("retirementAge")
    private int retirementAge = 65;
    @JsonProperty("stateInsurances")
    private StateInsurance stateInsurances;

    /**
     *  Wenn <code>true</code>, ist der Kunde kirchensteuerpflichtig
     */
    public boolean getChurchTaxDuty() {
        return churchTaxDuty;
    }

    /**
     *  Wenn <code>true</code>, ist der Kunde kirchensteuerpflichtig
     */
    public Partner setChurchTaxDuty(boolean churchTaxDuty) {
        this.churchTaxDuty = churchTaxDuty;
        return this;
    }

    /**
     *  Krankenversicherung
     */
    public HealthInsurance getHealthInsurance() {
        return healthInsurance;
    }

    /**
     *  Krankenversicherung
     */
    public Partner setHealthInsurance(HealthInsurance healthInsurance) {
        this.healthInsurance = healthInsurance;
        return this;
    }

    /**
     *  Die Berufsgruppe des Kunden
     */
    public OccupationalGroup getOccupationalGroup() {
        return occupationalGroup;
    }

    /**
     *  Die Berufsgruppe des Kunden
     */
    public Partner setOccupationalGroup(OccupationalGroup occupationalGroup) {
        this.occupationalGroup = occupationalGroup;
        return this;
    }

    /**
     *  Alter bei Renteneintritt
     */
    public int getRetirementAge() {
        return retirementAge;
    }

    /**
     *  Alter bei Renteneintritt
     */
    public Partner setRetirementAge(int retirementAge) {
        this.retirementAge = retirementAge;
        return this;
    }

    /**
     *  Gesetzliche Versicherungen
     */
    public StateInsurance getStateInsurances() {
        return stateInsurances;
    }

    /**
     *  Gesetzliche Versicherungen
     */
    public Partner setStateInsurances(StateInsurance stateInsurances) {
        this.stateInsurances = stateInsurances;
        return this;
    }


    public Partner() { }

    public Partner(String fullName) {
        this();
        var split = fullName.split(" ", 2);
        firstName = split[0];
        lastName = split[1];
    }

}
