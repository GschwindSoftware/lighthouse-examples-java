package de.financial_lighthouse.demo.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Definiert Methoden für Elemente, die einen eindeutigen Schlüssel besitzen.
 */
public class HasId<TKey> {

    @JsonProperty("id")
    protected TKey id;

    /**
     * Der eindeutige Schlüssel des Objekts.
     */
    public TKey getID() {
        return id;
    }
    
}
