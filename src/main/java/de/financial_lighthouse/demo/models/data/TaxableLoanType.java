package de.financial_lighthouse.demo.models.data;

/**
 * Typ der steuerlichen Ausgabe im Darlehen.
 */
public enum TaxableLoanType {
    /**
     * Automatisch.
     */
    Automatic,
    /**
     * Land- und Forstwirtschaft.
     */
    Agriculture,
    /**
     * Gewerbebetrieb.
     */
    Business,
    /**
     * Selbständige Arbeit.
     */
    SelfEmployed,
    /**
     * Kapitalvermögen.
     */
    Capital,
    /**
     * Vermietung und Verpachtung.
     */
    LettingAndLeasing,
    /**
     * Sonstige Einkünfte.
     */
    Other,
}
