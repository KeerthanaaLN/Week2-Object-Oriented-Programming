class Employee {
    private static String companyName = "Tech Solutions";
    private static int totalEmployees = 0;

    private final int id;
    private String name, designation;

    public Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++;
    }

    public static void displayTotalEmployees() {
        System.out.println("Total Employees in " + companyName + ": " + totalEmployees);
    }

    public void displayEmployeeDetails() {
        if (this instanceof Employee) {
            System.out.println("Company: " + companyName);
            System.out.println("ID: " + id + ", Name: " + name + ", Designation: " + designation);
        } else {
            System.out.println("Invalid employee object.");
        }
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("Alice Johnson", 101, "Software Engineer");
        Employee e2 = new Employee("Bob Smith", 102, "Project Manager");

        e1.displayEmployeeDetails();
        System.out.println();
        e2.displayEmployeeDetails();

        System.out.println();
        Employee.displayTotalEmployees();
    }
}
