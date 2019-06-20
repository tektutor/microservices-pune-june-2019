package org.tektutor;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.kafka.annotation.KafkaListener;
	import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubscribeNewConnectionRestController {
	
	@Autowired
	private KafkaTemplate<String,String> kakfaTemplate;
	
	private static final String TOPIC = "NEW_MOBILE_CONNECTION_REQUEST";
	
	@KafkaListener(topics = TOPIC, groupId = "PROCESS_NEW_CONNECTION_REQUEST")
	public String listen(String message) {
		
	    System.out.println("Received new mobile connection request ==> " + message);
	    return message;
	    
	}
	
}
