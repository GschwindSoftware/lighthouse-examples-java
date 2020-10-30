package de.financial_lighthouse.demo.models.families;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Zuordnung eines Kindes zu einem Riestervertrag.
 */
public enum RiesterChildAssignment {
    /**
     * Kunde.
     */
    Client,
    /**
     * Partner.
     */
    Partner,
    /**
     * Automatisch.
     */
    Automatic,
    /**
     * Keiner.
     */
    @JsonProperty("none")
    Neither
}
