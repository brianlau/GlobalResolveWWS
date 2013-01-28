package com.example.globalresovlewws;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class SecondScreen extends Activity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second_screen);

	Button btnBack = (Button) findViewById(R.id.buttonBack);
	
	btnBack.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent deployedScreen = new Intent(getApplicationContext(), MainActivity.class );

			startActivity(deployedScreen);
			finish();
		}
	});
}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_second_screen, menu);
		return true;
	}

}
