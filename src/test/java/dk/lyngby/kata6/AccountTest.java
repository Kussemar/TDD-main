package dk.lyngby.kata6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccountTest {
    static Account account;

    @BeforeEach
    void setup(){
        account =  new Account("1234567890", 1000);
    }

    @Test
    void deposit() {
        account.deposit(100);
        int expected = 1100;
        int actual = account.getBalance();
        assertEquals(expected, actual);
    }

    @Test
    void withdraw() {
    account.withdraw(200);
    int expected = 800;
    int actual = account.getBalance();
    assertEquals(expected, actual);
    }

    @Test
    void depositNegativeNumber(){
        try {
            account.deposit(-100);
        } catch (IllegalArgumentException e) {
            assertEquals("Amount must be positive", e.getMessage());
        }
    }

    @Test
    void withdrawNegativeNumber(){
        try {
            account.withdraw(-100);
        } catch (IllegalArgumentException e) {
            assertEquals("Amount must be positive", e.getMessage());
        }
    }
}