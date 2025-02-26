package datastruct;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyUnsortedListTest {
    
    @Test
    public void testIsEmpty() {
        UnsortedList<Integer> integers = MyUnsortedList.of();
        assertTrue("new list should be empty", integers.isEmpty());
        integers.append(5);
        assertFalse("List should not be empty after adding an element", integers.isEmpty());
        assertEquals("List check after append", "MyUnsortedList { size = 1, [5] }", integers.toString());
    }
    
    @Test
    public void testSize() {
        UnsortedList<Integer> integers = MyUnsortedList.of(1, 2, 3, 4);
        assertEquals("Initial size with four elements should be 4", 4, integers.size());
    }
    
    @Test
    public void testAppendOneElement() {
        UnsortedList<Integer> integers = MyUnsortedList.of();
        integers.append(2);
        assertEquals("List should show one element", "MyUnsortedList { size = 1, [2] }", integers.toString());
    }

    @Test
    public void testAppendElements() {
        UnsortedList<Integer> integers = MyUnsortedList.of();
        integers.append(7);
        integers.append(2);
        integers.append(18);
        integers.append(-8);
        assertEquals("List should correctly display all appended elements", "MyUnsortedList { size = 4, [7, 2, 18, -8] }", integers.toString());
    }

    @Test
    public void testPrependElement() {
        UnsortedList<Integer> integers = MyUnsortedList.of();
        integers.prepend(5);
        assertEquals("List should show the prepended element", "MyUnsortedList { size = 1, [5] }", integers.toString());
    }

    @Test
    public void testPrependElements() {
        UnsortedList<Integer> integers = MyUnsortedList.of();
        integers.prepend(7);
        integers.prepend(2);
        integers.prepend(18);
        integers.prepend(-8);
        assertEquals("List should correctly display all prepended elements in reverse order", "MyUnsortedList { size = 4, [-8, 18, 2, 7] }", integers.toString());
    }

    @Test
    public void testInsertFirstElement() {
        UnsortedList<Integer> integers = MyUnsortedList.of(1, 2, 3, 4);
        integers.insert(7, 0);
        assertEquals("List should include the newly inserted element at the start", "MyUnsortedList { size = 5, [7, 1, 2, 3, 4] }", integers.toString());
    }

    @Test
    public void testInsertLastElement() {
        UnsortedList<Integer> integers = MyUnsortedList.of(1, 2, 3, 4);
        integers.insert(15, 4);
        assertEquals("List should include the newly inserted element at the end", "MyUnsortedList { size = 5, [1, 2, 3, 4, 15] }", integers.toString());
    }

    @Test
    public void testInsertAtMiddle() {
        UnsortedList<Integer> integers = MyUnsortedList.of(1, 3, 4);
        integers.insert(2, 1);
        assertEquals("List should include the newly inserted element in the middle", "MyUnsortedList { size = 4, [1, 2, 3, 4] }", integers.toString());
    }

    @Test
    public void testRemoveElement() {
        UnsortedList<Integer> integers = MyUnsortedList.of(1, 2, 3, 4);
        integers.remove(1);
        assertEquals("List should show current state after remove", "MyUnsortedList { size = 3, [1, 3, 4] }", integers.toString());
    }

    @Test
    public void testRemoveElements() {
        UnsortedList<Integer> integers = MyUnsortedList.of(1, 2, 3, 4);
        integers.remove(0);
        integers.remove(0);
        integers.remove(0);
        integers.remove(0);
        assertTrue("List should be empty", integers.isEmpty());
        assertEquals("List should be empty", "MyUnsortedList { size = 0, [] }", integers.toString());
    }
    
    @Test(expected = EmptyListException.class)
    public void testPopOnEmptyList() {
        UnsortedList<Integer> integers = MyUnsortedList.of();
        integers.pop();
    }
    
    @Test(expected = EmptyListException.class)
    public void testPopLastOnEmptyList() {
        UnsortedList<Integer> integers = MyUnsortedList.of();
        integers.popLast();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveAtNegativePosition() {
        UnsortedList<Integer> integers = MyUnsortedList.of();
        integers.remove(-1);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveBeyondSize() {
        UnsortedList<Integer> integers = MyUnsortedList.of(1, 2, 3, 4);
        integers.remove(10);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertAtNegativePosition() {
        UnsortedList<Integer> integers = MyUnsortedList.of(1, 2, 3, 4);
        integers.insert(51, -1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertBeyondSize() {
        UnsortedList<Integer> integers = MyUnsortedList.of(1, 2, 3, 4);
        integers.insert(2, 10);
    }
    
}
