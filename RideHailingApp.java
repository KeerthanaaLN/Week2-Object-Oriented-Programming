interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

abstract class Vehicle implements GPS {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    private String currentLocation;

    public Vehicle(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
        this.currentLocation = currentLocation;
    }

    public String getVehicleId() { return vehicleId; }
    public String getDriverName() { return driverName; }
    public double getRatePerKm() { return ratePerKm; }

    public void setVehicleId(String vehicleId) { this.vehicleId = vehicleId; }
    public void setDriverName(String driverName) { this.driverName = driverName; }
    public void setRatePerKm(double ratePerKm) { this.ratePerKm = ratePerKm; }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }

    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate per Km: ₹" + ratePerKm);
        System.out.println("Current Location: " + currentLocation);
    }

    public abstract double calculateFare(double distance);
}

class Car extends Vehicle {
    public Car(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm, currentLocation);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() + 50; 
    }
}

class Bike extends Vehicle {
    public Bike(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm, currentLocation);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm(); 
    }
}

class Auto extends Vehicle {
    public Auto(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm, currentLocation);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() + 20; 
    }
}

public class RideHailingApp {
    public static void main(String[] args) {
        Vehicle[] rides = {
			new Car("C101", "Ravi", 12.5, "MG Road"),
			new Bike("B202", "Kiran", 7.0, "Indiranagar"),
			new Auto("A303", "Rahul", 9.0, "BTM Layout")
		};

        double[] distances = {8.0, 5.5, 10.0};

		int index = 0;
		for (Vehicle ride : rides) {
			System.out.println("\n--- Ride Details ---");
			ride.getVehicleDetails();
			System.out.println("Distance Travelled: " + distances[index] + " km");
			double fare = ride.calculateFare(distances[index]);
			System.out.printf("Total Fare: ₹%.2f\n", fare);
			ride.updateLocation("Destination Reached");
			System.out.println("Updated Location: " + ride.getCurrentLocation());
			index++;
		}

    }
}
