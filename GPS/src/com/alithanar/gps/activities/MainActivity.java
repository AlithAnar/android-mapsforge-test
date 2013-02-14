package com.alithanar.gps.activities;

import com.alithanar.gps.R;
import com.alithanar.gps.R.layout;
import com.alithanar.gps.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        Thread logoTimer = new Thread(){
        	public void run(){
        		try {
        			int logoTimer = 0;
        			while(logoTimer < 2000){
        				sleep(100);
        				logoTimer = logoTimer+100;
        			}
        			startActivity(new Intent("com.alithanar.gps.CLEARSCREEN"));
        		} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		
        		finally{
        			finish();
        		}
        	}
        };
        logoTimer.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	@Override
	protected void onDestroy() {
		super.onDestroy();
	    //android.os.Process.killProcess(android.os.Process.myPid());
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}
    
    
    
}
