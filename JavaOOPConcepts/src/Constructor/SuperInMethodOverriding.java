package Constructor;

class Parentclass {
	
	public Parentclass() {
		System.out.println("I am constructor of parent class."); 
	}
	// Overridden method
	void display() {
		System.out.println("Parent class method: with Super()");
	}
}

class Subclass extends Parentclass {
	
	public Subclass() {
		super();
		System.out.println("I am constructor of child class."); 
	}
	
	// Overriding method
	@Override
	void display() {
		System.out.println("Child class method");
	}

	void printMsg() {
		// This would call Overriding method
		display();
		// This would call Overridden method
		super.display();
	}

}

public class SuperInMethodOverriding {
	public static void main(String args[]) {
		
		// call super with method overriding
		Subclass obj = new Subclass();
		obj.printMsg();
		
		// no need to call super() because there is no method overriding
		Subclass2 obj2 = new Subclass2();
		obj2.printMsg();
	}
}


class Parentclass2
{
   void display(){
	System.out.println("Parent class method: without super()");
   }
}

class Subclass2 extends Parentclass2
{
   void printMsg(){
	/* This would call method of parent class,
	 * no need to use super keyword because no other
	 * method with the same name is present in this class
	 */
	display();
   } 
 }