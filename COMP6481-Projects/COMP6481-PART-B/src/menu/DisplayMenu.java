package menu;

public class DisplayMenu {
	
	public void mainMenu() {
		System.out.println();
		System.out.println("What do you want to do?\n" + 
				"1. Enter new computers (password required)\n" + 
				"2. Change information of a computer (password required)\n" + 
				"3. Display all computers by a specific brand\n" + 
				"4. Display all computers under a certain a price.\n" + 
				"5. Quit"); 
		System.out.println();
		System.out.print("Please enter your choice (1-5)> ");
	}
	
	public void updateMenu() {
		System.out.println();
		System.out.println("What information (attributes) would you like to change?\n" + 
				"1. Brand\n" + 
				"2. Model\n" + 
				"3. SN\n" + 
				"4. Price\n" + 
				"5. Quit");
		System.out.println();
		System.out.print("Please enter your choice (1-5)> ");
	}
}
