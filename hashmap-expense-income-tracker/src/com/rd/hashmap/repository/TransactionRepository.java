package com.rd.hashmap.repository;

    import com.rd.hashmap.model.Transaction;

    import java.util.ArrayList;
import java.util.HashMap;


public class TransactionRepository {
    private HashMap<Integer, ArrayList<Transaction>> transactions = new HashMap<>();

    public void addTransaction(Transaction transaction) {
        transactions.putIfAbsent(transaction.getWalletId(), new ArrayList<>());
        transactions.get(transaction.getWalletId()).add(transaction);
    }

    public ArrayList<Transaction> getTransactions(int walletId) {
        return transactions.getOrDefault(walletId, new ArrayList<>());
    }
}

