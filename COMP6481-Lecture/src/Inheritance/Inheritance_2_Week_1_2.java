package Inheritance;

//*******************************************************************
//Inherit2.java By: Aiman Hanna (C) 1993 - 2020
//This program illustrates more of inheritance. Derived classes has access to 
//instance variables and methods of their parent classes (this to be revised in 
//relation to access rights).  
//
//Key Points: 
//1) Having access to methods of parent classes
//*******************************************************************

//Vehicle Class
class Vehicle2 {

	// Attributes
	private int numOfDoors;
	private double price;
	
	// Constructors
	public Vehicle2()	// default constructor 
	{
		System.out.println("Creating a vehicle object using default constructor ....");
		
		numOfDoors = 4;
		price = 10000;
	}
	
	public Vehicle2(int nd, double pr)	
	{
		System.out.println("Creating a vehicle object using parameterized constructor ....");
		
		numOfDoors = nd;
		price = pr;
	}
	
	
	public Vehicle2(Vehicle2 vec)	// copy constructor 
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
class Bus2 extends Vehicle2{

	// Attributes
	private int passengerCapacity;
	
	// Constructors
	public Bus2()	// default constructor 
	{
		System.out.println("Creating a bus object using default constructor ....\n");
		
		passengerCapacity = 10;
	}
	
	public Bus2(int pc)	
	{
		System.out.println("Creating a bus object using parameterized constructor ....\n");
		
		passengerCapacity = pc;
	}
	
	public Bus2(Bus2 b)	
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
		return "This Bus has " + getNumOfDoors() + " and its price is: " + getPrice() +
		"$. The passenger capacity of this bus is " + passengerCapacity + "."; 
	}
}   // end of Bus class




public class Inheritance_2_Week_1_2 {
	public static void main(String[] args) {
		System.out.println("Will create two Vehicle objects");

		Vehicle2 v1 = new Vehicle2(), v2 = new Vehicle2(4, 5000);
		
		System.out.println();
		System.out.println("Will create three Bus objects");

		Bus2 b1 = new Bus2(), b2 = new Bus2(55), b3 = new Bus2(b1);
		
		//Change the information of some of those bus objects
		b1.setNumOfDoors(2);
		b1.setPrice(55000);
		b1.setPassengerCapacity(37);
		
		b2.setPrice(62000);
		b3.setPrice(32000);
		
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

Here is the information of the first bus:
This Bus has 2 and its price is: 55000.0$. The passenger capacity of this bus is 37.

Here is the information of the second bus:
This Bus has 4 and its price is: 62000.0$. The passenger capacity of this bus is 55.

Here is the information of the third bus:
This Bus has 4 and its price is: 32000.0$. The passenger capacity of this bus is 10.
 */


