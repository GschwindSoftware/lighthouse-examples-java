package de.financial_lighthouse.demo.query;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Fasst Sortieroptionen zusammen.
 */
public class OrderBy {
    
    @JsonProperty("property")
    private String property;
    @JsonProperty("order")
    private SortOrder order = SortOrder.Ascending;

    /**
     * Name der Eigenschaft, nach der sortiert werden soll.
     * Pfade sind punktsepariert.
     */
    public String getProperty() {
        return property;
    }

    /**
     * Name der Eigenschaft, nach der sortiert werden soll.
     * Pfade sind punktsepariert.
     */
    public OrderBy setProperty(String property) {
        this.property = property;
        return this;
    }

    /**
     * Die Sortierungsrichtung.
     */
    public SortOrder getOrder() {
        return order;
    }

    /**
     * Die Sortierungsrichtung.
     */
    public OrderBy setOrder(SortOrder order) {
        this.order = order;
        return this;
    }

    public OrderBy() { }

    public OrderBy(String property, SortOrder order) {
        this.property = property;
        this.order = order;
    }

}
