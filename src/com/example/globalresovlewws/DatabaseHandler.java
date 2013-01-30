package com.example.globalresovlewws;

import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.*;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class DatabaseHandler extends SQLiteOpenHelper {

	private static final int DATA_BASE_VERSION = 1;

	private static final String DATA_BASE_NAME = "weatherManager";

	private static final String TABLE_WEATHER = "Weather";

	private static final String KEY_LAT = "Latitude";
	private static final String KEY_LONG = "Longitude";
	private static final String KEY_TIME = "Time";
	private static final String KEY_MAX_TEMP = "Max. Temp";
	private static final String KEY_MIN_TEMP = "Min. Temp";
	private static final String KEY_CHANCE_PREC = "Chance of Precipitation";

	public DatabaseHandler(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_WEATHER_TABLE = "Create table " + TABLE_WEATHER + "(Lat"
				+ KEY_LAT + " Long" + KEY_LONG + " Time " + KEY_TIME
				+ "MAX TEMP " + KEY_MAX_TEMP + "MINTEMP" + KEY_MIN_TEMP
				+ "Precip Chance" + KEY_CHANCE_PREC;
		db.execSQL(CREATE_WEATHER_TABLE);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("Upgrading..." + TABLE_WEATHER);
		onCreate(db);
	}

	public void addWeather(Weather weather){
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(KEY_LAT, weather.getLatitude());
		values.put(KEY_LONG, weather.getLongitude());
		values.put(KEY_TIME, weather.getTime());
		values.put(KEY_CHANCE_PREC, weather.getChanceOfPrecipi());
		values.put(KEY_MAX_TEMP, weather.getMaxTemp());
		values.put(KEY_MIN_TEMP, weather.getMinTemp());
		
		db.insert(TABLE_WEATHER, null, values);
		db.close();
	}
	
	public Weather getWeather(String time){
		SQLiteDatabase db = this.getWritableDatabase();
		
		return null;
		
	}
	
	public List<Weather> getAllWeather(){
		return null;
		
	}
}
