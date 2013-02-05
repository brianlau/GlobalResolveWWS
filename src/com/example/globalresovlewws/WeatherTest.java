package com.example.globalresovlewws;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Test;

public class WeatherTest {
	private Weather weather1;
	private Weather weather2;

	@Test
	public void testConstructor() throws Exception {
		weather1 = new Weather("12:32:01", 45.2, 78.1, 90, 78, 12);
		weather2 = new Weather("01:23:75", 101.2, 45.3, 1, -3, 1);
		assertNotNull(weather1);
		assertEquals("12:32:01", weather1.getTime());
		assertEquals(45.2, weather1.getLatitude(),.01);
		assertEquals(78.1, weather1.getLongitude(),.01);
		assertEquals(90, weather1.getMaxTemp());
		assertEquals(78, weather1.getMinTemp());
		assertEquals(12, weather1.getChanceOfPrecipi());
		assertNotNull(weather2);
	}

	@Test
	public void testSetandGetTime(){
		weather1.setTime("02:56:32");
		weather2.setTime("05:36:59");
		assertEquals("02:56:32",weather1.getTime());
		assertEquals("05:36:59",weather2.getTime());
	}
	@After
	public void tearDown() throws Exception {
	}


}
