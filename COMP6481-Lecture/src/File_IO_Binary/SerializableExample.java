package File_IO_Binary;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
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
        
        serializeClassObject(newUser);
        
        User savedUser = deserializeClassObject();
        if (savedUser != null) {
            savedUser.printInfo();
        }
    }
	
	private static void serializeClassObject(User newUser) {
		try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath));
            outputStream.writeObject(newUser);
            outputStream.close();
        } catch (IOException ex) {
            System.err.println(ex);
        }
		
	}

	private static User deserializeClassObject() {
		User savedUser = null;
        
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath));
            savedUser = (User) inputStream.readObject();
            inputStream.close();
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println(ex);
        }
         
        return savedUser;
	}


}

/*
 * SerialVersionUID:
	The Serialization runtime associates a version number with each Serializable class called a SerialVersionUID, 
	which is used during Deserialization to verify that sender and reciever of a serialized object have loaded 
	classes for that object which are compatible with respect to serialization. If the reciever has loaded a class 
	for the object that has different UID than that of corresponding sender’s class, the Deserialization will 
	result in an InvalidClassException.
 */

class User implements Serializable {
	private static final long serialVersionUID = 1234L;
	 
    private String username;
    private String email;
    private transient String password; 
    // transient Because we don’t want store the password when serializing the object. The rule is, when a 
    // variable is marked as transient, its object won’t be serialized during serialization.  
    private Date birthday;
    private int age;
 
    public User(String username, String email, String password, Date birthday,
            int age) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
        this.age = age;
    }
 
    public void printInfo() {
        System.out.println("username: " + username);
        System.out.println("email: " + email);
        System.out.println("password: " + password);
        System.out.println("birthday: " + birthday);
        System.out.println("age: " + age);
    }
 
    // A simple implementation of getters and setters
}

