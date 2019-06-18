package org.tektutor;

import java.util.ArrayList;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("book-catalogue")
public interface IBookCatalogueProxy {
	
	@GetMapping("/books" )
	public ArrayList<Book> getAllBooks();
	
}