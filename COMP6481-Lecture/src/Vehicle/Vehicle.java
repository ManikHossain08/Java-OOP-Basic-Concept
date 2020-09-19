// *******************************************************************
// Vehicle.java By: Aiman Hanna (C) 1993 - 2020
// This program illustrates how "protected" access rights 
// are influenced by different packages. 
//
// Key Points: 
// 	1) Protected access rights and packages
// *******************************************************************

package Vehicle; 
// This class is created in a package called Vehicle 


// Vehicle Class
public class Vehicle {

	// Attributes
	protected int numOfDoors;	// Notice the access rights of the 
	protected double price;		// class attributes
	
	// Constructors
	public Vehicle()	// default constructor 
	{
		System.out.println("Creating a vehicle object using default constructor ....");
		
		numOfDoors = 4;
		price = 10000;
	}
	
	public Vehicle(int nd, double pr)	
	{
		System.out.println("Creating a vehicle object using parameterized constructor ....");
		
		numOfDoors = nd;
		price = pr;
	}
	
	
	public Vehicle(Vehicle vec)	// copy constructor 
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


	
