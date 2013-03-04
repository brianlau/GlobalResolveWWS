package com.example.globalresovlewws;

import junit.framework.TestCase;

public class SimulateDataTest extends TestCase {

	public void testTemperatureForecast() {
		SimulateData SD = new SimulateData();
		double x = SD.TemperatureForecast();
		assertNotNull(x);
	}

	public void testCurrentTemperature() {
		SimulateData SD = new SimulateData();
		double x = SD.CurrentTemperature();
		assertNotNull(x);
	}

}
