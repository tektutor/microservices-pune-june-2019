
  package org.tektutor;
  
  import org.springframework.boot.SpringApplication; 
  import org.springframework.boot.autoconfigure.SpringBootApplication; 
  import org.springframework.cloud.netflix.eureka.EnableEurekaClient; 

  
  @SpringBootApplication
  
  @EnableEurekaClient 
  public class OlaMicroServiceAppApplication {
  
	  public static void main(String[] args) {
		  SpringApplication.run(OlaMicroServiceAppApplication.class, args); 
	  }
  
} 