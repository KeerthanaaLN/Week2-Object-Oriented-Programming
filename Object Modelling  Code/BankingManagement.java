
public class BankingManagement {
    public static void main(String[] args) {
        Bank bank = new Bank("Global Bank");

        Customer c1 = new Customer("Alice");
        Customer c2 = new Customer("Bob");

        bank.openAccount(c1, 1000);
        bank.openAccount(c1, 2500);
        bank.openAccount(c2, 5000);

        c1.viewBalances();
        c2.viewBalances();
    }
}

class Bank {
    private String name;

    public Bank(String name) {
        this.name = name;
    }

    public void openAccount(Customer customer, double initialBalance) {
        Account account = new Account(this, initialBalance);
        customer.addAccount(account);
        System.out.println("Account opened for " + customer.getName() + " in " + name + " with balance: " + initialBalance);
    }

    public String getName() {
        return name;
    }
}

class Customer {
    private String name;
    private Account[] accounts;
    private int count;

    public Customer(String name) {
        this.name = name;
        accounts = new Account[10];
        count = 0;
    }

    public void addAccount(Account account) {
        if (count < accounts.length) {
            accounts[count++] = account;
        }
    }

    public String getName() {
        return name;
    }

    public void viewBalances() {
        System.out.println("Accounts of " + name + ":");
        for (int i = 0; i < count; i++) {
            System.out.println(" - Bank: " + accounts[i].getBank().getName() + ", Balance: " + accounts[i].getBalance());
        }
        System.out.println();
    }
}

class Account {
    private Bank bank;
    private double balance;

    public Account(Bank bank, double balance) {
        this.bank = bank;
        this.balance = balance;
    }

    public Bank getBank() {
        return bank;
    }

    public double getBalance() {
        return balance;
    }
}

