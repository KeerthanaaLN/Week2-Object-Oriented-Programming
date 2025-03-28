class Patient {
    private static String hospitalName = "MMM Hospital";
    private static int totalPatients = 0;

    private final int patientID;
    private String name;
    private int age;
    private String ailment;

    public Patient(String name, int patientID, int age, String ailment) {
        this.name = name;
        this.patientID = patientID;
        this.age = age;
        this.ailment = ailment;
        totalPatients++;
    }

    public static void getTotalPatients() {
        System.out.println("Total Patients admitted to " + hospitalName + ": " + totalPatients);
    }

    public void displayPatientDetails() {
        if (this instanceof Patient) {
            System.out.println("Hospital: " + hospitalName + ", Patient ID: " + patientID + ", Name: " + name + ", Age: " + age + ", Ailment: " + ailment);
        } else {
            System.out.println("Invalid patient object.");
        }
    }

    public static void main(String[] args) {
        Patient p1 = new Patient("Keerthi", 101, 30, "Fever");
        Patient p2 = new Patient("Swetha", 102, 45, "Fracture");
        Patient p3 = new Patient("Suji", 103, 60, "Asthma");

        p1.displayPatientDetails();
        p2.displayPatientDetails();
        p3.displayPatientDetails();

        getTotalPatients();
    }
}
