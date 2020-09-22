package FileReadAndSerialization;

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

public class SerializableExample {
	/*
	 * When running this program, the object state is stored in a file called “user.ser”, 
	 * and the output would be from printInfo();
	 * 
	 * As we see, all the fields of the User object are saved and restored back perfectly by de-serialization, 
	 * except the password field is null, because we mark it as transient.
	 */
	private static final String filePath = "user.ser";
	
	public static void main(String[] args) {
        String username = "codejava";
        String email = "info@codejava.net";
        String password = "secret";
        Date birthDay = new Date();
        int age = 20;
         
        User newUser = new User(username, email, password, birthDay, age);
        
        serialize(newUser);
        
        User savedUser = deserialize();
         
        if (savedUser != null) {
            savedUser.printInfo();
        }
    }
	
	private static void serialize(User newUser) {
		try {
            FileOutputStream fos = new FileOutputStream(filePath);
            ObjectOutputStream outputStream = new ObjectOutputStream(fos);
            outputStream.writeObject(newUser);
            outputStream.close();
        } catch (IOException ex) {
            System.err.println(ex);
        }
		
	}

	private static User deserialize() {
		User savedUser = null;
        
        try {
            FileInputStream fis = new FileInputStream(filePath);
            ObjectInputStream inputStream = new ObjectInputStream(fis);
            savedUser = (User) inputStream.readObject();
            inputStream.close();
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println(ex);
        }
         
        return savedUser;
	}


}
