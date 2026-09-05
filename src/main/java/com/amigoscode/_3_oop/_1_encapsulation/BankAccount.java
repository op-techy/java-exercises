package com.amigoscode._3_oop._1_encapsulation;

/**
 * Exercise: Encapsulation with BankAccount
 *
 * Learn how to protect data using private fields, provide controlled access
 * through getters, and enforce business rules in methods.
 *
 * Key concepts:
 * - Private fields to hide internal state
 * - Public methods to provide controlled access
 * - Validation logic inside setters/methods
 * - Private helper methods
 */
public class BankAccount {

    private String accountNumber;
    private double balance;
    private String ownerName;


    // TODO: 2 - Create a constructor that takes accountNumber, ownerName,

    public BankAccount(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        if (balance < 0) {
            throw new IllegalArgumentException("Initial account balance can't be less than zero.");
        }
        this.balance = balance;

    }

    public double getBalance() {
        return balance;
    }

    public double deposit(double amount){
        if (amount <= 0) throw new IllegalArgumentException("Deposit amount must be positive");
        balance += amount;
        String msg = "Amount deposited: " + amount;
        logTransaction(msg);
        return balance;
    }

    public double withdraw(double amount){
        if (amount <= 0) throw new IllegalArgumentException("Withdrawal amount must be positive");
        if (amount > balance) throw new IllegalStateException("Insufficient funds");
        balance -= amount;
        String msg = "Amount withdrawn: " + amount;
        logTransaction(msg);
        return balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", ownerName='" + ownerName + '\'' +
                '}';
    }

    private void logTransaction(String message){
        System.out.println("[Transaction Log] " + message);
    }

    public static void main(String[] args) {
        // Uncomment and test after completing the TODOs:
         BankAccount account = new BankAccount("ACC-001", "Alice", 1000.0);
         System.out.println(account);
         System.out.println("Balance: " + account.getBalance());

         account.deposit(500.0);
         System.out.println("After deposit: " + account.getBalance());

         account.withdraw(200.0);
         System.out.println("After withdrawal: " + account.getBalance());

         // These should throw exceptions:
         // account.deposit(-100);
         // account.withdraw(999999);
    }
}
