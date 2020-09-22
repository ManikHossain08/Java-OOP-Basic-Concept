package Composition;

public class Composition {
	public static void main(String[] args) {
		System.out.println("Will create three Car objects");

		Car c1 = new Car(), 
			c2 = new Car(120, Body.availableColors.Blue, 22000, 4000, 2008),
			c3 = new Car(250, Body.availableColors.Yellow, 19000, 1000, 2010);

		System.out.println("\nDisplaying information of the cars");
		System.out.println("==================================");

		System.out.println(c1);
		System.out.println();

		System.out.println(c2);
		System.out.println();

		System.out.println(c3);
		System.out.println();

	}

}
