package chapter16.practice.entity;

public class Book extends Item {
	private String isbn;
	private String author;
	private String publisher;
//	private int publishYear;
//	private int price;
//	private int stock;
	private Category category;

	public Book(String id, String name, String isbn, String author, String publisher, Category category) {
		super(id, name);
		this.isbn = isbn;
		this.author = author;
		this.publisher = publisher;
		this.category = category;
	}

	@Override
	public void display() {
		System.out.println("ID: " + getId() + ", Title: " + getName() + ", Category: " + category);
	}
}
