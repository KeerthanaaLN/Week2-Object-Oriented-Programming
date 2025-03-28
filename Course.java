class Course {
    String courseName;
    int duration, fee;
    static String instituteName = "SRM";

    Course(String courseName, int duration, int fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    void displayCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " months");
        System.out.println("Fees: " + fee);
        System.out.println("Institute Name: " + instituteName);
    }

    static void updateInstituteName(String newName) {
        instituteName = newName;
    }

    public static void main(String[] args) {
        Course c1 = new Course("Computer Science", 48, 30000);
        Course c2 = new Course("Data Science", 24, 25000);

        System.out.println("Before updating institute name:");
        c1.displayCourseDetails();
        c2.displayCourseDetails();

        updateInstituteName("AACW");

        System.out.println("\nAfter updating institute name:");
        c1.displayCourseDetails();
        c2.displayCourseDetails();
    }
}
