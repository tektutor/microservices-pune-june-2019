package org.tektutor;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableEurekaClient
@SpringBootApplication
public class BookCatalogueRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookCatalogueRestApplication.class, args);
	}

}