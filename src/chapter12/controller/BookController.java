package chapter12.controller;

import java.util.ArrayList;
import java.util.List;
import chapter12.model.Book;

public class BookController {
	private List<Book> books;
	
	public BookController() {
		this.books = new ArrayList<>();
	}
	
	public void addBook(String title, String author, String publisher) {
		Book newBook = new Book(title, author, publisher);
		books.add(newBook);
	}
	
	public List<Book> getAllBooks() { return books; }

	public List<Book> searchBook(String title) {
		List<Book> result = new ArrayList<Book>();
		
		for (Book book: books) {
			if(book.getAuthor().contains(title)) {
				result.add(book);
			}
		}
		return result;
	}
}
