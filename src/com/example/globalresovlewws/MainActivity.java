package com.example.globalresovlewws;

import java.io.IOException;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Handler;

public class MainActivity extends Activity {
	MediaPlayer mp = new MediaPlayer();
	AssetFileDescriptor siren;
	boolean flag = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		final SimulateData sim = new SimulateData();
		final int[] imageArray = { R.drawable.sunny_icon, R.drawable.night_rain };

		siren = getResources().openRawResourceFd(R.raw.siren);

		final TextView textView = (TextView) findViewById(R.id.temp_curr);
		final ImageView imageView = (ImageView) findViewById(R.id.imageView);
		final Handler handler = new Handler();
	
		final Runnable runnable = new Runnable() {
			int i = 0;

			public void run() {
				sim.TemperatureForecast(); // run dummyTemp
				try {
					mp.setDataSource(siren.getFileDescriptor(),
							siren.getStartOffset(), siren.getLength());
					mp.prepare();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (sim.CurrentTemperature() <= 30) { // sets to rain
					i = 1;
					mp.start();

				} else if (sim.CurrentTemperature() > 30) { // sets to sun
					i = 0;
					if (mp != null && mp.isPlaying()) {
						mp.stop();
						mp.reset();
					}
				}
				imageView.setImageResource(imageArray[i]); // sets image
				textView.setText(Integer.toString(sim.CurrentTemperature())
						+ "F"); // sets temp
				handler.postDelayed(this, 5000); // for interval 5 sec delay
													// before switching
			}
		};
		handler.postDelayed(runnable, 2000); // for initial delay..
		Button btnDockedMode = (Button) findViewById(R.id.button1);

		btnDockedMode.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent dockedScreen = new Intent(getApplicationContext(),
						SecondScreen.class);
				startActivity(dockedScreen);
				handler.removeCallbacks(runnable);
				finish();
			}}
		);}

	@Override 
	public void onPause(){
	    super.onPause();
	    if(mp != null){
	    	mp.release();
	    }

	}

	@Override
	public void onResume(){
		super.onResume();
		if(mp == null)
			initializeMediaPlayer();
	}
	private void initializeMediaPlayer() {
		mp = new MediaPlayer();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
