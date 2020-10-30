package de.financial_lighthouse.demo.query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Eine Konjunktion mehrerer {@link Term Terme} eines Filters.
 */
public class Conjunction extends Term implements Collection<Term> {

    @JsonProperty("terms")
    private Collection<Term> terms = new ArrayList<Term>();
    @JsonProperty("op")
    private LogicalOperator operator = LogicalOperator.And;

    /**
     * Der Operator, mit dem die Aussagen verknüpft werden.
     */
    public LogicalOperator getOperator() {
        return operator;
    }

    /**
     * Der Operator, mit dem die Aussagen verknüpft werden.
     */
    public void setOperator(LogicalOperator operator) {
        this.operator = operator;
    }

    // #region Collection<Term>

    @Override
    public int size() {
        return terms.size();
    }

    @Override
    public boolean isEmpty() {
        return terms.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return terms.contains(o);
    }

    @Override
    public Iterator<Term> iterator() {
        return terms.iterator();
    }

    @Override
    public Object[] toArray() {
        return terms.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return terms.toArray(a);
    }

    @Override
    public boolean add(Term e) {
        return terms.add(e);
    }

    @Override
    public boolean remove(Object o) {
        return terms.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return terms.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends Term> c) {
        return terms.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return terms.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return terms.retainAll(c);
    }

    @Override
    public void clear() {
        terms.clear();
    }

    // #endregion

    public Conjunction() { }

    public Conjunction(Collection<Term> terms, LogicalOperator operator) {
        this.terms.addAll(terms);
        this.operator = operator;
    }

}
