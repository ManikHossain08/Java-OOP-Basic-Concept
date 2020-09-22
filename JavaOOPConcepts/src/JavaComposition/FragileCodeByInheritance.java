package JavaComposition;

class ClassBASE {

	public void methodC(){
	}
}

class ClassD extends ClassBASE{

	public int test(){
		return 0;
	}
}

// The above code compiles and works fine but what if ClassBASE implementation is changed like below:
/*
 class ClassBASE {

	public void methodC(){
	}

	public void test(){
	}
}

// this code will not work here BRECAUSE:
 PROBLEM:
 * Notice that test() method already exists in the subclass but the return type is different. 
 * Now the ClassD won’t compile and if you are using any IDE, it will suggest you change the 
 * return type in either superclass or subclass. 
 * Now imagine the situation where we have multiple levels of class inheritance and superclass 
 * is not controlled by us. We will have no choice but to change our subclass method signature 
 * or its name to remove the compilation error. Also, we will have to make a change in all the 
 * places where our subclass method was getting invoked, so inheritance makes our code fragile.

SOLUTION/BENIFITS: 
- The above problem will never occur with composition and that makes it more favorable over inheritance.

PROBLEM:
Another problem with inheritance is that we are exposing all the superclass methods to the client and 
if our superclass is not properly designed and there are security holes, then even though we take complete 
care in implementing our class, we get affected by the poor implementation of the superclass.

SOLUTION:
- Composition helps us in providing controlled access to the superclass methods whereas inheritance doesn’t 
provide any control of the superclass methods, this is also one of the major advantages of composition over inheritance.

PROBLEM:
Another benefit with composition is that it provides flexibility in the invocation of methods. 
Our above implementation of ClassC is not optimal and provides compile-time binding with the method that 
will be invoked, with minimal change we can make the method invocation flexible and make it dynamic.

FOR 3RD PROBLEM AND SOLUTION SEE InheritanceVsComposition CLASS IN THE SAME PACKAGE
 */

public class FragileCodeByInheritance {
	// FOR 3RD PROBLEM AND SOLUTION SEE InheritanceVsComposition CLASS IN THE SAME PACKAGE
}
