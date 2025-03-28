class Student {
    private static String universityName = "Global University";
    private static int totalStudents = 0;

    private final int rollNumber;
    private String name;
    private char grade;

    public Student(String name, int rollNumber, char grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;
    }

    public static void displayTotalStudents() {
        System.out.println("Total Students Enrolled in " + universityName + ": " + totalStudents + "\n");
    }

    public void displayStudentDetails() {
        if (this instanceof Student)
            System.out.println("University: " + universityName + ", Roll Number: " + rollNumber +", Name: " + name + ", Grade: " + grade + "\n");
        else
            System.out.println("Invalid student object.\n");
    }

    public void updateGrade(char newGrade) {
        if (this instanceof Student) {
            this.grade = newGrade;
            System.out.println("Updated Grade for Roll Number " + rollNumber + ": " + grade + "\n");
        } else
            System.out.println("Invalid student object.\n");
    }

    public static void main(String[] args) {
        Student s1 = new Student("Keerthi", 101, 'A');
        Student s2 = new Student("Swetha", 102, 'B');

        s1.displayStudentDetails();
        s2.displayStudentDetails();
        displayTotalStudents();
        s2.updateGrade('A');
        s2.displayStudentDetails();
    }
}
