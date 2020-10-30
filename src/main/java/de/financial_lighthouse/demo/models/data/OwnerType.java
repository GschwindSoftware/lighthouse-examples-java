package de.financial_lighthouse.demo.models.data;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Der Typ eines {@link Owner}.
 */
public enum OwnerType {
    /**
     * Kunde.
     */
    Client,
    /**
     * Partner.
     */
    Partner,
    /**
     * Kunde und Partner.
     */
    Both,
    /**
     * Sonstige Person.
     */
    Other,
    /**
     * Benutzerdefinierte Aufteilung zwischen Kunde und Partner.
     */
    @JsonProperty("individual")
    Custom
}
