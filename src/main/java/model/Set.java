package model;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public class Set<V extends Comparable<V>> implements VSet<V> {

    private List<V> elements;
    private String name;

    public Set(List<V> elements, String name) {
        if (elements == null) {
            this.elements = new ArrayList<>();
        } else {
            this.elements = elements;
        }
        this.name = name;
    }


    @Override
    public void addElement(V elemento) {
        boolean itExists = false;
        for (V element : elements) {
            if (element.compareTo(elemento) == 0) {
                itExists = true;
                break;

            }
        }
        if (!itExists) {
            elements.add(elemento);
        }
    }

    @Override
    public void removeElement(V element) {
        for (V existentElement : elements) {
            if (existentElement.compareTo(element) == 0) {
                elements.remove(existentElement);
            }
        }
    }

    @Override
    public List<V> getElements() {
        return elements;
    }

    @Override
    public Set<V> setUnion(Set<V> sets) {
        for (V element : sets.getElements()) {
            this.addElement(element);
        }
        return this;
    }

    @Override
    public Set<V> setDifference(Set<V> set) {
        Set<V> difference = new Set<>(new ArrayList<V>(), "Difference Set");
        for (V element : this.getElements()) {
            boolean found = false;
            for (V otherElement : set.getElements()) {
                if (element.compareTo(otherElement) == 0) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                difference.addElement(element);
            }
        }
        return difference;
    }

    @Override
    public Set<V> setIntersection(Set<V> sets) {
        Set<V> intersection = new Set<>(new ArrayList<V>(), "Intersection Set");
        for (V element : this.getElements()) {
            for (V otherElement : sets.getElements()) {
                if (element.compareTo(otherElement) == 0) {
                    intersection.addElement(element);
                    break;
                }
            }
        }
        return intersection;
    }

    @Override
    public ArrayList<V> getSetInformation(Set<V> sets) {
        return (ArrayList<V>) sets.getElements();
    }

    @Override
    public Set<V> searchElement(V element) {
        Set<V> result = new Set<V>(new ArrayList<V>(), "Search Result");
        List<V> thisSetElements = getElements();

        for (V thisElement : thisSetElements) {
            if (thisElement.compareTo(element) == 0) {
                result.addElement(thisElement);
            }
        }

        return result;
    }

    @Override
    public boolean isEmpty() {
        return getElements().isEmpty();
    }

    @Override
    public boolean isSubset(Set<V> sets) {
        List<V> thisSetElements = getElements();
        List<V> otherSetElements = sets.getElements();

        for (V element : thisSetElements) {
            boolean found = false;
            for (V otherElement : otherSetElements) {
                if (element.equals(otherElement)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }

        return true;
    }

    public V getElementAtRandom() {
        if (elements.isEmpty()) {
            throw new NoSuchElementException("El conjunto está vacío");
        }
        int randomIndex = new Random().nextInt(elements.size());
        return elements.get(randomIndex);
    }
}
