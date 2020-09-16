package Inheritance;

//*******************************************************************
//Inherit3.java By: Aiman Hanna (C) 1993 - 2020
//This program illustrates how a derived class can override methods of its 
//parent class. 
//
//Key Points: 
//1) Method overriding 
//2) Calling methods of base class - the keyword "super"
//*******************************************************************


class Vehicle3 {

	// Attributes
	private int numOfDoors;
	private double price;
	
	// Constructors
	public Vehicle3()	// default constructor 
	{
		System.out.println("Creating a vehicle object using default constructor ....");
		
		numOfDoors = 4;
		price = 10000;
	}
	
	public Vehicle3(int nd, double pr)	
	{
		System.out.println("Creating a vehicle object using parameterized constructor ....");
		
		numOfDoors = nd;
		price = pr;
	}
	
	
	public Vehicle3(Vehicle3 vec)	// copy constructor 
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



// Bus Class - This is a derived class from the Vehicle Class; that is it 
// inherits the Vehicle class 
class Bus3 extends Vehicle3{

	// Attributes
	private int passengerCapacity;
	
	// Constructors
	public Bus3()	// default constructor 
	{
		System.out.println("Creating a bus object using default constructor ....\n");
		
		passengerCapacity = 10;
	}
	
	public Bus3(int pc)	
	{
		System.out.println("Creating a bus object using parameterized constructor ....\n");
		
		passengerCapacity = pc;
	}
	
	public Bus3(Bus3 b)	
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
	
	// Method Override the setPrice() method from the base class
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



public class Inheritance_3_W1_2 {
	public static void main(String[] args) {
		System.out.println("Will create two Vehicle objects");

		Vehicle3 v1 = new Vehicle3(), v2 = new Vehicle3(4, 5000);
		v1.setPrice(22000);
		v2.setPrice(16700);
		
		System.out.println();
		System.out.println("Will create three Bus objects");

		Bus3 b1 = new Bus3(), b2 = new Bus3(55), b3 = new Bus3(b1);
		
		//Change the information of some of those bus objects
		b1.setNumOfDoors(2);
		b1.setPrice(55000);
		b1.setPassengerCapacity(37);
		
		b2.setPrice(62000);
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
Creating a bus object using default constructor ....

Creating a vehicle object using default constructor ....
Creating a bus object using parameterized constructor ....

Creating a vehicle object using default constructor ....
Creating a bus object using copy constructor ....

The price of this bus will be increased from 10000.0$ to 55000.0$.
The price of this bus will be increased from 10000.0$ to 62000.0$.
The price of this bus will be reduced from 10000.0$ to 9900.0$.

Here is the information of the first bus:
This Bus has 2 doors and its price is: 55000.0$. The passenger capacity of this bus is 37.

Here is the information of the second bus:
This Bus has 4 doors and its price is: 62000.0$. The passenger capacity of this bus is 55.

Here is the information of the third bus:
This Bus has 4 doors and its price is: 9900.0$. The passenger capacity of this bus is 10.
*/

