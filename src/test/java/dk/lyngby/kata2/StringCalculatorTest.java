package dk.lyngby.kata2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringCalculatorTest {

    @Test
    public void testAddEmptyString() {
        assertEquals(0, StringCalculator.add(""));
    }

    @Test
    public void testAddSingleNumber() {
        assertEquals(1, StringCalculator.add("1"));
    }

    @Test
    public void testAddTwoNumbers() {
        assertEquals(3, StringCalculator.add("1,2"));
    }

    @Test
    public void testAddUnknownNumberOfArguments() {
        assertEquals(6, StringCalculator.add("1,2,3"));
    }

    @Test
    public void testAddNewlinesAsSeparators() {
        assertEquals(6, StringCalculator.add("1,2\n3"));
    }

    @Test
    public void testAddSeparatorAtEnd() {
        assertThrows(IllegalArgumentException.class, () -> {
            StringCalculator.add("1,2,");
        });
    }

    @Test
    public void testAddDifferentDelimiters() {
        assertEquals(4, StringCalculator.add("//;\n1;3"));
        assertEquals(6, StringCalculator.add("//|\n1|2|3"));
        assertEquals(7, StringCalculator.add("//sep\n2sep5"));
        assertThrows(IllegalArgumentException.class, () -> {
            StringCalculator.add("//|\n1|2,3");
        });
    }

    @Test
    public void testAddNegativeNumbers() {
        assertThrows(IllegalArgumentException.class, () -> {
            StringCalculator.add("1,-2");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            StringCalculator.add("2,-4,-9");
        });
    }



    @Test
    public void testNumbersBiggerThan1000() {
        assertEquals(2, StringCalculator.add("2,1001"));
    }
}


