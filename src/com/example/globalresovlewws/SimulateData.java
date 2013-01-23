package com.example.globalresovlewws;

public class SimulateData {
public double TemperatureForecast()
{
	double temp = Math.random() * 100;
	return temp;
}
public double CurrentTemperature()
{
	return TemperatureForecast();
}
}
