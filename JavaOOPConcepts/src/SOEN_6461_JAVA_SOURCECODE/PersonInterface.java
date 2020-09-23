package SOEN_6461_JAVA_SOURCECODE;

class Person1 {
	String name;
	//@Constructor
	Person1(String n) {
		name = "Person:  " + n;
		System.out.println(name);
	}
}

interface Mother1 {
	public void FeedChildren();
}

interface Wife1 {
	public void CallHusband();
}

class WifeAndMother extends Person1 implements Wife1, Mother1 {
	//constructor
	WifeAndMother(String n) {
		super(n);
		name = "Wife and mother:  " + n;
	}

	public void FeedChildren() {
		System.out.println(name + " is feeding the children.");
	}

	public void CallHusband() {
		System.out.println(name + " is calling her husband.");
	}
}


