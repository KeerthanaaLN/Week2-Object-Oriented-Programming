class BankAccount {
    String accountNumber;
    double balance;

    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void displayDetails() {
        System.out.println("Account Number: " + accountNumber + ", Balance: $" + balance);
    }
}

class SavingsAccount extends BankAccount {
    double interestRate;

    SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Account Type: Savings, Interest Rate: " + interestRate + "%");
    }
}

class CheckingAccount extends BankAccount {
    double withdrawalLimit;

    CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Account Type: Checking, Withdrawal Limit: $" + withdrawalLimit);
    }
}

public class BankManagement {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("SAV12345", 5000.0, 3.5);
        CheckingAccount checking = new CheckingAccount("CHK67890", 3000.0, 1000.0);

        savings.displayDetails();
        System.out.println();
        checking.displayDetails();
    }
}
