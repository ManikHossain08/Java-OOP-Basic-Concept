package JavaInterface;

/*
  Interfaces: 

	An interface is a 100% abstract class. It can have only static, final, and public fields and abstract methods. 
	It’s frequently referred to as a blueprint of a class as well. Java interfaces allow us to implement multiple 
	inheritance in our code, as a class can implement any number of interfaces. Classes can access an interface 
	using the implements keyword.

	In the example, define two interfaces, Animal and Bird. Animal has two abstract methods, while Bird has two 
	static fields and an abstract method.
 */

// https://raygun.com/blog/oop-concepts-java/

interface Animal {
	public void eat();
	public void sound();
	public static int abc = 10;
}

interface Bird {
	int numberOfLegs = 2;
	String outerCovering = "feather";
	public void fly();
}
// multiple inheritance
class Eagle implements Animal, Bird {

	@Override
	public void fly() {
		System.out.println("Flies up to 10,000 feet.");

	}

	@Override
	public void eat() {
		System.out.println("Eats reptiles and amphibians.");

	}

	@Override
	public void sound() {
		System.out.println("Has a high-pitched whistling sound.");

	}

}

public class Interface {
	public static void main(String[] args) {
		Eagle myEagle = new Eagle();

		myEagle.eat();
		myEagle.sound();
		myEagle.fly();
		
		// As static fields don’t belong to a specific object but to a whole class, you need to access them 
		// from the Bird interface instead of the myEagle object.
		System.out.println("Number of legs: " + Bird.numberOfLegs);
		System.out.println("Outer covering: " + Bird.outerCovering);
	}
}
