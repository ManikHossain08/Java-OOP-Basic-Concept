package JavaComposition;


//*******************************************************************
//Compositioin1.java By: Aiman Hanna (C) 1993 - 2020
//This program illustrates the subject of class composition. 
//Composition is when objects of some classes are used to create bigger 
//objects of other classes. 
//While inheritance leads to an "IS-A" relationship between classes, 
//composition leads to a "HAS-A" relationship. 
//
//Key Points:
//1) Class composition
//*******************************************************************


public class Car {
	// Attributes
	private Engine eng;
	private Body bdy;
	private double price;
	private int year;

	private final static double profitRate = 2.5;

	public Engine getEng() {
		return eng;
	}

	public void setEng(Engine eng) {
		this.eng = eng;
	}

	public Body getBdy() {
		return bdy;
	}

	public void setBdy(Body bdy) {
		this.bdy = bdy;
	}

	public double getPrice() {
		return price;
	}
	
	public void setPrice(double pr)
	{
		if(pr < (eng.getPrice() + bdy.getPrice()) )
		{
			System.out.println("Sorry, price does not cover cost. No change will be made.");	
		}
		else
		{
			price = pr;
		}
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public static double getProfitrate() {
		return profitRate;
	}

	public Car(Engine eng, Body bdy, double price, int year) {
		super();
		this.eng = eng;
		this.bdy = bdy;
		this.price = price;
		this.year = year;
	}

	// Constructors
	public Car() // default constructor
	{
		System.out.println("\nCreating a car object using default constructor ....");

		eng = new Engine();
		bdy = new Body();
		price = (eng.getPrice() + bdy.getPrice()) * profitRate;
		year = 2010;
	}

	public Car(int hp, Body.availableColors cl, double epr, double bpr, int yr) {
		System.out.println("\nCreating a car object using parameterized constructor ....");

		eng = new Engine(hp, epr);
		bdy = new Body(cl, bpr);

		price = (epr + bpr) * profitRate;

		year = yr;
	}
	
	public int getHorsePower()
	{
		return eng.getHorsePower();
	}
	
	public void setHorsePower(int hp)
	{
		eng.setHorsePower(hp);
	}
	
	
	public Body.availableColors getColor()
	{
		return bdy.getColor();
	}
	
	
	public void setColor(Body.availableColors cl)
	{
		
		bdy.setColor(cl);
	}

	
	
	public String toString()
	{
		return "This Car has " + eng.getHorsePower() + " HP, and its color is " +
		bdy.getColor() + ". The manufacturing year of the car is " + year +
		", and its price is " + price + "$.";
				
	}
		
	public boolean equals(Object x)
	{
		if (x == null || this.getClass() != x.getClass())
			return false;
		else
		{
			// cast the passed object to a Car object
			Car c = (Car)x;

			return (this.getHorsePower() == c.getHorsePower() &&
					this.getColor() == c.getColor() &&
					this.getPrice() == c.getPrice() &&
					this.year == c.year);
		}
	}

}
