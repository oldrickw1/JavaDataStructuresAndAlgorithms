import DataStructures.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

    // SetUp
    private LinkedList underTest;

    @BeforeEach
    void setUp() {
        underTest = new LinkedList();
    }

    // Testing print
    @Test
    @DisplayName("Prints an empty Linked List")
    void printsEmptyLinkedList() {
        assertEquals("[]", underTest.print());
    }

    @Test
    @DisplayName("Prints a Linked List with 1 item")
    void printsLinkedListWithOneItem() {
        underTest.addFirst(1);
        assertEquals("[1]", underTest.print());
    }

    @Test
    @DisplayName("Prints a Linked List with 3 item")
    void printsLinkedListWithThreeItem() {
        underTest.addFirst(1);
        underTest.addFirst(2);
        underTest.addFirst(3);
        assertEquals("[3,2,1]", underTest.print());
    }

    // Testing addFirst
    @Test
    @DisplayName("Adding node to an empty Linked List")
    void addToEmptyLinkedList() {
        underTest.addFirst(5);
        assertEquals(1, underTest.getSize());
        assertEquals("[5]", underTest.print());
        assertEquals(5, underTest.get(0));
    }

    @Test
    @DisplayName("Adding several nodes to an empty Linked List")
    void addSeveralToEmptyLinkedList() {
        underTest.addFirst(5);
        underTest.addFirst(6);
        underTest.addFirst(7);
        assertEquals(3, underTest.getSize());
        assertEquals("[7,6,5]", underTest.print());
        assertEquals(7, underTest.get(0));
    }

    // Testing get method
    @Test
    @DisplayName("Returns the right value at the 'index' of the linked list")
    void getValues() {
        underTest.addFirst(1);
        underTest.addFirst(2);
        underTest.addFirst(3);
        assertEquals(3, underTest.get(0));
        assertEquals(2, underTest.get(1));
        assertEquals(1, underTest.get(2));
        assertThrows(IndexOutOfBoundsException.class, () -> {
            underTest.get(4);
        });
    }

    // Testing getSize method
    @Test
    @DisplayName("Returns the correct size")
    void returnsSize() {
        assertEquals(0, underTest.getSize());
        underTest.addFirst(1);
        underTest.addFirst(2);
        assertEquals(2, underTest.getSize());
    }

    // Testing addLast method
    @Test
    @DisplayName("Adding a last item to an empty list")
    void addLastToEmptyLinkedList() {
        underTest.addLast(4);
        assertEquals(1, underTest.getSize());
        assertEquals("[4]", underTest.print());
        assertEquals(4, underTest.get(0));
    }

    @Test
    @DisplayName("Adding a last item to a list")
    void addLastToLinkedList() {
        underTest.addFirst(4);
        underTest.addLast(5);
        assertEquals(2, underTest.getSize());
        assertEquals("[4,5]", underTest.print());
        assertEquals(4, underTest.get(0));
        assertEquals(5, underTest.get(1));
    }

    @Test
    @DisplayName("Adding multiple last items to an empty list")
    void addMultipleLastItems() {
        underTest.addLast(3);
        underTest.addLast(5);
        underTest.addLast(7);
        assertEquals(7, underTest.get(2));
        assertEquals(3, underTest.get(0));
        assertEquals("[3,5,7]", underTest.print());
        assertEquals(3, underTest.getSize());
    }

    // Testing deleteFirst method
    @Test
    @DisplayName("Removing first item from an empty Linked List")
    void removeFirstItemFromEmptyLinkedList() {
        assertThrows(NoSuchElementException.class, () -> {
            underTest.deleteFirst();
        });
    }

    @Test
    @DisplayName("Removing first item from Linked List with items")
    void removeFirstItemFromLinkedListWithItems() {
        underTest.addFirst(3);
        underTest.addFirst(2);
        underTest.addFirst(1);
        int removedItem = underTest.deleteFirst();
        assertEquals(1, removedItem);
        assertEquals(2, underTest.get(0));
        assertEquals(3, underTest.get(1));
        assertEquals(2, underTest.getSize());
        assertEquals("[2,3]", underTest.print());
    }

    @Test
    @DisplayName("Removing first item from Linked List with just 1 item")
    void removeFirstItemFromLinkedListWithOneItem() {
        underTest.addFirst(1);
        int removedItem = underTest.deleteFirst();
        assertEquals(1, removedItem);
        assertEquals(0, underTest.getSize());
        assertEquals("[]", underTest.print());
    }

    // Testing deleteLast method
    @Test
    @DisplayName("Removing first item from an empty Linked List")
    void removeLastItemFromEmptyLinkedList() {
        assertThrows(NoSuchElementException.class, () -> {
            underTest.deleteLast();
        });
    }

    @Test
    @DisplayName("Removing first item from Linked List with items")
    void removeLastItemFromLinkedListWithItems() {
        underTest.addFirst(3);
        underTest.addFirst(2);
        underTest.addFirst(1);
        int removedItem = underTest.deleteLast();
        assertEquals(3, removedItem);
        assertEquals(1, underTest.get(0));
        assertEquals(2, underTest.get(1));
        assertEquals(2, underTest.getSize());
        assertEquals("[1,2]", underTest.print());
    }

    @Test
    @DisplayName("Removing first item from Linked List with just 1 item")
    void removeLastItemFromLinkedListWithOneItem() {
        underTest.addFirst(1);
        int removedItem = underTest.deleteLast();
        assertEquals(1, removedItem);
        assertEquals(0, underTest.getSize());
        assertEquals("[]", underTest.print());
    }
    // Testing contains method
    // Testing indexOf method
}
