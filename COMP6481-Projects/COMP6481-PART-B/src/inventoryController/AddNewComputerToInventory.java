package inventoryController;

import computer.Computer;

public class AddNewComputerToInventory extends StoreInventory{
	
	public static void insertIntoInventory(Computer comp, int index){
		insertNewComputerToInventory(comp, index);
	}

}
