package FileReadAndSerialization;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
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
