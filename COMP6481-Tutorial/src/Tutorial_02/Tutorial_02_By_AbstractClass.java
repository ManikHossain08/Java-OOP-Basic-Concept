package Tutorial_02;

// same output using abstract class and method

abstract class Shape {
	abstract public double shapeArea();
}

class Circle extends Shape {
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

class Rectangle extends Shape{

	private double width;
	private double height;
	private double area;
	
	public Rectangle() {
		this.width = 10;
		this.height = 5;
	}
	
	public Rectangle(double width, double height) {
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

public class Tutorial_02_By_AbstractClass {
	public static void main(String args[]) {
		
		Circle c1 = new Circle();
		c1.setRadious(2);
		System.out.println("Area of c1 Circle: " + c1.shapeArea());
		//System.out.println("Area of c1 Circle: " + c1);
		
		Circle c2 = new Circle();
		c2.setRadious(4);
		System.out.println("Area of c2 Circle: " + c2.shapeArea());
		//System.out.println("Area of c2 Circle: " + c2);
		
		Rectangle r1 = new Rectangle();
		r1.setHeight(2);
		r1.setWidth(4);
		System.out.println("Area of r1 Rectangle: " + r1);
		
		Rectangle r2 = new Rectangle();
		r2.setHeight(3);
		r2.setWidth(6);
		System.out.println("Area of r2 Rectangle: " + r2);
		
		
		Shape[] shapes = {c1,c2,r1,r2};
		totalArea(shapes);
		
	}

	private static void totalArea(Shape[] shapes) {
		double sumArea = 0.00;
		for (int i = 0; i < shapes.length; i++) {
			sumArea += shapes[i].shapeArea();
		}
		sumArea = Math.round(sumArea * 100.0) / 100.0;
		System.out.print("Total Area is: "+ sumArea);
	}
}
