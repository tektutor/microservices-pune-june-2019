package org.tektutor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class OlaCabMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OlaCabMicroServiceApplication.class, args);
	}

}