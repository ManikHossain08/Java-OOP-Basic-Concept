package tutorial01;

public class T_01_Client {
	
	final static int a = 10;
	public static enum workDay {MONDAY, TUESDAY, WENESDAY, THURSDAY, FRIDAY};
	
	public static void main(String... args) {
		
		// a = 15; this statement is WRONG because final value cannot be changed once it initialized
		
		Animal a = new Animal(10, "Tom", "red");
		House h1 = new House("Montreal", a);
		
		a.setAge(2);
		a.setName("Jack");
		a.setColor("blue"); 
		// updating attributes of 'a' and reflecting to all the time whenever 'a' is called or used;
		// because it was same reference means 'a' have same reference for both place.
		// so once the value updating its consistently reflecting everywhere.
		
		House h2 = new House("Toronto", a);
		
		System.out.println(h1 +"\n"+ h2);
		
		// ----------------------//
		Rectangle r = new Rectangle(10, 10);
		// here you cannot call the instance method (non-static method) from static method directly 
		// from here.
		T_01_Client c = new T_01_Client();
		c.MyMethod(r); // updating the value by specific object means inside the object
		System.out.println(r);
		
		// --------------------//
		// we are only updating the reference not updating anything (attribute) inside the object.
		// hence value still will be remained same.
		// if we open the commented line in MyMethod2() then updated value will be assigned not 
		// update the reference.
		Rectangle r1 = new Rectangle(10, 10);
		Rectangle r2 = new Rectangle(15, 15);
		c.MyMethod2(r1, r2);
		System.out.println(r1 +"\n"+ r2);
		
		// ----------------- //
		Dog d = new Dog();
		System.out.println(d);
		Dog b = new BullDog();
		System.out.println(b);
		
		// -------------------//
		Dog fido = new Dog();
		Chiwawa carlos = new Chiwawa();
		System.out.println(fido.bark());
		System.out.println(carlos.bark());
		System.out.println(fido.bark2());
		System.out.println(carlos.bark2());
		
		// -------------------//
		Dog fido1 = new Dog();
		BullDog terror = new BullDog();
		System.out.println(fido1);
		System.out.println(terror);
		
		//--------------------//
		Card crd = new Card("Luncinda","Holiday");
		crd.greeting(); // happy holiday
		Valentine crd2 = new Valentine("Walter", 7);
		crd2.greeting();
		
		//------------------//
		workDay[] days = workDay.values();
		for (int i = 0; i < days.length; i++) {
			System.out.println(days[i]);
		}
		
	}

	public void MyMethod(Rectangle r) {
		r.a = 15;
		r.b = 15;
	}
	
	public void MyMethod2(Rectangle rect1, Rectangle rect2) {
		   rect1 = rect2;
		// rect1.a = rect2.a; 
		// rect1.b = rect2.b;
	}
	
	
}
