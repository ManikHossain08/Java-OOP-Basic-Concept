package client;

import computer.Computer;

public class Client {
	public static void main(String[] args) {
		
		// Assign value using default constructor and print by toString() method.
		Computer comp = new Computer();
		System.out.println("DEFAULT CONSTRUCTOR> Assign value using default constructor and print by toString() method:\n"); 
		System.out.println(comp); 
		
		// Assign value using copy constructor and print by toString() method.
		Computer comp1 = new Computer(comp);
		System.out.println("COPY CONSTRUCTOR> Assign value using copy constructor and print by toString() method:\n"); 
		System.out.println(comp1); 
		
		// Assign value using parameterized constructor and print by toString() method.
		Computer comp2 = new Computer("Apple","Macbook Pro",123, 100);
		System.out.println("PARAMETERIZED CONSTRUCTOR> Assign value using parameterized constructor and print by toString() method:\n"); 
		System.out.println(comp2); 
		
		// Find number of created computers using extra static method and variables
		System.out.println("NUMBER OF CREATED COMPUTERS> Number of created computers: "+ 
				Computer.findNumberOfCreatedComputers() + "\n"); 

		System.out.println("EQUALS METHOD> Object equality using equals() method: " + comp.equals(comp1));  // this two objects equal 
		System.out.println("EQUALS METHOD> Object equality using equals() method: " + comp1.equals(comp2)); // this two object is not equal.
		
		// changing or modifying value using Mutators or setter
		System.out.println("\nMUTATORS & ACCESSORS> Assign value using Mutators(setter) and accessing value by Accessors(getter) :"); 
		comp.setBand("Samsung");
		comp.setModel("SamsungTab3");
		comp.setSN(19890110);
		comp.setPrice(2300.00);
		System.out.println(comp); 
	}
}
