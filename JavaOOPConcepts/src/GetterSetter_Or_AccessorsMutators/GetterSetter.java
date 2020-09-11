package GetterSetter_Or_AccessorsMutators;

/*
 * Key points: Accessors & Mutators
 * This is also know as Accessor and Mutators inn java.
 * This getter and setter is used to access the private variable of a class
 * https://www.thoughtco.com/accessors-and-mutators-2034335
 * https://www.testingdocs.com/accessor-and-mutator-methods-in-java/
 */

class Product {
	private String name;
	private double price;
	private int quantity;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}

public class GetterSetter {
	public static void main(String[] args) {
		Product p = new Product();
		p.setName("Phone");

		String productName = p.getName();

		System.out.print(productName);

	}
}
