package de.financial_lighthouse.demo.models.data;

/**
 * Risikostufe.
 */
public enum RiskLevel {
    /**
     * Keine.
     */
    None,
    /**
     * Risikolos.
     */
    NotCritical,
    /**
     * Konservativ.
     */
    LessCricital,
    /**
     * Wachstumsorientiert.
     */
    ModeratelyCritical,
    /**
     * Offensiv.
     */
    Critical,
    /**
     * Spekulativ.
     */
    HighlyCritical,
}
