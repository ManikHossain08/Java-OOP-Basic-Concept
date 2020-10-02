package javaEnum;

// https://www.javatpoint.com/enum-in-java
// https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html

/*
 * An enum is a special "class" that represents a group of constants (unchangeable variables, like final variables).
 */

public class EnumExample1 {

	private enum Days {
		SATURDAY, SUNDAY, MONDAY, TUESDAY, THUSRSDAY, FRIDAY
	};

	private enum IntDayName {
		SATURDAY(10), SUNDAY(20), MONDAY(30), TUESDAY(01), THUSRSDAY(02), FRIDAY(100);

		private int value;

		private IntDayName(int value) {
			this.value = value;
		}
	};

	private enum Planet {
		MERCURY(3.303e+23, 2.4397e6), VENUS(4.869e+24, 6.0518e6), EARTH(5.976e+24, 6.37814e6),
		MARS(6.421e+23, 3.3972e6), JUPITER(1.9e+27, 7.1492e7), SATURN(5.688e+26, 6.0268e7), URANUS(8.686e+25, 2.5559e7),
		NEPTUNE(1.024e+26, 2.4746e7);

		private final double mass; // in kilograms
		private final double radius; // in meters

		Planet(double mass, double radius) {
			this.mass = mass;
			this.radius = radius;
		}

		private double mass() {
			return mass;
		}

		private double radius() {
			return radius;
		}

		// universal gravitational constant (m3 kg-1 s-2)
		public static final double G = 6.67300E-11;

		double surfaceGravity() {
			return G * mass() / (radius() * radius());
		}

		double surfaceWeight(double otherMass) {
			return otherMass * surfaceGravity();
		}
	};

	public static void main(String[] args) {
		for (Seasons s : Seasons.values())
			System.out.println(s);

		System.out.println("Value of WINTER is: " + Seasons.valueOf("WINTER"));
		System.out.println("Index of WINTER is: " + Seasons.valueOf("WINTER").ordinal());
		System.out.println("Index of SUMMER is: " + Seasons.valueOf("SUMMER").ordinal());

		Days day = Days.FRIDAY;
		System.out.println(day);

		switch (day) {
		case SUNDAY:
			System.out.println("sunday");
			break;
		case MONDAY:
			System.out.println("monday");
			break;
		default:
			System.out.println("other day");
		}

		for (IntDayName dn : IntDayName.values())
			System.out.println(dn + " " + dn.value);
		
		double earthWeight = 175;
		double mass = earthWeight / Planet.EARTH.surfaceGravity();
		for (Planet p : Planet.values())
			System.out.println("Your weight on "+p+ " is "+ p.surfaceWeight(mass));

	}

}
