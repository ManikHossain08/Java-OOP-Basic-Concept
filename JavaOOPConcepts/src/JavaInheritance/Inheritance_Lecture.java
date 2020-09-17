package JavaInheritance;


class Vehicle {
	
	private int nd;
	private double price;
	
	Vehicle(){
		System.out.println("Creating a vehicle object using default constructor ....");
		nd = 4;
		price = 10000.00;
	}
	Vehicle(int nd, double price){
		System.out.println("Creating a vehicle object using parameterized constructor ....");
		this.nd = nd;
		this.price = price;
	}
	Vehicle(Vehicle v){
		System.out.println("Creating a vehicle object using copy constructor ....");
		this.nd = v.nd;
		this.price = v.price;
	}
	public int getND() {
		return nd;
	}
	
	public void setND(int nd) {
		this.nd = nd;
	}
	
	final public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "This Vehicle has "+getND() +"doors and it price is "+ getPrice()+"$.";
	}
}

class Bus extends Vehicle{
	private int pc;
	
	public Bus() {
		System.out.println("Creating a bus object using default constructor ....");
		pc = 37;
	}
	
	public Bus(int pc) {
		System.out.println("Creating a bus object using parameterized constructor ....");
		this.pc = pc;
	}

	
	public Bus(int nd, double price, int pc) {
		this(pc);
		super.setND(nd);
		System.out.println("Creating a bus object using parameterized constructor for full settings....");
		setPrice(price);
		
	}
	
	public Bus(Bus b1) {
		this(b1.getND(), b1.getPrice(), b1.getPC());

	}

	public int getPC() {
		return pc;
	}
	public void setPC(int pc) {
		this.pc = pc;
	}
	@Override
	public void setPrice(double price) {
		if(price > getPrice()) {
			System.out.println("The price of this bus will be increased from "+ getPrice()+" to "+ price +"$\n");
		}if(price < getPrice()) {
			System.out.println("The price of this bus will be decreased from "+ getPrice()+" to "+ price +"$\n");
		}
		super.setPrice(price);
	}
	
	
	public String toString() {
		return "This Bus has "+ getND()+ " doors and its price is: "
				+ getPrice()+". The passenger capacity of this bus is "+ getPC()+".";
		
	}
}

class Car extends Vehicle {
	private int seats;

	public Car() {
		this.seats = 10;
	}
	
	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public Car(int nd, double price, int seats) {
		super(nd, price);
		System.out.println("Creating a car object using parameterized constructor ...."); 
		this.seats = seats;
	}

	@Override
	public String toString() {
		return "This car has "+ getND()+ " doors and its price is: "
				+ getPrice()+". The passenger seat capacity of this car is "+ getSeats()+".";
		
	}
	
}

class SportsCar extends Car {
	private int gasConsumption;

	public SportsCar() {}
	
	public SportsCar(int gasConsumption) {
		this.gasConsumption = gasConsumption;
	}

	public SportsCar(int nd, double price, int seats, int gasConsumption) {
		super(nd, price, seats);
		System.out.println("Creating a SportsCar object using parameterized constructor ...."); 
		this.gasConsumption = gasConsumption;
	}
	
	public int getGasConsumption() {
		return gasConsumption;
	}

	public void setGasConsumption(int gasConsumption) {
		this.gasConsumption = gasConsumption;
	}
	
	@Override
	public String toString() {
		return "This SportsCar has "+ getND()+ " doors and its price is: "
				+ getPrice()+". The number of seats of this Sport Car is "+ getSeats()+ 
						"and its gas consumption is "+ getGasConsumption()+" gallons/100-mile.";
		
	}
}

class RaceCar extends SportsCar{
	private int horsePower;
	

	public RaceCar(int horsePower) {
		this.horsePower = horsePower;
	}

	public RaceCar(int nd, double price, int seats, int gasConsumption, int horsepower) {
		super(nd, price, seats, gasConsumption);
		System.out.println("Creating a RaceCar object using parameterized constructor ...."); 
		this.horsePower = horsepower;
	}

	public int getHorsePower() {
		return horsePower;
	}

	public void setHorsePower(int horsePower) {
		this.horsePower = horsePower;
	}

	@Override
	public String toString() {
		return "This RaceCar has "+ getND()+ " doors and its price is: "
				+ getPrice()+". The number of seats of this Sport Car is "+ getSeats()+ 
						"and its gas consumption is "+ getGasConsumption()+" gallons/100-mile." +
				"The horse power of this Race Car is:" + getHorsePower()+" .";
		
	}
	
}

public class Inheritance_Lecture {
	public static void ShowVehicleInfo(Vehicle v) {
		System.out.print("\nHere is the information of this vehicle:\n"); 
		System.out.println(v);
	}
	
	public static void main(String[] args) {
		System.out.println("Will create two vehicle objects");
		Vehicle v1 = new Vehicle(), v2 = new Vehicle(4, 16700.0);
		v1.setPrice(22000);
		v2.setPrice(16700);
		
		System.out.println("\nWill create three Bus objects");
		Bus b1 = new Bus(2, 55000.0, 37), b2 = new Bus(3, 62000.0, 55), b3 = new Bus(b1);
		
		System.out.println("\nWill create two Car objects");
		Vehicle c1 = new Car(4, 55000.0, 11), c2 = new Car(4, 62000.0, 11);
		
		System.out.println("\nWill create two Sports Car objects");
		Vehicle sc1 = new SportsCar(4, 12000.0, 5, 3), sc2 = new SportsCar(3, 18500.0, 4, 4);
		
		System.out.println("\nWill create two Race Car objects");
		Vehicle rc1 = new RaceCar(4, 67000.0, 2, 4, 400), rc2 = new RaceCar(3, 85000.0, 4, 4, 450);
		
		System.out.println("\nDisplaying Information of the different vehicles");
		System.out.println("================================================");
		ShowVehicleInfo(v1);
		ShowVehicleInfo(v2);
		ShowVehicleInfo(b1);
		ShowVehicleInfo(b2);
		ShowVehicleInfo(b3);
		ShowVehicleInfo(sc1);
		ShowVehicleInfo(sc2);
		ShowVehicleInfo(rc1);
		ShowVehicleInfo(rc2);
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