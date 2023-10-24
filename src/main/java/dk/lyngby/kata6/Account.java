package dk.lyngby.kata6;

import java.time.LocalDate;
import java.util.ArrayList;

public class Account {
    private String accountNumber;
    private int balance;

    ArrayList<Transaction> transactions = new ArrayList<Transaction>();

    public Account(String accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add(new Transaction(amount, LocalDate.now(), balance));
        } else {
            throw new IllegalArgumentException("Amount must be positive");
        }
    }

    public void withdraw(int amount) {
        if (amount > 0) {
            balance -= amount;
            transactions.add(new Transaction(-amount, LocalDate.now(), balance));
        } else {
            throw new IllegalArgumentException("Amount must be positive");
        }

    }

    public void printStatement() {
        System.out.println("Date\t\tAmount\tBalance");
        for (Transaction transaction : transactions) {
            System.out.println(transaction.getDate() + "\t" + transaction.getAmount() + "\t" + transaction.getBalance());
        }
    }

    public static void main(String[] args) {
        Account account = new Account("1234567890", 1000);
        account.deposit(100);
        account.withdraw(200);
        account.printStatement();
    }

    public int getBalance() {
        return balance;
    }
}
