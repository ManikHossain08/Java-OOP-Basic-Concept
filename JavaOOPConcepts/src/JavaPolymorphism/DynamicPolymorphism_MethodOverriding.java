package JavaPolymorphism;
// https://beginnersbook.com/2014/01/method-overriding-in-java-with-example/
/*
 * Dynamic polymorphism:

	By using the method overriding feature of Java, you can override the methods of a parent class from its child class.
	
	The Bird class extends the Animal class in the example below. Both have an eat() method. By default, 
	Bird inherits its parent’s eat() method. However, as it also defines its own eat() method, Java will 
	override the original method and call eat() from the child class.
 */

class Animal {
	public void eat() {
		System.out.println("This animal eats insects.");
	}
}

class Birds extends Animal {
	@Override
	public void eat() {
		System.out.println("This bird eats seeds.");
	}

}

public class DynamicPolymorphism_MethodOverriding {
	// The TestBird class first instantiates a new Animal object and calls its eat()
	// method. Then, it also creates a Bird object and calls the polymorphic eat() method again.
	
	public static void main(String[] args) {
		Animal myAnimal = new Animal();
		myAnimal.eat();
		
		Animal bird = new Birds(); // it will check both class but if the subclass is overridden then call override function
		bird.eat();
		
		Birds myBird = new Birds();
		myBird.eat();
		
	}
}
