package de.financial_lighthouse.demo.models.reports;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

/**
 * Beschreibt zusammenhängende Datenpunkte von Reihen innerhalb eines Berichtes.
 */
@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = DateReportCategory.class, name = DateReportCategory.TYPENAME),
    @JsonSubTypes.Type(value = DateRangeReportCategory.class, name = DateRangeReportCategory.TYPENAME)
})
public abstract class ReportCategory {

    /**
     * Eine Bezeichnung der Kategorie.
     */
    public abstract String getName();

}
