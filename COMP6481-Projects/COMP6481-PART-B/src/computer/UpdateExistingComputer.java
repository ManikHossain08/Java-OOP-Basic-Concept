package computer;

import java.util.Scanner;

import inventoryController.StoreInventory;
import inventoryController.UpdateComputerToInventory;
import menu.DisplayMenu;
import messagging.SystemMessage;

public class UpdateExistingComputer extends StoreInventory {

	private static Scanner sc;
	private static int updateIndex = 0;
	private static String Yes = "y";
	private static String No = "n";

	public void updateComputerInformation(Scanner scanner) {
		sc = scanner;

		boolean isEmptyFound = getValidInputIndex();
		if (isEmptyFound == false)
			handleUpdatingMenu();
	}

	private boolean getValidInputIndex() {
		sc.nextLine();
		int addingLimit = (getMaxComputers() - 1);
		
		SystemMessage.ComputerUpdateMessage(addingLimit);
		while (!sc.hasNextInt()) {
			SystemMessage.ComputerUpdateMessage(addingLimit);
			sc.next();
		}
		updateIndex = sc.nextInt();
		if (updateIndex < getMaxComputers() && StoreInventory.getInventory()[updateIndex] != null)
			getComputerInformationByIndex(updateIndex);
		else {
			handleComputerEntryOnEmptyIndex(addingLimit);
			return true;
		}
		return false;
	}

	private void handleComputerEntryOnEmptyIndex(int addingLimit) {
		
		SystemMessage.AlertNoComputerObject(updateIndex);
		String conformation = sc.next();

		if (conformation.toLowerCase().contentEquals(Yes) && updateIndex <= addingLimit) {
			EnterNewComputer.addComputerToInventory(1, sc, updateIndex);
		} else if (conformation.toLowerCase().contentEquals(No)) {
			System.out.println();
			System.out.println("ALERT MESSAGE: Going back to Main Menu");
		} else if (updateIndex > addingLimit) {
			SystemMessage.GoingBackMainManuMessage(addingLimit, updateIndex);
		}
	}

	private static Computer getComputerInformationByIndex(int compIndex) {
		Computer computer = StoreInventory.getInventory()[compIndex];
		System.out.println();
		System.out.print(computer);
		return computer;
	}

	public static void handleUpdatingMenu() {
		int menuOption = 0;
		for (;;) {
			menuOption = displayAndSelectUpdateMenuOption();
			if (menuOption > 0 && menuOption < 5)
				processUpdateOption(menuOption - 1);
			else if (menuOption == 5) {
				break;
			}
		}
	}

	private static void processUpdateOption(int menuOption) {
		
		String[] compAttributes = EnterNewComputer.getCompAttributes();
		Computer computer = StoreInventory.getInventory()[updateIndex];
		sc.nextLine();

		System.out.println();
		System.out.println("Please provide update value for # " + compAttributes[menuOption].split(":")[0]);

		if (menuOption <= 2) {
			
			
			System.out.print(compAttributes[menuOption]);
			String userInput = sc.nextLine();
			
			
			
			updateSingleAttribute(menuOption, computer, compAttributes[menuOption] + userInput);

		} else {
			System.out.print(compAttributes[3]);
			while (!sc.hasNextDouble()) {
				System.out.print(compAttributes[3]);
				sc.next();
			}
			double price = sc.nextDouble();
			updateSingleAttribute(menuOption, computer, compAttributes[3] + price);
			computer.setDoublePrice(price); 
		}

		UpdateComputerToInventory.updateAttributesToInventory(computer, updateIndex);
		getComputerInformationByIndex(updateIndex);
	}

	private static void updateSingleAttribute(int menuIndex, Computer computer, String newValue) {

		switch (menuIndex) {
		
		case 0:
			computer.setBrand(newValue);
			break;
		case 1:
			computer.setModel(newValue);
			break;
		case 2:
			computer.setSerialNo(newValue);
			break;
		case 3:
			computer.setPrice(newValue);
			break;

		default:
			break;
		}

	}

	private static int displayAndSelectUpdateMenuOption() {
		DisplayMenu menu = new DisplayMenu();
		menu.updateMenu();
		while (!sc.hasNextInt()) {
			System.out.print("Please enter your choice (1-5)> ");
			sc.next();
		}
		return sc.nextInt();
	}

}
