package de.financial_lighthouse.demo.models.plans;

/**
 * Arten der Veröffentlichung eines Plans an den Kunden.
 */
public enum PublishType {
    /**
     * Nicht sichtbar für den Kunden.
     */
    Invisible,
    /**
     * Der Kunde kann den Plan öffnen, aber nicht mitwirken.
     */
    Visible,
    /**
     * Der Kunde kann den Plan öffnen und daran mitwirken.
     */
    Editable
}
