class Vehicle {
    private static double registrationFee = 7850.0; 

    private final String registrationNumber;
    private String ownerName, vehicleType;

    public Vehicle(String ownerName, String registrationNumber, String vehicleType) {
        this.ownerName = ownerName;
        this.registrationNumber = registrationNumber;
        this.vehicleType = vehicleType;
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
        System.out.println("Registration fee updated to: $" + registrationFee + "\n");
    }

    public void displayVehicleDetails() {
        if (this instanceof Vehicle) {
            System.out.println("Owner: " + ownerName + ", Vehicle Type: " + vehicleType +
                               ", Registration Number: " + registrationNumber +
                               ", Registration Fee: $" + registrationFee + "\n");
        } else {
            System.out.println("Invalid vehicle object.\n");
        }
    }

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("John Doe", "AB1234", "Car");
        Vehicle v2 = new Vehicle("Jane Smith", "XY5678", "Bike");

        v1.displayVehicleDetails();
        v2.displayVehicleDetails();
        updateRegistrationFee(8780.0);
        v1.displayVehicleDetails();
        v2.displayVehicleDetails();
    }
}
