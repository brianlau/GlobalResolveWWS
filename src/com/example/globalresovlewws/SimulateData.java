package com.example.globalresovlewws;

//dummyTemperature Class
public class SimulateData {
	private int temp = 0;

	public void TemperatureForecast() {//sets the temp variable
		temp = (int) (Math.random() * 100);
	}

	public int CurrentTemperature() { //returns temperature as an int
		return temp;
	}
}
