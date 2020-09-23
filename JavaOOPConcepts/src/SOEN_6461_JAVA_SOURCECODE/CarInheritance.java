package SOEN_6461_JAVA_SOURCECODE;


import java.io.*;


abstract class Car {
    protected boolean isSedan;
    protected String seats;
    
    public Car(boolean isSedan, String seats) {
        this.isSedan = isSedan;
        this.seats = seats;
    }
    
    public boolean getIsSedan() {
        return this.isSedan;
    }
    
    public String getSeats() {
        return this.seats;
    }
    
    abstract public String getMileage();
    
    public void printCar(String name) {
        System.out.println( 
          "A " + name + " is " + (this.getIsSedan() ? "" : "not ") 
            + "Sedan, is " + this.getSeats() + "-seater, and has a mileage of around "
            + this.getMileage() + ".");
    }
}

// Write your code here.
/**
*   WagonR class
**/

class WagonR extends Car {
	protected int milage;
	public WagonR(int carMileage) {
		super(false, "4");
		this.milage = carMileage;
	}


	@Override
	public String getMileage() {
		// TODO Auto-generated method stub
		return Integer.toString(this.milage) + "kmpl" ;
	}
}

/**
*   HondaCity class
**/


class HondaCity extends Car { 
	protected int milage;
	public HondaCity(int carMileage) {
		super(true, "4");
		// TODO Auto-generated constructor stub
		this.milage = carMileage;
	}


	@Override
	public String getMileage() {
		// TODO Auto-generated method stub
		return Integer.toString(this.milage)+ " kmpl" ;
	}
	
}

/**
*   InnovaCrysta class
**/

class InnovaCrysta extends Car {
	
	protected int milage;
	public InnovaCrysta(int carMileage) {
		super(false, "6");
		this.milage = carMileage;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMileage() {
		// TODO Auto-generated method stub
		return Integer.toString(this.milage) + " kmpl" ;
	}
	
}

 class CarInheritance {
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int carType = Integer.parseInt(bufferedReader.readLine().trim());
        int carMileage = Integer.parseInt(bufferedReader.readLine().trim());
        
        if (carType == 0){
            Car wagonR = new WagonR(carMileage);
            wagonR.printCar("WagonR");
        }
        
        if(carType == 1){
            Car hondaCity = new HondaCity(carMileage);
            hondaCity.printCar("HondaCity");
        }
        
        if(carType == 2){
            Car innovaCrysta = new InnovaCrysta(carMileage);
            innovaCrysta.printCar("InnovaCrysta");
        }
    }
}