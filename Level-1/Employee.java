import java.util.*;

public class Employee {
    String name;
    int id;
    double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public void displayEmployeeDetails() {
        System.out.println("\nEmployee Details:");
        System.out.println("Name    : " + name);
        System.out.println("ID      : " + id);
        System.out.println("Salary  : " + salary);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter Employee Name: ");
        String name = in.nextLine();

        System.out.print("Enter Employee ID: ");
        int id = in.nextInt();

        System.out.print("Enter Employee Salary: ");
        double salary = in.nextDouble();

        Employee emp = new Employee(name, id, salary);
        emp.displayEmployeeDetails();

        in.close();
    }
}
