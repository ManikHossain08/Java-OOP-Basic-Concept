package Inheritance;


//*******************************************************************
//Inherit8.java By: Aiman Hanna (C) 1993 - 2020
//This program illustrates the "this" constructor. The "this"
//constructor can be used within the definition of a constructor 
//to invoke another constructor of the same class. The "this" 
//constructor must be the first statement; consequently, either "this"
//or "super" can be used with a constructor, but not both. 
//
//Key Points:
//1) The "this" constructor  
//*******************************************************************

//Vehicle Class
class Vehicle8 {

	// Attributes
	private int numOfDoors;
	private double price;
	
	
	// Constructors
	public Vehicle8()	// default constructor 
	{
		System.out.println("Creating a vehicle object using default constructor ....");
		
		numOfDoors = 4;
		price = 10000;
	}
	
	public Vehicle8(int nd, double pr)	
	{
		System.out.println("Creating a vehicle object using parameterized constructor ....");
		
		numOfDoors = nd;
		price = pr;
	}
	
	
	public Vehicle8(Vehicle8 vec)	// copy constructor 
	{
		System.out.println("Creating a vehicle object using copy constructor ....");
		
		numOfDoors = vec.numOfDoors;
		price = vec.price;
	}
	
	public int getNumOfDoors()
	{
		return numOfDoors;
	}
	
	public void setNumOfDoors(int nd)
	{
		numOfDoors = nd;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public void setPrice(double pr)
	{
		price = pr;
	}
	
	public String toString()
	{
		return "This Vehicle has " + numOfDoors + 
		"doors and it price is " + price + "$.";
	}
} // end of Vehicle class




//Bus Class - This is a derived class from the Vehicle Class; that is it 
//inherits the Vehicle class 
class Bus8 extends Vehicle8{

	// Attributes
	private int passengerCapacity;
	
	// Constructors
	public Bus8()	// default constructor 
	{
		System.out.println("Creating a bus object using default constructor ....\n");
		
		passengerCapacity = 10;
	}
	
	public Bus8(int pc)	
	{
		System.out.println("Creating a bus object using parameterized constructor ....\n");
		
		passengerCapacity = pc;
	}
	
	public Bus8(Bus8 b)	
	{
		System.out.println("Creating a bus object using copy constructor ....\n");
		
		passengerCapacity = b.passengerCapacity;
	}
	
	
	// A constructor that would allow the setting of the price and the number of doors
	// and the passenger capacity
	public Bus8(int nd, double pr, int pc)	
	{
		
		this(pc); 	// Call the constructor of same class that sets the passenger capacity  
	
		System.out.println("Creating a bus object using parameterized constructor for full settings....\n");
		
		// Notice that we now cannot call super to set the other two attributes 
		// (i.e. super(nd, pr);) since either "this" or 'super" must be the first 
		// statement, and it is not possible to have both of them as such!
		
		setPrice(pr);		
		setNumOfDoors(nd); 
		
	}

	
	public int getPassangerCapacity()
	{
		return passengerCapacity;
	}
	
	public void setPassengerCapacity(int pc)
	{
		passengerCapacity = pc;;
	}
	
	public String toString()
	{
		return "This Bus has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
		"$. The passenger capacity of this bus is " + passengerCapacity + "."; 
	}
	
	// Override the setPrice() method
	public void setPrice(double pr)
	{
		if(pr < getPrice())
			System.out.println("The price of this bus will be reduced from " + getPrice() + "$ to " + pr + "$.");
		else if (pr > getPrice())
			System.out.println("The price of this bus will be increased from " + getPrice() + "$ to " + pr + "$.");
		else
			System.out.println("No change will be applied to this price of the bus.");
		
		super.setPrice(pr);	
		
		// Notice that you cannot access "price" directly  since it is private to the base class
		// i.e. price = pr; would be illegal
		
	}
}   // end of Bus class



public class Inheritance_8_W1_2 {
	public static void main(String[] args) {
		System.out.println("Will create two Vehicle objects");

		Vehicle8 v1 = new Vehicle8(), v2 = new Vehicle8(14, 5000);
		v1.setPrice(22000);
		v2.setPrice(16700);
		
		System.out.println();
		System.out.println("Will create three Bus objects");

		Bus8 b1 = new Bus8(2, 55000, 37), b2 = new Bus8(3, 62000, 55), b3 = new Bus8(b1);
		
		//Change the information of some of those bus objects

		b3.setPrice(9900);
		
		System.out.println();
		System.out.println("Here is the information of the first bus:\n" + b1 + "\n");
		System.out.println("Here is the information of the second bus:\n" + b2 + "\n");
		System.out.println("Here is the information of the third bus:\n" + b3 + "\n");

	}

}

/* The Output 
Will create two Vehicle objects
Creating a vehicle object using default constructor ....
Creating a vehicle object using parameterized constructor ....

Will create three Bus objects
Creating a vehicle object using default constructor ....
Creating a bus object using parameterized constructor ....

Creating a bus object using parameterized constructor for full settings....

The price of this bus will be increased from 10000.0$ to 55000.0$.
Creating a vehicle object using default constructor ....
Creating a bus object using parameterized constructor ....

Creating a bus object using parameterized constructor for full settings....

The price of this bus will be increased from 10000.0$ to 62000.0$.
Creating a vehicle object using default constructor ....
Creating a bus object using copy constructor ....

The price of this bus will be reduced from 10000.0$ to 9900.0$.

Here is the information of the first bus:
This Bus has 2 doors and its price is: 55000.0$. The passenger capacity of this bus is 37.

Here is the information of the second bus:
This Bus has 3 doors and its price is: 62000.0$. The passenger capacity of this bus is 55.

Here is the information of the third bus:
This Bus has 4 doors and its price is: 9900.0$. The passenger capacity of this bus is 37.

*/

