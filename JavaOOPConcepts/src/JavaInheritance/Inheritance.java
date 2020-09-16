package JavaInheritance;

/*
 * Inheritance:

	Inheritance allows us to extend a class with child classes that inherit the fields and methods of the parent class. 
	It’s an excellent way to achieve code reusability. In Java, we need to use the extends keyword to create a child class.
	
	In the example, the Eagle class extends the Bird parent class. It inherits all of its fields and methods, 
	plus defines two extra fields that belong only to Eagle.

 */

//https://www.javatpoint.com/inheritance-in-java
/*
Q. Why use inheritance in java:

	-For Method Overriding (so runtime polymorphism can be achieved).
	-For Code Reusability.
	
Q) Why multiple inheritance is not supported in java?

- To reduce the complexity and simplify the language, multiple inheritance is not supported in java.

*/

class Bird {
	
	public String reproduction = "egg";
	public String outerCovering = "feather";

	public void flyUp() {
		System.out.println("Flying up from parent...");
	}

	public void flyDown() {
		System.out.println("Flying down from parent...");
	}
	
}

class Eagle extends Bird {
	
	public String name = "eagle";
	public int lifespan = 15;

	@Override
	public void flyUp() {
		System.out.println("Flying up from subclass...");
	}
//	@Override
//	public void flyDown() {
//		System.out.println("Flying down from subclass...");
//	}
}

public class Inheritance {
	// The TestEagle class instantiates a new Eagle object and prints out all the
	// information (both the inherited fields and methods and the two extra fields
	// defined in the Eagle class).
	
	public static void main(String[] args) {
		
		Eagle myEagle = new Eagle();

		System.out.println("Name: " + myEagle.name);
		System.out.println("Reproduction: " + myEagle.reproduction);
		System.out.println("Outer covering: " + myEagle.outerCovering);
		System.out.println("Lifespan: " + myEagle.lifespan);
		myEagle.flyUp(); // dynamic polymorphism
		myEagle.flyDown();
		
		Bird b = new Eagle();
		b.flyUp(); // dynamic polymorphism
		b.flyDown();
	}
}
