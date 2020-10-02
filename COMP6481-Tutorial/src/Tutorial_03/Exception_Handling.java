package Tutorial_03;

// https://www.javatpoint.com/exception-handling-in-java
/*
 * The Exception Handling in Java is one of the powerful mechanism to handle the runtime errors 
 * so that normal flow of the application can be maintained.
 * 
 * Exception Handling is a mechanism to handle runtime errors such as ClassNotFoundException, 
 * IOException, SQLException, RemoteException, etc.
 * 
 * Difference between Checked and Unchecked Exceptions

	1) Checked Exception
	
	The classes which directly inherit Throwable class except RuntimeException and Error are known as 
	checked exceptions e.g. IOException, SQLException etc. Checked exceptions are CHECKED at compile-time.
	
	2) Unchecked Exception
	
	The classes which inherit RuntimeException are known as unchecked exceptions e.g. ArithmeticException, 
	NullPointerException, ArrayIndexOutOfBoundsException etc. Unchecked exceptions are NOT CHECKED at 
	compile-time, but they are checked at runtime.
	
	3) Error
	
	Error is irrecoverable e.g. OutOfMemoryError, VirtualMachineError, AssertionError etc.
 * 
 */

public class Exception_Handling {
	public static void main(String args[]) {
		try {
			// code that may raise exception
			int data = 100 / 0;
			// if exception occurs, the remaining statement will not exceute  
			System.out.println("value of data:" +data);
		} catch (ArithmeticException e) {
			System.out.println(e);
			// displaying the custom message  
            System.out.println("Can't divided by zero");  
		}
		finally {
			System.out.println("I will always be execute...");
		}
		
		
		// rest code of the program
		System.out.println("rest of the code...");
	}
}
