import java.util.Scanner;

class ATM {
    private static final String USER_ID = "aditi";
    private static final String USER_PIN = "6464";
    private double balance;
    private boolean hasTransaction;

    public ATM() {
        balance = 0.0;
        hasTransaction = false;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the ATM!");

        if (!authenticateUser(scanner)) {
            System.out.println("Authentication failed. Exiting.");
            return;
        }

        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showTransactionHistory();
                    break;
                case 2:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    break;
                case 4:
                    System.out.print("Enter the amount to transfer: ");
                    double transferAmount = scanner.nextDouble();
                    System.out.print("Enter the recipient's account number: ");
                    String recipientAccount = scanner.next();
                    transfer(transferAmount, recipientAccount);
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    private boolean authenticateUser(Scanner scanner) {
        System.out.print("Enter user ID: ");
        String userID = scanner.next();
        System.out.print("Enter user PIN: ");
        String userPIN = scanner.next();

        if (userID.equals(USER_ID) && userPIN.equals(USER_PIN)) {
            System.out.println("Authentication successful!");
            return true;
        }
        return false;
    }

    private void displayMenu() {
        System.out.println("\nATM Functionalities:");
        System.out.println("1. Transaction History");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Transfer");
        System.out.println("5. Quit");
    }

    private void showTransactionHistory() {
        System.out.println("\nTransaction History:");
        if (hasTransaction) {
            System.out.println("No transactions yet");
        } else {
            System.out.println("No transactions yet");
        }
    }

    private void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient amount");
        } else {
            balance -= amount;
            System.out.println("Withdrawal of Rs" + amount + " successful!");
            System.out.println("Current balance: Rs" + balance);
            hasTransaction = true;
        }
    }

    private void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit of Rs" + amount + " successful!");
        System.out.println("Current balance: Rs" + balance);
        hasTransaction = true;
    }

    private void transfer(double amount, String recipientAccount) {
        System.out.println("Transfer of Rs" + amount + " to account " + recipientAccount + " successful!");
        System.out.println("Current balance: Rs" + balance);
        hasTransaction = true;
    }
}

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.start();
    }
}
