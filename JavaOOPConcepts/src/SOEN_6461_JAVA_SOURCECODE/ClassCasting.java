package SOEN_6461_JAVA_SOURCECODE;

public class ClassCasting {
	public static void main(final String[] args) throws InstantiationException, IllegalAccessException {
		final SuperClass superClass = new SubClass();
		superClass.foo();
		final SubClass subClass = new SubClass();
		((SuperClass) subClass).foo();
		((SuperClass) subClass.getClass().getSuperclass().newInstance()).foo();
		
		System.out.println("-------------------------");
		final Point p1 = new Point();
		final Point p2 = new Point();
		final Object o = p1;
		System.out.println(p1.equals(p2));
		System.out.println(o.equals(p2));
		System.out.println(p1.equals(o));
		System.out.println(((Point)o).equals(p2));
		System.out.println(((Object)p1).equals(p2));
	}
}

class SuperClass {
	public void foo() {
		System.out.println("One implementation.");
	}
}

class SubClass extends SuperClass {
	public void foo() {
		super.foo();
		System.out.println("Another implementation.");
	}
}

 class Point {
	public boolean equals(final Object anObject) {
		System.out.println("One implementation.");
		return false;
	}

	public boolean equals(final Point aPoint) {
		System.out.println("Another implementation.");
		return false;
	}
}