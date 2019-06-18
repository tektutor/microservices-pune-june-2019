package org.tektutor;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class OlaCabRestController {

	private static ArrayList<Cab> listOfCabs = new ArrayList();
	
	static {
		Cab bmwX5 = new Cab ( "Akshay Kumar", "BMW X5", "MH 05 1234", "Black");
		Cab audiQ7 = new Cab( "Ameer Khan",   "Audi Q7", "MH 01 3525", "White");
		Cab audiA6 = new Cab( "Amitabh Bachan", "Audi A6", "MH 02 5555", "Black");
		Cab vwPassat = new Cab ( "Rajinikant","Volkswagen Passat", "MH 05 9999", "Black");
		Cab mercedesEClass = new Cab ( "Kamal Hasan", "Mercedes E Class", "MH 05 8055", "White");
		
		listOfCabs.add(bmwX5);
		listOfCabs.add(audiQ7);
		listOfCabs.add(audiA6);
		listOfCabs.add(vwPassat);
		listOfCabs.add(mercedesEClass);
	}
	
	@GetMapping("/cab")
	public Cab getDriverDetails() {
		Random rand = new Random();
		return listOfCabs.get(rand.nextInt(listOfCabs.size()));
	}
}
