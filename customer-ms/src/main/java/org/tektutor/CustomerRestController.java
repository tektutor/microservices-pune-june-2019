package org.tektutor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerRestController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private KafkaTemplate<Integer,Object> kakfaTemplate;
	
	private static final String TOPIC = "CUSTOMER_ADDRESS_UPDATE";
	
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
	
	@GetMapping("/update-address")
	public String updateCustomerAddress() {
				
			Customer customer = new Customer ( 1, "Jegan", "Austin" );
		
			kakfaTemplate.send( TOPIC,  customer );
		
			return "Customer updated successfully !";
	}
	
}
