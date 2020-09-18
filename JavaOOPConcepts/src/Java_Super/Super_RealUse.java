package Java_Super;

// https://www.javatpoint.com/super-keyword

/*
 * super example: real use

- Let's see the real use of super keyword. Here, Emp class inherits Person class so all the properties 
of Person will be inherited to Emp by default. To initialize all the property, we are using parent class 
constructor from child class. In such way, we are reusing the parent class constructor.
 */

// NOTE: A constructor can have either super() or this() but not both.
class Person {
	
	int id;
	String name;

	Person(int id, String name) {
		this.id = id;
		this.name = name;
	}
}

class Emp extends Person {
	float salary;
	
	Emp(int id, String name, float salary) {
		super(id, name); // reusing parent constructor
		this.salary = salary;
	}

	void display() {
		System.out.println(id + " " + name + " " + salary);
	}
}

public class Super_RealUse {
	public static void main(String[] args) {
		Emp e1 = new Emp(1, "ankit", 45000);
		e1.display();
	}
}
