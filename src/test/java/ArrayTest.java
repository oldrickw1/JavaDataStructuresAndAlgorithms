import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayTest {

    @Test
    @DisplayName("returns 2")
    void return2() {
        assertEquals(2, Array.return2());
    }

    @Test
    @DisplayName("returns 2")
    void testReturn2() {
        assertEquals(2, Array.return2());
    }
}