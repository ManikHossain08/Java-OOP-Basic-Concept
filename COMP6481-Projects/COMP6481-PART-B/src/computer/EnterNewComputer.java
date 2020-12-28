package computer;

import java.util.Scanner;

import inventoryController.AddNewComputerToInventory;
import inventoryController.StoreInventory;
import messagging.SystemMessage;

public class EnterNewComputer extends StoreInventory {

	private static String[] compAttributes = { "Brand: ", "Model: ", "SN   : ", "Price: $" };
	private static String Yes = "y";

	public static String[] getCompAttributes() {
		String[] temAttributes = new String[compAttributes.length];
		for (int i = 0; i < temAttributes.length; i++) {
			temAttributes[i] = compAttributes[i];
		}
		return temAttributes;
	}

	public static void HowManyComputerEntry(Scanner sc) {

		int howManyComp = 0;
		System.out.print("How many computers you wants to enter (number): ");
		while (!sc.hasNextInt()) {
			System.out.print("How many computers you wants to enter (number): ");
			sc.next();
		}

		howManyComp = sc.nextInt();
		int availableSpace = (getMaxComputers() - getUsedSpace());
		System.out.println();

		if (howManyComp == 0) {
			SystemMessage.ZeroEntryMessgae(0);
			return;
		} else if (availableSpace == 0) {
			SystemMessage.FailedMessgae(howManyComp);
			return;
		}

		checkSpaceAndAddNewComputer(howManyComp, availableSpace, sc);

	}

	private static void checkSpaceAndAddNewComputer(int howManyComp, int availableSpace, Scanner sc) {

		if (howManyComp > availableSpace) {

			SystemMessage.AlertSpaceAvailability(availableSpace);

			String conformation = sc.next();
			if (conformation.toLowerCase().contentEquals(Yes)) {
				howManyComp = availableSpace;
				addComputerToInventory(howManyComp, sc, -1);
			}
		} else {
			addComputerToInventory(howManyComp, sc, -1);
		}

		System.out.println();

	}

	// isManuallyIndexBasedEntry == -1 indicate automatic increment of computer
	// index while inserting new computer
	// ELSE specific index based entry if the index is empty while updating computer
	// info from update menu option # 2.
	public static void addComputerToInventory(int howManyComp, Scanner sc, int isManuallyIndexBasedEntry) {
		sc.nextLine();
		Computer[] newComp = new Computer[howManyComp];
		for (int i = 0; i < howManyComp; i++) {
			int compIndex = getNextEmptyIndexFromInventory(isManuallyIndexBasedEntry);
			System.out.println();
			System.out.println("Please provide information for computer # " + compIndex);
			newComp[i] = new Computer(sc, compIndex);
			AddNewComputerToInventory.insertIntoInventory(newComp[i], compIndex);
		}
		SystemMessage.SuccessMessgae(howManyComp, getUsedSpace(), getRemainComputers());

	}

	private static int getNextEmptyIndexFromInventory(int isManuallyIndexBasedEntry) {
		int compIndex = 0;
		if (isManuallyIndexBasedEntry != -1) {
			compIndex = isManuallyIndexBasedEntry;
			return compIndex;
		} else {
			if (StoreInventory.getInventory()[compIndex] == null) {
				return compIndex;
			} else
				return getEmptyIndexInInventoryDB();
		}

	}

}
