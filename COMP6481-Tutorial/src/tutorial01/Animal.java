package tutorial01;

public class Animal {
	private int age;
	private String name, color;

	public Animal(int age, String name, String color) {
		this.age = age;
		this.name = name;
		this.color = color;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Animal [age=" + age + ", name=" + name + ", color=" + color + "]";
	}

}
