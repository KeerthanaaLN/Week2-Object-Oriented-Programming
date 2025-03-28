import java.util.Scanner;

class HotelBooking  {
	 String guestName, droomType ;
	 int nights;
	 
	HotelBooking(){
		guestName = "Sujatha";
		droomType = "Deluxe";
		nights = 3;
	}

	HotelBooking (String guestName, String droomType, int nights){
		this.guestName = guestName;
		this.droomType = droomType;
		this.nights = nights;
	}
	
	HotelBooking (HotelBooking  h){
		guestName = h.guestName;
		droomType = h.droomType;
		nights = h.nights;
	}
	
	void display(){
		System.out.println("Name : "+guestName+" room Type : "+droomType+" Nights : "+nights);
	}
	public static void main(String[] args){
		HotelBooking h1 = new HotelBooking();
		HotelBooking h2 = new HotelBooking("Keerthi","Normal",2);
		HotelBooking h3 = new HotelBooking("Swetha","Normal",4);
		HotelBooking h4 = new HotelBooking(h3);
	
		h1.display();
		h2.display();
		h4.display();
	}
}
	