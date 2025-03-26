import java.util.Scanner;

class MobilePhone {
    String brand, model;
    double price;

    MobilePhone(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public void display() {
        System.out.println("\nMobile Phone Details:");
        System.out.printf("Brand : %s\nModel : %s\nPrice : %.2f\n", brand, model, price);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter Mobile Brand: ");
        String brand = in.nextLine();

        System.out.print("Enter Mobile Model: ");
        String model = in.nextLine();

        System.out.print("Enter Mobile Price: ");
        double price = in.nextDouble();

        MobilePhone mobile = new MobilePhone(brand, model, price);

        mobile.display();

        in.close();
    }
}
