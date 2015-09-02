package com.lifeline.lifelineforyou;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListViewAdapter extends BaseAdapter
{

    Context context;
    LayoutInflater inflater;
    String text[];

    public ListViewAdapter(Context context1, String as[])
    {
        context = context1;
        text = as;
       
    }

    public int getCount()
    {
        return text.length;
    }

    public Object getItem(int i)
    {
        return null;
    }

    public long getItemId(int i)
    {
        return 0L;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        inflater = (LayoutInflater)context.getSystemService("layout_inflater");
        View view1 = inflater.inflate(R.layout.list_row, viewgroup, false);
        TextView textview = (TextView)view1.findViewById(R.id.textView1);
        textview.setText(text[i]);

        return view1;
    }
}
