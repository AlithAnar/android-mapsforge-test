package com.alithanar.gps.activities;
/*package com.alithanar.gps;

import java.util.List;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import com.google.android.maps.MapController;
public class MyMap extends MapActivity {
	GPSTracker gps;
	double lat;
	double lng;
	 MapController mc;
	 GeoPoint p;
	 MyLocationOverlay mlo;
	 List<Overlay> mapOverlays;
	 MapView mapView;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_layout);
        mapView = (MapView) findViewById(R.id.mapview);
        mapView.setBuiltInZoomControls(true);

        mc = mapView.getController();
        
   	    List<Overlay> mapOverlays = mapView.getOverlays();
        Drawable drawable = this.getResources().getDrawable(R.drawable.icon);
        SkrzatyOverlay so = new SkrzatyOverlay(drawable, this);
        mlo = new MyLocationOverlay(this, mapView);
        
        lat = Double.parseDouble("51.107495");
        lng = Double.parseDouble("17.032550");
        p = new GeoPoint((int) (lat * 1E6), (int) (lng * 1E6));
        
        gps = new GPSTracker(this);
        refreshPosition();
        
        SkrzatyKontener kontener = new SkrzatyKontener();
        OverlayItem oItem;
        for(int i=0; i<kontener.lat.length; i++){
        	lat = Double.parseDouble(kontener.lat[i]);
        	lng = Double.parseDouble(kontener.lon[i]);
        	p = new GeoPoint((int) (lat * 1E6), (int) (lng * 1E6));
        oItem = new OverlayItem(p, kontener.names[i], kontener.lat[i]);
        so.addOverlay(oItem);
        }
        so.populateAll();
        mapOverlays.add(so);
        mc.setZoom(5);
        mapView.invalidate();
       
    }
	
	public void refreshPosition(){
		if(gps.canGetLocation()){
			mlo.enableMyLocation();
        	lat = gps.getLatitude();
        	lng = gps.getLongitude();
        	p = new GeoPoint((int) (lat * 1E6), (int) (lng * 1E6));
        	mapView.getOverlays().add(mlo);
        	mapView.postInvalidate();
        	Toast.makeText(getApplicationContext(), "Tu jesteœ! " + lat + " " + lng, Toast.LENGTH_LONG).show();
            mc.animateTo(p);
        }else{
        gps.showSettingsAlert();}
	
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.map_layout, menu);
        return true;
    }
	
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
	    case R.id.menu1:
	    	refreshPosition();
	    return true;
	    default:
	    return super.onOptionsItemSelected(item);
	}
	}
	
	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}


}
*/