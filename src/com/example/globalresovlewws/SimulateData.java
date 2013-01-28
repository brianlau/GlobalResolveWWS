package com.example.globalresovlewws;

public class SimulateData {
	private int temp = 0;

	public void TemperatureForecast() {
		temp = (int) (Math.random() * 100);
	}

	public int CurrentTemperature() {
		return temp;
	}
}
