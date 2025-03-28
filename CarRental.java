import java.util.Scanner;

class CarRental {
    String customerName, carModel;
    int rentalDays;

    CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        int totalCost = rentalDays * 550;
		display();
        System.out.println(", Total Cost Calculated: " + totalCost);
    }

    public void display() {
        System.out.print("Customer Name : " + customerName + 
                           ", Car Model : " + carModel + 
                           ", Rental Days : " + rentalDays);
    }

    public static void main(String[] args) {
        CarRental c1 = new CarRental("Sujatha", "Benz - B class", 4);
    }
}
