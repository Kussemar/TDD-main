package dk.lyngby.kata1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {
    FizzBuzz fizzBuzz = new FizzBuzz();

    @Test
    public void testInput() {
        assertEquals("1", fizzBuzz.fizzBuzz(1));

    }
    @Test
    public void testInput2() {
        assertEquals("Fizz", fizzBuzz.fizzBuzz(3));
    }

    @Test
    public void testInput3() {
        assertEquals("Buzz", fizzBuzz.fizzBuzz(5));
    }

    @Test
    public void testInput4() {
        assertEquals("FizzBuzz", fizzBuzz.fizzBuzz(15));
    }
}