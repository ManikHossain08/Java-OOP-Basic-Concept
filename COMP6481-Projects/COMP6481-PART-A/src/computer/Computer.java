package computer;

public class Computer {

	private String brand;
	private String model;
	private long SN;
	private double price;
	private static int objCounter = 0;

	public Computer() {
		this.brand = "Apple";
		this.model = "Macbook Pro";
		SN = 123456;
		this.price = 1000;
		objCounter++;
	}

	public Computer(String band, String model, long sN, double price) {
		this.brand = band;
		this.model = model;
		this.SN = sN;
		this.price = price;
		objCounter++;
	}

	public Computer(Computer comp) {
		this.brand = comp.brand;
		this.model = comp.model;
		this.SN = comp.SN;
		this.price = comp.price;
		objCounter++;
	}

	public String getBrand() {
		return brand;
	}

	public void setBand(String band) {
		this.brand = band;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public long getSN() {
		return SN;
	}

	public void setSN(long sN) {
		this.SN = sN;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public static int findNumberOfCreatedComputers() {
		return objCounter;
	}

	@Override
	public String toString() {

		return "Computer object Information:" + "\nband = " + getBrand() + " \nmodel = " + getModel() + "\nSN = " + getSN()
				+ "\nprice = " + getPrice() +"\n";

	}
	
	
//	public boolean equals(Computer c) {
//		return this.brand == c.brand && this.model == c.model && this.price == c.price;	
//	}
	

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		Computer other = (Computer) obj;

		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;

		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;

		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;

		return true;
	}

}
