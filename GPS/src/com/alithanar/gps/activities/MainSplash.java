package com.alithanar.gps.activities;

import com.alithanar.gps.R;
import com.alithanar.gps.R.id;
import com.alithanar.gps.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainSplash extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		/*Button btn1 = (Button) findViewById(R.id.mapButton);
		btn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//startActivity(new Intent("com.alithanar.gps.activities.OSM"));
			}
		});
		
		*/
		Button btn2 = (Button) findViewById(R.id.mapButton2);
		btn2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				startActivity(new Intent("com.alithanar.gps.activities.OSMWROC"));
			}
		});
		
		/*Button btn3 = (Button) findViewById(R.id.mapButton3);
		btn2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent("com.alithanar.gps.activities.OSMWROC"));
			}
		});*/
	}

}
