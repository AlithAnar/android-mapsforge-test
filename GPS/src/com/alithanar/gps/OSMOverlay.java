package com.alithanar.gps;

import java.util.List;

import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.OverlayItem;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;

public class OSMOverlay extends ItemizedIconOverlay<OverlayItem> {
	protected Context mContext;
	
	
	public OSMOverlay(final Context context, final List<OverlayItem> aList) {
		super(context, aList, new OnItemGestureListener<OverlayItem>() {
            @Override public boolean onItemSingleTapUp(final int index, final OverlayItem item) {
                return false;
        }
        @Override public boolean onItemLongPress(final int index, final OverlayItem item) {
                return false;
        }
      } );

		mContext = context;
	}


	@Override
	protected boolean onSingleTapUpHelper(int index, OverlayItem item,
			MapView mapView) {
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
