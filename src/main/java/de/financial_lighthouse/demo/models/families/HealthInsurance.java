package de.financial_lighthouse.demo.models.families;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.lang.Nullable;

/**
 * Angaben zur Krankenkasse einer Person.
 */
public class HealthInsurance {
    
    @JsonProperty("additionalRate")
    private double additionalRate = 0.9;
    @JsonProperty("hasDailyBenefitsInsurance")
    private boolean hasDailyBenefitsInsurance = true;
    @JsonProperty("insuranceCompany")
    private String insuranceCompany;

    /**
     * Der Zusatzbeitrag.
     */
    public double getAdditionalRate() {
        return additionalRate;
    }

    /**
     * Der Zusatzbeitrag.
     */
    public HealthInsurance getAdditionalRate(double additionalRate) {
        this.additionalRate = additionalRate;
        return this;
    }

    /**
     * Wenn <code>true</code>, besteht eine Krankentagegeld-Versicherung.
     */
    public boolean getHasDailyBenefitsInsurance() {
        return hasDailyBenefitsInsurance;
    }

    /**
     * Wenn <code>true</code>, besteht eine Krankentagegeld-Versicherung.
     */
    public HealthInsurance getHasDailyBenefitsInsurance(boolean hasDailyBenefitsInsurance) {
        this.hasDailyBenefitsInsurance = hasDailyBenefitsInsurance;
        return this;
    }

    /**
     * Der Name der Krankenkasse.
     */
    public @Nullable String getInsuranceCompany() {
        return insuranceCompany;
    }

    /**
     * Der Name der Krankenkasse.
     */
    public HealthInsurance getInsuranceCompany(@Nullable String insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
        return this;
    }


}
