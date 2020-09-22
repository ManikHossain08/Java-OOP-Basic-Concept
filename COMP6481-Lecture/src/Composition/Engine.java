package Composition;

public class Engine {
	// Attributes
	private int horsePower;
	private double price;

	// Constructors
	public Engine() // default constructor
	{
		System.out.println("Creating an Engine object using default constructor ....");

		horsePower = 200;
		price = 14000;
	}

	public Engine(int horsePower, double price) {
		super();
		this.horsePower = horsePower;
		this.price = price;
	}

	public int getHorsePower() {
		return horsePower;
	}

	public void setHorsePower(int horsePower) {
		this.horsePower = horsePower;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || this.getClass() != obj.getClass())
			return false;

		Engine other = (Engine) obj;
		if (horsePower != other.horsePower)
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Engine [horsePower=" + horsePower + ", price=" + price + "]";
	}

}
