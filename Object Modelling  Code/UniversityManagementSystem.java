
public class UniversityManagementSystem {
    public static void main(String[] args) {
        Student s1 = new Student("Alice");
        Student s2 = new Student("Bob");

        Professor p1 = new Professor("Dr. Smith");
        Professor p2 = new Professor("Dr. Johnson");

        Course c1 = new Course("Mathematics");
        Course c2 = new Course("Computer Science");

        s1.enrollCourse(c1);
        s1.enrollCourse(c2);

        s2.enrollCourse(c1);

        c1.assignProfessor(p1);
        c2.assignProfessor(p2);

        s1.viewCourses();
        s2.viewCourses();

        c1.viewCourseDetails();
        c2.viewCourseDetails();
    }
}

class Student {
    private String name;
    private Course[] courses;
    private int courseCount;

    public Student(String name) {
        this.name = name;
        this.courses = new Course[10];
        this.courseCount = 0;
    }

    public void enrollCourse(Course course) {
        if (courseCount < courses.length) {
            courses[courseCount++] = course;
            course.addStudent(this);
        }
    }

    public void viewCourses() {
        System.out.println(name + " is enrolled in:");
        for (int i = 0; i < courseCount; i++) {
            System.out.println(" - " + courses[i].getCourseName());
        }
        System.out.println();
    }

    public String getName() {
        return name;
    }
}

class Professor {
    private String name;

    public Professor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Course {
    private String courseName;
    private Student[] students;
    private int studentCount;
    private Professor professor;

    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new Student[20];
        this.studentCount = 0;
    }

    public void addStudent(Student student) {
        if (studentCount < students.length) {
            students[studentCount++] = student;
        }
    }

    public void assignProfessor(Professor professor) {
        this.professor = professor;
    }

    public void viewCourseDetails() {
        System.out.println("Course: " + courseName);
        System.out.println("Professor: " + (professor != null ? professor.getName() : "Not assigned"));
        System.out.println("Enrolled Students:");
        for (int i = 0; i < studentCount; i++) {
            System.out.println(" - " + students[i].getName());
        }
        System.out.println();
    }

    public String getCourseName() {
        return courseName;
    }
}

