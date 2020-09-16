package Inheritance;


//*******************************************************************
//Inherit5.java By: Aiman Hanna (C) 1993 - 2020
//This program illustrates more on default and other constructors. The 
//program shows how other constructors of the base class can be called. 
//Notice that in all previous examples so far, the derived class constructors
//have only resulted in invoking the default constructor of the base class. 
//
//Key Points: 
//1) The "super" constructor  
//*******************************************************************

//Vehicle Class
class Vehicle5 {

	// Attributes
	private int numOfDoors;
	private double price;
	
	
	// Constructors
	public Vehicle5()	// default constructor 
	{
		System.out.println("Creating a vehicle object using default constructor ....");
		
		numOfDoors = 4;
		price = 10000;
	}
	
	public Vehicle5(int nd, double pr)	
	{
		System.out.println("Creating a vehicle object using parameterized constructor ....");
		
		numOfDoors = nd;
		price = pr;
	}
	
	
	public Vehicle5(Vehicle5 vec)	// copy constructor 
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
class Bus5 extends Vehicle5{

	// Attributes
	private int passengerCapacity;
	
	// Constructors
	public Bus5()	// default constructor 
	{
		System.out.println("Creating a bus object using default constructor ....\n");
		
		passengerCapacity = 10;
	}
	
	public Bus5(int pc)	
	{
		System.out.println("Creating a bus object using parameterized constructor ....\n");
		
		passengerCapacity = pc;
	}
	
	public Bus5(Bus5 b)	
	{
		System.out.println("Creating a bus object using copy constructor ....\n");
		
		passengerCapacity = b.passengerCapacity;
	}
	
	// A constructor that would allow the setting of the price and the number of doors as well
	public Bus5(int nd, double pr, int pc)	
	{
		super(nd, pr); 	// Simply pass the given parameters to the constructor of the base class to set them up
		System.out.println("Creating a bus object using parameterized constructor for full settings....\n");
		
		passengerCapacity = pc;
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


public class Inheritence_5_W1_2 {
	public static void main(String[] args) {
		System.out.println("Will create two Vehicle objects");

		Vehicle5 v1 = new Vehicle5(), v2 = new Vehicle5(4, 5000);
		v1.setPrice(22000);
		v2.setPrice(16700);
		
		System.out.println();
		System.out.println("Will create three Bus objects");

		Bus5 b1 = new Bus5(2, 55000, 37), b2 = new Bus5(3, 62000, 55), b3 = new Bus5(b1);
		
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
Creating a vehicle object using parameterized constructor ....
Creating a bus object using parameterized constructor for full settings....

Creating a vehicle object using parameterized constructor ....
Creating a bus object using parameterized constructor for full settings....

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
