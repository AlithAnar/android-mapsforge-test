package com.alithanar.gps;

import java.util.ArrayList;
import java.util.List;

import org.mapsforge.android.maps.overlay.ItemizedOverlay;
import org.mapsforge.android.maps.overlay.OverlayItem;
import org.osmdroid.views.overlay.ItemizedIconOverlay.OnItemGestureListener;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;

public class MyOverlay extends ItemizedOverlay<OverlayItem>{
	private static final int ARRAY_LIST_INITIAL_CAPACITY = 8;
	  private static final String THREAD_NAME = "ArrayItemizedOverlay";

	  private final Context context;
	  private AlertDialog.Builder dialog;
	  private OverlayItem item;
	  private final ArrayList<OverlayItem> overlayItems;
	  
	public MyOverlay(Drawable defaultMarker, Context context) {
		super(defaultMarker == null ? null : boundCenterBottom(defaultMarker));
	    this.context = context;
	    this.overlayItems = new ArrayList<OverlayItem>(ARRAY_LIST_INITIAL_CAPACITY);
	}

	@Override
	protected OverlayItem createItem(int arg0) {
		synchronized (this.overlayItems) {
		      return this.overlayItems.get(arg0);
		    }
	}

	
	public void addOverlay(OverlayItem overlayItem) {
	    synchronized (this.overlayItems) {
	      this.overlayItems.add(overlayItem);
	    }
	  }
	
	public void populateAll(){	
	populate();
	}
	
	@Override
	public int size() {
		synchronized (this.overlayItems) {
		      return this.overlayItems.size();
		    }
	}
	
	 @Override
	  protected boolean onTap(int index) {
	    synchronized (this.overlayItems) {
	      this.item = this.overlayItems.get(index);
	      this.dialog = new AlertDialog.Builder(this.context);
	      this.dialog.setTitle(this.item.getTitle());
	      this.dialog.setMessage(this.item.getSnippet());
	      this.dialog.show();
	      return true;
	    }
	  }

}
