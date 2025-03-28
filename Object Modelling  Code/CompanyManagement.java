
public class CompanyManagement {
    public static void main(String[] args) {
        Company company = new Company("TechNova");

        company.addDepartment("Engineering");
        company.addDepartment("Human Resources");

        company.addEmployeeToDepartment("Engineering", "Alice");
        company.addEmployeeToDepartment("Engineering", "Bob");
        company.addEmployeeToDepartment("Human Resources", "Charlie");

        company.displayStructure();

        company = null;
        System.gc();

        System.out.println("Company object is now deleted. Associated departments and employees are also gone (in concept).");
    }
}

class Company {
    private String name;
    private Department[] departments;
    private int depCount;

    public Company(String name) {
        this.name = name;
        departments = new Department[10];
        depCount = 0;
    }

    public void addDepartment(String departmentName) {
        if (depCount < departments.length) {
            departments[depCount++] = new Department(departmentName);
        }
    }

    public void addEmployeeToDepartment(String departmentName, String employeeName) {
        for (int i = 0; i < depCount; i++) {
            if (departments[i].getName().equals(departmentName)) {
                departments[i].addEmployee(employeeName);
                return;
            }
        }
        System.out.println("Department not found: " + departmentName);
    }

    public void displayStructure() {
        System.out.println("Company: " + name);
        for (int i = 0; i < depCount; i++) {
            departments[i].displayEmployees();
        }
    }
}

class Department {
    private String name;
    private Employee[] employees;
    private int empCount;

    public Department(String name) {
        this.name = name;
        employees = new Employee[10];
        empCount = 0;
    }

    public String getName() {
        return name;
    }

    public void addEmployee(String employeeName) {
        if (empCount < employees.length) {
            employees[empCount++] = new Employee(employeeName);
        }
    }

    public void displayEmployees() {
        System.out.println(" Department: " + name);
        for (int i = 0; i < empCount; i++) {
            System.out.println("  - " + employees[i].getName());
        }
    }
}

class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

