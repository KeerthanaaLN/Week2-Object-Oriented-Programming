interface MedicalRecord {
    void addRecord(String diagnosis);
    void viewRecords();
}

abstract class Patient implements MedicalRecord {
    private String patientId;
    private String name;
    private int age;
    private String diagnosis;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public String getPatientId() { return patientId; }
    public String getName() { return name; }
    public int getAge() { return age; }

    public void setPatientId(String patientId) { this.patientId = patientId; }
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }

    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    @Override
    public void addRecord(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public void viewRecords() {
        System.out.println("Diagnosis: " + diagnosis);
    }

    public abstract double calculateBill();
}

class InPatient extends Patient {
    private int daysAdmitted;
    private double dailyCharge;

    public InPatient(String patientId, String name, int age, int daysAdmitted, double dailyCharge) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
        this.dailyCharge = dailyCharge;
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * dailyCharge;
    }
}

class OutPatient extends Patient {
    private double consultationFee;

    public OutPatient(String patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }
}

public class HospitalManagementSystem {
    public static void main(String[] args) {
        Patient[] patients = new Patient[2];

        patients[0] = new InPatient("P101", "Alice", 35, 4, 1500.0);
        patients[1] = new OutPatient("P102", "Bob", 28, 500.0);

        patients[0].addRecord("Appendicitis");
        patients[1].addRecord("Fever");

        for (Patient p : patients) {
            System.out.println("\n--- Patient Details ---");
            p.getPatientDetails();
            p.viewRecords();
            double bill = p.calculateBill();
            System.out.printf("Total Bill: ₹%.2f\n", bill);
        }
    }
}
