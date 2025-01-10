package com.rd.hashmap.model;

public class Transaction {
        private int walletId;
        private String type; // "income" or "expense"
        private double amount;

        public Transaction(int walletId, String type, double amount) {
            this.walletId = walletId;
            this.type = type;
            this.amount = amount;
        }

        public int getWalletId() {
            return walletId;
        }

        public String getType() {
            return type;
        }

        public double getAmount() {
            return amount;
        }
    }


