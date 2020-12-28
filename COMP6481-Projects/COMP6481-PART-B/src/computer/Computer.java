package computer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Computer {

	private String brand;
	private String model;
	private String serialNo;
	private String price;
	private double dPrice;
	private int computerNo;

	public Computer(String brand, String model, String serialNo, String price, int compNo) {
		this.brand = brand;
		this.model = model;
		this.serialNo = serialNo;
		this.price = price;
		this.computerNo = compNo;
	}

	public Computer(Scanner sc, int index) {
		List<String> inputs = new ArrayList<String>();
		String[] attributes = EnterNewComputer.getCompAttributes();

		for (int j = 0; j < attributes.length - 1; j++) {
			System.out.print(attributes[j]);
			String userInput = sc.nextLine();
			inputs.add(attributes[j] + userInput);
		}
		// handling number while provide string input instead numeric
		System.out.print(attributes[3]);
		while (!sc.hasNextDouble()) {
			System.out.print(attributes[3]);
			sc.next();
		}
		double price = sc.nextDouble();

		this.dPrice = price;
		this.price = attributes[3] + price;
		this.brand = inputs.get(0);
		this.model = inputs.get(1);
		this.serialNo = inputs.get(2);
		this.computerNo = index;
		sc.nextLine();
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public double getDoublePrice() {
		return dPrice;
	}

	public void setDoublePrice(double price) {
		this.dPrice = price;
	}

	public int getComputerNo() {
		return computerNo;
	}

	public void setComputerNo(int computerNo) {
		this.computerNo = computerNo;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append("Computer # " + getComputerNo() + "\n");
		sb.append(getBrand() + "\n");
		sb.append(getModel() + "\n");
		sb.append(getSerialNo() + "\n");
		sb.append(getPrice() + "\n");

		return sb.toString();
	}
}
