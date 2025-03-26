import java.util.Scanner;

class Item {
    int itemCode;
    String itemName;
    double price;

    Item(int itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    public void displayItemDetails() {
        System.out.printf("\nItem Details:\n");
        System.out.printf("Item Code : %d\nItem Name : %s\nPrice per unit : %.2f\n", itemCode, itemName, price);
    }

    public void calculateTotalCost(int quantity) {
        double totalCost = price * quantity;
        System.out.printf("Total Cost for %d units: %.2f\n", quantity, totalCost);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter Item Code: ");
        int itemCode = in.nextInt(); 
		in.nextLine();
		
        System.out.print("Enter Item Name: ");
        String itemName = in.nextLine();

        System.out.print("Enter Price per unit: ");
        double price = in.nextDouble();

        System.out.print("Enter Quantity: ");
        int quantity = in.nextInt();

        Item item = new Item(itemCode, itemName, price);

        item.displayItemDetails();
        item.calculateTotalCost(quantity);

        in.close();
    }
}
