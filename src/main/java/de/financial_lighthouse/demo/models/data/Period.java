package de.financial_lighthouse.demo.models.data;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 	Beschreibt einen Zeitpunkt.
 */
public class Period {

    @JsonProperty("type")
    private MomentType type = MomentType.AtDate;
    @JsonProperty("endAge")
    private int endAge = 65;
    @JsonProperty("endDate")
    private LocalDateTime endDate;
    @JsonProperty("startDate")
    private LocalDateTime startDate;

    /**
     * Der Typ des Zeitpunkts.
     */
    public MomentType getType() {
        return type;
    }

    /**
     * Der Typ des Zeitpunkts.
     */
    public Period setType(MomentType type) {
        this.type = type;
        return this;
    }

    /**
     * Bei {@link MomentType#AtendAge}: Ende des Zeitraums nach Alter des Eigentümers.
     */
    public int getEndAge() {
        return endAge;
    }

    /**
     * Bei {@link MomentType#AtendAge}: Ende des Zeitraums nach Alter des Eigentümers.
     */
    public Period setEndAge(int endAge) {
        this.endAge = endAge;
        return this;
    }

    /**
     * Bei {@link MomentType#AtendAge}: Ende des Zeitraums nach Datum.
     */
    public LocalDateTime getEndDate() {
        return endDate;
    }

    /**
     * Bei {@link MomentType#AtendAge}: Ende des Zeitraums nach Datum.
     */
    public Period setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
        return this;
    }

    /**
     * Start des Zeitraums.
     */
    public LocalDateTime getStartDate() {
        return startDate;
    }

    /**
     * Start des Zeitraums.
     */
    public Period setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
        return this;
    }
    
}
