interface Discountable {
    double applyDiscount();
    void getDiscountDetails();
}

abstract class FoodItem implements Discountable {
    private String itemName;
    private double price;
    private int quantity;

    FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() { return itemName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public void setItemName(String itemName) { this.itemName = itemName; }
    public void setPrice(double price) { this.price = price; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public void getItemDetails() {
        System.out.println("Item Name: " + itemName+"\nPrice: " + price+"\nQuantity: " + quantity);
    }

    public abstract double calculateTotalPrice();
}

class VegItem extends FoodItem {
    VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.15;
    }

    @Override
    public void getDiscountDetails() {
        System.out.println("15% discount on Veg Items");
    }
}

class NonVegItem extends FoodItem {
    NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity() * 1.10;
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.04;
    }

    @Override
    public void getDiscountDetails() {
        System.out.println("4% discount on Non-Veg Items");
    }
}

public class FoodDeliverySystem {
    public static void main(String[] args) {
        FoodItem[] foodItems = {
            new VegItem("Parotta", 70, 2),
            new NonVegItem("Biryani", 180, 5)
        };

        for (FoodItem item : foodItems) {
            item.getItemDetails();
            double totalPrice = item.calculateTotalPrice();
            double discount = item.applyDiscount();
            item.getDiscountDetails();
            System.out.printf("Total Price before discount: %.2f\n", totalPrice);
            System.out.printf("Discount Amount: %.2f\n", discount);
            System.out.printf("Final Price after discount: %.2f\n", (totalPrice - discount));
            System.out.println("---------------------------------");
        }
    }
}
