interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

abstract class BankAccount implements Loanable {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }

    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }
    public void setHolderName(String holderName) { this.holderName = holderName; }
    public void setBalance(double balance) { this.balance = balance; }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: Rs." + amount);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: Rs." + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public abstract double calculateInterest();
}

class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * 0.04;
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Savings Account Loan Applied: Rs." + amount);
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() >= 10000; 
    }
}

class CurrentAccount extends BankAccount {
    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * 0.02;
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Current Account Loan Applied: Rs." + amount);
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() >= 20000;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        BankAccount[] accounts = {
            new SavingsAccount("S001", "Alice", 15000),
            new CurrentAccount("C001", "Bob", 25000)
        };

        for (BankAccount account : accounts) {
            System.out.println("Account Holder: " + account.getHolderName());
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Balance: Rs." + account.getBalance());
            System.out.println("Interest Earned: Rs." + account.calculateInterest());

            account.deposit(2000);
            account.withdraw(1000);

            account.applyForLoan(50000);
            System.out.println("Loan Eligibility: " + (account.calculateLoanEligibility() ? "Eligible" : "Not Eligible"));
            System.out.println("----------------------------------------------------");
        }
    }
}
