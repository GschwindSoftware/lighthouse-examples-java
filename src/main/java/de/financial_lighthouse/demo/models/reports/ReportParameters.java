package de.financial_lighthouse.demo.models.reports;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

/**
 * Parameter für die Generierung einer Finanzauswertung.
 */
@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = DateReportParameters.class, name = DateReportParameters.TYPENAME),
})
public abstract class ReportParameters {

    @JsonProperty("depth")
    protected int depth = 3;
    @JsonProperty("scenarioType")
    protected ScenarioType scenarioType = ScenarioType.Standard;
    @JsonProperty("root")
    protected String root;
    @JsonProperty("recommendationIndex")
    protected int recommendationIndex;
    @JsonProperty("hideEmptyLines")
    protected boolean hideEmptyLines = true;

    /**
     * Die maximale Tiefe der hierarchischen Berichtsdaten.
     */
    public int getDepth() {
        return depth;
    }

    /**
     * Die maximale Tiefe der hierarchischen Berichtsdaten.
     */
    public ReportParameters setDepth(int depth) {
        this.depth = depth;
        return this;
    }

    /**
     * Die Art der Zuordnung in der Bilanz.
     */
    public ScenarioType getScenarioType() {
        return scenarioType;
    }

    /**
     * Die Art der Zuordnung in der Bilanz.
     */
    public ReportParameters setScenarioType(ScenarioType scenarioType) {
        this.scenarioType = scenarioType;
        return this;
    }

    /**
     * Die Wurzel der Auswertung.
     */
    public String getRoot() {
        return root;
    }

    /**
     * Die Wurzel der Auswertung.
     */
    public ReportParameters setRoot(String root) {
        this.root = root;
        return this;
    }

    /**
     * Der Index einer Empfehlungsliste zur Berücksichtigung von Empfehlungen innerhalb der Auswertung. Wird dieser nicht angegeben, werden vorhandene Empfehlungen nicht berücksichtigt.
     */
    public int getRecommendationIndex() {
        return recommendationIndex;
    }

    /**
     * Der Index einer Empfehlungsliste zur Berücksichtigung von Empfehlungen innerhalb der Auswertung. Wird dieser nicht angegeben, werden vorhandene Empfehlungen nicht berücksichtigt.
     */
    public ReportParameters setRecommendationIndex(int recommendationIndex) {
        this.recommendationIndex = recommendationIndex;
        return this;
    }

    /**
     * Sollen Null-Zeilen verteckt werden?
     */
    public boolean getHideEmptyLines() {
        return hideEmptyLines;
    }

    /**
     * Sollen Null-Zeilen verteckt werden?
     */
    public ReportParameters setHideEmptyLines(boolean hideEmptyLines) {
        this.hideEmptyLines = hideEmptyLines;
        return this;
    }
    
}
