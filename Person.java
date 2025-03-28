
import java.util.Scanner;

class Person {
	int id;
    String name;

	Person(int id, String name){
		this.id = id;
		this.name = name;
	}
	
	Person(Person p){
		id = p.id;
		name = p.name;
	}
	
	void display(){
		System.out.println("Id : "+id+" Name : "+name);
	}
	public static void main(String[] args){
		Person p1 = new Person(23,"Datchu");
		Person p2 = new Person(20,"Keerthika");
		Person p3 = new Person(p2);
	
		p1.display();
		p3.display();
	}
}
	