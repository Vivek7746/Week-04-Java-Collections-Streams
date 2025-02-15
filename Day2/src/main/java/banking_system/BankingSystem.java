package banking_system;

import java.util.*;

// Class representing a Banking System
class BankingSystem {
    private Map<Integer, Double> accountBalances = new HashMap<>(); // Store account balances
    private TreeMap<Double, Integer> sortedAccounts = new TreeMap<>(); // Sort accounts by balance
    private Queue<Integer> withdrawalQueue = new LinkedList<>(); // Queue for withdrawal requests

    // Add a new account
    public void addAccount(int accountNumber, double balance) {
        accountBalances.put(accountNumber, balance);
        sortedAccounts.put(balance, accountNumber);
    }

    // Process a withdrawal request
    public void requestWithdrawal(int accountNumber) {
        if (accountBalances.containsKey(accountNumber)) {
            withdrawalQueue.add(accountNumber);
            System.out.println("Withdrawal requested for Account: " + accountNumber);
        } else {
            System.out.println("Account not found.");
        }
    }

    // Process the next withdrawal request
    public void processWithdrawal(double amount) {
        if (!withdrawalQueue.isEmpty()) {
            int accountNumber = withdrawalQueue.poll();
            double currentBalance = accountBalances.get(accountNumber);
            if (currentBalance >= amount) {
                accountBalances.put(accountNumber, currentBalance - amount);
                System.out.println("Withdrawal of " + amount + " processed for Account: " + accountNumber);
            } else {
                System.out.println("Insufficient balance for Account: " + accountNumber);
            }
        } else {
            System.out.println("No withdrawal requests in queue.");
        }
    }

    // Display account balances
    public void displayAccountBalances() {
        System.out.println("Account Balances: " + accountBalances);
    }

    // Display accounts sorted by balance
    public void displaySortedAccounts() {
        System.out.println("Accounts Sorted by Balance: " + sortedAccounts);
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        // Adding sample accounts
        bank.addAccount(101, 1500.00);
        bank.addAccount(102, 2500.00);
        bank.addAccount(103, 1000.00);

        // Display account details
        bank.displayAccountBalances();
        bank.displaySortedAccounts();

        // Request and process withdrawals
        bank.requestWithdrawal(101);
        bank.processWithdrawal(500);
        bank.displayAccountBalances();
    }
}