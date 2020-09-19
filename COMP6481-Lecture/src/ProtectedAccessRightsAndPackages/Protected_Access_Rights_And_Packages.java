package ProtectedAccessRightsAndPackages;

//*******************************************************************
//Inherit12.java By: Aiman Hanna (C) 1993 - 2020
//This program illustrates how "protected" access rights 
//are influenced by different packages. 
//
//A derived class has generally access to the protected
//attributes of its base class, however, the following is true 
//if the classes belong to different packages:
//A derived class that belongs to a different package cannot 
//access the protected attributes of its base class through
//objects of that base class. Derived classes, HOWEVER, have the
//right to create objects of their own class and access the protected
//attributes of the base class through these objects. 
//
//See the showInfo()method below. 
//
//Key Points: 
//	1) Protected access rights and packages
//*******************************************************************
//These classes are created in a different package than the Vehicle package

import Vehicle.*;	// must import the Vehicle class to use it

//Bus Class - This is a derived class from the Vehicle Class; 
//The Vehicle class however belongs to another package 


class Bus extends Vehicle {

	// Attributes
	private int passengerCapacity;
	
	// Constructors
	public Bus()	// default constructor 
	{
		System.out.println("Creating a bus object using default constructor ....\n");
		numOfDoors = 2;
		super.price = 32000;
		passengerCapacity = 10;
	}
	
	public Bus(int pc, int nd, double pr)	
	{
		System.out.println("Creating a bus object using parameterized constructor ....\n");
		numOfDoors = nd;
		super.price = pr;
		passengerCapacity = pc;
	}
	
	public Bus(Bus b)	
	{
		System.out.println("Creating a bus object using copy constructor ....\n");
		numOfDoors = b.numOfDoors;
		super.price = b.price;
		passengerCapacity = b.passengerCapacity;
	}
	
	public int getPassangerCapacity()
	{
		return passengerCapacity;
	}
	
	public void setPassengerCapacity(int pc)
	{
		passengerCapacity = pc;
	}
	
	public String toString()
	{
		return "This Bus has " + numOfDoors + " doors and its price is: " + price +
		"$. The passenger capacity of this bus is " + passengerCapacity + "."; 
	}
	
	public void showInfo()
	{
		// Since Bus is in a different package than vehicle, it is NOT possible to 
		// refer to any of Vehicle attributes directly, even if they are protected,
		// which is the case. Consequently, the following would be illegal
		
		Vehicle v1 = new Vehicle(4, 12000);
		
		// Notice that the following statements are commented out
		System.out.println("Here is the information of the created Vehicle:\n");
		System.out.println(v1);
		// System.out.println("The vehicle has " + v1.numOfDoors + " and its price is " + v1.price + "$.");
		
		// On the contrary, the Bus class can refer to the protected attributes of 
		// the Vehicle class through its own Bus objects
		
		Bus b1 = new Bus(60, 3, 74000);
		System.out.println("Here is the information of the created Bus:\n");
		System.out.println("The Bus has "+ b1.numOfDoors + " doors, its price is " + b1.price + 
				"$, and it has a passenger capacity of " +	b1.passengerCapacity +".");
	}
	
}   // end of Bus class



public class Protected_Access_Rights_And_Packages {
	
	public static void main(String[] args) {
		System.out.println("Will create two Vehicle objects");

		Vehicle v1 = new Vehicle(), v2 = new Vehicle(4, 5000);
		
		System.out.println();
		System.out.println("Will create three Bus objects");

		Bus b1 = new Bus(), b2 = new Bus(55, 3, 65000), b3 = new Bus(b1);
		
		System.out.println("Here is the information of the first bus:\n" + b1 + "\n");
		System.out.println("Here is the information of the second bus:\n" + b2 + "\n");
		System.out.println("Here is the information of the third bus:\n" + b3 + "\n");

		b3.showInfo();
	}

}
