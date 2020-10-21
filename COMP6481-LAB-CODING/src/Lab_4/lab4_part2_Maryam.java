package Lab_4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class lab4_part2_Maryam {

	public static void main(String[] args) {

		PrintWriter pw = null;
		Scanner sc = null;
		BufferedReader b = null;

		// open scanner and print writer
		try {

			sc = new Scanner(new FileInputStream("Inventory.txt"));
			pw = new PrintWriter(new FileOutputStream("Good_Inventory.txt"));

			correct_Inventory(sc, pw);

		}

		catch (FileNotFoundException e) {
			System.out.println("The specefic file dose not exist");
			System.exit(0);
		}

		// open buffer reader

		try {
			b = new BufferedReader(new FileReader("Good_Inventory.txt"));
		}

		catch (FileNotFoundException e) {
			System.out.println("The specefic file dose not exist");
			System.exit(0);
		}

		// Display buffer reader

		System.out.println("Display the inventory : ");
		System.out.println("=========================");

		try {
			dispaly_GoodInventory(b);
		}

		catch (IOException e) {
			System.out.println("File can not read");
			System.exit(0);
		}

	}

	public static void dispaly_GoodInventory(BufferedReader b) throws IOException {

		int x;
		x = b.read();
		while (x != -1) {

			System.out.print((char) x);
			x = b.read();
		}

		b.close();

	}

	public static void correct_Inventory(Scanner sc, PrintWriter pw) {

		String s;
		long id;

		while (sc.hasNextLine()) {

			s = sc.nextLine();

			if (sc.hasNextLong()) {

				id = sc.nextLong();
				String ID = Long.toString(id);
				ID = ID.substring(ID.length() - 2);

				if (ID == "99") {
					ID = "88";
					pw.println(id);

				}

				else if (ID == "33") {
					sc.nextLine();
				}

			}

			pw.println(s);

		}

		sc.close();
		pw.close();
	}

}
