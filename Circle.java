import java.util.Scanner;

class Circle {
    float radius;
	
	Circle() {
        radius = 5;
    }
	
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
		
		Circle c1 = new Circle();
		c1.calculateAreaCircumference();

        System.out.print("\nEnter radius of the circle: ");
        float radius = scanner.nextFloat();
		
        Circle c2 = new Circle(radius);
        c2.calculateAreaCircumference();

        scanner.close();
    }
}