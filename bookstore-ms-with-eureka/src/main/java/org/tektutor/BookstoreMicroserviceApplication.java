package org.tektutor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@EnableCircuitBreaker
@SpringBootApplication
public class BookstoreMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreMicroserviceApplication.class, args);
	}

}
