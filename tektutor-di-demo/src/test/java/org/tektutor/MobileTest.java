package org.tektutor;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;

public class MobileTest {
	
	@Test
	public void testMobilePowerOnWhenCameraOnWorksNormally() {
		
		//Mocking
		ICamera mockedCamera = Mockito.mock(ICamera.class);
		
		//Stubbing - hard coding response of dependent method
		when(mockedCamera.on()).thenReturn(true);
		
		//Dependency Injection
		Mobile mobile = new Mobile(mockedCamera);
		
		boolean actualResponse = mobile.powerOn();
		boolean expectedResponse = true;
		
		assertEquals ( expectedResponse, actualResponse );
	}

}
