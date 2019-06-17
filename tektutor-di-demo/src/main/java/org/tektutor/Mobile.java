package org.tektutor;

public class Mobile {
	
	private ICamera camera;
	
//	public Mobile() {
//		System.out.println("Mobile constructor ...");
//		camera = new Camera();
//	}
	
	//Constructor - Dependency Injection
	public Mobile(ICamera camera) {
		this.camera = camera;
	}

	public boolean powerOn() {
		
		System.out.println("Mobile powerOn invoked ...");
		
		if ( camera.on() ) {
			System.out.println("Mobile powerOn positive code path ...");
			return true;
		}
		
		System.out.println("Mobile powerOn negative code path");
		return false;
	}
	
}
