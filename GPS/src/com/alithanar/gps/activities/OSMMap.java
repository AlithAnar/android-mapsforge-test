package com.alithanar.gps.activities;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Toast;

import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.MyLocationOverlay;
import org.osmdroid.views.overlay.OverlayItem;
import org.osmdroid.views.overlay.ScaleBarOverlay;

import com.alithanar.gps.GPSTracker;
import com.alithanar.gps.OSMOverlay;
import com.alithanar.gps.R;
import com.alithanar.gps.SkrzatyKontener;
import com.alithanar.gps.R.drawable;
import com.alithanar.gps.R.id;
import com.alithanar.gps.R.layout;


public class OSMMap extends Activity{
	protected MapView mapView;
	private MapController myMapController;
	ArrayList<OverlayItem> anotherOverlayItemArray;
	MyLocationOverlay mlo;
	GPSTracker gps;
	double lat = 0;
	double lng = 0;
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.osm_layout);
		
		
		mapView = (MapView) findViewById(R.id.mapview2);
		mapView.setTileSource(TileSourceFactory.MAPNIK);
		mapView.setClickable(true);
		mapView.setBuiltInZoomControls(true);
		mapView.setMultiTouchControls(true);
		Drawable drawable = this.getResources().getDrawable(R.drawable.icon);
		myMapController = mapView.getController();
		OverlayItem myMarker;
		
		mlo = new MyLocationOverlay(this, mapView);
		gps = new GPSTracker(this);
		//myMapController.animateTo(mlo.getMyLocation());
		//refreshPosition();
		
		
		anotherOverlayItemArray = new ArrayList<OverlayItem>();
		SkrzatyKontener kontener = new SkrzatyKontener();
        for(int i=0; i<kontener.lat.length; i++){
        	lat = Double.parseDouble(kontener.lat[i]);
        	lng = Double.parseDouble(kontener.lon[i]);
        	myMarker = new OverlayItem(kontener.names[i], kontener.names[i], new GeoPoint((int) (lat * 1E6), (int) (lng * 1E6)));
        	myMarker.setMarker(drawable);
        	anotherOverlayItemArray.add(myMarker);
        }
	
        OSMOverlay anotherItemizedIconOverlay = new OSMOverlay(this, anotherOverlayItemArray);
        mapView.getOverlays().add(anotherItemizedIconOverlay);
        mapView.getOverlays().add(mlo);
        mapView.postInvalidate();
	}
	
	
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		mlo.disableMyLocation();
		mlo.disableCompass();
	}



	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		mlo.enableMyLocation();
		mlo.enableCompass();
	}

	public void refreshPosition(){
		if(gps.canGetLocation()){
			mlo.enableMyLocation();
        	lat = gps.getLatitude();
        	lng = gps.getLongitude();
        	mapView.getOverlays().add(mlo);
        	mapView.postInvalidate();
        	Toast.makeText(getApplicationContext(), "Tu jesteœ! " + lat + " " + lng, Toast.LENGTH_LONG).show();
        	myMapController.animateTo(new GeoPoint((int) (lat * 1E6), (int) (lng * 1E6)));
        }else{
        gps.showSettingsAlert();}
	
	}

	protected boolean isRouteDisplayed() {
        // TODO Auto-generated method stub
        return false;
    }

}
