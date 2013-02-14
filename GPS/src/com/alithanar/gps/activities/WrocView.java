package com.alithanar.gps.activities;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;

import org.mapsforge.android.maps.MapActivity;
import org.mapsforge.android.maps.MapView;
import org.mapsforge.android.maps.overlay.ArrayItemizedOverlay;
import org.mapsforge.android.maps.overlay.ItemizedOverlay;
import org.mapsforge.android.maps.overlay.OverlayItem;
import org.mapsforge.core.GeoPoint;

import com.alithanar.gps.MyOverlay;
import com.alithanar.gps.R;
import com.alithanar.gps.SkrzatyKontener;

import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class WrocView extends MapActivity{
	ArrayList<OverlayItem> anotherOverlayItemArray;
	double lat = 0;
	double lng = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.wroc_layout);
		MapView mapView = (MapView)findViewById(R.id.mapview3);
		mapView.setClickable(true);
		mapView.setBuiltInZoomControls(true);
		
		AssetManager am = getAssets();
		
		try{
			File dir = new File(Environment.getExternalStorageDirectory() + "/skrzatoid/");
			
			if(!dir.exists()){
				dir.mkdir();
			}
			
			String fileName = "wroclaw.map";
			File destinationFile = new File(Environment.getExternalStorageDirectory() + "/skrzatoid/" + fileName);
			
			if(!destinationFile.exists()){
				InputStream in = am.open("wroclaw.map");
				FileOutputStream f = new FileOutputStream(destinationFile);
				byte[] buffer = new byte[1024];
				
				int len1 = 0;
				
				while((len1 = in.read(buffer))>0){
					f.write(buffer, 0, len1);
				}
				
				f.close();
			}
		} catch (Exception e) { String err = (e.getMessage()==null)?"SD Card failed":e.getMessage();
		Log.e("sdcard-err2:",err);  
		}
		
		String filepath = Environment.getExternalStorageDirectory().getPath() + "/skrzatoid/wroclaw.map";
		mapView.setMapFile(new File(filepath));
		
		Drawable drawable = this.getResources().getDrawable(R.drawable.icon);
		
		//ArrayItemizedOverlay itemizedOverlay = new ArrayItemizedOverlay(drawable);
		MyOverlay itemizedOverlay = new MyOverlay(drawable, this);
		OverlayItem myMarker;
		SkrzatyKontener kontener = new SkrzatyKontener();
        for(int i=0; i<kontener.lat.length; i++){
        	lat = Double.parseDouble(kontener.lat[i]);
        	lng = Double.parseDouble(kontener.lon[i]);
            myMarker = new OverlayItem();
        	myMarker.setTitle(kontener.names[i]);
        	myMarker.setPoint(new GeoPoint((int) (lat * 1E6), (int) (lng * 1E6)));
        	myMarker.setMarker(drawable);
        	itemizedOverlay.addOverlay(myMarker);
        }
        itemizedOverlay.populateAll();
        mapView.getOverlays().add(itemizedOverlay);
        mapView.postInvalidate();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.wroc_layout, menu);
        return true;
	}
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		switch (item.getItemId()) {
	    case R.id.mapMenu1:
	    return true;
	    case R.id.mapMenu2:
	    finish();
	    System.exit(0);
	    android.os.Process.killProcess(android.os.Process.myPid());
	    
	    default:
	    return super.onOptionsItemSelected(item);
	}
	}



}
