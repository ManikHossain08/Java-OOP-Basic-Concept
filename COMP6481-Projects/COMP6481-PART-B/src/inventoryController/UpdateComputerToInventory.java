package inventoryController;

import computer.Computer;

public class UpdateComputerToInventory extends StoreInventory {
	
	public static void updateAttributesToInventory (Computer comp, int index){
		updateExistingComputerToInventory(comp, index);
	}
}
