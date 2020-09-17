package Constructor;
// https://beginnersbook.com/2013/03/constructors-in-java/

/*
 	Java Copy Constructor:

	A copy constructor is used for copying the values of one object to another object.
 */


class JavaExample {
	String web;

	JavaExample(String w) {
		this.web = w;
	}

	/*
	 * This is the Copy Constructor, it copies the values of one object to the
	 * another object (the object that invokes this constructor)
	 */
	JavaExample(JavaExample je) {
		this.web = je.web;
	}

	void disp() {
		System.out.println("Website: " + web);
	}

}

public class CopyConstructor {
	public static void main(String args[]) {
		JavaExample obj1 = new JavaExample("BeginnersBook");

		/*
		 * Passing the object as an argument to the constructor This will invoke the
		 * copy constructor
		 */
		JavaExample obj2 = new JavaExample(obj1);
		obj1.disp();
		obj2.disp();
	}
}


/*
	Difference between Constructor and Methods:
	
	The purpose of constructor is to initialize the object of a class while the purpose of a method is 
	to perform a task by executing java code.
	Constructors cannot be abstract, final, static and synchronized while methods can be.
	Constructors do not have return types while methods do.
	
 */
