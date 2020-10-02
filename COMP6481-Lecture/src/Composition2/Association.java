package Composition2;

// https://examples.javacodegeeks.com/java-composition-example/

/*
 * Composition in java is the design technique to implement has-a relationship in classes. 
 * We can use java inheritance or Object composition in java for code reuse.
 * Java composition is achieved by using instance variables that refer to other objects.
 */

// IMPORTANT : The below Java program is to illustrate the concept of Association (ASSOCIATION) WHERE 
// in association two entities are highly dependent on each other. BUT In composition, both the entities 
// are dependent on each other. 
// FOR COMPOSION PLEASE SEE THE LIBRARY AND BOOKS EXAMPLE.



//class bank
class Bank {
	private String name;

	// bank name
	Bank(String name) {
		this.name = name;
	}

	public String getBankName() {
		return this.name;
	}
}

//employee class
class Employee {
	private String name;

	// employee name
	Employee(String name) {
		this.name = name;
	}

	public String getEmployeeName() {
		return this.name;
	}
}

//Association between both the classes in main method
public class Association {

	public static void main(String[] args) {
		Bank bank = new Bank("Axim Bank Limited.");
		Employee emp = new Employee("Neha");

		System.out.println(emp.getEmployeeName() + " is employee of " + bank.getBankName());
	}

}
