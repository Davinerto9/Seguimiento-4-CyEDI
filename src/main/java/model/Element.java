package model;

public class Element<V> implements Comparable<V> {
    private V value;

    public Element(V value) {
        this.value = value;
    }

    public V getValue() {
        return value;
    }

    @Override
    public int compareTo(V other) {
        return ((Comparable<V>) value).compareTo(other);
    }

    @Override
    public boolean equals(Object newObject) {
        if (this == newObject) {
            return true;
        }
        if (newObject == null || getClass() != newObject.getClass()) {
            return false;
        }
        Element<V> element = (Element<V>) newObject;
        return value.equals(element.value);
    }
}
