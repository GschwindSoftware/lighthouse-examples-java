package de.financial_lighthouse.demo.models.reports;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Eine hierarchische Reihe von Datenpunkten.
 */
public class HierarchicalDataSeries {

    @JsonProperty("type")
    private DataPointType type;
    @JsonProperty("data")
    private List<Double> data = new ArrayList<>();
    @JsonProperty("title")
    private String title;
    @JsonProperty("series")
    private List<HierarchicalDataSeries> series = new ArrayList<>();

    /**
     * Beschreibt, wie die Datenpunkte zu interpretieren sind.
     */
    public DataPointType getType() {
        return type;
    }

    /**
     * Die Datenpunkte der Reihe.
     */
    public List<Double> getData() {
        return data;
    }

    /**
     * Der Titel der Reihe.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Untergeordnete Reihen, die zusammen die Daten dieser Reihe bilden.
     */
    public List<HierarchicalDataSeries> getSeries() {
        return series;
    }

}
