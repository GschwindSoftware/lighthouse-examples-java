package de.financial_lighthouse.demo.query;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import org.springframework.lang.Nullable;

/**
 * Suchkriterien für eine Abfrage.
 */
@JsonInclude(Include.NON_NULL)
public class Query {

    @JsonProperty("search")
    private String search;
    @JsonProperty("filter")
    private Term filter;
    @JsonProperty("ordering")
    private Collection<OrderBy> ordering;
    @JsonProperty("include")
    private Collection<String> include;
    @JsonProperty("exclude")
    private Collection<String> exclude;
    @JsonProperty("skip")
    private Integer skip;
    @JsonProperty("take")
    private Integer take;

    /**
     * Die optionale Zeichenfolge, mittels derer die Elemente gesucht werden.
     * @return Der aktuelle Wert.
     */
    public @Nullable String getSearch() {
        return search;
    }

    /**
     * Die optionale Zeichenfolge, mittels derer die Elemente gesucht werden.
     */
    public Query setSearch(@Nullable String search) {
        this.search = search;
        return this;
    }

    /**
     * Enthält Filter zur Eingrenzung der Suche.
     */
    public @Nullable Term getFilter() {
        return filter;
    }

    /**
     * Enthält Filter zur Eingrenzung der Suche.
     */
    public Query setFilter(@Nullable Term filter) {
        this.filter = filter;
        return this;
    }

    /**
     * Eine Sammlung von optionalen Sortieroperationen.
     */
    public @Nullable Collection<OrderBy> getOrdering() {
        return ordering;
    }
    
    /**
     * Eine Sammlung von optionalen Sortieroperationen.
     */
    public Query setOrdering(@Nullable Collection<OrderBy> ordering) {
        this.ordering = ordering;
        return this;
    }

    /**
     * Namen der Eigenschaften, die in die Ergebnismenge übernommen werden.
     * Pfade sind punktsepariert, Wirldcards sind möglich.
     */
    public @Nullable Collection<String> getInclude() {
        return include;
    }

    /**
     * Namen der Eigenschaften, die in die Ergebnismenge übernommen werden.
     * Pfade sind punktsepariert, Wirldcards sind möglich.
     */
    public Query setInclude(@Nullable Collection<String> include) {
        this.include = include;
        return this;
    }

    /**
     * Namen der Eigenschaften, die nicht in die Ergebnismenge übernommen werden.
     * Pfade sind punktsepariert, Wirldcards sind möglich.
     */
    public @Nullable Collection<String> getExclude() {
        return exclude;
    }

    /**
     * Namen der Eigenschaften, die nicht in die Ergebnismenge übernommen werden.
     * Pfade sind punktsepariert, Wirldcards sind möglich.
     */
    public Query setExclude(@Nullable Collection<String> exclude) {
        this.exclude = exclude;
        return this;
    }

    /**
     * Wenn gesetzt, wird diese Anzahl von Übereinstimmungen übersprungen.
     */
    public @Nullable Integer getSkip() {
        return skip;
    }

    /**
     * Wenn gesetzt, wird diese Anzahl von Übereinstimmungen übersprungen.
     */
    public Query setSkip(@Nullable Integer skip) {
        this.skip = skip;
        return this;
    }

    /**
     * Wenn gesetzt, wird das Ergebnis der Abfrage höchstens diese Anzahl von Übereinstimmungen enthalten.
     */
    public @Nullable Integer getTake() {
        return take;
    }

    /**
     * Wenn gesetzt, wird das Ergebnis der Abfrage höchstens diese Anzahl von Übereinstimmungen enthalten.
     */
    public Query setTake(@Nullable Integer take) {
        this.take = take;
        return this;
    }
    
}
