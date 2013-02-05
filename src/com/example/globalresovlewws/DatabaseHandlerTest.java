package com.example.globalresovlewws;

import static org.junit.Assert.*;
import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;

import com.example.globalresovlewws.DatabaseHandler;
import org.junit.Test;

public class DatabaseHandlerTest extends AndroidTestCase{

	private DatabaseHandler db;
	private Weather weather1;
	public void setUp(){
		RenamingDelegatingContext context = new RenamingDelegatingContext(getContext(), "test_");
		db = new DatabaseHandler(context);
		weather1 = new Weather("01:12:12", 57.2, 52.3, 75, 50, 50);
	}

	@Test
	public void testAddWeather() {
		db.addWeather(weather1);
		db.getWeather("01:12:12");
	}
	
	public void tearDown() throws Exception{
        db.close(); 
        super.tearDown();
    }

}
