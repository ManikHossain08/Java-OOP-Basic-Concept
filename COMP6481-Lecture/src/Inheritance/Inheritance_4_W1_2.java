package Inheritance;

import java.util.Scanner;


//*******************************************************************
//Inherit4.java By: Aiman Hanna (C) 1993 - 2020
//This program illustrates the "final" modifier. If that 
//modifier is placed before the definition of a method, 
//then that method may not be overridden in a derived class.
//
//Key Points: 
//1) Method overriding
//2) method overloading
//3) The "final" modifier  
//*******************************************************************


//Vehicle Class
class Vehicle4 {

	// Attributes
	private int numOfDoors;
	private double price;
	
	// Constructors
	public Vehicle4()	// default constructor 
	{
		System.out.println("Creating a vehicle object using default constructor ....");
		
		numOfDoors = 4;
		price = 10000;
	}
	
	public Vehicle4(int nd, double pr)	
	{
		System.out.println("Creating a vehicle object using parameterized constructor ....");
		
		numOfDoors = nd;
		price = pr;
	}
	
	
	public Vehicle4(Vehicle4 vec)	// copy constructor 
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
	// this method cannot be override in the derive class because of final
	final public void setPrice(double pr) 
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
class Bus4 extends Vehicle4{

	// Attributes
	private int passengerCapacity;
	
	// Constructors
	public Bus4()	// default constructor 
	{
		System.out.println("Creating a bus object using default constructor ....\n");
		
		passengerCapacity = 10;
	}
	
	public Bus4(int pc)	
	{
		System.out.println("Creating a bus object using parameterized constructor ....\n");
		
		passengerCapacity = pc;
	}
	
	public Bus4(Bus4 b)	
	{
		System.out.println("Creating a bus object using copy constructor ....\n");
		
		passengerCapacity = b.passengerCapacity;
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
	
	// The following method Overriding would be illegal due to the final modifier 
/*
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
*/
	
	// The following method overloading would however be legal since 
	// the overloaded method is not the same as the one flagged as "final" 
	// in the base class. 
	public void setPrice() // Notice that this is an overloading 
	{
		// Create a Scanner object
		Scanner kb = new Scanner(System.in);
		double pr;
		System.out.print("Please enter the new price of this bus: ");
		pr = kb.nextInt();
		
		if(pr < getPrice())
			System.out.println("The price of this bus will be reduced from " + getPrice() + "$ to " + pr + "$.");
		else if (pr > getPrice())
			System.out.println("The price of this bus will be increased from " + getPrice() + "$ to " + pr + "$.");
		else
			System.out.println("No change will be applied to this price of the bus.");
		
		super.setPrice(pr);		
		// Notice that you cannot access "price" directly  since it is private to the base class
		// i.e. price = pr; would be illegal
		//kb.close();
	}
}   // end of Bus class



public class Inheritance_4_W1_2 {
	public static void main(String[] args) {
		System.out.println("Will create two Vehicle objects");

		Vehicle4 v1 = new Vehicle4(), v2 = new Vehicle4(4, 5000);
		v1.setPrice(22000);
		v2.setPrice(16700);
		
		System.out.println();
		System.out.println("Will create three Bus objects");

		Bus4 b1 = new Bus4(), b2 = new Bus4(55), b3 = new Bus4(b1);
		
		//Change the information of some of those bus objects
		b1.setNumOfDoors(2);
		b1.setPrice();
		b1.setPassengerCapacity(37);
		
		b2.setPrice();
				
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
Creating a bus object using default constructor ....

Creating a vehicle object using default constructor ....
Creating a bus object using parameterized constructor ....

Creating a vehicle object using default constructor ....
Creating a bus object using copy constructor ....

Please enter the new price of this bus: 73000
The price of this bus will be increased from 10000.0$ to 73000.0$.
Please enter the new price of this bus: 9200
The price of this bus will be reduced from 10000.0$ to 9200.0$.

Here is the information of the first bus:
This Bus has 2 doors and its price is: 73000.0$. The passenger capacity of this bus is 37.

Here is the information of the second bus:
This Bus has 4 doors and its price is: 9200.0$. The passenger capacity of this bus is 55.

Here is the information of the third bus:
This Bus has 4 doors and its price is: 10000.0$. The passenger capacity of this bus is 10.
*/

