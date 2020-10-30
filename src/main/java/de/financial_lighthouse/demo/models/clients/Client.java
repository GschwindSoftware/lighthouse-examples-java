package de.financial_lighthouse.demo.models.clients;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.lang.Nullable;

import de.financial_lighthouse.demo.models.HasId;

/**
 * Ein Kunde, der mehrere zugeordnete Pläne haben kann
 */
public class Client extends HasId<Integer> {

    @JsonProperty("birthday")
    private LocalDateTime birthday = null;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("note")
    private String note;

    /**
     * Der Geburtstag des Kunden.
     */
    public LocalDateTime getBirthday() {
        return birthday;
    }

    /**
     * Der Geburtstag des Kunden.
     */
    public Client setBirthday(@Nullable LocalDateTime birthday) {
        this.birthday = birthday;
        return this;
    }

    /**
     * Der Vorname des Kunden.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Der Vorname des Kunden.
     */
    public Client setFirstName(@Nullable String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * Der Nachname des Kunden.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Der Nachname des Kunden.
     */
    public Client setLastName(@Nullable String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * Eine beliebige, benutzerdefinierte Notiz über den Kunden.
     */
    public String getNote() {
        return note;
    }

    /**
     * Eine beliebige, benutzerdefinierte Notiz über den Kunden.
     */
    public Client setNote(@Nullable String note) {
        this.note = note;
        return this;
    }

    public Client() { }

    public Client(String fullName) {
        this();
        var split = fullName.split(" ", 2);
        firstName = split[0];
        lastName = split[1];
    }

}
