import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class ListManager {

    public static void addElement(List<Integer> list, int element) {
        list.add(element);
    }

    public static void removeElement(List<Integer> list, int element) {
        list.remove(Integer.valueOf(element));
    }

    public static int getSize(List<Integer> list) {
        return list.size();
    }

    // --- JUnit Test Cases ---
    @Test
    public void testAddElement() {
        List<Integer> list = new ArrayList<>();
        addElement(list, 10);
        addElement(list, 20);
        assertEquals(2, getSize(list));
        assertTrue(list.contains(10));
        assertTrue(list.contains(20));
    }

    @Test
    public void testRemoveElement() {
        List<Integer> list = new ArrayList<>();
        addElement(list, 10);
        addElement(list, 20);
        removeElement(list, 10);
        assertEquals(1, getSize(list));
        assertFalse(list.contains(10));
        assertTrue(list.contains(20));
    }

    @Test
    public void testGetSize() {
        List<Integer> list = new ArrayList<>();
        assertEquals(0, getSize(list));
        addElement(list, 5);
        addElement(list, 15);
        assertEquals(2, getSize(list));
    }
}
