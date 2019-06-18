package org.tektutor;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

import org.springframework.context.annotation.Bean;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class OlaAppRestController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private LoadBalancerClient clientSideLB;
	
	@Bean
	public RestTemplate createRestTemplate() {
		return new RestTemplate();
	}
	
	@GetMapping("/bookcab")
	public Cab bookACab() {
		
		/*
		 * String strURL="";
		 * 
		 * InstanceInfo instance = discoveryClient.getNextServerFromEureka("ola-cab",
		 * false); strURL = instance.getHomePageUrl();
		 * 
		 * strURL = strURL + "/cab";
		 * 
		 * System.out.println(strURL);
		 * 
		 * URI url = URI.create( strURL ); return restTemplate.getForObject(url,
		 * Cab.class);	
		 */		 
		
		ServiceInstance cabServiceinstance = clientSideLB.choose("ola-cab");
		
		String url = cabServiceinstance.getUri().toString();
		url = url + "/cab";
		
		Cab cab = restTemplate.getForObject( url, Cab.class);
		return cab;
	}
	
}
