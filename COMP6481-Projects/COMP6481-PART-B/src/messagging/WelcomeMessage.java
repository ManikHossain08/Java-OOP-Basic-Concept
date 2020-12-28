package messagging;

import java.util.Scanner;

import inventoryController.StoreInventory;

public class WelcomeMessage extends StoreInventory {
	
	public WelcomeMessage(Scanner sc) {
		System.out.println("Hello owner! we are hopping the best services for your computer store.\n");
		
		System.out.println("Please first enter maximum space for your store. How many computer can contains at your store?");
		System.out.print("Please enter maximum computer number> ");
		while (!sc.hasNextInt()) {
			System.out.print("Please enter maximum computer number> ");
			sc.next();
		}
		int maxComputer = sc.nextInt();
		setStoreMaxComputerSpace(maxComputer);
		
		System.out.println();
		System.out.println("IMPORTANNT NOTE: You are allowed to keep maximum " + getMaxComputers() + " computers. "
				+ "\nYou have already keep " + getUsedSpace() + " computers on your store and you have "
				+ getRemainComputers() + " space left.");
		
	}
}
