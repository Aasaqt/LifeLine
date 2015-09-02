package com.lifeline.lifelineforyou;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class AddMoreMedActivity extends Activity {

	  private ListView myList;
	    private MyAdapter myAdapter;
	    ArrayList<String> med_qty=new ArrayList<String>();
		ArrayList<String> med_name=new ArrayList<String>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_more_med);
		  myList = (ListView) findViewById(R.id.MyList);
	        myList.setItemsCanFocus(true);
	        myAdapter = new MyAdapter();
	        myList.setAdapter(myAdapter);
	     
	 
	    }
	 
	    public class MyAdapter extends BaseAdapter {
	        private LayoutInflater mInflater;
	        public ArrayList myItems = new ArrayList();
	 
	        public MyAdapter() {
	            mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	            for (int i = 0; i < 15; i++) {
	                ListItem listItem = new ListItem();
	                listItem.caption = "Caption" + i;
	                myItems.add(listItem);
	            }
	            notifyDataSetChanged();
	        }
	 
	        public int getCount() {
	            return myItems.size();
	        }
	 
	        public Object getItem(int position) {
	            return position;
	        }
	 
	        public long getItemId(int position) {
	            return position;
	        }
	 
	        public View getView(int position, View convertView, ViewGroup parent) {
	            ViewHolder holder;
	            if (convertView == null) {
	                holder = new ViewHolder();
	                convertView = mInflater.inflate(R.layout.item, null);
	                holder.caption = (EditText) convertView
	                        .findViewById(R.id.etmedmore);
	                convertView.setTag(holder);
	            } else {
	                holder = (ViewHolder) convertView.getTag();
	            }
	            //Fill EditText with the value you have in data source
//	            holder.caption.setText(myItems.get(position).caption);
	            holder.caption.setId(position);
	 
	            //we need to update adapter once we finish with editing
	            holder.caption.setOnFocusChangeListener(new OnFocusChangeListener() {
	                public void onFocusChange(View v, boolean hasFocus) {
	                    if (!hasFocus){
	                        final int position = v.getId();
	                        final EditText Caption = (EditText) v;
//	                        myItems.get(position).caption = Caption.getText().toString();
	                    }
	                }
	            });
	 
	            return convertView;
	        }
	    }
	 
	    class ViewHolder {
	        EditText caption;
	    }
	 
	    class ListItem {
	        String caption;
	    }
	}