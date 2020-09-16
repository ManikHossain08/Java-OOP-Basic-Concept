package tutorial01;

public class Dog {

	public String bark() {
		return "Bark!";
	}

	public String bark2() {
		return "Bark! Bark!";
	}

	@Override
	public String toString() {
		return "This is dog";
	}

}

class BullDog extends Dog {
	
	public String toString() {
		return super.toString() + " but also a Bulldog";
	}
}

class Chiwawa extends Dog {
	public String bark2() {
		return "Yip! Yip!";
	}
}