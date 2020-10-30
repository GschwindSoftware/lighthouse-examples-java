package de.financial_lighthouse.demo.models.data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import org.springframework.lang.Nullable;

/**
 * Vorgang "Einkunft aus nichtselbständiger Arbeit"
 */
@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "type")
public class EmployedIncome extends PlanData {

    protected static final String TYPENAME = "EmployedIncome";

    @JsonProperty("bonuses")
    private List<Bonus> bonuses;
    @JsonProperty("cashFlows")
    private CashFlows cashFlows;
    @JsonProperty("companyCars")
    private List<CompanyCar> companyCars;
    @JsonProperty("isStateInsuranceDuty")
    private boolean isStateInsuranceDuty = true;
    @JsonProperty("monetaryAdvantages")
    private List<MonetaryAdvantage> monetaryAdvantages;
    @JsonProperty("numberOfPayments")
    private int numberOfPayments = 12;
    @JsonProperty("termination")
    private Moment termination;

    /**
     *  Bonuszahlungen.
     */
    public @Nullable List<Bonus> getBonuses() {
        return bonuses;
    }

    /**
     *  Bonuszahlungen.
     */
    public EmployedIncome setBonuses(@Nullable List<Bonus> bonuses) {
        this.bonuses = bonuses;
        return this;
    }

    /**
     *  Zahlungen.
     */
    public CashFlows getCashFlows() {
        return cashFlows;
    }

    /**
     *  Zahlungen.
     */
    public EmployedIncome setCashFlows(CashFlows cashFlows) {
        this.cashFlows = cashFlows;
        return this;
    }

    /**
     *  Dienstwagen.
     */
    public @Nullable List<CompanyCar> getCompanyCars() {
        return companyCars;
    }

    /**
     *  Dienstwagen.
     */
    public EmployedIncome setCompanyCars(@Nullable List<CompanyCar> companyCars) {
        this.companyCars = companyCars;
        return this;
    }

    /**
     *  Sozialversicherungspflichtig?
     */
    public boolean getIsStateInsuranceDuty() {
        return isStateInsuranceDuty;
    }

    /**
     *  Sozialversicherungspflichtig?
     */
    public EmployedIncome setIsStateInsuranceDuty(boolean isStateInsuranceDuty) {
        this.isStateInsuranceDuty = isStateInsuranceDuty;
        return this;
    }

    /**
     *  Geldwerte Vorteile.
     */
    public @Nullable List<MonetaryAdvantage> getMonetaryAdvantages() {
        return monetaryAdvantages;
    }

    /**
     *  Geldwerte Vorteile.
     */
    public EmployedIncome setMonetaryAdvantages(@Nullable List<MonetaryAdvantage> monetaryAdvantages) {
        this.monetaryAdvantages = monetaryAdvantages;
        return this;
    }

    /**
     *  Anzahl Monatsgehälter
     */
    public int getNumberOfPayments() {
        return numberOfPayments;
    }

    /**
     *  Anzahl Monatsgehälter
     */
    public EmployedIncome setNumberOfPayments(int numberOfPayments) {
        this.numberOfPayments = numberOfPayments;
        return this;
    }

    /**
     *  Ende der Zahlungen.
     */
    public Moment getTermination() {
        return termination;
    }

    /**
     *  Ende der Zahlungen.
     */
    public EmployedIncome setTermination(Moment termination) {
        this.termination = termination;
        return this;
    }

}
