
public class LibraryManagement {
    public static void main(String[] args) {
        Book b1 = new Book("1984", "George Orwell");
        Book b2 = new Book("To Kill a Mockingbird", "Harper Lee");
        Book b3 = new Book("The Great Gatsby", "F. Scott Fitzgerald");

        Library cityLibrary = new Library("City Library", 5);
        Library schoolLibrary = new Library("School Library", 5);

        cityLibrary.addBook(b1);
        cityLibrary.addBook(b2);

        schoolLibrary.addBook(b2);
        schoolLibrary.addBook(b3);

        cityLibrary.displayBooks();
        schoolLibrary.displayBooks();
    }
}

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String toString() {
        return "\"" + title + "\" by " + author;
    }
}

class Library {
    private String name;
    private Book[] books;
    private int count;

    public Library(String name, int size) {
        this.name = name;
        books = new Book[size];
        count = 0;
    }

    public void addBook(Book book) {
        if (count < books.length) {
            books[count] = book;
            count++;
        } else {
            System.out.println("Library is full, cannot add more books.");
        }
    }

    public void displayBooks() {
        System.out.println("Library: " + name);
        if (count == 0) {
            System.out.println("No books in this library.");
        } else {
            for (int i = 0; i < count; i++) {
                System.out.println(" - " + books[i]);
            }
        }
        System.out.println();
    }
}

