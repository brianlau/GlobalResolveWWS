package com.example.globalresovlewws;

public class Weather {
	
	private double latitude;
	private double longitude;
	private String time;
	private int	maxTemp;
	private int minTemp;
	private int chanceOfPrecipi;
	
	
	
	public Weather() {

	}

	public Weather(String time, double latitude, double longitude, int maxTemp, int minTemp, int cOP){
		this.latitude = latitude;
		this.longitude = longitude;
		this.time = time;
		this.maxTemp = maxTemp;
		this.minTemp = minTemp;
		this.chanceOfPrecipi = cOP;
	}


	public double getLatitude() {
		return latitude;
	}



	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}



	public double getLongitude() {
		return longitude;
	}



	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}



	public String getTime() {
		return time;
	}



	public void setTime(String time) {
		this.time = time;
	}



	public int getMaxTemp() {
		return maxTemp;
	}



	public void setMaxTemp(int maxTemp) {
		this.maxTemp = maxTemp;
	}



	public int getMinTemp() {
		return minTemp;
	}



	public void setMinTemp(int minTemp) {
		this.minTemp = minTemp;
	}



	public int getChanceOfPrecipi() {
		return chanceOfPrecipi;
	}



	public void setChanceOfPrecipi(int chanceOfPrecipi) {
		this.chanceOfPrecipi = chanceOfPrecipi;
	}
}
