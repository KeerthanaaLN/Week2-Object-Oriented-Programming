import java.util.Scanner;

class Books {
    String title, author;
    double price;
    boolean isAvailable;
	
    public Books(String title, String author, double price, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("You have successfully borrowed: " + title);
        } else {
            System.out.println("Sorry, " + title + " is not available.");
        }
    }

    public void display() {
        System.out.println("Title: " + title + ", Author: " + author + 
                           ", Price: $" + price + ", Available: " + isAvailable);
    }

    public static void main(String[] args) {

        Books b1 = new Books("The Alchemist", "Paulo Coelho", 15.99, true);
        Books b2 = new Books("1984", "George Orwell", 12.50, false);

        b1.display();
        b2.display();

        b1.borrowBook();
        b2.borrowBook();

        b1.display();
        b2.display();
    }
}
