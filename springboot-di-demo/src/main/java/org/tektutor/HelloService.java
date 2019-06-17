package org.tektutor;

import org.springframework.stereotype.Component;

@Component
public class HelloService {

	public HelloService() {
		
	}
	
	public String sayHello() {
		return "Hello MicroService !";
	}
}