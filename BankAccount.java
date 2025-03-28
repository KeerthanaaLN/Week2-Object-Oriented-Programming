public class BankAccount {
    private static String bankName = "Global Bank";
    private static int totalAccounts = 0;

    private final int accountNumber;
    private String accountHolderName;

    public BankAccount(String accountHolderName, int accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        totalAccounts++;
    }

    public static void getTotalAccounts() {
        System.out.println("\nTotal accounts in " + bankName + ": " + totalAccounts);
    }

    public void displayAccountDetails() {
        if (this instanceof BankAccount) {
            System.out.println("\nBank Name: " + bankName);
            System.out.println("Account Holder: " + accountHolderName);
            System.out.println("Account Number: " + accountNumber);
        } else {
            System.out.println("Invalid account object.");
        }
    }

    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("John Doe", 101);
        BankAccount acc2 = new BankAccount("Jane Smith", 102);

        acc1.displayAccountDetails();
        acc2.displayAccountDetails();

        getTotalAccounts();
    }
}
