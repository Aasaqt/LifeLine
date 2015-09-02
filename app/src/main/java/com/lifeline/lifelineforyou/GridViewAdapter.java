package com.lifeline.lifelineforyou;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridViewAdapter extends BaseAdapter {
	private Context context;
	private final String[] itemName;
 
	public GridViewAdapter(Context context, String[] itemName) {
		this.context = context;
		this.itemName = itemName;
	}
 
	public View getView(int position, View convertView, ViewGroup parent) {
 
		LayoutInflater inflater = (LayoutInflater) context
			.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
 
		View gridView;
 
		if (convertView == null) {
 
			gridView = new View(context);
 
			// get layout from home_gridview_item.xml
			gridView = inflater.inflate(R.layout.home_gridview_item, null);
 
			// set value into textview
			TextView textView = (TextView) gridView
					.findViewById(R.id.grid_item_label);
			textView.setText(itemName[position]);
 
			// set image based on selected text
			ImageView imageView = (ImageView) gridView
					.findViewById(R.id.grid_item_image);
 
			String mobile = itemName[position];
 
			if (mobile.equals("Stationary")) {
				imageView.setImageResource(R.drawable.icon_ststionary);
			}
			 else if (mobile.equals("General Store")) {
					imageView.setImageResource(R.drawable.icon_general_store);
				} else if (mobile.equals("Cosmetics")) {
					imageView.setImageResource(R.drawable.icon_cosmetics);
				} 
				else if (mobile.equals("  PU Sweets")) {
					imageView.setImageResource(R.drawable.icon_food);
				} else if (mobile.equals("     Food")) {
				imageView.setImageResource(R.drawable.icon_food);
			} else if (mobile.equals("  Medicine")) {
				imageView.setImageResource(R.drawable.icon_medicine);
			} 
			else if (mobile.equals("    Bakery")) {
				imageView.setImageResource(R.drawable.icon_bakery);
			} else if (mobile.equals("Recharge")) {
				imageView.setImageResource(R.drawable.icon_recharge);
			} 
			else if (mobile.equals("e-printout")) {
				imageView.setImageResource(R.drawable.icon_printouts);
			} else if (mobile.equals("Fruits")) {
				imageView.setImageResource(R.drawable.icon_fruits);
			} else {
				imageView.setImageResource(R.drawable.icon_ststionary);
			}
 
		} else {
			gridView = (View) convertView;
		}
 
		return gridView;
	}
 
	@Override
	public int getCount() {
		return itemName.length;
	}
 
	@Override
	public Object getItem(int position) {
		return null;
	}
 
	@Override
	public long getItemId(int position) {
		return 0;
	}
 
}
