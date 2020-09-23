package SOEN_6461_JAVA_SOURCECODE;

 class SuperClass_1 {
	public void foo(final Object anObject) {
		System.out.println("One implementation.");
	}
}

 class SubClass_1 extends SuperClass_1 {
	public void foo(final Object anObject) {
		super.foo(this);
		System.out.println("Another implementation.");
	}

	public void foo(final String aString) {
		super.foo(this);
		System.out.println("Yet another implementation.");
	}
}

public class Polymorphism {
	public static void main(final String[] args) {
		final SuperClass_1 SuperClass_1 = new SubClass_1();
		SuperClass_1.foo(new Object());
		SuperClass_1.foo("");
		System.out.println("----------------------.");
		final SubClass_1 SubClass_1 = new SubClass_1();
		((SuperClass_1) SubClass_1).foo("");
	}
}