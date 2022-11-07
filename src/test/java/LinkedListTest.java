import DataStructures.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

    // SetUp
    private LinkedList underTest;

    @BeforeEach
    void setUp() {
        underTest = new LinkedList();
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

//    // Testing getSize method
//    @Test
//    @DisplayName()

    // Testing addLast method
    // Testing deleteFirst method
    // Testing deleteLast method
    // Testing contains method
    // Testing indexOf method
}
