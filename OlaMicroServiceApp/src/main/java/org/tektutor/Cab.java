package org.tektutor;

public class Cab {

	private String driverName;
	private String carMake;
	private String carRegistrationDetails;
	private String colorOfTheCar;
	
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getCarMake() {
		return carMake;
	}
	public void setCarMake(String carMake) {
		this.carMake = carMake;
	}
	public String getCarRegistrationDetails() {
		return carRegistrationDetails;
	}
	public void setCarRegistrationDetails(String carRegistrationDetails) {
		this.carRegistrationDetails = carRegistrationDetails;
	}
	public String getColorOfTheCar() {
		return colorOfTheCar;
	}
	public void setColorOfTheCar(String colorOfTheCar) {
		this.colorOfTheCar = colorOfTheCar;
	}
	
	public Cab() {
	}
	
	public Cab(String driverName, String carMake, String carRegistrationDetails, String colorOfTheCar) {
		this.driverName = driverName;
		this.carMake = carMake;
		this.carRegistrationDetails = carRegistrationDetails;
		this.colorOfTheCar = colorOfTheCar;
	}
	
	
}
