package com.example.globalresovlewws;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Handler;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final SimulateData sim = new SimulateData();	
		final int []imageArray={R.drawable.sunny_icon,R.drawable.night_rain};

		final TextView textView = (TextView) findViewById(R.id.temp_curr);	
		final ImageView imageView = (ImageView) findViewById(R.id.imageView);
		final Handler handler = new Handler();
		         Runnable runnable = new Runnable() {
		        	 int i;
		            public void run() {
		               sim.TemperatureForecast();
		               if(sim.CurrentTemperature() <= 30){
		            	   i=1;
		               }
		               else if(sim.CurrentTemperature() > 30){
		            	   i=0;
		               }
		               imageView.setImageResource(imageArray[i]);
		               textView.setText(Integer.toString(sim.CurrentTemperature()) + "F");
		                handler.postDelayed(this, 5000);  //for interval...
		            }
		        };
		        handler.postDelayed(runnable, 2000); //for initial delay..
		Button btnDockedMode = (Button) findViewById(R.id.button1);
		
		btnDockedMode.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
					Intent dockedScreen = new Intent(getApplicationContext(), SecondScreen.class );
					startActivity(dockedScreen);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
