package de.financial_lighthouse.demo.models.families;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

/**
 * 	Ein Kind des Kunden und oder Partners innerhalb der Familie.
 */
@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "type")
public class Child extends FamilyMember {
    
    protected static final String TYPENAME = "Child";

    @JsonProperty("childAllowanceAge")
    private int childAllowanceAge;
    @JsonProperty("childAllowancePerson")
    private ChildAllowanceBeneficiary childAllowanceBeneficiary = ChildAllowanceBeneficiary.Client;
    @JsonProperty("householdResidecy")
    private int householdResidecy = 18;
    @JsonProperty("riesterChildAssignment")
    private RiesterChildAssignment riesterChildAssignment = RiesterChildAssignment.Automatic;

    /**
     * Das Alter in Jahren, bis zu dem die Eltern des Kindes Anspruch auf das Kindergeld haben.
     */
    public int getChildAllowanceAge() {
        return childAllowanceAge;
    }

    /**
     * Das Alter in Jahren, bis zu dem die Eltern des Kindes Anspruch auf das Kindergeld haben.
     */
    public Child setChildAllowanceAge(int childAllowanceAge) {
        this.childAllowanceAge = childAllowanceAge;
        return this;
    }

    /**
     * Person, die den Kinderfreibetrag erhält.
     */
    public ChildAllowanceBeneficiary getChildAllowanceBeneficiary() {
        return childAllowanceBeneficiary;
    }

    /**
     * Person, die den Kinderfreibetrag erhält.
     */
    public Child setChildAllowanceBeneficiary(ChildAllowanceBeneficiary childAllowanceBeneficiary) {
        this.childAllowanceBeneficiary = childAllowanceBeneficiary;
        return this;
    }

    /**
     * Lebensjahr, bis zum dem das Kind im Haushalt lebt.
     */
    public int getHouseholdResidecy() {
        return householdResidecy;
    }

    /**
     * Lebensjahr, bis zum dem das Kind im Haushalt lebt.
     */
    public Child setHouseholdResidecy(int householdResidecy) {
        this.householdResidecy = householdResidecy;
        return this;
    }

    /**
     * Zuordnung eines Kindes zu einem Riestervertrag.
     */
    public RiesterChildAssignment getRiesterChildAssignment() {
        return riesterChildAssignment;
    }

    /**
     * Zuordnung eines Kindes zu einem Riestervertrag.
     */
    public Child setRiesterChildAssignment(RiesterChildAssignment riesterChildAssignment) {
        this.riesterChildAssignment = riesterChildAssignment;
        return this;
    }

    public Child() { }

    public Child(String fullName) {
        this();
        var split = fullName.split(" ", 2);
        this.firstName = split[0];
        this.lastName = split[1];
    }

}
