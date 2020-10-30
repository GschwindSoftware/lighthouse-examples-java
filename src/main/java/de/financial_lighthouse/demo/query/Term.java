package de.financial_lighthouse.demo.query;

import java.util.ArrayList;
import java.util.List;

/**
 * Ein Term eines Filterausdrucks.
 */
public abstract class Term {

    /**
     * Vereint zwei Terme per "Oder" Konjunktion.
     * @param other Der zweite Term.
     * @return Der neue Term.
     */
    public Term or(Term other) {
        return join(other, LogicalOperator.Or);
    }    

    /**
     * Vereint zwei Terme per "Und" Konjunktion.
     * @param other Der zweite Term.
     * @return Der neue Term.
     */
    public Term and(Term other) {
        return join(other, LogicalOperator.And);
    }

    private Term join(Term other, LogicalOperator op) {
        if (other == null)
            return this;

        var c1 = this instanceof Conjunction ? (Conjunction)this : null;
        var c2 = other instanceof Conjunction ? (Conjunction)other : null;

        if (c1 != null && c1.getOperator() == op) {
            var terms = new ArrayList<Term>(c1);

            if (c2 != null && c2.getOperator() == op) {
                terms.addAll(c2);
            } else {
                terms.add(other);
            }

            return new Conjunction(terms, op);
        } else if (c2 != null && c2.getOperator() == op) {
            var terms = new ArrayList<Term>();
            terms.add(this);
            terms.addAll(c2);
            return new Conjunction(terms, op);
        }

        return new Conjunction(List.of(this, other), op);
    }


}
