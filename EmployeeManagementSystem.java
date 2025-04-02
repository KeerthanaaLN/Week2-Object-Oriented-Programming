interface Department {
    void assignDepartment(String departmentName);
    String getDepartmentDetails();
}

abstract class Employee implements Department {
    private int employeeId;
    private String name;
    private double baseSalary;
    private String department;

    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public abstract double calculateSalary();

    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: $" + baseSalary);
        System.out.println("Department: " + department);
        System.out.println("Calculated Salary: $" + calculateSalary());
        System.out.println("----------------------------------");
    }

    public int getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public double getBaseSalary() { return baseSalary; }

    public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }
    public void setName(String name) { this.name = name; }
    public void setBaseSalary(double baseSalary) { this.baseSalary = baseSalary; }

    public void assignDepartment(String departmentName) {
        this.department = departmentName;
    }

    public String getDepartmentDetails() {
        return department;
    }
}

class FullTimeEmployee extends Employee {
    private double fixedBonus;

    public FullTimeEmployee(int employeeId, String name, double baseSalary, double fixedBonus) {
        super(employeeId, name, baseSalary);
        this.fixedBonus = fixedBonus;
    }

    public double calculateSalary() {
        return getBaseSalary() + fixedBonus;
    }
}

class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(int employeeId, String name, double baseSalary, int hoursWorked, double hourlyRate) {
        super(employeeId, name, baseSalary);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    public double calculateSalary() {
        return getBaseSalary() + (hoursWorked * hourlyRate);
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Employee emp1 = new FullTimeEmployee(101, "Alice", 3000, 1000);
        emp1.assignDepartment("Finance");

        Employee emp2 = new PartTimeEmployee(102, "Bob", 1000, 40, 25);
        emp2.assignDepartment("IT");

        emp1.displayDetails();
        emp2.displayDetails();
    }
}
