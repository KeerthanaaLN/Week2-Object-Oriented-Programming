class Course {
    String courseName;
    int duration;

    Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    void getCourseStatus() {
        System.out.println("Course Name: " + courseName + ", Duration: " + duration + " weeks");
    }
}

class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;

    OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    @Override
    void getCourseStatus() {
        super.getCourseStatus();
        System.out.println("Platform: " + platform + ", Recorded: " + (isRecorded ? "Yes" : "No"));
    }
}

class PaidOnlineCourse extends OnlineCourse {
    double fee;
    double discount;

    PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    @Override
    void getCourseStatus() {
        super.getCourseStatus();
        double finalPrice = fee - (fee * discount / 100);
        System.out.println("Fee: $" + fee + ", Discount: " + discount + "%, Final Price: $" + finalPrice);
    }
}

public class EducationalCourseHierarchy {
    public static void main(String[] args) {
        PaidOnlineCourse course = new PaidOnlineCourse("Java Programming", 6, "Udemy", true, 500, 20);
        course.getCourseStatus();
    }
}
