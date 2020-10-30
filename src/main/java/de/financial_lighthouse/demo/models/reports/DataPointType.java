package de.financial_lighthouse.demo.models.reports;

/**
 * Beschreibt, wie Datenpunkte in einer {@link HierarchicalDataSeries} zu interpretieren sind.
 */
public enum DataPointType {
    /**
     * Datenpunkte stellen absolute Werte dar.
     */
    Double,
    /**
     * Datenpunkte repräsentieren Prozentwerte zwischen <code>0</code> und <code>1</code>.
     */
    Percent,
    /**
     * Datenpunkte stellen Werte in der Einheit Quadratmeter dar.
     */
    SquareMeter,
    /**
     * Datenpunkte repräsentieren Werte in einer Währung.
     */
    Currency,
}
