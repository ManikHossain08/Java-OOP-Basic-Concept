package JavaComposition;

// KEY POINTS: One of the best practices of Java programming is to “favor composition over inheritance”.

/*
 * https://www.journaldev.com/1775/multiple-inheritance-in-java
 * NOTE: read this article to gather full knowledge about Inheritance Vs Composition Vs Interface 
 */

/*
 * HERE COMPOSITION IS USED FOR MULTIPLE INHERITANCE BECAUSE BY USING ABSTRACT CLASS IT IS NOT POSSIBLE
 * TO DO IT FOR AMBIGUITY REASON. THEREFORE, COMPOSIOTN IS USEFULL IN THIS CASE.
 * 
 */


abstract class SuperClass {

	public abstract void doSomething();
}

class ClassA extends SuperClass{
	
	@Override
	public void doSomething(){
		System.out.println("doSomething implementation of A");
	}
	
	//ClassA own method
	public void methodA(){
		
	}
}

class ClassB extends SuperClass{

	@Override
	public void doSomething(){
		System.out.println("doSomething implementation of B");
	}
	
	//ClassB specific method
	public void methodB(){
		
	}
}

// SEE THIS COMMENTED CODEE WILL NOT WORK HERE BECAUSE OF THE FOLLOWING REASON: 
/*
 * Notice that test() method is making a call to superclass doSomething() method. 
 * This leads to the ambiguity as the compiler doesn’t know which superclass method to execute. 
 * Because of the diamond-shaped class diagram, it’s referred to as Diamond Problem in java. 
 * The diamond problem in Java is the main reason java doesn’t support multiple inheritances in classes. 
 * Notice that the above problem with multiple class inheritance can also come with only three classes 
 * where all of them has at least one common method.
 * 

this is just an assumption to explain the diamond problem
//this code won't compile

public class ClassC extends ClassA, ClassB{

	public void test(){
		//calling super class method
		doSomething(); // AMBIGIOUS CALLING
	}
}
 * 
 */



class ClassC {

	ClassA objA = new ClassA(); // has a relation = composition
	ClassB objB = new ClassB();
	
	public void test(){
		objA.doSomething(); // THIS IS STATIC/ RUN-TIME BINDING, WE CAN MAKE IT DYMANIC SEE IN MAIN CLASS. 
	}
	
	public void methodA(){
		objA.methodA(); // THIS IS STATIC/ RUN-TIME BINDING, WE CAN MAKE IT DYMANIC SEE IN MAIN CLASS. 
	}
	
	public void methodB(){
		objB.methodB(); // THIS IS STATIC/ RUN-TIME BINDING, WE CAN MAKE IT DYMANIC SEE IN MAIN CLASS. 
	}
}

// this is THE REPLACEMENT OF class 'ClassC'  for dynamic binding instead of static / runtime binding
public class InheritanceVsComposition {
	public static void main(String[] args) {
		// BEFORE: STATIC BINDING DURING RUN-TIME
		ClassC c = new ClassC();
		c.test();
		c.methodB();
		
		// AFTER: DYNAMIC BINDING AND THIS SHOULD BE THE REPLACEMENT OF class 'ClassC'  
		InheritanceVsComposition obj1 = new InheritanceVsComposition(new ClassA()); // DYNAMIC BINDING
		InheritanceVsComposition obj2 = new InheritanceVsComposition(new ClassB()); // DYNAMIC BINDING
		
		obj1.test();
		obj2.test();
		
	}
	
	// AFTER: DYMANIC BINDING OF THE METHOD CALLING
	/*
	 * Another benefit with composition is that it provides flexibility in the invocation of methods. 
	 * Our above implementation of ClassC is not optimal and provides compile-time binding with 
	 * the method that will be invoked, with minimal change we can make the method invocation 
	 * flexible and make it dynamic.
	 */
	SuperClass obj = null; // creating IS-A relationship here;

	public InheritanceVsComposition (SuperClass o){
		this.obj = o;
	}
	public void test(){
		obj.doSomething();
	}
	
}



