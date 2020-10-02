package Composition2;

import java.util.ArrayList;
import java.util.List;
// https://examples.javacodegeeks.com/java-composition-example/
// **** https://www.geeksforgeeks.org/association-composition-aggregation-java/
// **** https://abhiandroid.com/java/composition
/*
 * 3. Java Composition Benefits
If you are looking for code reuse and the relationship between the two classes is has-a then you should use composition rather than inheritance.
The benefit of using composition in java is that we can control the visibility of other objects to client classes and reuse only what we need.
Also if there is any change in the other class implementation, for example, getSalary returning String, we need to change Person class to accommodate it but client classes don’t need to change.
Composition allows the creation of back-end class when it’s needed, for example, we can change the Person getSalary method to initialize the Job object at runtime when required.
It is easier to change the class which is implementing composition than inheritance.
The composition is done at run time i.e. dynamic binding while Inheritance is done at compile time i.e. static binding.
If you want to reuse code and there is no is-a relationship, then use composition. You don’t need to use inheritance for code reuse.
If you want polymorphism, but there is no is-a relationship, then use composition with interfaces. You don’t need to use inheritance to get polymorphism.
 */

/*
 * In above example a library can have no. of books on same or different subjects. So, If Library gets destroyed then 
 * All books within that particular library will be destroyed. i.e. book can not exist without library. 
 * That’s why it is composition.
 */

/*
 * Aggregation vs Composition

Dependency: Aggregation implies a relationship where the child can exist independently of the parent. 
For example, Bank and Employee, delete the Bank and the Employee still exist. whereas Composition implies a 
relationship where the child cannot exist independent of the parent. Example: Human and heart, heart don’t exist separate 
to a Human
Type of Relationship: Aggregation relation is “has-a” and composition is “part-of” relation.
Type of association: Composition is a strong Association whereas Aggregation is a weak Association.

 */

public class Compostion2_ConcordiaLibrary {
	// main method
	public static void main(String[] args) {

		// Creating the Objects of Book class.
		Book b1 = new Book("EffectiveJ Java", "Joshua Bloch");
		Book b2 = new Book("Thinking in Java", "Bruce Eckel");
		Book b3 = new Book("Java: The Complete Reference", "Herbert Schildt");

		// Creating the list which contains the no. of books.
		List<Book> books = new ArrayList<Book>();
		books.add(b1);
		books.add(b2);
		books.add(b3);

		Library library = new Library(books);

		List<Book> bks = library.getTotalBooksInLibrary();
		for (Book bk : bks) {

			System.out.println("Title : " + bk.title + " and " + " Author : " + bk.author);
		}

		// Another Way: instead of adding manually I am using function to add book.
		System.out.println("\nAnother Way: instead of adding manually I am using function to add book.");
		library.AddBookToLibrary(b1);
		library.AddBookToLibrary(b2);
		library.AddBookToLibrary(b3);

		List<Book> addedBooks = library.getTotalBooksInLibrary();
		for (Book book : addedBooks) {

			System.out.println("Title : " + book.title + " and " + " Author : " + book.author);
		}
	}
}
