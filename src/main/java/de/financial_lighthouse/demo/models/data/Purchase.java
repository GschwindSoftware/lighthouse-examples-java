package de.financial_lighthouse.demo.models.data;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import de.financial_lighthouse.demo.util.Dates;

/**
 * Ein Kauf.
 */
public class Purchase {

    @JsonProperty("doBuy")
    private boolean buy;
    @JsonProperty("purchaseDate")
    private LocalDateTime date;
    @JsonProperty("purchasePrice")
    private double price;

    /**
     * Wird gekauft?
     */
    public boolean getBuy() {
        return buy;
    }

    /**
     * Wird gekauft?
     */
    public Purchase setBuy(boolean buy) {
        this.buy = buy;
        return this;
    }

    /**
     * Kaufdatum.
     */
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * Kaufdatum.
     */
    public Purchase setDate(LocalDateTime date) {
        this.date = date;
        return this;
    }

    /**
     * Kauspreis.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Kauspreis.
     */
    public Purchase setPrice(double price) {
        this.price = price;
        return this;
    }

    public Purchase() {
        date = Dates.startOfYear();
    }

}
