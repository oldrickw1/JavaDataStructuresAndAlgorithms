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
        assertEquals("[]", underTest.toString());
    }

    @Test
    @DisplayName("Prints a Linked List with 1 item")
    void printsLinkedListWithOneItem() {
        underTest.addFirst(1);
        assertEquals("[1]", underTest.toString());
    }

    @Test
    @DisplayName("Prints a Linked List with 3 item")
    void printsLinkedListWithThreeItem() {
        underTest.addFirst(1);
        underTest.addFirst(2);
        underTest.addFirst(3);
        assertEquals("[3,2,1]", underTest.toString());
    }

    // Testing addFirst
    @Test
    @DisplayName("Adding node to an empty Linked List")
    void addToEmptyLinkedList() {
        underTest.addFirst(5);
        assertEquals(1, underTest.getSize());
        assertEquals("[5]", underTest.toString());
        assertEquals(5, underTest.get(0));
    }

    @Test
    @DisplayName("Adding several nodes to an empty Linked List")
    void addSeveralToEmptyLinkedList() {
        underTest.addFirst(5);
        underTest.addFirst(6);
        underTest.addFirst(7);
        assertEquals(3, underTest.getSize());
        assertEquals("[7,6,5]", underTest.toString());
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
        assertEquals("[4]", underTest.toString());
        assertEquals(4, underTest.get(0));
    }

    @Test
    @DisplayName("Adding a last item to a list")
    void addLastToLinkedList() {
        underTest.addFirst(4);
        underTest.addLast(5);
        assertEquals(2, underTest.getSize());
        assertEquals("[4,5]", underTest.toString());
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
        assertEquals("[3,5,7]", underTest.toString());
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
        assertEquals("[2,3]", underTest.toString());
    }

    @Test
    @DisplayName("Removing first item from Linked List with just 1 item")
    void removeFirstItemFromLinkedListWithOneItem() {
        underTest.addFirst(1);
        int removedItem = underTest.deleteFirst();
        assertEquals(1, removedItem);
        assertEquals(0, underTest.getSize());
        assertEquals("[]", underTest.toString());
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
        assertEquals("[1,2]", underTest.toString());
    }

    @Test
    @DisplayName("Removing first item from Linked List with just 1 item")
    void removeLastItemFromLinkedListWithOneItem() {
        underTest.addFirst(1);
        int removedItem = underTest.deleteLast();
        assertEquals(1, removedItem);
        assertEquals(0, underTest.getSize());
        assertEquals("[]", underTest.toString());
    }
    // Testing contains method
    @Test
    @DisplayName("Returns false if used on empty Linked List")
    void checkIfEmptyLinkedListContains4() {
        assertEquals(false, underTest.contains(4));
    }

    @Test
    @DisplayName("Check if Linked List with one item contains item")
    void checkIfLinkedListWithOneItemContains() {
        underTest.addFirst(4);
        assertEquals(true, underTest.contains(4));
        assertEquals(false, underTest.contains(6));
    }

    @Test
    @DisplayName("Check if Linked List with multiple elements contains item")
    void checkIfLinkedListWithMultElemsContains() {
        underTest.addFirst(3);
        underTest.addFirst(2);
        underTest.addFirst(1);
        assertEquals(false, underTest.contains(4));
        assertEquals(true, underTest.contains(1));
        assertEquals(true, underTest.contains(2));
        assertEquals(true, underTest.contains(3));
    }

    @Test
    @DisplayName("Check if Linked List with multiple same elements contains item")
    void checkIfLinkedListWithMultSameElemsContains() {
        underTest.addFirst(3);
        underTest.addFirst(3);
        underTest.addFirst(1);
        assertEquals(false, underTest.contains(4));
        assertEquals(true, underTest.contains(3));
        assertEquals(true, underTest.contains(1));
    }

    // Testing indexOf method
    @Test
    @DisplayName("Returns -1 if indexOf is used on empty Linked List")
    void indexOfEmptyLinkedList() {
        assertEquals(-1,underTest.indexOf(4));
    }

    @Test
    @DisplayName("Returns -1 if indexOf is used on Linked List that doesn't contain elem")
    void indexOfLinkedListThatDoesNotContainElem() {
        underTest.addFirst(1);
        underTest.addFirst(2);
        underTest.addFirst(3);
        assertEquals(-1,underTest.indexOf(4));
    }

    @Test
    @DisplayName("Returns index when indexOf is used on Linked List that does contain elem")
    void indexOfLinkedListThatDoesContainElem() {
        underTest.addFirst(3);
        assertEquals(0,underTest.indexOf(3));
    }

    @Test
    @DisplayName("Returns first index when indexOf is used on Linked List that does contain elem multiple times")
    void firstIndexOfLinkedListThatDoesContainElemMultipleTimes() {
        underTest.addFirst(1);
        underTest.addFirst(2);
        underTest.addFirst(3);
        assertEquals(0,underTest.indexOf(3));
    }

    // Testing getKthFromLast method
    @Test
    @DisplayName("Returns the value of the specified node in a Linked List of size 1")
    void getKthFromLastInSizeOf1() {
        underTest.addFirst(1);
        int value = -1;
        try {
            value = underTest.kthFromLast(1);
        } catch (Exception e)
        {};
        assertEquals(value, 1);
    }

    @Test
    @DisplayName("Returns value of specified node in LL of size 3")
    void getKthFromLastInSizeOf3() {
        underTest.addFirst(3);
        underTest.addFirst(2);
        underTest.addFirst(1);
        int value1 = -1;
        int value2 = -1;
        int value3 = -1;
        try {
            value1 = underTest.kthFromLast(1);
            value2 = underTest.kthFromLast(2);
            value3 = underTest.kthFromLast(3);
        } catch (Exception e)
        {};
        assertEquals(value1, 3);
        assertEquals(value2, 2);
        assertEquals(value3, 1);
    }

    @Test
    @DisplayName("KthFromLast on empty LL")
    void kthFromLastOnEmptyLL() {
        assertThrows(Exception.class, () -> {
            underTest.kthFromLast(0);
        });
    }

    @Test
    @DisplayName("Raises error when K is illegal")
    void getIllegalKthFromLast() {
        underTest.addFirst(1);
        assertThrows(Exception.class, () -> {
            underTest.kthFromLast(5);
        });
        assertThrows(Exception.class, () -> {
            underTest.kthFromLast(-1);
        });
    }

}
