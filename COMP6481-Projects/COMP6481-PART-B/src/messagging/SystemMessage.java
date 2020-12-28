package messagging;

public class SystemMessage {
	
	public static void AlertEmptyInput(String attr) {
		String msg = "ALLERT MESSAGE: Sorry you did not provide any information for '"+ attr.split(":")[0] + "' attribute. "
				+ "Please provide input for '"+ attr.split(":")[0] + "' to proceed";
		System.out.println(msg);
	}
	
	public static void AlertNoComputerObject(int updateIndex) {
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		sb.append("\nALERT MESSAGE: There is no computer object on index # " + updateIndex);
		sb.append("\nDo you want to enter another computer on index # " + updateIndex +" (y/n)> ");
		
		System.out.print(sb.toString());
	}
	
	public static void AlertSpaceAvailability(int availableSpace) {
		String msg = "SPACE AVAILABLIBILITY MESSAGE: There is only " + availableSpace
				+ " space available. You can add only " + availableSpace + " Computers.\n"
				+ "Do you want to add only " + availableSpace + " computer (y/n)> ";
		System.out.print(msg);
	}
	

	public static void SuccessMessgae(int howManyComp, int usedSpace, int remainComputers) {
		System.out.println();
		System.out.println("SUCCESS MESSAGE: " + howManyComp + " computers have been stored succesfully.");
		System.out.println("STORE SPACE UPDATE MESSAGE: Total " + usedSpace + " computers stored in your store and "
						+ "still you are allowed to store " + remainComputers + " computers");
		
	}
	
	public static void FailedMessgae(int howManyComp) {
		System.out.println("FALIED MESSAGE: Sorry, there is no space available, so " + howManyComp
				+ " computers cannot be stored.");
	}

	public static void ZeroEntryMessgae(int i) {
		System.out.println("FAILED MESSAGE: Sorry, entry cannot be 0, must be greater than 0.");
	}

	public static void GoingBackMainManuMessage(int addingLimit, int updateIndex) {
		System.out.println();
		System.out.println("FAILED MESSAGE: Going back to Main Menu because the index # " + updateIndex
				+ " exceed the " + "limit of index # " + addingLimit);
		
	}

	public static void ComputerUpdateMessage(int addingLimit) {
		System.out.print("Which computer number you want to update (Enter Index # 0-" + addingLimit + ")> ");
	}

	public static void SuccessSearchMessage(int foundCounter, double searchingPrice) {
		System.out.println("SUCCESS SEARCH MESSAGE: Found " + foundCounter
				+ " computer records from your store which price are below $" + searchingPrice);
		
	}

	public static void SuccessSearchMessageBrand(int counter, String searchingBrand) {
		System.out.println("SUCCESS SEARCH MESSAGE: Found " + counter
				+ " computer records from your store which match with '" + searchingBrand + "'");
		
	}

}
