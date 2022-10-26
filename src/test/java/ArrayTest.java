import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class ArrayTest {

    @Test
    @DisplayName("returns 2")
    void return2() {
        assertEquals(2, Array.return2());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("returns 2")
    void testReturn2() {
        assertEquals(2, Array.return2());
    }
}