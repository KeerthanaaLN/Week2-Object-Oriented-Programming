class Product {
    private static double discount = 10.0;

    private final int productID;
    private String productName;
    private double price;
    private int quantity;

    public Product(int productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public static void updateDiscount(double newdiscount) {
        discount = newdiscount;
        System.out.println("\nDiscount updated to: " + discount + "%");
    }

    public void displayProductDetails() {
        if (this instanceof Product) {
            System.out.println("\nProduct ID: " + productID + ", Product Name: " + productName + ", Price: $" + price + 
                   ", Quantity: " + quantity + ", Discount: " + discount + "%, Final Price after Discount: $" + (price - (price * discount / 100)));
        } else {
            System.out.println("Invalid product object.");
        }
    }

    public static void main(String[] args) {
        Product p1 = new Product(101, "Laptop", 1200.0, 1);
        Product p2 = new Product(102, "Smartphone", 800.0, 2);

        p1.displayProductDetails();
        p2.displayProductDetails();

        updateDiscount(15.0);

        p1.displayProductDetails();
        p2.displayProductDetails();
    }
}
