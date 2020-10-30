package de.financial_lighthouse.demo.models.data;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Die Person, auf die sich das {@link PlanData} bezieht.
 */
public class Owner {

    @JsonProperty("type")
    private OwnerType type = OwnerType.Client;
    @JsonProperty("clientRate")
    private double clientRate = 50;
    @JsonProperty("partnerRate")
    private double partnerRate = 50;

    /**
     * Der Typ der Person.
     */
    public OwnerType getType() {
        return type;
    }

    /**
     * Der Typ der Person.
     */
    public Owner setType(OwnerType type) {
        this.type = type;
        return this;
    }

    /**
     * Bei {@link OwnerType#Custom}: Der Anteil des Kunden.
     */
    public double getClientRate() {
        return clientRate;
    }

    /**
     * Bei {@link OwnerType#Custom}: Der Anteil des Kunden.
     */
    public Owner setClientRate(double clientRate) {
        this.clientRate = clientRate;
        return this;
    }

    /**
     * Bei {@link OwnerType#Custom}: Der Anteil des Partners.
     */
    public double getPartnerRate() {
        return partnerRate;
    }

    /**
     * Bei {@link OwnerType#Custom}: Der Anteil des Partners.
     */
    public Owner setPartnerRate(double partnerRate) {
        this.partnerRate = partnerRate;
        return this;
    }
    
}
