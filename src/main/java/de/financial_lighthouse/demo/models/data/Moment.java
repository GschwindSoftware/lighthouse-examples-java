package de.financial_lighthouse.demo.models.data;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 	Beschreibt einen Zeitpunkt.
 */
public class Moment {

    @JsonProperty("type")
    private MomentType type = MomentType.AtDate;
    @JsonProperty("age")
    private int age = 65;
    @JsonProperty("date")
    private LocalDateTime date;

    /**
     * Der Typ des Zeitpunkts.
     */
    public MomentType getType() {
        return type;
    }

    /**
     * Der Typ des Zeitpunkts.
     */
    public Moment setType(MomentType type) {
        this.type = type;
        return this;
    }

    /**
     * Bei {@link MomentType#AtAge}: Alter des Eigentümers.
     */
    public int getAge() {
        return age;
    }

    /**
     * Bei {@link MomentType#AtAge}: Alter des Eigentümers.
     */
    public Moment setAge(int age) {
        this.age = age;
        return this;
    }

    /**
     * Bei {@link MomentType#AtDate}: Datum des Zeitpunkts.
     */
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * Bei {@link MomentType#AtDate}: Datum des Zeitpunkts.
     */
    public Moment setDate(LocalDateTime date) {
        this.date = date;
        return this;
    }

    public static Moment AtRetirement(int retiresWith) {
        return new Moment()
            .setType(MomentType.AtRetirement)
            .setAge(retiresWith);
    }

    public static Moment AtAge(int age) {
        return new Moment()
            .setType(MomentType.AtAge)
            .setAge(age);
    }

    public static Moment AtDate(LocalDateTime date) {
        return new Moment()
            .setType(MomentType.AtDate)
            .setDate(date);
    }

    public static Moment Never() {
        return new Moment()
            .setType(MomentType.Never);
    }
    
}
