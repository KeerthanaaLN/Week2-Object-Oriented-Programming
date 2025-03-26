import java.util.Scanner;

class Student {
    String name;
    int rollNumber;
    float marks;

    Student(String name, int rollNumber, float marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    public String calculateGrade() {
        if (marks >= 90) return "A+";
        else if (marks >= 80) return "A";
        else if (marks >= 70) return "B";
        else if (marks >= 60) return "C";
        else if (marks >= 50) return "D";
        else return "F";
    }

    public void displayDetails() {
        System.out.println("\nStudent Details:");
        System.out.printf("Name: %s\nRoll Number: %d\nMarks: %.2f\nGrade: %s\n", 
                           name, rollNumber, marks, calculateGrade());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        String name = in.nextLine();

        System.out.print("Enter Roll Number: ");
        int rollNumber = in.nextInt();

        System.out.print("Enter Marks (out of 100): ");
        float marks = in.nextFloat();

        Student student = new Student(name, rollNumber, marks);

        student.displayDetails();

        in.close();
    }
}
