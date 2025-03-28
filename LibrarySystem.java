class Book3 {
    public int ISBN;
    protected String title;
    private String author;

    public Book3(int ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void displayDetails() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

class EBook extends Book3 {
    private double fileSize;
    private String format;

    public EBook(int ISBN, String title, String author, double fileSize, String format) {
        super(ISBN, title, author);
        this.fileSize = fileSize;
        this.format = format;
    }

    public void displayEBookDetails() {
        super.displayDetails();
        System.out.println("File Size: " + fileSize + " MB");
        System.out.println("Format: " + format);
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Book3 book = new Book3(12345, "Java Programming", "John Doe");
        book.displayDetails();

        EBook ebook = new EBook(67890, "Python Basics", "Jane Smith", 2.5, "PDF");
        ebook.displayEBookDetails();
    }
}
