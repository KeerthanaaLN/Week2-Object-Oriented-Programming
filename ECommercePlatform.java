interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

abstract class Product implements Taxable {
    private String productId;
    private String name;
    private double price;

    Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public abstract double calculateDiscount();

    public String getProductId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    public void setProductId(String productId) { this.productId = productId; }
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
}

class Electronics extends Product {
    public Electronics(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10;
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.15;
    }

    @Override
    public String getTaxDetails() {
        return "15% electronics tax applied.";
    }
}

class Clothing extends Product {
    public Clothing(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.20;
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.05;
    }

    @Override
    public String getTaxDetails() {
        return "5% clothing tax applied.";
    }
}

class Groceries extends Product {
    public Groceries(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05;
    }

    @Override
    public double calculateTax() {
        return 0.0;
    }

    @Override
    public String getTaxDetails() {
        return "No tax for groceries.";
    }
}

public class ECommercePlatform {

    public static void displayFinalPrices(Product[] products) {
        for (Product p : products) {
            double price = p.getPrice();
            double discount = p.calculateDiscount();
            double tax = p.calculateTax();
            String taxDetails = p.getTaxDetails();

            System.out.println(taxDetails);
            double finalPrice = price + tax - discount;

            System.out.println("Product: " + p.getName());
            System.out.printf("Base Price: %.2f, Discount: %.2f, Tax: %.2f, Final Price: %.2f%n%n",
                    price, discount, tax, finalPrice);
        }
    }

    public static void main(String[] args) {
        Product[] products = {
            new Electronics("E001", "Smartphone", 50000),
            new Clothing("C001", "Jeans", 2000),
            new Groceries("G001", "Rice", 500)
        };

        displayFinalPrices(products);
    }
}
