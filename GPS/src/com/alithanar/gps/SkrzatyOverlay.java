/*package com.alithanar.gps;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapView;
import com.google.android.maps.OverlayItem;

public class SkrzatyOverlay extends ItemizedOverlay {

	private ArrayList<OverlayItem> mOverlays = new ArrayList<OverlayItem>();
	Context mContext;
	
	public SkrzatyOverlay(Drawable defaultMarker, Context context) {
		super(boundCenterBottom(defaultMarker));
		mContext = context; 
	}

	@Override
	protected OverlayItem createItem(int i) {
		 return mOverlays.get(i);
	}

	@Override
	public int size() {
		return mOverlays.size();
	}
	
	public void addOverlay(OverlayItem overlay) {
	    mOverlays.add(overlay);
	}
	
	public void populateAll()
	{
		populate();
	}
	@Override
	protected boolean onTap(int index) {
	  OverlayItem item = mOverlays.get(index);
	  AlertDialog.Builder dialog = new AlertDialog.Builder(mContext);
	  LayoutInflater factory = LayoutInflater.from(mContext);
	  final View view = factory.inflate(R.layout.skrzat_image, null);
	  dialog.setTitle(item.getTitle());
	  dialog.setView(view);
	  dialog.setMessage(item.getSnippet());
	  dialog.setNeutralButton("OK!", new DialogInterface.OnClickListener() {
		
		@Override
		public void onClick(DialogInterface dialog, int which) {
			// TODO Auto-generated method stub
			
		}
	});
	  dialog.show();
	  return true;
	}

}
*/