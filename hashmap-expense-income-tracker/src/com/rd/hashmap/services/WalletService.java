package com.rd.hashmap.services;

import com.rd.hashmap.model.Wallet;
import com.rd.hashmap.repository.WalletRepository;

public class WalletService {
        private WalletRepository walletRepository = new WalletRepository();
        private static int walletIdCounter = 1; // Simple counter for wallet IDs

        public void createWallet(String name, double balance) {
            Wallet wallet = new Wallet(walletIdCounter++, name, balance);
            walletRepository.saveWallet(wallet);
        }

        public void viewWallets() {
            walletRepository.viewAllWallets();
        }

        public Wallet getWalletById(int walletId) {
            return walletRepository.getWallet(walletId);
        }
    }


