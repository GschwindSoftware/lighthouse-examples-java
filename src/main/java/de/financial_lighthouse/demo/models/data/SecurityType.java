package de.financial_lighthouse.demo.models.data;

/**
 * Wertpapierart
 */
public enum SecurityType {
    /**
     * Anleihe.
     */
    Bond,
    /**
     * Aktie.
     */
    Stock,
    /**
     * Aktienfonds.
     */
    StockFunds,
    /**
     * Rentenfonds.
     */
    BondFunds,
    /**
     * Immobilienfonds.
     */
    PropertyFunds,
    /**
     * Geldmarktfonds.
     */
    MoneyMarketFunds,
    /**
     * Zertifikate.
     */
    Certificate,
    /**
     * Hedgefonds.
     */
    HedgeFunds,
    /**
     * Private Equity Fonds.
     */
    PrivateEquity,
    /**
     * Dachfonds.
     */
    FundOfFunds,
    /**
     * Mischfonds.
     */
    BalancedFunds,
    /**
     * Sonstige Fonds.
     */
    OtherFunds,
    /**
     * Strukturierte Produkte.
     */
    StructuredProducts,
    /**
     * Rohstofffonds.
     */
    CommodityFunds,
    /**
     * Zerobonds.
     */
    Zerobond
}
