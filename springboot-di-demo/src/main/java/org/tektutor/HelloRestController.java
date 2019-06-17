package org.tektutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {
	
	@Autowired
	private HelloService helloService;

	@GetMapping("/")
	public String sayHello() {
		return helloService.sayHello();
	}
}	