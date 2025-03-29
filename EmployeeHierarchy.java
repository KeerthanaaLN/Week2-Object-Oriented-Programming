class Employee {
    String name;
    int id;
    double salary;

    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    void displayDetails() {
        System.out.println("Employee Details:\nName: " + name + ", ID: " + id + ", Salary: $" + salary);
    }
}

class Manager extends Employee {
    int teamSize;

    Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    @Override
    void displayDetails() {
        System.out.println("Employee Details (MANAGER):\nName: " + name + ", ID: " + id + ", Salary: $" + salary + ", Team Size: " + teamSize);
    }
}

class Developer extends Employee {
    String programmingLanguage;

    Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    void displayDetails() {
        System.out.println("Employee Details (DEVELOPER):\nName: " + name + ", ID: " + id + ", Salary: $" + salary + ", Programming Language: " + programmingLanguage);
    }
}

class Intern extends Employee {
    Intern(String name, int id, double salary) {
        super(name, id, salary);
    }

    @Override
    void displayDetails() {
        System.out.println("Employee Details (INTERN):\nName: " + name + ", ID: " + id + ", Salary: $" + salary);
    }
}

public class EmployeeHierarchy {
    public static void main(String[] args) {
        Employee manager = new Manager("Keerthi", 101, 80000, 10);
        Employee developer = new Developer("Datchu", 102, 60000, "Java");
        Employee intern = new Intern("Koushik", 103, 20000);

        manager.displayDetails();
        developer.displayDetails();
        intern.displayDetails();
    }
}
