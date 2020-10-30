package de.financial_lighthouse.demo.models.reports;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

/**
 * Beschreibt zusammenhängende Datenpunkte von Reihen innerhalb eines Berichtes.
 * Jeder Datenpunkt repräsentiert einen Moment in der Zeit.
 */
@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "type")
public class DateReportCategory extends ReportCategory {

    protected static final String TYPENAME = "date";
    
    @JsonProperty("end")
    private LocalDateTime date;

    /**
     * Der Zeitpunkt der Kategorie.
     */
    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public String getName() {
        return String.valueOf(date.getYear());
    }

}
