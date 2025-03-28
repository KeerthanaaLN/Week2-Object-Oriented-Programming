
public class SchoolManagement {
    public static void main(String[] args) {
        School school = new School("Greenwood High");

        Student s1 = new Student("Alice");
        Student s2 = new Student("Bob");
        Student s3 = new Student("Charlie");

        school.addStudent(s1);
        school.addStudent(s2);
        school.addStudent(s3);

        Course c1 = new Course("Mathematics");
        Course c2 = new Course("Physics");
        Course c3 = new Course("History");

        s1.enroll(c1);
        s1.enroll(c2);

        s2.enroll(c2);
        s2.enroll(c3);

        s3.enroll(c1);

        s1.viewCourses();
        s2.viewCourses();
        s3.viewCourses();

        c1.viewEnrolledStudents();
        c2.viewEnrolledStudents();
        c3.viewEnrolledStudents();
    }
}

class School {
    private String name;
    private Student[] students;
    private int count;

    public School(String name) {
        this.name = name;
        students = new Student[100];
        count = 0;
    }

    public void addStudent(Student student) {
        if (count < students.length) {
            students[count++] = student;
        }
    }

    public String getName() {
        return name;
    }
}

class Student {
    private String name;
    private Course[] courses;
    private int courseCount;

    public Student(String name) {
        this.name = name;
        courses = new Course[10];
        courseCount = 0;
    }

    public void enroll(Course course) {
        if (courseCount < courses.length) {
            courses[courseCount++] = course;
            course.addStudent(this);
        }
    }

    public void viewCourses() {
        System.out.println(name + " is enrolled in:");
        for (int i = 0; i < courseCount; i++) {
            System.out.println(" - " + courses[i].getTitle());
        }
        System.out.println();
    }

    public String getName() {
        return name;
    }
}

class Course {
    private String title;
    private Student[] students;
    private int studentCount;

    public Course(String title) {
        this.title = title;
        students = new Student[100];
        studentCount = 0;
    }

    public void addStudent(Student student) {
        if (studentCount < students.length) {
            students[studentCount++] = student;
        }
    }

    public void viewEnrolledStudents() {
        System.out.println("Course: " + title + " has the following students:");
        for (int i = 0; i < studentCount; i++) {
            System.out.println(" - " + students[i].getName());
        }
        System.out.println();
    }

    public String getTitle() {
        return title;
    }
}

