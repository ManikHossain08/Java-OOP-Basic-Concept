package tutorial01;

public class House {

	private String address;
	private Animal animal;

	public House(String address, Animal animal) {
		super();
		this.address = address;
		this.animal = animal;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	@Override
	public String toString() {
		return "House [address=" + address + ", animal=" + animal + "]";
	}

}
