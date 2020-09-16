package Inheritance;


//*******************************************************************
//Inherit6.java By: Aiman Hanna (C) 1993 - 2020
//This program illustrates how significant default constructors are when
//inheritance is used. Notice that the base class in this program has no
//defined constructors. Would that program compile/run? If so, carefully 
//notice its output. 
//
//Key Points: 
//	1) Default constructors 
//*******************************************************************

//Vehicle Class
class Vehicle6 {
 
	// Attributes
	private int numOfDoors;
	private double price;
	
	// Notice that this class has no defined constructors

	
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
class Bus6 extends Vehicle6{

	// Attributes
	private int passengerCapacity;
	
	// Constructors
	public Bus6()	// default constructor 
	{
		System.out.println("Creating a bus object using default constructor ....\n");
		
		passengerCapacity = 10;
	}
	
	public Bus6(int pc)	
	{
		System.out.println("Creating a bus object using parameterized constructor ....\n");
		
		passengerCapacity = pc;
	}
	
	public Bus6(Bus6 b)	
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
	

}   // end of Bus class



public class Inheritance_6_W1_2 {
	public static void main(String[] args) {
		System.out.println("Will create two Vehicle objects");

		Vehicle6 v1 = new Vehicle6(), v2 = new Vehicle6();

		System.out.println();
		System.out.println("Will create three Bus objects");

		Bus6 b1 = new Bus6(), b2 = new Bus6(55), b3 = new Bus6(b1);
		
		System.out.println("Here is the information of the first bus:\n" + b1 + "\n");
		System.out.println("Here is the information of the second bus:\n" + b2 + "\n");
		System.out.println("Here is the information of the third bus:\n" + b3 + "\n");

	}

}

/* The Output 
Will create two Vehicle objects

Will create three Bus objects
Creating a bus object using default constructor ....

Creating a bus object using parameterized constructor ....

Creating a bus object using copy constructor ....

Here is the information of the first bus:
This Bus has 0 doors and its price is: 0.0$. The passenger capacity of this bus is 10.

Here is the information of the second bus:
This Bus has 0 doors and its price is: 0.0$. The passenger capacity of this bus is 55.

Here is the information of the third bus:
This Bus has 0 doors and its price is: 0.0$. The passenger capacity of this bus is 10.
*/

