package de.financial_lighthouse.demo.query;

/**
 * Der Operator eines Prädikats.
 */
public enum RelationalOperator {
    /**
     * Gleichhheit.
     */
    Equals,
    /**
     * Ungleichheit.
     */
    NotEquals,
    /**
     * Teilmenge.
     */
    Contains,
    /**
     * Größer.
     */
    GreaterThan,
    /**
     * Kleiner.
     */
    LessThan,
    /**
     * Größer gleich.
     */
    GreaterEquals,
    /**
     * Kleiner gleich.
     */
    LessEquals
}
