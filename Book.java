class Book {
    private static String libraryName = "BV Library";
    private String title, author;
    private final int isbn;

    public Book(String title, String author, int isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    public void displayBookDetails() {
        if (this instanceof Book) {
            System.out.println("ISBN: " + isbn + ", Title: " + title + ", Author: " + author);
        } else {
            System.out.println("Invalid book object.");
        }
    }

    public static void main(String[] args) {
        Book b1 = new Book("Java Programming", "James Gosling", 123456);
        Book b2 = new Book("Python Basics", "Guido van Rossum", 789012);

        displayLibraryName();
        b1.displayBookDetails();
        b2.displayBookDetails();
    }
}
