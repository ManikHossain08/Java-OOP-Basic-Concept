package Constructor;

// https://beginnersbook.com/2013/03/constructors-in-java/

/*
 Super():

	Whenever a child class constructor gets invoked it implicitly invokes the constructor of parent class. 
	You can also say that the compiler inserts a super(); statement at the beginning of child class constructor.
 */

class MyParentClass {
	MyParentClass() {
		System.out.println("MyParentClass Constructor");
	}
}

class MyChildClass extends MyParentClass {
	MyChildClass() {
		System.out.println("MyChildClass Constructor");
	}

}

// here super() function called automatically because parent class has constructor which will be invoked
// and as it extends by child class
// so firstly base class constructor will be called and then child class constructor will be called.
public class JavaConstructor {
	public static void main(String args[]) {
		new MyChildClass();
	}
}

