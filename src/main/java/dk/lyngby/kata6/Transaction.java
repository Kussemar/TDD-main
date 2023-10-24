package dk.lyngby.kata6;

import java.time.LocalDate;

public class Transaction {
    private int amount;
    private LocalDate date;
    private int balance;

    public Transaction(int amount, LocalDate date, int balance) {
        this.amount = amount;
        this.date = date;
        this.balance = balance;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getBalance() {
        return balance;
    }
}
