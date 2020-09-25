package JavaInterface;

// https://www.journaldev.com/1775/multiple-inheritance-in-java

interface InterfaceA {

	public void doSomething();
}

interface InterfaceB {

	public void doSomething();
}

interface InterfaceC extends InterfaceA, InterfaceB {

	// same method is declared in InterfaceA and InterfaceB both
	public void doSomething();

}
// Multiple inheritance
public class MultipleInheritanceByInterface implements InterfaceA, InterfaceB, InterfaceC {

	@Override
	public void doSomething() {
		System.out.println("doSomething implementation of concrete class");

	}

	public static void main(String[] args) {
		InterfaceA objA = new MultipleInheritanceByInterface();
		InterfaceB objB = new MultipleInheritanceByInterface();
		InterfaceC objC = new MultipleInheritanceByInterface();

		// all the method calls below are going to same concrete implementation
		objA.doSomething();
		objB.doSomething();
		objC.doSomething();
	}

}
