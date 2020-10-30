package de.financial_lighthouse.demo.models.data;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Ein Verkauf.
 */
public class Sale {

    @JsonProperty("moment")
    private Moment moment;
    @JsonProperty("sellingMode")
    private SellingMode sellingMode = SellingMode.MarketValue;
    @JsonProperty("sellingPrice")
    private double sellingPrice;

    /**
     * Zeitpunkt des Verkaufs.
     */
    public Moment getMoment() {
        return moment;
    }

    /**
     * Zeitpunkt des Verkaufs.
     */
    public Sale setMoment(Moment moment) {
        this.moment = moment;
        return this;
    }

    /**
     * Verkaufsmethode.
     */
    public SellingMode getSellingMode() {
        return sellingMode;
    }

    /**
     * Verkaufsmethode.
     */
    public Sale setSellingMode(SellingMode sellingMode) {
        this.sellingMode = sellingMode;
        return this;
    }

    /**
     * Verkaufspreis.
     */
    public double getSellingPrice() {
        return sellingPrice;
    }

    /**
     * Verkaufspreis.
     */
    public Sale setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
        return this;
    }
    
}
