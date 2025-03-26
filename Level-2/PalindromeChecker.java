import java.util.*;

class PalindromeChecker {
    String text;

    PalindromeChecker(String text) {
        this.text = text;
    }

    boolean isPalindrome() {
        String reverseStr = "";
        for (int i = text.length() - 1; i >= 0; i--) {
            reverseStr += text.charAt(i);
        }
        return text.equalsIgnoreCase(reverseStr); 
    }

    void displayResult() {
        if (isPalindrome()) {
            System.out.println(text +" is a palindrome.");
        } else {
            System.out.println(text +" is not a palindrome.");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = in.nextLine();

        PalindromeChecker checker = new PalindromeChecker(text);
        checker.displayResult();

        in.close();
    }
}
