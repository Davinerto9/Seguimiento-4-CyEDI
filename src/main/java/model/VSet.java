package model;
import java.util.List;

public interface VSet<V extends Comparable<V>> {

    public void addElement(V element);
    public void removeElement(V element);
    public List<V> getElements();
    public Set<V> setUnion(Set<V>sets);
    public Set<V> setDifference(Set<V> sets);
    public Set<V> setIntersection(Set<V>sets);
    public List<V> getSetInformation(Set<V>sets);
    public Set<V> searchElement(V element);
    public boolean isEmpty();
    public boolean isSubset(Set<V> sets);
    public V getElementAtRandom();

}
