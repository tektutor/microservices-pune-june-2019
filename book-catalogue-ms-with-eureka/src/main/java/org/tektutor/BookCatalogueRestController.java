package org.tektutor;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookCatalogueRestController {

	private ArrayList<Book> listOfBooks;
	
	public BookCatalogueRestController() {
		
		listOfBooks = new ArrayList<Book>();
		
		Book builMicroServices = new Book("Building Microservices", "Sam Newman", "Rs. 550" );
		Book ansibleUpAndRunning = new Book("Ansible Up and Running", "Jeff", "Rs. 350" ) ;
		Book cleanCode = new Book("Clean Code", "Robert Martin C", "Rs. 450" ) ;
		
		listOfBooks.add( builMicroServices );
		listOfBooks.add( ansibleUpAndRunning );
		listOfBooks.add( cleanCode );

	}
	
	@GetMapping("/books")
	public ArrayList<Book> getAllBooks() {
		return listOfBooks;
	}
	
}
