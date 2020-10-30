package de.financial_lighthouse.demo.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

/**
 * Parameter für die Abfrage mehrerer Elemente über die API.
 */
@JsonFormat(shape = Shape.OBJECT)
public class QueryResult<TItem> implements List<TItem> {

    @JsonProperty("matches")
    private List<TItem> matches = new ArrayList<TItem>();
    @JsonProperty("offset")
    private int offset;
    @JsonProperty("count")
    private int count;
    @JsonProperty("total")
    private int total;

    /**
     * Die Anzahl der übersprungenen Suchtreffer der Abfrage.
     */
    public int getOffset() {
        return offset;
    }

    /**
     * Die Anzahl der im Ergebnis enthaltenen Suchtreffer.
     */
    public int getCount() {
        return count;
    }

    /**
     * Die Gesamtanzahl aller möglichen Suchtreffer. Eine Abfrage kann eine
     * Untermenge an Elementen enthalten.
     */
    public int getTotal() {
        return total;
    }

    // #region List<T>

    @Override
    public int size() {
        return matches.size();
    }

    @Override
    public boolean isEmpty() {
        return matches.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return matches.contains(o);
    }

    @Override
    public Iterator<TItem> iterator() {
        return matches.iterator();
    }

    @Override
    public Object[] toArray() {
        return matches.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return matches.toArray(a);
    }

    @Override
    public boolean add(TItem e) {
        return matches.add(e);
    }

    @Override
    public boolean remove(Object o) {
        return matches.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return matches.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends TItem> c) {
        return matches.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return matches.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return matches.retainAll(c);
    }

    @Override
    public void clear() {
        matches.clear();
    }

    @Override
    public boolean addAll(int index, Collection<? extends TItem> c) {
        return matches.addAll(index, c);
    }
    
    @Override
    public TItem get(int index) {
        return matches.get(index);
    }
    
    @Override
    public TItem set(int index, TItem element) {
        return matches.set(index, element);
    }
    
    @Override
    public void add(int index, TItem element) {
        matches.add(index, element);
    }
    
    @Override
    public TItem remove(int index) {
        return matches.remove(index);
    }
    
    @Override
    public int indexOf(Object o) {
        return matches.indexOf(o);
    }
    
    @Override
    public int lastIndexOf(Object o) {
        return matches.lastIndexOf(o);
    }
    
    @Override
    public ListIterator<TItem> listIterator() {
        return matches.listIterator();
    }
    
    @Override
    public ListIterator<TItem> listIterator(int index) {
        return matches.listIterator(index);
    }
    
    @Override
    public List<TItem> subList(int fromIndex, int toIndex) {
        return matches.subList(fromIndex, toIndex);
    }
    
    // #endregion
    
}
