import java.util.*;

class MovieTicket {
    String movieName;
    int seatNumber; 
    double price; 
    
    MovieTicket(String movieName) {
        this.movieName = movieName;
    }

    boolean bookTickets(int seatNumber, int[] bookedSeats, double[] seatPrices, double price) {
        if (seatNumber < 1 || seatNumber > 50) {
            System.out.println("Invalid seat number! Enter again.");
            return false;
        }

        if (bookedSeats[seatNumber - 1] != 0) {
            System.out.println("Seat " + seatNumber + " is already booked. Choose another seat.");
            return false;
        }

        this.seatNumber = seatNumber;
        this.price = price;  
        bookedSeats[seatNumber - 1] = seatNumber;
        seatPrices[seatNumber - 1] = price;

        System.out.println("Successfully booked seat " + seatNumber + " for " + movieName + " at price $" + price);
        return true;
    }

    static void displayBookings(String movieName, int[] bookedSeats, double[] seatPrices) {
        System.out.println("\n--- Booking Details for Movie: " + movieName + " ---");
        boolean anyBooking = false;

        for (int i = 0; i < bookedSeats.length; i++) {
            if (bookedSeats[i] != 0) {
                System.out.println("Seat " + bookedSeats[i] + " - Price: $" + seatPrices[i]);
                anyBooking = true;
            }
        }

        if (!anyBooking) {
            System.out.println("No tickets booked yet.");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter Movie name: ");
        String movieName = in.nextLine();

        MovieTicket ticket = new MovieTicket(movieName);
        
        int[] bookedSeats = new int[50];  
        double[] seatPrices = new double[50];  

        char choice;

        do {
            System.out.print("\nEnter seat number (1-50): ");
            int seatNumber = in.nextInt();

            System.out.print("Enter ticket price: ");
            double price = in.nextDouble();

            if (ticket.bookTickets(seatNumber, bookedSeats, seatPrices, price)) {
                System.out.println("Booking successful!");
            }

            System.out.print("Do you want to book another ticket? (y/n): ");
            choice = in.next().charAt(0);

        } while (choice != 'n' && choice != 'N');

        displayBookings(movieName, bookedSeats, seatPrices);

        System.out.println("Thank you for booking. Enjoy your movie!");
        in.close();
    }
}
