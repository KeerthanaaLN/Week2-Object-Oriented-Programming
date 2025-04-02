interface Reservable {
    void reserveItem(String borrowerName);
    boolean checkAvailability();
}

abstract class LibraryItem implements Reservable {
    private String itemId;
    private String title;
    private String author;
    private String borrowerName;
    private boolean isReserved = false;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public String getItemId() { return itemId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getBorrowerName() { return borrowerName; }

    public void setItemId(String itemId) { this.itemId = itemId; }
    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }

    public void getItemDetails() {
        System.out.println("Id: " + itemId + "\nTitle: " + title + "\nAuthor: " + author);
    }

    public abstract int getLoanDuration();

    @Override
    public void reserveItem(String borrowerName) {
        if (!isReserved) {
            this.borrowerName = borrowerName;
            isReserved = true;
            System.out.println(title + " has been reserved by " + borrowerName);
        } else {
            System.out.println(title + " is already reserved.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return !isReserved;
    }
}

class Book extends LibraryItem {
    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 10;
    }
}

class Magazine extends LibraryItem {
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 5;
    }
}

class DVD extends LibraryItem {
    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 3;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryItem[] items = {
            new Book("B101", "Java Programming", "James Gosling"),
            new Magazine("M202", "Science Weekly", "Various Authors"),
            new DVD("D303", "The Matrix", "Wachowski Brothers")
        };

        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
            item.reserveItem("Alice");
            System.out.println("Available: " + item.checkAvailability());
            System.out.println("Borrower: " + item.getBorrowerName());
            System.out.println("--------------------------------");
        }
    }
}
