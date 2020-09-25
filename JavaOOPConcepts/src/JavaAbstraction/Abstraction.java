package JavaAbstraction;

/*
 Abstraction: 

	With abstraction, you can hide the internal workings of an object and only show the features 
	the user needs to know about. Java provides two ways to implement abstraction: abstract classes and interfaces. 
	With abstract classes, you can achieve partial abstraction, while interfaces make total (100%) abstraction possible.

	In the example below, you can see an abstract class called Animal with two abstract and one concrete method
	
	**) These cannot be abstract
	1.Constructors
	2.Static methods
	3.Private methods
	4.Methods that are declared “final”
	
 */

public class Abstraction {
	public static void main(String[] args) {

		Animal myBird = new Bird();

		myBird.label();
		myBird.move();
		myBird.eat();

		Animal myFish = new Fish();

		myFish.label();
		myFish.move();
		myFish.eat();
		
	}
}

abstract class Animal {
	// abstract methods
	abstract void move();

	abstract void eat();

	// concrete method
	void label() {
		System.out.println("Animal's data:");
	}
}

// Extend the Animal abstract class with two child classes: Bird and Fish. Both of them set up their own 
// functionality for the move() and eat() abstract methods.
class Bird extends Animal {
	@Override
	void move() {
		System.out.println("Moves by flying.");
	}

	@Override
	void eat() {
		System.out.println("Eats birdfood.");
	}
}

class Fish extends Animal {
	@Override
	void move() {
		System.out.println("Moves by swimming.");
	}

	@Override
	void eat() {
		System.out.println("Eats seafood.");
	}
}
// https://beginnersbook.com/2013/04/oops-concepts/
/*
 * Note 1: There can be some scenarios where it is difficult to implement all
 * the methods in the base class. In such scenarios one can define the base
 * class as an abstract class which signifies that this base class is a special
 * kind of class which is not complete on its own.
 * 
 * A class derived from the abstract base class must implement those methods
 * that are not implemented(means they are abstract) in the abstract class.
 * 
 * Note 2: Abstract class cannot be instantiated (e.g: Animal a = new Animal() ) which means you cannot create
 * the object of abstract class. To use this class, you need to create another
 * class that extends this abstract class provides the implementation of
 * abstract methods, then you can use the object of that child class to call
 * non-abstract parent class methods as well as implemented methods(those that
 * were abstract in parent but implemented in child class).
 * 
 * Note 3:*** If a child does not implement all the abstract methods of parent
 * class(the abstract class), then the child class must need to be declared
 * abstract.
 */
