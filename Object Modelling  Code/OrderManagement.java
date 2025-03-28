
public class OrderManagement {
    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 800.0);
        Product p2 = new Product("Phone", 500.0);
        Product p3 = new Product("Headphones", 150.0);

        Customer c1 = new Customer("Alice");
        Customer c2 = new Customer("Bob");

        Order o1 = c1.placeOrder();
        o1.addProduct(p1);
        o1.addProduct(p3);

        Order o2 = c2.placeOrder();
        o2.addProduct(p2);

        Order o3 = c2.placeOrder();
        o3.addProduct(p1);
        o3.addProduct(p2);
        o3.addProduct(p3);

        c1.viewOrders();
        c2.viewOrders();
    }
}

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getInfo() {
        return name + " - $" + price;
    }

    public double getPrice() {
        return price;
    }
}

class Order {
    private static int orderCounter = 1;
    private int orderId;
    private Product[] products;
    private int productCount;

    public Order() {
        this.orderId = orderCounter++;
        this.products = new Product[10];
        this.productCount = 0;
    }

    public void addProduct(Product product) {
        if (productCount < products.length) {
            products[productCount++] = product;
        }
    }

    public void viewOrder() {
        System.out.println("Order ID: " + orderId);
        double total = 0;
        for (int i = 0; i < productCount; i++) {
            System.out.println(" - " + products[i].getInfo());
            total += products[i].getPrice();
        }
        System.out.println("Total: $" + total);
        System.out.println();
    }
}

class Customer {
    private String name;
    private Order[] orders;
    private int orderCount;

    public Customer(String name) {
        this.name = name;
        this.orders = new Order[10];
        this.orderCount = 0;
    }

    public Order placeOrder() {
        if (orderCount < orders.length) {
            Order order = new Order();
            orders[orderCount++] = order;
            return order;
        }
        return null;
    }

    public void viewOrders() {
        System.out.println("Customer: " + name + "'s Orders:");
        for (int i = 0; i < orderCount; i++) {
            orders[i].viewOrder();
        }
    }
}

