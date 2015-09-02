package com.lifeline.lifelineforyou;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class HistoryListAdapter extends BaseAdapter{
	
	Context context;
    LayoutInflater inflater;
    ArrayList orderNo;
    ArrayList<String> totalAmount;
    ArrayList<String> date;
    

    public HistoryListAdapter(Context context1,ArrayList orderNo,ArrayList<String> totalAmount,ArrayList<String> date)
	{
		context = context1;
		this.orderNo=orderNo;
		this.totalAmount=totalAmount;
		this.date=date;
		
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return orderNo.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		 inflater = (LayoutInflater)context.getSystemService("layout_inflater");
	        View view1 = inflater.inflate(R.layout.history_list_row, parent, false);
	        TextView tvorderNo = (TextView)view1.findViewById(R.id.tvorderno);
	        TextView tvdate = (TextView)view1.findViewById(R.id.tvdate);
	        TextView tvamount = (TextView)view1.findViewById(R.id.tvamount);
	        tvorderNo.setText(String.valueOf(orderNo.get(position)));
	        tvdate.setText(date.get(position));
	        tvamount.setText(totalAmount.get(position));

	        return view1;
	}

}
