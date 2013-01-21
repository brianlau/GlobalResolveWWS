package com.example.globalresovlewws;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button btnDockedMode = (Button) findViewById(R.id.button1);
		
		btnDockedMode.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent dockedScreen = new Intent(getApplicationContext(), secondScreenActivity.class );
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
