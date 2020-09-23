package SOEN_6461_JAVA_SOURCECODE;

//A java program to demonstrate use of 
//static keyword with methods and variables 

//Student class 
class CheckStaticKeywordInMethod {
	String name;
	int rollNo;

	// static variable
	static String cllgName = "ABC";

	// static counter to set unique roll no
	static int counter = 0;

	// static method
	public static void setCllg(String name) {
		cllgName = name;
	}

	public CheckStaticKeywordInMethod(String name) {
		this.name = name;

		this.rollNo = setRollNo();
	}

	// getting unique rollNo
	// through static variable(counter)
	static int setRollNo() {
		counter++;
		return counter;
	}

	// instance method
	void getStudentInfo() {
		System.out.println("name : " + this.name);
		System.out.println("rollNo : " + this.rollNo);

		// accessing static variable
		System.out.println("cllgName : " + cllgName);
	}

}



// checking static method in class
class Base {
    public static void show() {
       System.out.println("Base::show() called");
    }
}
  
class Derived extends Base {
    public static void show() {
       System.out.println("Derived::show() called");
    }
}
  

class Base1 {
    public  void show() {
       System.out.println("Base::show() called");
    }
}
  
class Derived1 extends Base1 {
    public  void show() {
       System.out.println("Derived::show() called");
    }
}




