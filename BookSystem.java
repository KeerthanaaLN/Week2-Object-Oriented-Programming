class Book {
    String title;
    int publicationYear;

    Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    void displayInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}

class Author extends Book {
    String authorName;
    String bio;

    Author(String title, int publicationYear, String authorName, String bio) {
        super(title, publicationYear);
        this.authorName = authorName;
        this.bio = bio;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Author: " + authorName);
        System.out.println("Bio: " + bio);
    }
}

public class BookSystem {
    public static void main(String[] args) {
        Author book1 = new Author("Harry Potter and the Sorcerer's Stone", 1997, "J.K. Rowling", "British author, famous for the Harry Potter series.");
        book1.displayInfo();
    }
}
