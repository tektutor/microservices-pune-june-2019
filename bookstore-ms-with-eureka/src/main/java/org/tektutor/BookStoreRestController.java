package org.tektutor;

import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.context.annotation.Bean;


@RestController
public class BookStoreRestController {

	@Autowired
	private EurekaClient eurekaClient;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private IBookCatalogueProxy catalogueProxy;
	
	@Bean
	public RestTemplate createRestTemplate() {
		return new RestTemplate();
	}
	
	@HystrixCommand(fallbackMethod="getLocalCatalogue")
	@GetMapping("/catalogue")
	public ArrayList<Book> getBookCatalogue() {      
		/*
		 * String strURL="";
		 * 
		 * InstanceInfo instance =
		 * eurekaClient.getNextServerFromEureka("book-catalogue", false);
		 * 
		 * strURL = instance.getHomePageUrl();
		 * 
		 * strURL = strURL + "/books";
		 * 
		 * System.out.println(strURL);
		 * 
		 * URI url = URI.create( strURL );
		 * 
		 * ParameterizedTypeReference<ArrayList<Book>> reference = new
		 * ParameterizedTypeReference<ArrayList<Book>>() { };
		 * 
		 * ResponseEntity<ArrayList<Book>> response = restTemplate.exchange(url,
		 * HttpMethod.GET, null,reference);
		 * 
		 * return response.getBody();
		 */
		return catalogueProxy.getAllBooks();
	}
	
	public ArrayList<Book> getLocalCatalogue() {
		
		ArrayList<Book> listOfBooks = new ArrayList<Book>();
		listOfBooks.add(new Book("Hysterix", "Some author", "Rs.100"));
		
		return listOfBooks;
		
	}
}
