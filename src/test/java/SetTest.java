import model.Set;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class SetTest {

    private Set<Integer> set;

    @Before
    public void setup() {
        set = new Set<>(new ArrayList<Integer>(), "Test Set");
    }

    @Test
    public void testAddElement() {
        set.addElement(1);
        set.addElement(2);
        set.addElement(2); // duplicate element
        assertEquals(2, set.getElements().size());
    }

    @Test
    public void testRemoveElement() {
        set.addElement(1);
        set.addElement(2);
        set.removeElement(1);
        assertEquals(1, set.getElements().size());
    }

    @Test
    public void testGetElements() {
        set.addElement(1);
        set.addElement(2);
        List<Integer> elements = set.getElements();
        assertEquals(2, elements.size());
        assertTrue(elements.contains(1));
        assertTrue(elements.contains(2));
    }

    @Test
    public void testSetUnion() {
        Set<Integer> set1 = new Set<>(new ArrayList<Integer>(), "Set 1");
        set1.addElement(1);
        set1.addElement(2);
        Set<Integer> set2 = new Set<>(new ArrayList<Integer>(), "Set 2");
        set2.addElement(2);
        set2.addElement(3);
        Set<Integer> union = set1.setUnion(set2);
        assertNotNull(union);
        assertEquals(3, union.getElements().size());
        assertTrue(union.getElements().contains(1));
        assertTrue(union.getElements().contains(2));
        assertTrue(union.getElements().contains(3));
    }

    @Test
    public void testSetDifference() {
        Set<Integer> set1 = new Set<>(new ArrayList<Integer>(), "Set 1");
        set1.addElement(1);
        set1.addElement(2);
        Set<Integer> set2 = new Set<>(new ArrayList<Integer>(), "Set 2");
        set2.addElement(2);
        set2.addElement(3);
        Set<Integer> difference = set1.setDifference(set2);
        assertEquals(1, difference.getElements().size());
        assertTrue(difference.getElements().contains(1));
    }

    @Test
    public void testSetIntersection() {
        Set<Integer> set1 = new Set<>(new ArrayList<Integer>(), "Set 1");
        set1.addElement(1);
        set1.addElement(2);
        Set<Integer> set2 = new Set<>(new ArrayList<Integer>(), "Set 2");
        set2.addElement(2);
        set2.addElement(3);
        Set<Integer> intersection = set1.setIntersection(set2);
        assertEquals(1, intersection.getElements().size());
        assertTrue(intersection.getElements().contains(2));
    }

    @Test
    public void testGetSetInformation() {
        set.addElement(1);
        set.addElement(2);
        ArrayList<Integer> setInformation = set.getSetInformation(set);
        assertEquals(2, setInformation.size());
        assertTrue(setInformation.contains(1));
        assertTrue(setInformation.contains(2));
    }

    @Test
    public void testSearchElement() {
        set.addElement(1);
        set.addElement(2);
        Set<Integer> searchResult = set.searchElement(1);
        assertEquals(1, searchResult.getElements().size());
        assertTrue(searchResult.getElements().contains(1));
    }

    @Test
    public void testIsEmpty() {
        assertTrue(set.isEmpty());
        set.addElement(1);
        assertFalse(set.isEmpty());
    }

    @Test
    public void testIsSubset() {
        Set<Integer> subset = new Set<>(new ArrayList<Integer>(), "Subset");
        subset.addElement(1);
        subset.addElement(2);
        Set<Integer> superset = new Set<>(new ArrayList<Integer>(), "Superset");
        superset.addElement(1);
        superset.addElement(2);
        superset.addElement(3);
        assertTrue(subset.isSubset(superset));
    }

    @Test
    public void testGetElementAtRandom() {
        set.addElement(1);
        set.addElement(2);
        Integer randomElement = set.getElementAtRandom();
        assertNotNull(randomElement);
        assertTrue(set.getElements().contains(randomElement));
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetElementAtRandomEmptySet() {
        set.getElementAtRandom();
    }
}