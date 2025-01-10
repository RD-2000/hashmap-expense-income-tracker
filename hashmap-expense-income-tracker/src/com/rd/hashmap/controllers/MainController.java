package com.rd.hashmap.controllers;

    import com.rd.hashmap.model.User;
    import com.rd.hashmap.services.TransactionService;
    import com.rd.hashmap.services.UserService;
    import com.rd.hashmap.services.WalletService;

    import java.util.Scanner;

     import java.util.Scanner;
    import java.util.Scanner;

public class MainController {
    private UserService userService = new UserService();
    private WalletService walletService = new WalletService();
    private TransactionService transactionService = new TransactionService();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println("Welcome to the Expense and Income Tracker!");
        displayMainMenu();
    }

    private void displayMainMenu() {
        int choice;
        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    loginUser();
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void registerUser() {
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();
        userService.registerUser(username, password);
        System.out.println("User registered successfully!");
    }

    private void loginUser() {
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();

        User loggedInUser = userService.loginUser(username, password);
        if (loggedInUser != null) {
            System.out.println("Login successful!");
            displayUserMenu();
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    private void displayUserMenu() {
        int choice;
        while (true) {
            System.out.println("\nUser Menu:");
            System.out.println("1. Create Wallet");
            System.out.println("2. View Wallets");
            System.out.println("3. Add Transaction");
            System.out.println("4. View Transactions");
            System.out.println("5. View Income");
            System.out.println("6. View Expense");
            System.out.println("7. Logout");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createWallet();
                    break;
                case 2:
                    walletService.viewWallets();
                    break;
                case 3:
                    addTransaction();
                    break;
                case 4:
                    viewTransactions();
                    break;
                case 5:
                    viewIncome();
                    break;
                case 6:
                    viewExpense();
                    break;
                case 7:
                    System.out.println("Logged out.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void createWallet() {
        System.out.print("Enter wallet name: ");
        String name = scanner.next();
        System.out.print("Enter initial balance: ");
        double balance = scanner.nextDouble();
        walletService.createWallet(name, balance);
    }

    private void addTransaction() {
        System.out.print("Enter wallet ID: ");
        int walletId = scanner.nextInt();
        System.out.print("Enter transaction type (income/expense): ");
        String type = scanner.next();
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();

        if (type.equalsIgnoreCase("income")) {
            transactionService.addIncome(walletId, amount);
        } else if (type.equalsIgnoreCase("expense")) {
            transactionService.addExpense(walletId, amount);
        } else {
            System.out.println("Invalid transaction type.");
        }
    }

    private void viewTransactions() {
        System.out.print("Enter wallet ID: ");
        int walletId = scanner.nextInt();
        transactionService.viewAllTransactions(walletId);
    }

    private void viewIncome() {
        System.out.print("Enter wallet ID: ");
        int walletId = scanner.nextInt();
        transactionService.viewIncome(walletId);
    }

    private void viewExpense() {
        System.out.print("Enter wallet ID: ");
        int walletId = scanner.nextInt();
        transactionService.viewExpense(walletId);
    }
}

