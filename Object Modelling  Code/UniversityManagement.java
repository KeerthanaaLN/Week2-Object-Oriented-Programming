
public class UniversityManagement {
    public static void main(String[] args) {
        University uni = new University("Global Tech University");

        uni.addDepartment("Computer Science");
        uni.addDepartment("Electrical Engineering");

        Faculty f1 = new Faculty("Dr. Alice");
        Faculty f2 = new Faculty("Dr. Bob");
        Faculty f3 = new Faculty("Dr. Carol");

        uni.addFaculty(f1);
        uni.addFaculty(f2);
        uni.addFaculty(f3);

        uni.assignFacultyToDepartment("Computer Science", f1);
        uni.assignFacultyToDepartment("Computer Science", f2);
        uni.assignFacultyToDepartment("Electrical Engineering", f3);

        uni.displayStructure();

        uni = null;
        System.gc();

        System.out.println("University deleted. All departments also deleted. Faculty still exists independently.");
        System.out.println("Faculty still active: " + f1.getName() + ", " + f2.getName() + ", " + f3.getName());
    }
}

class University {
    private String name;
    private Department[] departments;
    private Faculty[] facultyMembers;
    private int depCount;
    private int facCount;

    public University(String name) {
        this.name = name;
        departments = new Department[10];
        facultyMembers = new Faculty[10];
        depCount = 0;
        facCount = 0;
    }

    public void addDepartment(String deptName) {
        if (depCount < departments.length) {
            departments[depCount++] = new Department(deptName);
        }
    }

    public void addFaculty(Faculty faculty) {
        if (facCount < facultyMembers.length) {
            facultyMembers[facCount++] = faculty;
        }
    }

    public void assignFacultyToDepartment(String deptName, Faculty faculty) {
        for (int i = 0; i < depCount; i++) {
            if (departments[i].getName().equals(deptName)) {
                departments[i].addFaculty(faculty);
                return;
            }
        }
        System.out.println("Department not found: " + deptName);
    }

    public void displayStructure() {
        System.out.println("University: " + name);
        for (int i = 0; i < depCount; i++) {
            departments[i].displayFaculty();
        }
    }
}

class Department {
    private String name;
    private Faculty[] facultyList;
    private int facCount;

    public Department(String name) {
        this.name = name;
        facultyList = new Faculty[10];
        facCount = 0;
    }

    public String getName() {
        return name;
    }

    public void addFaculty(Faculty faculty) {
        if (facCount < facultyList.length) {
            facultyList[facCount++] = faculty;
        }
    }

    public void displayFaculty() {
        System.out.println(" Department: " + name);
        for (int i = 0; i < facCount; i++) {
            System.out.println("  - " + facultyList[i].getName());
        }
    }
}

class Faculty {
    private String name;

    public Faculty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

