class BankAccount {
    public int accountNumber;
    protected String accountHolder;
    private double balance;

    public BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Balance cannot be negative!");
        }
    }

    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: $" + balance);
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(int accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    public void displaySavingAcctDetails() {
        displayDetails();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

public class Bank {
    public static void main(String[] args) {
        BankAccount b1 = new BankAccount(101, "Alice", 50000);
        b1.displayDetails();

        System.out.println();

        SavingsAccount s1 = new SavingsAccount(102, "Bob", 75000, 4.5);
        s1.displaySavingAcctDetails();

        System.out.println("\nUpdating balance...");
        b1.setBalance(60000);
        b1.displayDetails();
    }
}
