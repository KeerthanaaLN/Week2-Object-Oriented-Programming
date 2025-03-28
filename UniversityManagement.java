class Student {
    public int rollNumber;
    protected String name;
    private double CGPA;

    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    public double getCGPA() {
        return CGPA;
    }

    public void setCGPA(double CGPA) {
        if (CGPA >= 0.0 && CGPA <= 10.0) {
            this.CGPA = CGPA;
        } else {
            System.out.println("Invalid CGPA! It should be between 0 and 10.");
        }
    }

    public void displayStudentDetails() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + CGPA);
    }
}

class PostgraduateStudent extends Student {
    private String researchTopic;

    public PostgraduateStudent(int rollNumber, String name, double CGPA, String researchTopic) {
        super(rollNumber, name, CGPA);
        this.researchTopic = researchTopic;
    }

    public void displayPGStudentDetails() {
        super.displayStudentDetails();
        System.out.println("Research Topic: " + researchTopic);
    }
}

public class UniversityManagement {
    public static void main(String[] args) {
        Student s1 = new Student(101, "Alice", 8.5);
        System.out.println("Before updating CGPA:");
        s1.displayStudentDetails();

        s1.setCGPA(9.2);
        System.out.println("\nAfter updating CGPA:");
        s1.displayStudentDetails();

        System.out.println("\nPostgraduate Student:");
        PostgraduateStudent pg1 = new PostgraduateStudent(201, "Bob", 9.0, "Artificial Intelligence");
        pg1.displayPGStudentDetails();
    }
}
