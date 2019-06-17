package org.tektutor;

import org.springframework.stereotype.Component;

public class Book {
	
	private String name;
	private String author;
	private String price;
	
	public Book() {
		
	}

	public Book(String nameOfBook, String author, String price ) {
		this.name = nameOfBook;
		this.author = author;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
}
