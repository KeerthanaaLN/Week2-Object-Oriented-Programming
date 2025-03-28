
public class HospitalManagement {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("CityCare Hospital");

        Doctor d1 = new Doctor("Dr. Smith");
        Doctor d2 = new Doctor("Dr. Johnson");

        Patient p1 = new Patient("Alice");
        Patient p2 = new Patient("Bob");
        Patient p3 = new Patient("Charlie");

        hospital.addDoctor(d1);
        hospital.addDoctor(d2);
        hospital.addPatient(p1);
        hospital.addPatient(p2);
        hospital.addPatient(p3);

        d1.consult(p1);
        d1.consult(p2);
        d2.consult(p2);
        d2.consult(p3);

        System.out.println();
        d1.viewPatients();
        d2.viewPatients();

        System.out.println();
        p1.viewDoctors();
        p2.viewDoctors();
        p3.viewDoctors();
    }
}

class Hospital {
    private String name;
    private Doctor[] doctors;
    private Patient[] patients;
    private int doctorCount;
    private int patientCount;

    public Hospital(String name) {
        this.name = name;
        doctors = new Doctor[10];
        patients = new Patient[10];
        doctorCount = 0;
        patientCount = 0;
    }

    public void addDoctor(Doctor doctor) {
        if (doctorCount < doctors.length) {
            doctors[doctorCount++] = doctor;
        }
    }

    public void addPatient(Patient patient) {
        if (patientCount < patients.length) {
            patients[patientCount++] = patient;
        }
    }
}

class Doctor {
    private String name;
    private Patient[] patients;
    private int patientCount;

    public Doctor(String name) {
        this.name = name;
        patients = new Patient[20];
        patientCount = 0;
    }

    public void consult(Patient patient) {
        System.out.println(name + " is consulting " + patient.getName());
        if (patientCount < patients.length) {
            patients[patientCount++] = patient;
            patient.addDoctor(this);
        }
    }

    public void viewPatients() {
        System.out.println(name + " has consulted:");
        for (int i = 0; i < patientCount; i++) {
            System.out.println(" - " + patients[i].getName());
        }
    }

    public String getName() {
        return name;
    }
}

class Patient {
    private String name;
    private Doctor[] doctors;
    private int doctorCount;

    public Patient(String name) {
        this.name = name;
        doctors = new Doctor[20];
        doctorCount = 0;
    }

    public void addDoctor(Doctor doctor) {
        if (doctorCount < doctors.length) {
            doctors[doctorCount++] = doctor;
        }
    }

    public void viewDoctors() {
        System.out.println(name + " has consulted:");
        for (int i = 0; i < doctorCount; i++) {
            System.out.println(" - " + doctors[i].getName());
        }
    }

    public String getName() {
        return name;
    }
}

