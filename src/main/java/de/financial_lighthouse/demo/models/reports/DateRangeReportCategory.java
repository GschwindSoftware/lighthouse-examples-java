package de.financial_lighthouse.demo.models.reports;

import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.function.Function;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

/**
 * Beschreibt zusammenhängende Datenpunkte von Reihen innerhalb eines Berichtes.
 * Jeder Datenpunkt repräsentiert einen Zeitbereich.
 */
@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "type")
public class DateRangeReportCategory extends ReportCategory {

    protected static final String TYPENAME = "range";
    
    @JsonProperty("start")
    private LocalDateTime start;
    @JsonProperty("end")
    private LocalDateTime end;

    /**
     * Der Startzeitpunkt der Kategorie.
     */
    public LocalDateTime getStart() {
        return start;
    }

    /**
     * Der Endzeitpunkt der Kategorie.
     */
    public LocalDateTime getEnd() {
        return end;
    }

    @Override
    public String getName() {
        if (end.getYear() != start.getYear())
            return String.format("%d-%d", start.getYear(), end.getYear());
        else if (end.getMonth() != start.getMonth()) {
            Function<LocalDateTime, String> name = t -> t
                .getMonth()
                .getDisplayName(TextStyle.SHORT_STANDALONE, Locale.GERMAN);

            return String.format("%s-%s %d", name.apply(start), name.apply(end), end.getYear());
        }

        return String.format("%s-%s", start, end);
    }

}
