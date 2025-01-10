package com.rd.hashmap.services;

import com.rd.hashmap.model.Transaction;
import com.rd.hashmap.model.Wallet;
import com.rd.hashmap.repository.TransactionRepository;
import com.rd.hashmap.repository.WalletRepository;

       import java.util.ArrayList;

public class TransactionService {
    private TransactionRepository transactionRepository = new TransactionRepository();
    private WalletRepository walletRepository = new WalletRepository();

    public void addIncome(int walletId, double amount) {
        Wallet wallet = walletRepository.getWallet(walletId);
        if (wallet != null) {
            Transaction transaction = new Transaction(walletId, "income", amount);
            transactionRepository.addTransaction(transaction);

            // Update wallet balance
            wallet.setBalance(wallet.getBalance() + amount);
        }
    }

    public void addExpense(int walletId, double amount) {
        Wallet wallet = walletRepository.getWallet(walletId);
        if (wallet != null) {
            Transaction transaction = new Transaction(walletId, "expense", amount);
            transactionRepository.addTransaction(transaction);

            // Update wallet balance
            wallet.setBalance(wallet.getBalance() - amount);
        }
    }

    public void viewAllTransactions(int walletId) {
        ArrayList<Transaction> transactions = transactionRepository.getTransactions(walletId);
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            for (Transaction transaction : transactions) {
                System.out.println("Type: " + transaction.getType() + ", Amount: " + transaction.getAmount());
            }
        }
    }

    public void viewIncome(int walletId) {
        ArrayList<Transaction> transactions = transactionRepository.getTransactions(walletId);
        boolean hasIncome = false;

        for (Transaction transaction : transactions) {
            if (transaction.getType().equalsIgnoreCase("income")) {
                System.out.println("Income - Amount: " + transaction.getAmount());
                hasIncome = true;
            }
        }

        if (!hasIncome) {
            System.out.println("No income transactions found.");
        }
    }

    public void viewExpense(int walletId) {
        ArrayList<Transaction> transactions = transactionRepository.getTransactions(walletId);
        boolean hasExpense = false;

        for (Transaction transaction : transactions) {
            if (transaction.getType().equalsIgnoreCase("expense")) {
                System.out.println("Expense - Amount: " + transaction.getAmount());
                hasExpense = true;
            }
        }

        if (!hasExpense) {
            System.out.println("No expense transactions found.");
        }
    }
}
