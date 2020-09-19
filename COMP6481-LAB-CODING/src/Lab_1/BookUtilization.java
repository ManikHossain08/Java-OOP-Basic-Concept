package Lab_1;

import java.util.Scanner;

class Book {
	protected String title;
	protected int np ;
	protected double price;
	
	public Book(Scanner sc) {
		title = sc.next();
		np = sc.nextInt();
		price = sc.nextDouble();
	}
}

public class BookUtilization {
	private static Book[] books ;
	private static int size;
	private static double max = Double.MIN_VALUE; 
	private static double min = Double.MAX_VALUE; 
	private static Book expBook;; 
	private static Book leastbook; 
	
	private static void mostExpensive() {
		for (int i = 0; i < size; i++) {
			if(books[i].price > max) {
				expBook = books[i];
				max = Math.max(books[i].price, max);
			}
		}
		System.out.print("The most expensive book is " + expBook.title +" with " + expBook.np + " pages for the price of " + expBook.price+ "\n" );
	}
	
	private static void leastExpensive() {
		for (int i = 0; i < size; i++) {
			if(books[i].price < min) {
				leastbook = books[i];
				min = Math.min(books[i].price, min);
			}
		}
		System.out.print("The Least expensive book is " + leastbook.title +" with " + leastbook.np + " pages for the price of " + leastbook.price);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		size = sc.nextInt();
		books = new Book[size];
		for (int i = 0; i < size; i++) {
			books[i] = new Book(sc);
		}
		mostExpensive(); 
		leastExpensive();
		sc.close();
	}
}
