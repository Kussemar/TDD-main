package dk.lyngby.kata3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class PasswordTest {
    Password password = new Password();

    @Test
    public void testLeast8Characters() {
        assertEquals("Password must be at least 8 characters", password.validateLength("1234567"));

    }

    @Test
    public void validateHasTwoDigits() {
        assertTrue(password.validateHasTwoDigits("12345678"));

    }


    @Test
    public void validateHasOneCapitalLetter() {
        assertTrue(password.validateHasOneCapitalLetter("12345678A"));

    }


    @Test
    public void passwordMustNotContainTheUsername(){

    }

}




