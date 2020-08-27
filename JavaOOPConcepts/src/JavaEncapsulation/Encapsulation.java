package JavaEncapsulation;

/*
 * Encapsulation:

	With encapsulation, you can protect the fields of a class. To do so, declare the fields as private and providing 
	access to them with getter and setter methods. 
	The Animal class below is fully encapsulated. It has three private fields and each of them has its own set of 
	getter and setter methods.
 */

class Animal {
	private String name;
	private double averageWeight;
	private int numberOfLegs;

	// Getter methods
	public String getName() {
		return name;
	}

	public double getAverageWeight() {
		return averageWeight;
	}

	public int getNumberOfLegs() {
		return numberOfLegs;
	}

	// Setter methods
	public void setName(String name) {
		this.name = name;
	}

	public void setAverageWeight(double averageWeight) {
		this.averageWeight = averageWeight;
	}

	public void setNumberOfLegs(int numberOfLegs) {
		this.numberOfLegs = numberOfLegs;
	}
}

public class Encapsulation {
	// The TestAnimal class first sets a value for each field with the setter
	// methods, then prints out the values using the getter methods.
	public static void main(String[] args) {
		Animal myAnimal = new Animal();

		myAnimal.setName("Eagle");
		myAnimal.setAverageWeight(1.5);
		myAnimal.setNumberOfLegs(2);

		System.out.println("Name: " + myAnimal.getName());
		System.out.println("Average weight: " + myAnimal.getAverageWeight() + "kg");
		System.out.println("Number of legs: " + myAnimal.getNumberOfLegs());
	}
}
