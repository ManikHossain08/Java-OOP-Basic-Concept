package tutorial_0011;

class Alass {
	private int a;
	public int b;

	public Alass() {
		a = 10;
		b = 10;
	}

	private void increment() {
		increment(1);
	}

	public void increment(int i) {
		a += i;
		b += i;
	}
	
	public String toString()
	{return a +"  "+b;}
}

public class AClass {
	public static void main(String[] args) {
		// If there is an error, briefly explain why.?
		
		Alass obj1 = new Alass();
		System.out.println(obj1); // this is ok because constructor will assign value and print value by toString()
		//Alass.increment(5 + 5); // this will not run because using classname only static method is called not any 
		// method of the class (non-static method)
		//System.out.print(obj1.a); // wrong because private attribute is not accessible directly.
		System.out.print(obj1.b);
	}
}
