package inventoryController;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import computer.Computer;
import messagging.SystemMessage;

public class FindSpecificBrandFromInventory extends StoreInventory {

	public static void findComputersBy(Scanner sc) {
		int counter = 0;
		sc.nextLine();
		System.out.print("Please enter searching brand name: ");

		String searchingBrand = sc.nextLine();

		System.out.println();
		System.out.println("RESULT: List of seearching record followed by brand '" + searchingBrand + "'.");

		Computer[] computers = getInventory();
		for (int i = 0; i < computers.length; i++) {
			if (getInventory()[i] != null) {
				Computer comp = computers[i];
				if (isBrandNameMatched(comp.getBrand().toLowerCase(), searchingBrand.toLowerCase())) {
					System.out.println(comp);
					counter++;
				}
			}
		}

		SystemMessage.SuccessSearchMessageBrand(counter, searchingBrand);
	
	}

	private static boolean isBrandNameMatched(String source, String subItem) {
		String pattern = "\\b" + subItem + "\\b";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(source);
		return m.find();
	}
}
