package Inheritance;


//*******************************************************************
//Inherit9.java By: Aiman Hanna (C) 1993 - 2020
//This program illustrates the concept of how objects of derived
//classes are also considered as objects of their base (ancestor) 
//classes. Notice that the opposite is not true. 
//
//Key Points:
//1) The is-a relationship between derived and base classes.  
//*******************************************************************

//Vehicle Class
class Vehicle9 {

	// Attributes
	private int numOfDoors;
	private double price;
	
	
	// Constructors
	public Vehicle9()	// default constructor 
	{
		System.out.println("\nCreating a vehicle object using default constructor ....");
		
		numOfDoors = 4;
		price = 10000;
	}
	
	public Vehicle9(int nd, double pr)	
	{
		System.out.println("\nCreating a vehicle object using parameterized constructor ....");
		
		numOfDoors = nd;
		price = pr;
	}
	
	
	public Vehicle9(Vehicle9 vec)	// copy constructor 
	{
		System.out.println("\nCreating a vehicle object using copy constructor ....");
		
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
		" doors and it price is " + price + "$.";
	}
} // end of Vehicle class




//Bus Class - This is a derived class from the Vehicle Class; that is it 
//inherits the Vehicle class 
class Bus9 extends Vehicle9{

	// Attributes
	private int passengerCapacity;
	
	// Constructors
	public Bus9()	// default constructor 
	{
		System.out.println("Creating a bus object using default constructor ....");
		
		passengerCapacity = 10;
	}
	
	public Bus9(int pc)	
	{
		System.out.println("Creating a bus object using parameterized constructor ....");
		
		passengerCapacity = pc;
	}
	
	public Bus9(Bus9 b)	
	{
		System.out.println("Creating a bus object using copy constructor ....");
		
		setNumOfDoors(b.getNumOfDoors());
		setPrice(b.getPrice());
		passengerCapacity = b.passengerCapacity;
	}
	
	
	// A constructor that would allow the setting of the price and the number of doors
	// and the passenger capacity
	public Bus9(int nd, double pr, int pc)	
	{
		
		this(pc); 	// Call the constructor that sets the passenger capacity 
	
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


//Car Class - This is a derived class from the Vehicle Class.
//For a Car object, we are interested in its number of seats
class Car extends Vehicle9{

	// Attributes
	private int numOfSeats;
	
	// Constructors
	public Car()	// default constructor 
	{
		System.out.println("Creating a car object using default constructor ....");
		
		numOfSeats = 5;
	}
	
	public Car(int nd, double pr, int ns)	
	{
		super(nd, pr);
		System.out.println("Creating a car object using parameterized constructor ....");
		
		numOfSeats = ns;
	}
	
	public Car(Car c)	
	{
		System.out.println("Creating a car object using copy constructor ....");
		setNumOfDoors(c.getNumOfDoors());
		setPrice(c.getPrice());
		numOfSeats = c.numOfSeats;
	}
	
	
	public int getNumOfSeats()
	{
		return numOfSeats;
	}
	
	public void setNumOfSeats(int ns)
	{
		numOfSeats = ns;;
	}
	
	public String toString()
	{
		return "This Car has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
		"$. The number of seats of this car is " + numOfSeats + "."; 
	}
		
}   // end of Car class



//SportCar Class - This is a derived class from the Car Class
//For a SportCar object, we are interested in its gas consumption 
//as gallon per 100 miles
class SportCar extends Car{

	// Attributes
	private double gasConsumption;
	
	// Constructors
	public SportCar()	// default constructor 
	{
		System.out.println("Creating a sport car object using default constructor ....");
		
		gasConsumption = 4;
	}
	
	public SportCar(int nd, double pr, int ns, double gc)	
	{
		super(nd, pr, ns);
		System.out.println("Creating a sport car object using parameterized constructor ....");
		gasConsumption = gc;
	}
	
	public SportCar(SportCar sc)	
	{
		System.out.println("Creating a sport car object using copy constructor ....");
		
		setNumOfDoors(sc.getNumOfDoors());
		setPrice(sc.getPrice());
		setNumOfSeats(sc.getNumOfSeats());
		
		gasConsumption = sc.gasConsumption;
	}
	
	
	public double getGasConsumption()
	{
		return gasConsumption;
	}
	
	public void setGasConsumption(double gc)
	{
		gasConsumption = gc;;
	}
	
	public String toString()
	{
		return "This Sport Car has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
		"$. The number of seats of this Sport Car is " + getNumOfSeats() + 
		"\nand its gas consumption is " + gasConsumption + " gallons/100-mile."; 
	}
		
}   // end of Sport Car class



//RaceCar Class - This is a derived class from the SportCar Class
//For a RaceCar object, we are interested in its horse power
class RaceCar extends SportCar{

	// Attributes
	private int horsePower;
	
	// Constructors
	public RaceCar()	// default constructor 
	{
		System.out.println("Creating a race car object using default constructor ....");
		
		horsePower = 400;
	}
	
	public RaceCar(int nd, double pr, int ns, double gc, int hp)	
	{
		super(nd, pr, ns, gc);
		System.out.println("Creating a race car object using parameterized constructor ....");
		horsePower = hp;
	}
	
	public RaceCar(RaceCar rc)	
	{
		System.out.println("Creating a race car object using copy constructor ....");
		
		setNumOfDoors(rc.getNumOfDoors());
		setPrice(rc.getPrice());
		setNumOfSeats(rc.getNumOfSeats());
		setGasConsumption(rc.getGasConsumption());
		
		horsePower = rc.horsePower;
	}
	
	
	public int getHorsePower()
	{
		return horsePower;
	}
	
	public void setHorsePower(int hp)
	{
		horsePower = hp;
	}
	
	public String toString()
	{
		return "This Race Car has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
		"$. The number of seats of this Race Car is " + getNumOfSeats() + 
		"\nand its gas consumption is " + getGasConsumption() + " gallons/100-mile." +
		"The horse power of this Race Car is: " + horsePower + "."; 
	}
		
}   // end of Race Car class


public class Inheritance_9_W1_2 {
	// A method that would accept any vehicle object and displays its information 
		public static void showVehicleInfo(Vehicle9 v)
		{
			System.out.println("Here is the information of this vehicle");
			System.out.println(v);
			System.out.println();
		}
		
		public static void main(String[] args) {
			System.out.println("Will create two Vehicle objects");

			Vehicle9 v1 = new Vehicle9(), v2 = new Vehicle9(4, 5000);
			v1.setPrice(22000);
			v2.setPrice(16700);
			
			System.out.println();
			System.out.println("Will create three Bus objects");

			Bus9 b1 = new Bus9(2, 55000, 37), b2 = new Bus9(3, 62000, 55), b3 = new Bus9(b1);
			
			
			System.out.println();
			System.out.println("Will create two Car objects");

			Car c1 = new Car(4, 12000, 5), c2 = new Car(2, 26000, 2);
			
			System.out.println();
			System.out.println("Will create two Sport Car objects");

			SportCar sc1 = new SportCar(4, 12000, 5, 3), sc2 = new SportCar(3, 18500, 4, 4);
		
			
			System.out.println();
			System.out.println("Will create two Race Car objects");

			RaceCar rc1 = new RaceCar(4, 67000, 2, 4, 400), rc2 = new RaceCar(3, 85000, 4, 4, 450);
		
			System.out.println("\nDisplaying Information of the different vehicles");
			System.out.println("================================================\n");
			// Now, since all of the created objects are in fact Vehicle objects, the following
			// calls are all possible, legal, and would function properly. 
			showVehicleInfo(v1);
			showVehicleInfo(v2);
			showVehicleInfo(b1);
			showVehicleInfo(b2);
			showVehicleInfo(b3);
			showVehicleInfo(sc1);
			showVehicleInfo(sc2);
			showVehicleInfo(rc1);
			showVehicleInfo(rc2);
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
The price of this bus will be increased from 10000.0$ to 55000.0$.

Will create two Car objects

Creating a vehicle object using parameterized constructor ....
Creating a car object using parameterized constructor ....

Creating a vehicle object using parameterized constructor ....
Creating a car object using parameterized constructor ....

Will create two Sport Car objects

Creating a vehicle object using parameterized constructor ....
Creating a car object using parameterized constructor ....
Creating a sport car object using parameterized constructor ....

Creating a vehicle object using parameterized constructor ....
Creating a car object using parameterized constructor ....
Creating a sport car object using parameterized constructor ....

Will create two Race Car objects

Creating a vehicle object using parameterized constructor ....
Creating a car object using parameterized constructor ....
Creating a sport car object using parameterized constructor ....
Creating a race car object using parameterized constructor ....

Creating a vehicle object using parameterized constructor ....
Creating a car object using parameterized constructor ....
Creating a sport car object using parameterized constructor ....
Creating a race car object using parameterized constructor ....

Displaying Information of the different vehicles
================================================

Here is the information of this vehicle
This Vehicle has 4 doors and it price is 22000.0$.

Here is the information of this vehicle
This Vehicle has 4 doors and it price is 16700.0$.

Here is the information of this vehicle
This Bus has 2 doors and its price is: 55000.0$. The passenger capacity of this bus is 37.

Here is the information of this vehicle
This Bus has 3 doors and its price is: 62000.0$. The passenger capacity of this bus is 55.

Here is the information of this vehicle
This Bus has 2 doors and its price is: 55000.0$. The passenger capacity of this bus is 37.

Here is the information of this vehicle
This Sport Car has 4 doors and its price is: 12000.0$. The number of seats of this Sport Car is 5
and its gas consumption is 3.0 gallons/100-mile.

Here is the information of this vehicle
This Sport Car has 3 doors and its price is: 18500.0$. The number of seats of this Sport Car is 4
and its gas consumption is 4.0 gallons/100-mile.

Here is the information of this vehicle
This Race Car has 4 doors and its price is: 67000.0$. The number of seats of this Race Car is 2
and its gas consumption is 4.0 gallons/100-mile.The horse power of this Race Car is: 400.

Here is the information of this vehicle
This Race Car has 3 doors and its price is: 85000.0$. The number of seats of this Race Car is 4
and its gas consumption is 4.0 gallons/100-mile.The horse power of this Race Car is: 450.
*/

