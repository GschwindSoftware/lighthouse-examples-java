package de.financial_lighthouse.demo.models.data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import org.springframework.lang.Nullable;

import de.financial_lighthouse.demo.util.Dates;

/**
 * Vorgang "Eigengenutzte Immobilie"
 */
@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "type")
public class OwnerProperty extends PlanData {
    
    protected static final String TYPENAME = "OwnerProperty";

    @JsonProperty("buildYear")
    private int buildYear;
    @JsonProperty("buying")
    private Purchase purchase;
    @JsonProperty("computeProfit")
    private boolean computeProfit;
    @JsonProperty("landCosts")
    private double landCosts;
    @JsonProperty("livingArea")
    private int livingArea;
    @JsonProperty("location")
    private String location;
    @JsonProperty("mainFamilyResidential")
    private boolean mainFamilyResidential;
    @JsonProperty("maintenanceReserves")
    private List<MaintenanceReserve> maintenanceReserves;
    @JsonProperty("marketValues")
    private MarketValues marketValues;
    @JsonProperty("operatingCosts")
    private List<OperatingCosts> operatingCosts;
    @JsonProperty("profit")
    private CashFlows profit;
    @JsonProperty("purchaseCosts")
    private double purchaseCosts;
    @JsonProperty("riskLevel")
    private RiskLevel riskLevel;
    @JsonProperty("selling")
    private Sale sale;

    /**
     * Baujahr.
     */
    public int getBuildYear() {
        return buildYear;
    }

    /**
     * Baujahr.
     */
    public OwnerProperty setBuildYear(int buildYear) {
        this.buildYear = buildYear;
        return this;
    }

    /**
     * Kauf.
     */
    public Purchase getPurchase() {
        return purchase;
    }

    /**
     * Kauf.
     */
    public OwnerProperty setPurchase(Purchase purchase) {
        this.purchase = purchase;
        return this;
    }

    /**
     * Gewinn automatisch aus den Details berechnet?
     */
    public boolean getComputeProfit() {
        return computeProfit;
    }

    /**
     * Gewinn automatisch aus den Details berechnet?
     */
    public OwnerProperty setComputeProfit(boolean computeProfit) {
        this.computeProfit = computeProfit;
        return this;
    }

    /**
     * Grundstückkosten.
     */
    public double getLandCosts() {
        return landCosts;
    }

    /**
     * Grundstückkosten.
     */
    public OwnerProperty setLandCosts(double landCosts) {
        this.landCosts = landCosts;
        return this;
    }

    /**
     * Wohnfläche.
     */
    public int getLivingArea() {
        return livingArea;
    }

    /**
     * Wohnfläche.
     */
    public OwnerProperty setLivingArea(int livingArea) {
        this.livingArea = livingArea;
        return this;
    }

    /**
     * Standort.
     */
    public @Nullable String getLocation() {
        return location;
    }

    /**
     * Standort.
     */
    public OwnerProperty setLocation(@Nullable String location) {
        this.location = location;
        return this;
    }

    /**
     * Haupt-Familienwohnheim?
     */
    public boolean getMainFamilyResidential() {
        return mainFamilyResidential;
    }

    /**
     * Haupt-Familienwohnheim?
     */
    public OwnerProperty setMainFamilyResidential(boolean mainFamilyResidential) {
        this.mainFamilyResidential = mainFamilyResidential;
        return this;
    }

    /**
     * Rücklagen.
     */
    public @Nullable List<MaintenanceReserve> getMaintenanceReserves() {
        return maintenanceReserves;
    }

    /**
     * Rücklagen.
     */
    public OwnerProperty setMaintenanceReserves(@Nullable List<MaintenanceReserve> maintenanceReserves) {
        this.maintenanceReserves = maintenanceReserves;
        return this;
    }

    /**
     * Verkehrswerte.
     */
    public MarketValues getMarketValues() {
        return marketValues;
    }

    /**
     * Verkehrswerte.
     */
    public OwnerProperty setMarketValues(MarketValues marketValues) {
        this.marketValues = marketValues;
        return this;
    }

    /**
     * Betriebskosten.
     */
    public @Nullable List<OperatingCosts> getOperatingCosts() {
        return operatingCosts;
    }

    /**
     * Betriebskosten.
     */
    public OwnerProperty setOperatingCosts(@Nullable List<OperatingCosts> operatingCosts) {
        this.operatingCosts = operatingCosts;
        return this;
    }

    /**
     * Manuelle Gewinneingabe, falls {@link OwnerProperty#getComputeProfit()} false ist.
     */
    public CashFlows getProfit() {
        return profit;
    }

    /**
     * Manuelle Gewinneingabe, falls {@link OwnerProperty#getComputeProfit()} false ist.
     */
    public OwnerProperty setProfit(CashFlows profit) {
        this.profit = profit;
        return this;
    }

    /**
     * Kaufnebenkosten.
     */
    public double getPurchaseCosts() {
        return purchaseCosts;
    }

    /**
     * Kaufnebenkosten.
     */
    public OwnerProperty setPurchaseCosts(double purchaseCosts) {
        this.purchaseCosts = purchaseCosts;
        return this;
    }

    /**
     * Risikostufe.
     */
    public RiskLevel getRiskLevel() {
        return riskLevel;
    }

    /**
     * Risikostufe.
     */
    public OwnerProperty setRiskLevel(RiskLevel riskLevel) {
        this.riskLevel = riskLevel;
        return this;
    }

    /**
     * Verkauf.
     */
    public Sale getSale() {
        return sale;
    }

    /**
     * Verkauf.
     */
    public OwnerProperty setSale(Sale sale) {
        this.sale = sale;
        return this;
    }

    public OwnerProperty() {
        buildYear = Dates.currentYear();
    }

}
