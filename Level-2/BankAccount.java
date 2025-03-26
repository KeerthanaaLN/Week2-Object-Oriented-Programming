import java.util.Scanner;

class BankAccount {
    String accountHolder;
    long accountNumber;
    double balance;

    BankAccount(String accountHolder, long accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("%.2f deposited successfully.\n", amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.printf("%.2f withdrawn successfully.\n", amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    void displayBalance() {
        System.out.printf("Current Balance: ₹%.2f\n", balance);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter Account Holder Name: ");
        String accountHolder = in.nextLine();

        System.out.print("Enter Account Number: ");
        long accountNumber = in.nextLong();

        System.out.print("Enter Initial Balance: ");
        double balance = in.nextDouble();

        BankAccount account = new BankAccount(accountHolder, accountNumber, balance);

        int choice;
        do {
            System.out.print("\nChoose an option:\n1. Deposit\n2. Withdraw\n3. Display Balance\n4. Exit\nEnter your choice: ");

            choice = in.nextInt();

            if (choice == 1) {
                System.out.print("Enter deposit amount: ");
                double depositAmount = in.nextDouble();
                account.deposit(depositAmount);
            } 
			else if (choice == 2) {
                System.out.print("Enter withdrawal amount: ");
                double withdrawalAmount = in.nextDouble();
                account.withdraw(withdrawalAmount);
            } 
			else if (choice == 3) 
                account.displayBalance();
			else if (choice == 4) 
                System.out.println("Thank you for using the ATM!"); 
			else 
                System.out.println("Invalid choice. Please try again.");

        } while (choice != 4);

        in.close();
    }
}
