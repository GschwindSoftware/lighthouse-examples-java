package de.financial_lighthouse.demo.models.families;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Person, die den Kinderfreibetrag erhält.
 */
public enum ChildAllowanceBeneficiary {
    /**
     * Der Kunde bekommt den gesamten Freibetrag.
     */
    Client,
    /**
     * Der Partner bekommt den gesamten Freibetrag.
     */
    Partner,
    /**
     * Der Freibetrag wird zwischen Kunde und Partner hälftig aufgeteilt.
     */
    Both,
    /**
     * Der Kunde bekommt den halben Freibetrag.
     */
    ClienttHalf,
    /**
     * Der Partner bekommt den halben Freibetrag.
     */
    PartnerHalf,
    /**
     * Es gibt weder für Kunde noch Partner einen Freibetrag.
     */
    @JsonProperty("none")
    Neither
}
