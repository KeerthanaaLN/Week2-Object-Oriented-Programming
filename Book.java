
import java.util.Scanner;

class Book {
    String title, author;
    double price;
	
	Book() {
        title = "Harry Potter";
        author = "J K Rowling";
        price = 897;
    }

    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void display() {
        System.out.printf("\nBook Details:\n");
        System.out.printf("Title  : %s\nAuthor : %s\nPrice  : %.2f\n", title, author, price);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter title of the book: ");
        String title = in.nextLine();

        System.out.print("Enter author of the book: ");
        String author = in.nextLine();

        System.out.print("Enter price of the book: ");
        double price = in.nextDouble();
		
		Book b1 = new Book();
		b1.display();

        Book b2 = new Book(title, author, price);
        b2.display();

        in.close();
    }
}