class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("Salary cannot be negative!");
        }
    }

    public void displayEmployeeDetails() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: $" + salary);
    }
}

class Manager extends Employee {
    private String teamName;

    public Manager(int employeeID, String department, double salary, String teamName) {
        super(employeeID, department, salary);
        this.teamName = teamName;
    }

    public void displayManagerDetails() {
        displayEmployeeDetails();
        System.out.println("Team Name: " + teamName);
    }
}

public class EmployeeRecords {
    public static void main(String[] args) {
        Employee e1 = new Employee(101, "HR", 50000);
        e1.displayEmployeeDetails();

        System.out.println();

        Manager m1 = new Manager(102, "IT", 75000, "Development Team");
        m1.displayManagerDetails();

        System.out.println("\nUpdating salary...");
        e1.setSalary(55000);
        e1.displayEmployeeDetails();
    }
}
