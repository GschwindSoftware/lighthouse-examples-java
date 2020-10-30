package de.financial_lighthouse.demo.models.reports;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import de.financial_lighthouse.demo.util.Dates;

/**
 * Parameter für die Generierung einer Finanzauswertung nach Zeitpunkten.
 */
@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "type")
public class DateReportParameters extends ReportParameters {

    protected static final String TYPENAME = "DateReportParameters";

    @JsonProperty("dates")
    private List<LocalDateTime> dates;
    @JsonProperty("startDate")
    private LocalDateTime startDate = Dates.startOfYear();
    @JsonProperty("endDate")
    private LocalDateTime endDate = Dates.yearsFromNow(10);

    /**
     * Feste Termine für die Berechnung der Zahlen im generierten Bericht. Wenn diese Option gesetzt ist,
     * hat sie Vorrang vor {@link DateReportParameters#getStartDate()} und {@link DateReportParameters#getEndDate()}.
     */
    public List<LocalDateTime> getDates() {
        return dates;
    }

    /**
     * Feste Termine für die Berechnung der Zahlen im generierten Bericht. Wenn diese Option gesetzt ist,
     * hat sie Vorrang vor {@link DateReportParameters#getStartDate()} und {@link DateReportParameters#getEndDate()}.
     */
    public DateReportParameters setDates(List<LocalDateTime> dates) {
        this.dates = dates;
        return this;
    }

    /**
     * 
     */
    public LocalDateTime getStartDate() {
        return startDate;
    }

    /**
     * 
     */
    public DateReportParameters setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     * 
     */
    public LocalDateTime getEndDate() {
        return endDate;
    }

    /**
     * 
     */
    public DateReportParameters setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
        return this;
    }

}
