class Vehicle {
    String fuelType ;
    double maxSpeed;

    Vehicle(String fuelType, double maxSpeed) {
        this.fuelType  = fuelType ;
        this.maxSpeed = maxSpeed;
    }

    void displayInfo() {
        System.out.println("Vehicle Details:\nFuelType : " +fuelType+", maxSpeed: " + maxSpeed);
    }
}

class Car extends Vehicle {
    int seatCapacity ;

    Car(String fuelType , double maxSpeed, int seatCapacity ) {
        super(fuelType , maxSpeed);
        this.seatCapacity  = seatCapacity ;
    }

    @Override
    void displayInfo() {
        System.out.println("Vehicle Details (Car):\nFuelType : " +fuelType+", maxSpeed: " + maxSpeed+", Seat Capacity : "+seatCapacity);
    }
}

class Truck extends Vehicle {
    Truck(String fuelType , double maxSpeed) {
        super(fuelType , maxSpeed);
	}

    @Override
    void displayInfo() {
        System.out.println("Vehicle Details (Truck):\nFuelType : " +fuelType+", maxSpeed: " + maxSpeed);
    }
}

class Motorcycle extends Vehicle {
    Motorcycle(String fuelType , double maxSpeed) {
        super(fuelType , maxSpeed);
    }

    @Override
    void displayInfo() {
        System.out.println("Vehicle Details (Motorcycle):\nFuelType : " +fuelType+", maxSpeed: " + maxSpeed);
    }
}

public class VehicleHierarchy {
    public static void main(String[] args) {
        Vehicle Car = new Car("Pertol", 180, 4);
        Vehicle Truck = new Truck("Deisel", 200);
        Vehicle Motorcycle = new Motorcycle("EV", 90);

        Car.displayInfo();
        Truck.displayInfo();
        Motorcycle.displayInfo();
    }
}
