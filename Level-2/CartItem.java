import java.util.*;

class CartItem {
    static int count = 0; 
    static String[] itemNames = new String[100]; 
    static double[][] itemDetails = new double[100][3]; 
    
    static String itemName;
    static double price;
    static double quantity;

    static boolean addItem() {
        if (itemName.trim().isEmpty()) {
            return false;
        }
        
        itemNames[count] = itemName;
        itemDetails[count][0] = price;
        itemDetails[count][1] = quantity;
        itemDetails[count][2] = price * quantity;
        count++;
        
        return true;
    }

    static double calculateTotalCost() {
        double totalCost = 0.0;
        for (int i = 0; i < count; i++) {
            totalCost += itemDetails[i][2];
        }
        return totalCost;
    }

    static void removeItem() {
        for (int i = 0; i < count; i++) {
            if (itemNames[i] != null && itemNames[i].equalsIgnoreCase(itemName)) {
                for (int j = i; j < count - 1; j++) {
                    itemNames[j] = itemNames[j + 1];
                    itemDetails[j] = itemDetails[j + 1];
                }
                count--;
                System.out.println("Item removed successfully.");
                return;
            }
        }
        System.out.println("Item not found in cart.");
    }

    static void display() {
        if (count == 0) {
            System.out.println("Cart is empty.");
            return;
        }

        System.out.println("\nCart Items:");
        for (int i = 0; i < count; i++) {
            System.out.println("Item Name: " + itemNames[i] +
                    " | Price: " + itemDetails[i][0] +
                    " | Quantity: " + itemDetails[i][1] +
                    " | Total: " + itemDetails[i][2]);
        }
        System.out.println("Total Amount: " + calculateTotalCost());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char option;

        do {
            System.out.print("\nMENU\n1. Add Item\n2. Remove Item\n3. Display Cart\nEnter your choice: ");
            int choice = in.nextInt();
            in.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Item Name: ");
                    itemName = in.nextLine();

                    System.out.print("Enter " + itemName + " Price: ");
                    price = in.nextDouble();

                    System.out.print("Enter " + itemName + " Quantity: ");
                    quantity = in.nextDouble();

                    if (addItem())
                        System.out.println("Item added successfully.");
                    else
                        System.out.println("Item not added.");
                    break;

                case 2:
                    System.out.print("Enter Item Name to remove: ");
                    itemName = in.nextLine();
                    removeItem();
                    break;

                case 3:
                    display();
                    break;

                default:
                    System.out.println("Enter a valid input!!!");
            }

            System.out.print("Do you want to continue again (y/n): ");
            option = in.next().charAt(0);
        } while (option == 'y' || option == 'Y');

        in.close();
    }
}
