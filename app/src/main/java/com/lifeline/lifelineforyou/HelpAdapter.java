package com.lifeline.lifelineforyou;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class HelpAdapter extends BaseAdapter {
	 
    // Declare Variables
    Context context;
    String[] text;
    String[] subtext;
    LayoutInflater inflater;
 
    public HelpAdapter(Context context, String[] text, String[] subtext) {
        this.context = context;
       this.text=text;
       this.subtext=subtext;
    }
 
    @Override
    public int getCount() {
        return text.length;
    }
 
    @Override
    public Object getItem(int position) {
        return null;
    }
 
    @Override
    public long getItemId(int position) {
        return 0;
    }
 
    public View getView(int position, View convertView, ViewGroup parent) {
 
        // Declare Variables
        TextView txt,subtxt;
       
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
 
        View itemView = inflater.inflate(R.layout.help_row, parent, false);
 
        // Locate the TextViews in listview_item.xml
        txt = (TextView) itemView.findViewById(R.id.text);
        subtxt = (TextView) itemView.findViewById(R.id.subtext);
 
        // Capture position and set to the TextViews
        txt.setText(text[position]);
        subtxt.setText(subtext[position]);
 
        return itemView;
    }
}
