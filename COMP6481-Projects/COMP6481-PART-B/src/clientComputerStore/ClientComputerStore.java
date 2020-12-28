package clientComputerStore;

import java.util.Scanner;

import computer.EnterNewComputer;
import computer.UpdateExistingComputer;
import inventoryController.FindCheaperThanFromInventory;
import inventoryController.FindSpecificBrandFromInventory;
import menu.DisplayMenu;
import messagging.WelcomeMessage;

public class ClientComputerStore {
	
	private final static String PASSWORD = "password";
	private static Scanner sc;
	private static int menuOption = 0;
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		
		new WelcomeMessage(sc);
		handleMenuRepetition();

		sc.close();

	}

	public static void handleMenuRepetition() {
		for (;;) {
			menuOption = displayAndSelectMainMenuOption();
			if (menuOption == 1 || menuOption == 2) {
				if (isPasswordMatched()) proceedWithMenuOption(menuOption);
			} else {
				proceedWithMenuOption(menuOption);
			}
			if(menuOption == 5) {
				sc.close();
				break;
			}
		}
	}

	private static void proceedWithMenuOption(int option) {

		switch (option) {
		case 1:
			EnterNewComputer.HowManyComputerEntry(sc);
			break;

		case 2:
			UpdateExistingComputer updateComputer = new UpdateExistingComputer();
			updateComputer.updateComputerInformation(sc);
			break;
			
		case 3:
			FindSpecificBrandFromInventory.findComputersBy(sc);
			break;
			
		case 4:
			FindCheaperThanFromInventory.findCheaperThan(sc);
			break;
			
		case 5:
			System.out.println();
			System.out.print("CLOSINNG MESSAGE: You are done. Thanks for using me.");
			break;

		default:
			System.out.println();
			System.out.println("WRONG INPUT CHOICE MESSAGE: Please enter (1-5) correct option to proceed.");
			break;
		}

	}

	private static boolean isPasswordMatched() {
		int countTries = 0;
		boolean isMatched = false;

		String inputPassword = "null";
		for (;;) {
			System.out.print("Please enter your password (" + (3 - countTries) + " tries left)> ");
			inputPassword = sc.next();
			countTries++;
			if (PASSWORD.contentEquals(inputPassword)) {
				return true;
			} else if (countTries == 3) {
				break;
			}
		}
		if (!isMatched) {
			menuOption = displayAndSelectMainMenuOption();
			if (menuOption == 1 || menuOption == 2) {
				isMatched = isPasswordMatched();
			}
		}

		return isMatched;
	}

	private static int displayAndSelectMainMenuOption() {
		DisplayMenu menu = new DisplayMenu();
		menu.mainMenu();
		
		while (!sc.hasNextInt()) {
			System.out.print("Please enter your choice (1-5)> ");
			sc.next();
		}
		return sc.nextInt();
	}

}
