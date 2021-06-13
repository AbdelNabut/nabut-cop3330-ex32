package ex32;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    @Test
    void isNumeric() {
        assertThrows(NumberFormatException.class, ()-> {
            Integer.parseInt("a");
        });
        assertEquals(2, Integer.parseInt("2"));
    }
}