import DataStructures.Array;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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

    @Test
    @DisplayName("Array grows if more items inserted than originally allocated for")
    void insertingMoreThanOriginallyAllocated() {
        underTest.insert(1);
        underTest.insert(2);
        underTest.insert(3);
        underTest.insert(4);
        underTest.insert(5);
        underTest.insert(6);
        assertEquals(1, underTest.items[0]);
        assertEquals(2, underTest.items[1]);
        assertEquals(3, underTest.items[2]);
        assertEquals(4, underTest.items[3]);
        assertEquals(5, underTest.items[4]);
        assertEquals(6, underTest.items[5]);
    }

    @Test
    @DisplayName("Array keeps resizing")
    void arrayKeepsResizing() {
        underTest.insert(1);
        underTest.insert(2);
        underTest.insert(3);
        underTest.insert(4);
        underTest.insert(5);
        underTest.insert(6);
        underTest.insert(7);
        underTest.insert(8);
        underTest.insert(9);
        underTest.insert(10);
        underTest.insert(11);
        assertEquals(1, underTest.items[0]);
        assertEquals(2, underTest.items[1]);
        assertEquals(3, underTest.items[2]);
        assertEquals(4, underTest.items[3]);
        assertEquals(5, underTest.items[4]);
        assertEquals(6, underTest.items[5]);
        assertEquals(7, underTest.items[6]);
        assertEquals(8, underTest.items[7]);
        assertEquals(9, underTest.items[8]);
        assertEquals(10, underTest.items[9]);
        assertEquals(11, underTest.items[10]);
    }


    // Testing removeAt method

    @Test
    @DisplayName("First item gets removed")
    void removeFirstItem() {
        underTest.insert(1);
        underTest.insert(2);
        underTest.insert(3);
        underTest.insert(4);
        underTest.removeAt(0);
        assertEquals(2, underTest.items[0]);
        assertEquals(3, underTest.items[1]);
        assertEquals(4, underTest.items[2]);
    }

    @Test
    @DisplayName("Last item gets removed")
    void removeLastItem() {
        underTest.insert(1);
        underTest.insert(2);
        underTest.insert(3);
        underTest.insert(4);
        underTest.removeAt(3);
        assertEquals(1, underTest.items[0]);
        assertEquals(2, underTest.items[1]);
        assertEquals(3, underTest.items[2]);
        assertEquals(3, underTest.count);
    }

    @Test
    @DisplayName("Item somewhere in the middle gets removed")
    void removeMiddleItem() {
        underTest.insert(1);
        underTest.insert(2);
        underTest.insert(3);
        underTest.insert(4);
        underTest.removeAt(2);
        assertEquals(1, underTest.items[0]);
        assertEquals(2, underTest.items[1]);
        assertEquals(4, underTest.items[2]);
    }

    @Test
    @DisplayName("Trying to remove an index out of bound raises an exception")
    void removeItemOutOfBound() {
        underTest.insert(1);
        underTest.insert(2);
        underTest.insert(3);
        underTest.insert(4);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            underTest.removeAt(5);
        });
    }

    @Test
    @DisplayName("Removing from an empty raises exception")
    void removeFromEmptyArray() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            underTest.removeAt(0);
        });
    }

    @Test
    @DisplayName("Removed item should be returned")
    void returnRemovedItem() {
        underTest.insert(1);
        underTest.insert(2);
        underTest.insert(3);
        underTest.insert(4);
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

    @Test
    @DisplayName("Returns -1 if item not in array")
    void itemNotInArray() {
        underTest.insert(1);
        underTest.insert(2);
        underTest.insert(2);
        underTest.insert(2);
        assertEquals(-1, underTest.indexOf(10));
    }

    // testing max method
    @Test
    @DisplayName("Returns the maximum number in the array")
    void returnsMaxItem() throws Exception {
        underTest.insert(1);
        underTest.insert(5);
        underTest.insert(2);
        underTest.insert(2);
        assertEquals(5, underTest.max());
    }

    @Test
    @DisplayName("Returns the maximum number in the array if max appears multiple times")
    void returnsMaxItemWhenMultiple() throws Exception {
        underTest.insert(1);
        underTest.insert(5);
        underTest.insert(5);
        underTest.insert(2);
        assertEquals(5, underTest.max());
    }

    @Test
    @DisplayName("Raises Exception when array is empty")
    void maxWhenArrayIsEmpty() {
        assertThrows(Exception.class, () -> {
            underTest.max();
        });
    }

    // Testing intersect method
    @Test
    @DisplayName("Returns empty array if the original array is empty")
    void emptyOriginalArray() {
        int[] argArr = {1, 2, 3};
        int[] reference = {};
        var returnArr = underTest.intersection(argArr);
        assertEquals("[]", returnArr.print());
    }

    @Test
    @DisplayName("Returns empty array if the argument array is empty")
    void emptyArgumentArray() {
        int[] argArr = {};
        int[] reference = {1, 2, 3};
        var returnArr = underTest.intersection(argArr);
        assertEquals("[]", returnArr.print());
    }

    @Test
    @DisplayName("Returns valid array intersection")
    void validArrayIntersection() {
        underTest.insert(2);
        underTest.insert(3);
        underTest.insert(8);
        int[] argArr = {1, 2, 3, 4, 5};
        var returnArr = underTest.intersection(argArr);
        assertEquals("[2, 3]", returnArr.print());
    }

    @Test
    @DisplayName("Returns empty array if no intersection")
    void noIntersection() {
        underTest.insert(2);
        underTest.insert(3);
        underTest.insert(8);
        int[] argArr = {1, 4, 9};
        var returnArr = underTest.intersection(argArr);
        assertEquals("[]", returnArr.print());
    }

    @Test
    @DisplayName("Returns same array if full intersection")
    void fullIntersection() {
        underTest.insert(2);
        underTest.insert(3);
        underTest.insert(8);
        int[] argArr = {2, 3, 8};
        Array returnArr = underTest.intersection(argArr);
        assertEquals("[2, 3, 8]", returnArr.print());
    }

    // Testing reverse method
    @Test
    @DisplayName("Reverses array of size 3")
    void reverseArrayOf3() {
        underTest.insert(1);
        underTest.insert(2);
        underTest.insert(3);
        underTest.reverse();
        assertEquals(3, underTest.items[0]);
        assertEquals(2, underTest.items[1]);
        assertEquals(1, underTest.items[2]);
    }

    @Test
    @DisplayName("Reverses empty array")
    void reverseEmptyArray() {
        underTest.reverse();
        assertEquals("[]", underTest.print());
    }

    // Testing insertAt method
    @Test
    @DisplayName("Inserts item in array of size 3 at index 1")
    void insertItemAtIndex1InArrayOf3() {
        underTest.insert(1);
        underTest.insert(3);
        underTest.insert(4);
        underTest.insertAt(2, 1);
        assertEquals(1, underTest.items[0]);
        assertEquals(2, underTest.items[1]);
        assertEquals(3, underTest.items[2]);
        assertEquals(4, underTest.items[3]);
    }

    @Test
    @DisplayName("Inserts item in array of size 3 at index 0")
    void insertItemAtIndex0InArrayOf3() {
        underTest.insert(2);
        underTest.insert(3);
        underTest.insert(4);
        underTest.insertAt(1, 0);
        assertEquals(1, underTest.items[0]);
        assertEquals(2, underTest.items[1]);
        assertEquals(3, underTest.items[2]);
        assertEquals(4, underTest.items[3]);
    }

    @Test
    @DisplayName("Inserts item in array of size 3 at last index")
    void insertItemAtIndex2InArrayOf3() {
        underTest.insert(1);
        underTest.insert(2);
        underTest.insert(3);
        underTest.insertAt(4, 2);
        assertEquals(1, underTest.items[0]);
        assertEquals(2, underTest.items[1]);
        assertEquals(4, underTest.items[2]);
        assertEquals(3, underTest.items[3]);
    }

    @Test
    @DisplayName("Inserting item in negative index raises exception")
    void insertItemAtNegativeIndex() {
        underTest.insert(2);
        underTest.insert(3);
        underTest.insert(4);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            underTest.insertAt(1, -1);
        });
    }

    @Test
    @DisplayName("Inserting item at out of bound index raises exception")
    void insertItemAtInvalidIndex() {
        underTest.insert(2);
        underTest.insert(3);
        underTest.insert(4);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            underTest.insertAt(1, 10);
        });
    }

}