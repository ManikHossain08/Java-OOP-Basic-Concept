package File_IO_Binary;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

// https://www.codejava.net/java-se/file-io/java-serialization-basic-example
// https://www.codejava.net/java-se/file-io/why-do-we-need-serialization-in-java

/*
 * Serialization is the process of saving an object’s states in a persistent format 
 * (such as file stream or database), and later restoring them back from the stream (de-serialization).
 * 
 * The process of retrieval and construction of objects from disk files, databases and network is 
 * called de-serialization.
 * 

 Here are some examples of using serialization:
 
- Storing data in an object-oriented way to files on disk, e.g. storing a list of Student objects.

- Saving program’s states on disk, e.g. saving state of a game.

- Sending data over the network in form objects, e.g. sending messages as objects in chat application.
 */

public class SerializableExample_2_Modify {
	/*
	 * When running this program, the object state is stored in a file called
	 * “user.ser”, and the output would be from printInfo();
	 * 
	 * As we see, all the fields of the User object are saved and restored back
	 * perfectly by de-serialization, except the password field is null, because we
	 * mark it as transient.
	 */
	private static final String filePath = "userss.ser";
	private static User[] users = new User[4];

	public static void main(String[] args) {
		String username = "codejava";
		String email = "info@codejava.net";
		String password = "secret";
		Date birthDay = new Date();
		int age = 20;

		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;

		User newUser = new User(username, email, password, birthDay, age);
		User newUser1 = new User("abc20", "abc20@codejava.net", password, birthDay, 50);
		User newUser2 = new User("new1000", "new@codejava.net", password, birthDay, 100);
		users[0] = newUser;
		users[1] = newUser1;
		users[2] = newUser2;
		users[3] = newUser1;

		try {
			oos = new ObjectOutputStream(new FileOutputStream(filePath));
			serializeClassObject(oos);
		} catch (Exception e) {
			System.out.println("Error: Problem Reading from file: " + filePath + ".");
			System.out.println("Program will terminate.");
			System.exit(0);
		}

		try {
			ois = new ObjectInputStream(new FileInputStream(filePath));
			deserializeClassObject(ois);
		} catch (IOException | ClassNotFoundException ex) {
			System.err.println(ex);
		}
	}

	private static void serializeClassObject(ObjectOutputStream outputStream) throws IOException {
		for (int i = 0; i < users.length; i++) {
			outputStream.writeObject(users[i]);
		}

		outputStream.close();

	}

	private static void deserializeClassObject(ObjectInputStream inputStream)
			throws ClassNotFoundException, IOException {

		try {
			while (true) {
				User savedUser = (User) inputStream.readObject(); // Notice the type cast here; this is the reason
				// that we need to handle ClassNotFoundException
				savedUser.printInfo();
				System.out.println(savedUser.getAge());
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Error has occurred while reading the file: " + filePath + ".");
		} catch (EOFException e) {
			System.out.println("\nReading file \"" + filePath + "\" has been completed.");
		}

		inputStream.close();
	}

}
