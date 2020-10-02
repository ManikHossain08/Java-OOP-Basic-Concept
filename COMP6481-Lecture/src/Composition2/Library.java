package Composition2;

import java.util.List;

class Library {
	// reference to refer to list of books.
	private final List<Book> books;

	public Library(List<Book> books) {
		this.books = books;
	}

	public void AddBookToLibrary(Book book) {
		this.books.add(book);;
	}
	
	public List<Book> getTotalBooksInLibrary() {

		return books;
	}

}
