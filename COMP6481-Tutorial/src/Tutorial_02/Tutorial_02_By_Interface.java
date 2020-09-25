package Tutorial_02;

// same output using abstract class and method

interface iShape {
	public double shapeArea();
	
}

class Circled implements iShape {
	private double radious;
	private double area;

	public double getRadious() {
		return radious;
	}

	public void setRadious(int radious) {
		this.radious = radious;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	@Override
	public double shapeArea() {
		setArea(3.14 * radious * radious);
		return getArea();
	}
	
	@Override
	public String toString() {
		return "" + 3.14 * radious * radious;
	}
	
	
}

class Rectangled implements iShape{

	private double width;
	private double height;
	private double area;
	
	public Rectangled() {
		this.width = 10;
		this.height = 5;
	}
	
	public Rectangled(double width, double height) {
		this.width = width;
		this.height = height;
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


	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	@Override
	public double shapeArea() {
		setArea(height * width);
		return getArea();
	}


	@Override
	public String toString() {
		return "" + height * width;
	}
	
	
	
}

public class Tutorial_02_By_Interface {
	public static void main(String args[]) {
		
		Circled c1 = new Circled();
		c1.setRadious(2);
		System.out.println("Area of c1 Circle: " + c1.shapeArea());
		//System.out.println("Area of c1 Circle: " + c1);
		
		Circled c2 = new Circled();
		c2.setRadious(4);
		System.out.println("Area of c2 Circle: " + c2.shapeArea());
		//System.out.println("Area of c2 Circle: " + c2);
		
		Rectangled r1 = new Rectangled();
		r1.setHeight(2);
		r1.setWidth(4);
		System.out.println("Area of r1 Rectangle: " + r1);
		
		Rectangled r2 = new Rectangled();
		r2.setHeight(3);
		r2.setWidth(6);
		System.out.println("Area of r2 Rectangle: " + r2);
		
		
		iShape[] shapes = {c1,c2,r1,r2};
		totalArea(shapes);
		
	}

	private static void totalArea(iShape[] shapes) {
		double sumArea = 0.00;
		for (int i = 0; i < shapes.length; i++) {
			sumArea += shapes[i].shapeArea();
		}
		sumArea = Math.round(sumArea * 100.0) / 100.0;
		System.out.print("Total Area is: "+ sumArea);
	}
}
