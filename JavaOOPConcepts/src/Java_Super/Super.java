package Java_Super;

// https://www.javatpoint.com/super-keyword

/* NOTE: A constructor can have either super() or this() but not both.

 * Super Keyword in Java
-The super keyword in Java is a reference variable which is used to refer immediate parent class object.
Whenever you create the instance of subclass, an instance of parent class is created implicitly which 
is referred by super reference variable.

- The super keyword can also be used to invoke parent class method. It should be used if subclass contains 
the same method as parent class. In other words, it is used if method is overridden.
 */
/*
 * 3) super is used to invoke parent class constructor.
- The super keyword can also be used to invoke the parent class constructor. Let's see a simple example:
 */
public class Super {
	public static void main(String args[]) {
		Dog d = new Dog();
		System.out.print(d.toString());
	}
}

class Animal {
	Animal() {
		System.out.println("animal is created");
	}
}

class Dog extends Animal {
	Dog() {
		// calling the constructor of the Animal class, actually this is manual calling by the developer
		// but compiler also call this super (for calling the constructor of the parent class), if developer don't
		// call it manually. if we comment the super(), still we will get the same output.
		super();
		System.out.println("dog is created");
	}
}
