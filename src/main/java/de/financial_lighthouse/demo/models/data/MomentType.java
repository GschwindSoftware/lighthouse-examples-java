package de.financial_lighthouse.demo.models.data;

/**
 * Der Typ eines {@link Moment}
 */
public enum MomentType {
    /**
     * An einem bestimmten Datum.
     */
    AtDate,
    /**
     * Nie.
     */
    Never,
    /**
     * Bei Renteneintritt.
     */
    AtRetirement,
    /**
     * Zu einem bestimmten Alter.
     */
    AtAge,
}
