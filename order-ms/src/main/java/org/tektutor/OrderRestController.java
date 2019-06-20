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
public class OrderRestController {

	@Autowired
	private OrderRepository orderRepository;
	
	@PostConstruct
	public void initCustomerRepo() {
		
		orderRepository.saveAll ( Stream.of( new Order( 1, 1, "Markers", "Pune" ),
												new Order( 2, 1,  "Mobile", "Chennai")
		).collect( Collectors.toList()));

	}
	
	@GetMapping("/orders")
	public Iterable<Order> getAllOrders( ) {
		return  orderRepository.findAll();
	}
	
}
