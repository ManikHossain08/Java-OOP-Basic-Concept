package SOEN_6461_JAVA_SOURCECODE;

abstract class Animal {
	protected boolean isMammal;
	protected boolean isCarnivorous;

	public Animal(boolean isMammal, boolean isCarnivorous) {
		this.isMammal = isMammal;
		this.isCarnivorous = isCarnivorous;
	}

	public boolean getIsMammal() {
		return this.isMammal;
	}

	public boolean getIsCarnivorous() {
		return this.isCarnivorous;
	}

	abstract public String getGreeting();

	public void printAnimal(String name) {
		System.out.println(
				"A " + name + " says '" + this.getGreeting() + "', is " + (this.getIsCarnivorous() ? "" : "not ")
						+ "carnivorous, and is " + (this.getIsMammal() ? "" : "not ") + "a mammal.");
	}

}

class Dog extends Animal {

	public Dog() {
		super(true, true);
	}

	@Override
	public String getGreeting() {

		return "ruff";
	}

}

class Cow extends Animal {

	public Cow() {
		super(true, false);

	}

	@Override
	public String getGreeting() {

		return "moo";
	}

}

class Duck extends Animal {

	public Duck() {
		super(false, false);

	}

	@Override
	public String getGreeting() {

		return "quack";
	}

}

// Check other program using static keyword.
class A {
	static int add(int i, int j) {
		return i + j;
	}
	
	int b = 50;
}

public class AnimalInheritance extends A {
	int b= 20;
	public static void main(String args[]) {
		Animal dog = new Dog();
		dog.printAnimal("dog");

		Animal cow = new Cow();
		cow.printAnimal("cow");

		Animal duck = new Duck();
		duck.printAnimal("duck");

		// Check other program using static keyword.
		System.out.println(A.add(5, 9));
		// or
		System.out.println(add(5, 9));
		/*
		 check inheritance value:
		 Overridden variable calling always show parent value never child value.
		 method overriding if // If a Parent type reference refers 
		 to a Child object Child's show() / method
		 is called. This is called RUN TIME 
		 POLYMORPHISM. 
		 final method cannot be overridden and it will show compile time error.
		 */
		A a = new AnimalInheritance();
		System.out.println(a.b);
	}

}
