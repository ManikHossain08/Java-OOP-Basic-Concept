package Constructor;

// https://beginnersbook.com/2014/07/super-keyword-in-java-with-example/
class Parentclass1 {
	// no-arg constructor
	Parentclass1() {
		System.out.println("no-arg constructor of parent class");
	}

	// arg or parameterized constructor
	Parentclass1(String str) {
		System.out.println(str + " parameterized constructor of parent class");
	}
}

class Subclass1 extends Parentclass1 {
	Subclass1() {
		/*
		 * super() must be added to the first statement of constructor otherwise you
		 * will get a compilation error. Another important point to note is that when we
		 * explicitly use super in constructor the compiler doesn't invoke the parent
		 * constructor automatically.
		 */
		super("Hahaha");
		System.out.println("Constructor of child class");

	}

	void display() {
		System.out.println("Hello");
	}

}

public class ConstructorWithSuper {
	public static void main(String args[]) {
		Subclass1 obj = new Subclass1();
		obj.display();
	}
}

/*
 * There are few important points to note in this example: 
 * 1) super()(or parameterized super must be the first statement in constructor otherwise you
 * will get the compilation error: “Constructor call must be the first statement
 * in a constructor” 
 * 2) When we explicitly placed super in the constructor, the
 * java compiler didn’t call the default no-arg constructor of parent class.
 */
