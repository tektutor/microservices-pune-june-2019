package org.tektutor;

import java.net.URI;
import java.util.ArrayList;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class BookStoreRestController {

	@HystrixCommand(fallbackMethod="getLocalCatalogue")
	@GetMapping("/catalogue")
	public ArrayList<Book> getBookCatalogue() {
		RestTemplate restTemplate = new RestTemplate();
		
		URI url = URI.create("http://localhost:8080/books");
		
		ParameterizedTypeReference<ArrayList<Book>> reference
        = new ParameterizedTypeReference<ArrayList<Book>>() { };

        ResponseEntity<ArrayList<Book>> response
                = restTemplate.exchange(url, HttpMethod.GET, null,reference);

        return response.getBody();
	}
	
	public ArrayList<Book> getLocalCatalogue() {
		
		ArrayList<Book> listOfBooks = new ArrayList<Book>();
		listOfBooks.add(new Book("Hysterix", "Some author", "Rs.100"));
		
		return listOfBooks;
		
	}
}
