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
        underTest = new Array();
    }

    // Testing insert method
    @Test
    @DisplayName("Insert method test. Inserting 10")
    void insert10() {
        underTest.insert(10);
        assertEquals(10, underTest.items[0]);
    }

    @Test
    @DisplayName("Insert method test. Rejecting char")
    void insertChar() {
        assertThrows(IllegalArgumentException.class, () -> {
            underTest.insert('c');
        });
    }

    // Testing removeAt method

    // Testing print method

    // Testing indexOf method


}