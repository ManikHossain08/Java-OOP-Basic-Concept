package javaEnum;

/*
 * An enum type is a special data type that enables for a variable to be a set of predefined constants. 
 * The variable must be equal to one of the values that have been predefined for it. Common examples include compass 
 * directions (values of NORTH, SOUTH, EAST, and WEST) and the days of the week.
 * Because they are constants, the names of an enum type's fields are in uppercase letters.
 */

public class EnumTest {
	Seasons season;

	public EnumTest(Seasons season) {
		this.season = season;
	}

	public static void main(String[] args) {
		EnumTest firstSeason = new EnumTest(Seasons.WINTER);
		firstSeason.getSeasonMsg();
		
		EnumTest secondSeason = new EnumTest(Seasons.SUMMER);
		secondSeason.getSeasonMsg();
	}

	private void getSeasonMsg() {

		switch (season) {
		case WINTER:
			System.out.println("Winters are bad.");
			break;
		case SPRING:
			System.out.println("Spring are Good.");
			break;

		default:
			System.out.println("Midsummer are so-so.");
			break;
		}

	}

}
