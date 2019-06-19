package org.tektutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublishNewConnectionRestController {

	@Autowired
	private KafkaTemplate<String,String> kakfaTemplate;
	
	private static final String TOPIC = "NEW_MOBILE_CONNECTION_REQUEST";
	
	@GetMapping("/publish/{message}")
	public String requestNewMobileConnection( @PathVariable("message") String message)  {	
		kakfaTemplate.send( TOPIC, message );
	
		return "Congratulations, Your application is submitted successfully !";
	}
	
}