class Order {
    int orderId;
    String orderDate;

    Order(int orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    void getOrderStatus() {
        System.out.println("Order ID: " + orderId + ", Order Date: " + orderDate + ", Status: Order Placed");
    }
}

class ShippedOrder extends Order {
    int trackingNumber;

    ShippedOrder(int orderId, String orderDate, int trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    void getOrderStatus() {
        super.getOrderStatus();
        System.out.println("Tracking Number: " + trackingNumber + ", Status: Shipped");
    }
}

class DeliveredOrder extends ShippedOrder {
    String deliveryDate;

    DeliveredOrder(int orderId, String orderDate, int trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    @Override
    void getOrderStatus() {
        super.getOrderStatus();
        System.out.println("Delivery Date: " + deliveryDate + ", Status: Delivered");
    }
}

public class RetailManagement {
    public static void main(String[] args) {
        DeliveredOrder order = new DeliveredOrder(1001, "2025-03-10", 987654, "2025-03-15");
        order.getOrderStatus();
    }
}
