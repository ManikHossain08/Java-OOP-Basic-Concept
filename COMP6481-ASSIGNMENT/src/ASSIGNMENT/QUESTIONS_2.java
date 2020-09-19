package ASSIGNMENT;

public class QUESTIONS_2 {
	public static void main(String[] args) {
		String str = "gggN@@@@@KKeeeejjdsmmu";

		System.out.print(shortStringRepresentation(str));
	}

	private static String shortStringRepresentation(String str) {
		StringBuilder orgStr = new StringBuilder(str);
		StringBuilder result = new StringBuilder(str.charAt(0) + "");
		int counter = 0;

		for (int i = 0; i < orgStr.length(); i++) {
			int index = result.length() - 1;
			if (result.charAt(index) == orgStr.charAt(i)) {
				counter++;
			} else {
				if (counter >= 2)
					result.append(counter);
				result.append(orgStr.charAt(i));
				counter = 1;
			}
		}

		return result.toString();
	}
}
//g3N@5K2e4j2dsm2u