package AbstractClass;

abstract class Vehicle {
	protected int numOfDoors;
	protected double price;
	private long serialNum;
	private static long serialNumCtr = 1000;

	public Vehicle() {
		this.numOfDoors = 4;
		this.price = 1000;
		this.serialNum = serialNumCtr++;
	}

	public Vehicle(int numOfDoors, double price) {
		this.numOfDoors = numOfDoors;
		this.price = price;
		this.serialNum = serialNumCtr++;
	}

	public Vehicle(Vehicle v) {
		this.numOfDoors = v.numOfDoors;
		this.price = v.price;
		this.serialNum = serialNumCtr++;
	}

	public int getNumOfDoors() {
		return numOfDoors;
	}

	public void setNumOfDoors(int numOfDoors) {
		this.numOfDoors = numOfDoors;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isCheaper(Vehicle v) {

		// Obtain the class names just for display purposes
		String s1 = this.getClass().toString(), s2 = v.getClass().toString();
		s1 = s1.substring(6); // Remove the word "class" to get only the class name
		s2 = s2.substring(6);

		if (this.getPrice() < v.getPrice()) {
			System.out.println(
					"The price of this " + s1 + " object is cheaper than the price of the passed " + s2 + " object.");

			return false;
		} else {
			System.out.println("The price of this " + s1 + " object is NOT cheaper than the price of the passed " + s2
					+ " object.");
			return false;

		}

	}

	public abstract long getSerialNumber();

	public abstract String toString();

	public abstract Vehicle clone();

}

class Bus extends Vehicle {

	private int passengerCapacity;
	private long serialNum;
	private static long serialNumCtr = 2000;

	public Bus() {
		this.passengerCapacity = 100;
		this.serialNum = serialNumCtr++;
	}

	public Bus(int nd, int price, int passengerCapacity) {
		super(nd, price);
		this.passengerCapacity = passengerCapacity;
		this.serialNum = serialNumCtr++;
	}

	public Bus(Bus b) {
		super(b.numOfDoors, b.price);
		this.passengerCapacity = b.passengerCapacity;
		this.serialNum = serialNumCtr++;
	}

	public int getPassengerCapacity() {
		return passengerCapacity;
	}

	public void setPassengerCapacity(int passengerCapacity) {
		this.passengerCapacity = passengerCapacity;
	}

	@Override
	public void setPrice(double pr) {
		if (pr < getPrice())
			System.out.println("The price of this bus will be reduced from " + getPrice() + "$ to " + pr + "$.");
		else if (pr > getPrice())
			System.out.println("The price of this bus will be increased from " + getPrice() + "$ to " + pr + "$.");
		else
			System.out.println("No change will be applied to this price of the bus.");

		super.setPrice(pr);
		// Notice that you cannot access "price" directly since it is private to the
		// base class
		// i.e. price = pr; would be illegal

	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public long getSerialNumber() {
		return serialNum;
	}

	@Override
	public String toString() {

		return "This Bus has " + getNumOfDoors() + " doors and its price is: " + getPrice()
				+ "$. The passenger capacity of this bus is " + passengerCapacity + ".";

	}

	@Override
	public Vehicle clone() {
		return new Bus(this);
	}

}

//Car Class - This is a derived class from the Vehicle Class.
//For a Car object, we are interested in its number of seats
class Car extends Vehicle {

	// Attributes
	private int numOfSeats;
	private long serialNum;
	private static long serialNumCtr = 3000;

	// Constructors
	public Car() // default constructor
	{
		System.out.println("Creating a car object using default constructor ....");

		numOfSeats = 5;
		serialNum = serialNumCtr++;
	}

	public Car(int nd, double pr, int ns) {
		super(nd, pr);
		System.out.println("Creating a car object using parameterized constructor ....");

		numOfSeats = ns;
		serialNum = serialNumCtr++;
	}

	public Car(Car c) {
		System.out.println("Creating a car object using copy constructor ....");
		setNumOfDoors(c.getNumOfDoors());
		setPrice(c.getPrice());
		numOfSeats = c.numOfSeats;
		serialNum = serialNumCtr++;
	}

	public int getNumOfSeats() {
		return numOfSeats;
	}

	public void setNumOfSeats(int ns) {
		numOfSeats = ns;
	}

	public String toString() {
		return "This Car has " + getNumOfDoors() + " doors and its price is: " + getPrice()
				+ "$. The number of seats of this car is " + numOfSeats + ".";
	}
	@Override
	public double getPrice() {
		return price;
	}

	public long getSerialNumber() {
		return serialNum;
	}

	public Car clone() {
		return new Car(this); // Create and return a new Car using the copy constructor
	}
	
} // end of Car class

public class Abstract1 {
	
	// A method that would accept any vehicle object and displays its information 
		public static void showVehicleInfo(Vehicle v)
		{
			System.out.println("Here is the information of this vehicle");
			System.out.println(v);
			System.out.println();
		}

		public static void main(String[] args) {
			System.out.println("Will create three Vehicle objects");

			// The following would be illegal now since you can NOT create objects 
			// from an abstract class
			// Vehicle v1 = new Vehicle(), v2 = new Vehicle(4, 5000), v3 = new Vehicle(v2);
			
			System.out.println();
			System.out.println("Will create three Bus objects");

			Bus b1 = new Bus(2, 55000, 37), b2 = new Bus(3, 62000, 55), b3 = new Bus(b1);
			b1.setPrice(100);
			
			System.out.println();
			System.out.println("Will create two Car objects");

			Car c1 = new Car(4, 12000, 5), c2 = new Car(2, 26000, 2);
			c1.setPrice(200);

			
			showVehicleInfo(b1);
			showVehicleInfo(c1);
			b1.isCheaper(c1);
			c2.isCheaper(b1);
			
		}

}
