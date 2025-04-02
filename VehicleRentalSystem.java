interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

abstract class Vehicle implements Insurable {
    private int vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(int vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public int getVehicleNumber() { return vehicleNumber; }
    public String getType() { return type; }
    public double getRentalRate() { return rentalRate; }

    public void setVehicleNumber(int vehicleNumber) { this.vehicleNumber = vehicleNumber; }
    public void setType(String type) { this.type = type; }
    public void setRentalRate(double rentalRate) { this.rentalRate = rentalRate; }

    public abstract double calculateRentalCost(int days);
}

class Car extends Vehicle {
    public Car(int vehicleNumber, String type, double rentalRate) {
        super(vehicleNumber, type, rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.10;
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance: 10% of rental rate.";
    }
}

class Bike extends Vehicle {
    public Bike(int vehicleNumber, String type, double rentalRate) {
        super(vehicleNumber, type, rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.05;
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance: 5% of rental rate.";
    }
}

class Truck extends Vehicle {
    public Truck(int vehicleNumber, String type, double rentalRate) {
        super(vehicleNumber, type, rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days + 500; // additional heavy-load charge
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.15;
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance: 15% of rental rate.";
    }
}

public class VehicleRentalSystem {
    public static void displayVehicleCosts(Vehicle[] vehicles, int days) {
        for (Vehicle v : vehicles) {
            double rentalCost = v.calculateRentalCost(days);
            double insurance = v.calculateInsurance();

            System.out.println("Vehicle Type: " + v.getType());
            System.out.println("Rental Cost for " + days + " days: Rs." + rentalCost);
            System.out.println("Insurance: Rs." + insurance);
            System.out.println(v.getInsuranceDetails());
            System.out.println("Total Cost: Rs." + (rentalCost + insurance));
            System.out.println("----------------------------------");
        }
    }

    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Car(101, "Sedan", 1500),
            new Bike(202, "Sport Bike", 500),
            new Truck(303, "Cargo Truck", 3000)
        };

        displayVehicleCosts(vehicles, 5); // 5-day rental
    }
}
