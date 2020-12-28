package RefferenceFormatGenerator;

import java.util.List;

import BibFileProperty.Authors;
import BibFileProperty.BibAttributes;

public class OrganizeRefferencesInString {

	/**
	 * @param atricles
	 * @return
	 */
	public static String organizeInIEEFormat(List<BibAttributes> atricles) {

		StringBuilder IEEE = new StringBuilder();

		for (BibAttributes refference : atricles) {

			IEEE.append(authorsInIEEE(refference.getAuthor()));
			IEEE.append(" \"" + refference.getTitle() + "\",");
			IEEE.append(" " + refference.getJournal() + ",");
			IEEE.append(" vol. " + refference.getVolume() + ",");
			IEEE.append(" no. " + refference.getNumber() + ",");
			IEEE.append(" p. " + refference.getPages() + ",");
			IEEE.append(" " + refference.getMonth());
			IEEE.append(" " + refference.getYear() + ".");
			IEEE.append("\n");
			IEEE.append("\n");

		}

		return IEEE.toString();
	}

	public static String organizeInACMFormat(List<BibAttributes> atricles) {

		StringBuilder ACM = new StringBuilder();
		int refIndex = 1;
		for (BibAttributes refference : atricles) {

			ACM.append("[" + refIndex + "] ");
			ACM.append(authorsInACM(refference.getAuthor()));
			ACM.append(" " + refference.getYear() + ".");
			ACM.append(" " + refference.getTitle() + ".");
			ACM.append(" " + refference.getJournal() + ".");
			ACM.append(" " + refference.getVolume() + ",");
			ACM.append(" " + refference.getNumber());
			ACM.append(" (" + refference.getYear() + "),");
			ACM.append(" " + refference.getPages() + ".");
			ACM.append(" DOI:https://doi.org/" + refference.getDoi() + ".");
			ACM.append("\n");
			ACM.append("\n");
			refIndex++;
		}

		return ACM.toString();
	}

	public static String organizeInNJFormat(List<BibAttributes> atricles) {

		StringBuilder NJ = new StringBuilder();

		for (BibAttributes refference : atricles) {

			NJ.append(authorsInNJ(refference.getAuthor()));
			NJ.append(" " + refference.getTitle() + ".");
			NJ.append(" " + refference.getJournal() + ".");
			NJ.append(" " + refference.getVolume() + ",");
			NJ.append(" " + refference.getPages());
			NJ.append("(" + refference.getYear() + ").");
			NJ.append("\n");
			NJ.append("\n");

		}

		return NJ.toString();
	}

	/**
	 * @param authors
	 * @return
	 */
	private static String authorsInIEEE(List<Authors> authors) {

		String authorStr = "";
		for (int i = 0; i < authors.size(); i++) {
			if (authors.size() - 1 != i)
				authorStr += authors.get(i).getAuthor() + ", ";
			else
				authorStr += authors.get(i).getAuthor() + ".";
		}
		return authorStr;
	}

	private static String authorsInACM(List<Authors> authors) {

		String authorStr = authors.get(0).getAuthor() + " et al.";
		return authorStr;
	}

	private static String authorsInNJ(List<Authors> authors) {

		String authorStr = "";
		for (int i = 0; i < authors.size(); i++) {
			if (authors.size() - 1 != i)
				authorStr += authors.get(i).getAuthor() + " & ";
			else
				authorStr += authors.get(i).getAuthor() + ".";
		}
		return authorStr;
	}

}
