package org.tektutor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerRestController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@PostConstruct
	public void initCustomerRepo() {
		
		customerRepository.saveAll ( Stream.of( new Customer( 1, "Jegan", "Pune" ),
												new Customer( 2, "Hari", "Chennai")
		).collect( Collectors.toList()));

	}

	
	@GetMapping("/customers")
	public Iterable<Customer> getAllCustomers( ) {
		return  customerRepository.findAll();
	}
	
	@PutMapping("/update-address/{id}")
	public void updateCustomerAddress(@PathParam("id") int customerId) {



	}
	
}
