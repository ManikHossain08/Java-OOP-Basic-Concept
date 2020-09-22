package JavaComposition;

public class Body {

	public static enum availableColors {
		White, Red, Yellow, Blue
	};

	// Attributes
	private availableColors color;
	private double price;

	public Body() {
		System.out.println("Creating a Body object using default constructor ....");
		color = availableColors.White;
		price = 8000;
	}

	public Body(availableColors color, double price) {
		this.color = color;
		this.price = price;
	}

	public availableColors getColor() {
		return color;
	}

	public void setColor(availableColors color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean equals(Object x) {
		if (x == null || this.getClass() != x.getClass())
			return false;
		else {
			// cast the passed object to a body object
			Body b = (Body) x;
			return (this.price == b.price && this.color == b.color);
		}
	}

	public String toString() {
		return "The color of this Body is " + color + ", and its price is " + price + "$.";
	}

}
