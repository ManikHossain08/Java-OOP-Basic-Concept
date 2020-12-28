package inventoryController;

import java.util.Scanner;

import computer.Computer;
import messagging.SystemMessage;

public class FindCheaperThanFromInventory extends StoreInventory {

	public static void findCheaperThan(Scanner sc) {
		int foundCounter = 0;
		double searchingPrice = 0;

		System.out.print("Please enter searching price (number): ");
		while (!sc.hasNextDouble()) {
			System.out.print("Please enter searching price (number): ");
			sc.next();
		}
		searchingPrice = sc.nextDouble();

		Computer[] computers = getInventory();
		System.out.println();
		System.out.println("RESULT: List of seearching record under price $" + searchingPrice);

		for (int i = 0; i < computers.length; i++) {
			if (getInventory()[i] != null) {
				Computer comp = computers[i];
				if (comp.getDoublePrice() < searchingPrice) {
					System.out.println(comp);
					foundCounter++;
				}
			}
		}
		SystemMessage.SuccessSearchMessage(foundCounter, searchingPrice);
	}
}
