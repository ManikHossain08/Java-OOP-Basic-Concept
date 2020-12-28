package inventoryController;

import computer.Computer;

public class StoreInventory {

	private static Computer[] inventory;
	private static int maxComputers = 0;
	private static int usedSpace = 0;

	public void setStoreMaxComputerSpace(int maxComputer) {
		inventory = new Computer[maxComputer];
		maxComputers = maxComputer;
	}

	public static int getMaxComputers() {
		return maxComputers;
	}

	public static int getUsedSpace() {
		return usedSpace;
	}

	public static int getRemainComputers() {
		return maxComputers - usedSpace;
	}

	public static Computer[] getInventory() {
		return inventory;
	}

	public static void insertNewComputerToInventory(Computer comp, int compIndex) {
		inventory[compIndex] = comp;
		usedSpace++;
	}

	public static void updateExistingComputerToInventory(Computer comp, int compIndex) {
		inventory[compIndex] = comp;
	}

	public static int getEmptyIndexInInventoryDB() {
		for (int i = 0; i < inventory.length; i++) {
			if (inventory[i] == null)
				return i;
		}
		return inventory.length;
	}
}
