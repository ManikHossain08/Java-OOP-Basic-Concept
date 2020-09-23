package SOEN_6461_JAVA_SOURCECODE;



public class TestInterface {
	public static void main(String[] args) {
		IMeasure m = new Size();
		m.getValue();
		m.getValue2();
		Length l = new Sub_Override();
		l.checkOverride();
		l.getRealValue(); //final method is inherited but you cannot override it. this is Example.
		System.out.println(l.varCheck); 
		l.getValue2();
		
		IMeasure1 mea = new Test();
		mea.getValue2();
		
		
		//---- PersonSuper Class from another assembly file------
		
		Person p = new Person("Prerna");
        Mother m1 = new Mother("Mahima");
        Wife w = new Wife("Raani");
        System.out.println("p is a " + p.name);
        System.out.println("m is a " + m1.name);
        System.out.println("w is a " + w.name);
        m1.FeedChildren();
        w.CallHusband();
        
        // -------- Person Interface Class-----
        Person1 p1 = new Person1("Prerna");
        WifeAndMother w1 = new WifeAndMother("Raani");
        System.out.println("p is a " + p1.name);
        System.out.println("w is a " + w1.name);
        w1.FeedChildren();
        w1.CallHusband();
        
        Mother1 m11 = new WifeAndMother("Rima");
        m11.FeedChildren();
        
        Wife1 w11 = new WifeAndMother("Rima");
        w11.CallHusband();
        
        //--------------   STATIC CHECK   -------------------
        /// Check static keyword related issue
        CheckStaticKeywordInMethod.setCllg("XYZ"); // Static variable name changed here without using instance variable
    	// only sending the name and getting the incremented or unique roll no
        CheckStaticKeywordInMethod s1 = new CheckStaticKeywordInMethod("Alice"); 
        CheckStaticKeywordInMethod s2 = new CheckStaticKeywordInMethod("Bob"); 
		s1.getStudentInfo(); 
		s2.getStudentInfo(); 
		// Final methods cannot be overridden.
        // Like C++, when a function is static, runtime polymorphism doesn't happen.
		// as both method overridden method is static only base class method will be called because the object is for base 
		// reference
		Base base = new Derived();;  // due to static it will call base function not derived function.
        base.show();
        Derived derive = new Derived();;
        derive.show();
        // In this method there is no static keyword so it will happens runtime polymorphism.
        // in Java, non-static methods cannot be called in a static method.
        // https://www.geeksforgeeks.org/output-of-java-program-set-1/
        // static local variables are not allowed in Java
        Base1 base1 = new Derived1();; // due to non-static it will call derived function not base function.
        base1.show();
        
        // Note about Inheritance: Private methods are final., Protected members are accessible within a package and 
        // inherited classes outside the package.We cannot override private methods. 
        //  before calling the default constructor of calling class, the default constructor of super class is called.
        // ex: https://www.geeksforgeeks.org/output-java-program-set-6/
        // Thread cannot be started twice at the same time concurrently

	}
}

//All the methods of an interface are public abstract by default. 
//You cannot have concrete (regular methods with body) methods in an interface.
interface IMeasure {
	int getValue();  // This interface method implemented in the abstract class where we can also implement interface method. 
	int getValue2(); // This interface method implemented in the interface implementation class like size and length
	public abstract int multiplyTwo(int n1, int n2);
}

abstract class AbstractMeasure {

	public final int getValue() {
		System.out.print("Before...");
		this.getRealValue();
		return 1;
	}

	abstract int getRealValue();
}

class Length extends AbstractMeasure implements IMeasure {
	 
	@Override
	 final int getRealValue() {
		System.out.println("1");
		return 1;
	}
	// ----------- Purpose of overriding---------------
	public int checkOverride() { // we cannot override method using final keyword
		System.out.println("Length: checkOverride");
		return 1;
	}
	final int varCheck; // if we use private keyword here we cannot access this variable from the main function.
	// we can only initialize the blank variable in the constructor like this example
	
	// This is constructor: Can we declare a constructor final? No, because constructor is never inherited.
	Length(){ 
		varCheck = 10;
	}
	@Override
	public int getValue2() {
		System.out.println("AbsTract method from interface in Length...");
		return 0;
	}
	@Override
	public int multiplyTwo(int n1, int n2) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

class Size extends AbstractMeasure implements IMeasure {

	 final int getRealValue() {
		System.out.println("2");
		return 2;
	}

	@Override
	public int getValue2() {
		System.out.println("AbsTract method from interface in Size...");
		return 0;
	}

	@Override
	public int multiplyTwo(int n1, int n2) {
		// TODO Auto-generated method stub
		return 0;
	}
}

//Is final method inherited? Ans) Yes, final method is inherited but you cannot override it. For Example:
class Sub_Override extends Length {
	@Override
	public int checkOverride() {
		System.out.println("Sub_Override");
		return 2;
	}
}


// Inheritance between interface
interface IMeasure1 extends IMeasure {
	void checkInharitanceInInterface();
}
// Inheritance between normal/concrete class and interface with interface implementation. 
class Test implements IMeasure1{

	@Override
	public int getValue() {
		System.out.println("From class Test: getValue");
		return 0;
	}

	@Override
	public int getValue2() {
		System.out.println("From class Test: getValue2");
		return 0;
	}

	@Override
	public void checkInharitanceInInterface() {
		System.out.println("From class Test: checkInharitanceInInterface");
		
	}

	@Override
	public int multiplyTwo(int n1, int n2) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}














