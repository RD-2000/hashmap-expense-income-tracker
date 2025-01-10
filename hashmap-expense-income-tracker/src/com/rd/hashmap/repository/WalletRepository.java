package com.rd.hashmap.repository;
import com.rd.hashmap.model.Wallet;

import java.util.HashMap;

public class WalletRepository {
    private HashMap<Integer, Wallet> wallets = new HashMap<>();
    private static int walletIdCounter = 1;

    public void saveWallet(Wallet wallet) {
        wallets.put(wallet.getId(), wallet);
    }

    public Wallet getWallet(int id) {
        return wallets.get(id);
    }

    public void viewAllWallets() {
        for (Wallet wallet : wallets.values()) {
            System.out.println("ID: " + wallet.getId() + ", Name: " + wallet.getName() + ", Balance: " + wallet.getBalance());
        }
    }
}
