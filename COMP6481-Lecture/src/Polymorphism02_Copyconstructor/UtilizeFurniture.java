package Polymorphism02_Copyconstructor;


class Furniture {
	private double Price;
	private static int furnitureCounter;

	public Furniture(double price) {
		Price = price;
		furnitureCounter++;
	}
	
	public Furniture(Furniture f) {
		Price = f.Price;
		furnitureCounter++;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Furniture other = (Furniture) obj;
		if (Double.doubleToLongBits(Price) != Double.doubleToLongBits(other.Price))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Furniture [Price=" + Price + "]";
	}

	public int getNumberOfCreatedObject() {

		return furnitureCounter;
	}

	public Furniture copyObj() {
		return new Furniture(this);
	}
	
	public boolean isCheaper(Furniture f) {
		if (this.getPrice() > f.getPrice()) {
			System.out.println(this.getClass() +" is more expensive than " + f.getClass());
			return true;
		}else {
			System.out.println(this.getClass() +" is less expensive than " + f.getClass());
			return false;
		}
	}

}

class Chair extends Furniture {
	private double height;
	private static int chairCounter;

	public Chair(double height) {
		super(1000);
		this.height = height;
		chairCounter++;
	}

	public Chair(Chair c) {
		super(1000);
		this.height = c.height;
		chairCounter++;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chair other = (Chair) obj;
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Chair [height=" + height + "]";
	}

	@Override
	public int getNumberOfCreatedObject() {
		return chairCounter;
	}
	
	@Override
	public Furniture copyObj() {
		return new Chair(this);
	}
	

}

class Carpet extends Furniture {

	private String color;
	private static int carpetCounter;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Carpet(String color) {
		super(100);
		this.color = color;
		carpetCounter++;
	}

	public Carpet(Carpet cr1) {
		super(100);
		this.color = cr1.color;
		carpetCounter++;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carpet other = (Carpet) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Carpet [color=" + color + "]";
	}

	@Override
	public int getNumberOfCreatedObject() {
		return carpetCounter;
	}
	
	@Override
	public Furniture copyObj() {
		return new Carpet(this);
	}
	
}

class Table extends Furniture {
	private double length;
	private double width;
	private double height;
	private static int tableCounter;

	public Table(double length, double width, double height) {
		super(1000);
		this.length = length;
		this.width = width;
		this.height = height;
		tableCounter++;
	}

	public Table(Table t) {
		super(1000);
		this.length = t.length;
		this.width = t.width;
		this.height = t.height;
		tableCounter++;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Table other = (Table) obj;
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
			return false;
		if (Double.doubleToLongBits(length) != Double.doubleToLongBits(other.length))
			return false;
		if (Double.doubleToLongBits(width) != Double.doubleToLongBits(other.width))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Table [length=" + length + ", width=" + width + ", height=" + height + "]";
	}

	@Override
	public int getNumberOfCreatedObject() {
		return tableCounter;
	}
	
	@Override
	public Furniture copyObj() {
		return new Table(this);
	}
	
}

class AntiqueCarpet extends Furniture {
	private int year;
	private String countryOfManufacture;
	private static int antiqueCarpetCounter = 1000;
	private int serialNo = 1000;

	public AntiqueCarpet(int year, String countryOfManufacture) {
		super(10);
		this.year = year;
		this.countryOfManufacture = countryOfManufacture;
		this.serialNo = antiqueCarpetCounter;
		antiqueCarpetCounter++;
	}

	public AntiqueCarpet(AntiqueCarpet ac) {
		super(10);
		this.year = ac.year;
		this.countryOfManufacture = ac.countryOfManufacture;
		this.serialNo = antiqueCarpetCounter;
		antiqueCarpetCounter++;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getCountryOfManufacture() {
		return countryOfManufacture;
	}

	public void setCountryOfManufacture(String countryOfManufacture) {
		this.countryOfManufacture = countryOfManufacture;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AntiqueCarpet other = (AntiqueCarpet) obj;
		if (countryOfManufacture == null) {
			if (other.countryOfManufacture != null)
				return false;
		} else if (!countryOfManufacture.equals(other.countryOfManufacture))
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AntiqueCarpet [year=" + year + ", countryOfManufacture=" + countryOfManufacture + " , price = "+super.getPrice()+ ", serialNo = "+ serialNo+ "]";
	}

	@Override
	public void setPrice(double price) {
		if (price > 6000)
			super.setPrice(price);
	}

	@Override
	public int getNumberOfCreatedObject() {
		return antiqueCarpetCounter;
	}
	
	@Override
	public Furniture copyObj() {
		return new AntiqueCarpet(this);
	}
	
}

/**
 * @author Manik Hossain
 * @KeyPoint: Polymorphism and Copy constructor
 *
 */
public class UtilizeFurniture {
	public static int objCounter = 0;

	public static void main(String[] args) {
		
		Furniture f1 = new Furniture(5000);
		Furniture f2 = new Furniture(4000);
		Furniture f3 = new Furniture(f1);
		System.out.println("Object equality of the Furniture (f1 & f2): " + f1.equals(f2));
		System.out.println("Object equality of the Furniture (f3 & f1): " + f3.equals(f1));
		System.out.println();
		
		Chair c1 = new Chair(100);
		Chair c2 = new Chair(50);
		Chair c3 = new Chair(c1);
		System.out.println("Object equality of the Chair (c1 & c2): " + c1.equals(c2));
		System.out.println("Object equality of the Chair (c3 & c1): " + c3.equals(c1));
		System.out.println( c3.getNumberOfCreatedObject() +" chairs objects were created");
		System.out.println();
		
		Carpet cr1 = new Carpet("Green");
		Carpet cr2 = new Carpet("Black");
		Carpet cr3 = new Carpet(cr1);
		System.out.println("Object equality of the Carpet (cr1 & cr2): " + cr1.equals(cr2));
		System.out.println("Object equality of the Carpet (cr3 & cr1): " + cr3.equals(cr1));
		System.out.println( cr3.getNumberOfCreatedObject() +" carpet objects were created");
		System.out.println();
		
		Table t1 = new Table(100, 105, 400);
		Table t2 = new Table(100, 1050, 300);
		Table t3 = new Table(t1);
		//Table t4 = new Table(t2);
		System.out.println("Object equality of the Carpet (t1 & t2): " + t1.equals(t2));
		System.out.println("Object equality of the Carpet (t3 & t1): " + t3.equals(t1));
		System.out.println( t3.getNumberOfCreatedObject() +" table objects were created");
		System.out.println();
		
		AntiqueCarpet ac1 = new AntiqueCarpet(2020, "CA");
		AntiqueCarpet ac2 = new AntiqueCarpet(2020, "USA");
		AntiqueCarpet ac3 = new AntiqueCarpet(ac1);
		AntiqueCarpet ac4 = new AntiqueCarpet(ac2);
		System.out.println("Object equality of the Carpet (ac1 & ac2): " + ac1.equals(ac2));
		System.out.println("Object equality of the Carpet (ac3 & ac1): " + ac3.equals(ac1));
		System.out.println( ac4.getNumberOfCreatedObject() +" antiqueCarpets objects were created");
		System.out.println();
		
		
		ac3.setPrice(2000);
		System.out.println(ac3);
		
		ac4.setPrice(8000);
		System.out.println(ac4);
		
		
		System.out.println( f1.getNumberOfCreatedObject() +" furniture objects were created");
		
		
		Furniture[] polymorh = new Furniture[7];
		polymorh[0] = f1;
		polymorh[1] = c1;
		polymorh[2] = cr1;
		polymorh[3] = t1;
		polymorh[4] = ac1;
		polymorh[5] = ac2;
		polymorh[6] = c2;
		
		Furniture[] polymorhCopy = new Furniture[polymorh.length];
		for (int i = 0; i < polymorhCopy.length; i++) {
			/*
			 *  NOTE: THIS COMMENTED STATEMENT ('polymorhCopy[i] = polymorh[i]; ') 
			 *  WILL NOT WORK BECAUSE IT WILL POINT SAME 
			 	ADDRESS OR REFFERENCE OR POINTER; SO WE HAVE TO CREATE NEW FURNITURE 
			 	AND THEN KEEP TO THE ARRAY OBJECT.
			 */
			
			// polymorhCopy[i] = polymorh[i]; 
			
			
			/*
			 *  NOTE: THIS CODE WILL COPY THE SAME OBJECT by USING THE copyObj() method
			 *  and switch to specific method on runtime and create new copy using copy construction 
			 *  through polymorphism. 
			 */
			System.out.println(polymorh[i]);
			polymorhCopy[i] =  polymorh[i].copyObj();
			System.out.println(polymorhCopy[i]);
			System.out.println();
		}
		
		
		c1.isCheaper(f1);
		f1.isCheaper(c1);
		cr1.isCheaper(t1);
		t1.isCheaper(ac4);
		ac1.isCheaper(c2);
		
		
	}
}
