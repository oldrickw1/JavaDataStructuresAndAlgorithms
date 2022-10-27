import DataStructures.Array;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayTest {

    // SetUp
    private Array underTest;

    @BeforeEach
    void setUp() {
        underTest = new Array(5);
    }

    // Testing insert method
    @Test
    @DisplayName("Inserting 10")
    void insert10() {
        underTest.insert(10);
        assertEquals(10, underTest.items[0]);
    }

    @Test
    @DisplayName("Inserting multiple integers")
    void insertMultipleIntegers() {
        underTest.insert(1);
        underTest.insert(2);
        underTest.insert(3);
        assertEquals(1, underTest.items[0]);
        assertEquals(2, underTest.items[1]);
        assertEquals(3, underTest.items[2]);
    }


    // Testing removeAt method
    @Test
    @DisplayName("First item gets removed")
    void removeFirstItem() {
        underTest.items[0] = 1;
        underTest.items[1] = 2;
        underTest.items[2] = 3;
        underTest.items[3] = 4;
        underTest.removeAt(0);
        assertEquals(2, underTest.items[0]);
        assertEquals(3, underTest.items[1]);
        assertEquals(4, underTest.items[2]);
    }

    @Test
    @DisplayName("Last item gets removed")
    void removeLastItem() {
        underTest.items[0] = 1;
        underTest.items[1] = 2;
        underTest.items[2] = 3;
        underTest.items[3] = 4;
        underTest.removeAt(3);
        assertEquals(1, underTest.items[0]);
        assertEquals(2, underTest.items[1]);
        assertEquals(3, underTest.items[2]);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            int x = underTest.items[3];
        });
    }

    @Test
    @DisplayName("Item somewhere in the middle gets removed")
    void removeMiddleItem() {
        underTest.items[0] = 1;
        underTest.items[1] = 2;
        underTest.items[2] = 3;
        underTest.items[3] = 4;
        underTest.removeAt(2);
        assertEquals(1, underTest.items[0]);
        assertEquals(2, underTest.items[1]);
        assertEquals(4, underTest.items[2]);
    }

    @Test
    @DisplayName("Trying to remove an index out of bound raises an exception")
    void removeItemOutOfBound() {
        underTest.items[0] = 1;
        underTest.items[1] = 2;
        underTest.items[2] = 3;
        underTest.items[3] = 4;
        assertThrows(IndexOutOfBoundsException.class, () -> {
            underTest.removeAt(5);
        });
    }

    @Test
    @DisplayName("Removed item should be returned")
    void returnRemovedItem() {
        underTest.items[0] = 1;
        underTest.items[1] = 2;
        underTest.items[2] = 3;
        underTest.items[3] = 4;
        int removedItem = underTest.removeAt(3);
        assertEquals(4, removedItem);
    }

    // Testing print method
    @Test
    @DisplayName("Prints an empty array")
    void printsEmptyArray() {
        assertEquals("[]", underTest.print());
    }

    @Test
    @DisplayName("Prints an array")
    void printsAnArray() {
        underTest.insert(1);
        underTest.insert(2);
        underTest.insert(3);
        underTest.insert(4);
        assertEquals("[1, 2, 3, 4]", underTest.print());
    }


    // Testing indexOf method
    @Test
    @DisplayName("Provides index of item that is in the array at the first index")
    void itemExistsAtFirstIndex() {
        underTest.insert(1);
        underTest.insert(2);
        underTest.insert(3);
        underTest.insert(4);
        assertEquals(0, underTest.indexOf(1));
    }

    @Test
    @DisplayName("Provides index of item that is in the array at the last index")
    void itemExistAtTheLastIndex() {
        underTest.insert(1);
        underTest.insert(2);
        underTest.insert(3);
        underTest.insert(4);
        assertEquals(3, underTest.indexOf(4));
    }

    @Test
    @DisplayName("Provides index of item that is in the array at a middle index")
    void itemExistAtAMiddleIndex() {
        underTest.insert(1);
        underTest.insert(2);
        underTest.insert(3);
        underTest.insert(4);
        assertEquals(1, underTest.indexOf(2));
    }

    @Test
    @DisplayName("Provides first index if item appears multiple times")
    void firstIndexMultipleAppearances() {
        underTest.insert(1);
        underTest.insert(2);
        underTest.insert(2);
        underTest.insert(2);
        assertEquals(1, underTest.indexOf(2));
    }


}