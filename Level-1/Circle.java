import java.util.Scanner;

class Circle {
    float radius;

    Circle(float radius) {
        this.radius = radius;
    }

    public void calculateAreaCircumference() {
        double area = Math.PI * Math.pow(radius, 2);
        double circumference = 2 * Math.PI * radius;

        displayDetails(area, circumference);
    }

    public void displayDetails(double area, double circumference) {
		System.out.printf("\nRadius of the circle: %.2f cm\nArea of the circle: %.2f cmsq\nCircumference of the circle: %.2f cm\n", radius, area, circumference);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter radius of the circle: ");
        float radius = scanner.nextFloat();

        Circle c = new Circle(radius);
        c.calculateAreaCircumference();

        scanner.close();
    }
}
