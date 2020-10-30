package de.financial_lighthouse.demo.query;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.lang.Nullable;

/**
 * Ein Prädikat, das eine Eigenschaft eines Eintrags mit einem Wert vergleicht.
 */
public class Predicate extends Term {
    
    @JsonProperty("property")
    private String property;
    @JsonProperty("op")
    private RelationalOperator operator = RelationalOperator.Equals;
    @JsonProperty("value")
    private Object value;

    /**
     * Der Name der Eigenschaft, die verglichen werden soll.
     * Pfade sind punktsepariert.
     */
    public String getProperty() {
        return property;
    }

    /**
     * Der Name der Eigenschaft, die verglichen werden soll.
     * Pfade sind punktsepariert.
     */
    public Predicate setProperty(String property) {
        this.property = property;
        return this;
    }

    /**
     * Der Operator des Prädikats.
     */
    public RelationalOperator getOperator() {
        return operator;
    }

    /**
     * Der Operator des Prädikats.
     */
    public Predicate setOperator(RelationalOperator operator) {
        this.operator = operator;
        return this;
    }

    /**
     * Der Wert, mit dem verglichen werden soll.
     */
    public @Nullable Object getValue() {
        return value;
    }

    /**
     * Der Wert, mit dem verglichen werden soll.
     */
    public Predicate setValue(@Nullable Object value) {
        this.value = value;
        return this;
    }

    public Predicate() { }

    public Predicate(String property, RelationalOperator operator, @Nullable Object value) {
        this.property = property;
        this.operator = operator;
        this.value = value;
    }

}
