package CovariantReturnType;

// https://www.javatpoint.com/covariant-return-type
/*

-One of the rule of method overriding is that return type of overriding method must be same as overridden 
method but this restriction is relaxed little bit from Java 1.5 and now overridden method can return sub 
class of return type of original method.

This relaxation is known as co-variant method overriding and it allows you to remove casting at client end.

One of the best example of this comes when you override clone() method. Original Object.clone() method returns 
Object which needs to cast, but with co-variant method overriding you can directly return relevant type
E.g. Date class returns object of java.util.Date instead of java.lang.Object.
 */


class A {
	A get() {
		return this;
	}
}

class B1 extends A {
	B1 get() {
		return this;
	}

	void message() {
		System.out.println("welcome to covariant return type");
	}
}

public class Covariant {
	public static void main(String[] args) {
		new B1().get().message();
		new A();
	}
}
