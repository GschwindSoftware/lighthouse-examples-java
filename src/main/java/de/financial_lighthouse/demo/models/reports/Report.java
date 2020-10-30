package de.financial_lighthouse.demo.models.reports;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 	Ein Finanzauswertung.
 */
public class Report {

    @JsonProperty("categories")
    private List<ReportCategory> categories;
    @JsonProperty("series")
    private List<HierarchicalDataSeries> series;

    /**
     * ategorien, die zusammenhängende Datenpunkte beschreiben.
     * Die n-te Kategorie entspricht dem n-ten Datenpunkt in jedem Element der {@link Report#getSeries()}.
     */
    public List<ReportCategory> getCategories() {
        return categories;
    }

    /**
     * Die Reihe mit den Daten des Berichts
     */
    public List<HierarchicalDataSeries> getSeries() {
        return series;
    }
    
}
