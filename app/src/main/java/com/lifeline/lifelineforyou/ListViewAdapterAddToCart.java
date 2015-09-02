package com.lifeline.lifelineforyou;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lifeline.lifelineforyou.dboperation.DBCart;
import com.lifeline.lifelineforyou.dboperation.DBCartBean;

public class ListViewAdapterAddToCart extends BaseAdapter implements OnClickListener{
	
	Context context;
    LayoutInflater inflater;
    ArrayList<String> textlist,pricelist,pidlist;
  
    private final boolean[] mHighlightedPositions ;


	public ListViewAdapterAddToCart(Context context1,  ArrayList<String> textlist,ArrayList<String> pricelist,ArrayList<String> pidlist)
	{
		context = context1;
        this.textlist=textlist;
        this.pricelist=pricelist;
        this.pidlist=pidlist;
        mHighlightedPositions=new boolean[textlist.size()];
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return textlist.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0L;
	}

	@Override
	public View getView(final int position, final View convertView, ViewGroup parent) {
		 inflater = (LayoutInflater)context.getSystemService("layout_inflater");
	        View view1 = inflater.inflate(R.layout.pricemenu_list_row, parent, false);
	        final TextView textview = (TextView)view1.findViewById(R.id.itemtxt);
	        final TextView tvprice=(TextView)view1.findViewById(R.id.tvcartprice);
	        final TextView tvpid=(TextView)view1.findViewById(R.id.tvcartpid);
	        final ImageView ivcart=(ImageView) view1.findViewById(R.id.ivcartpress);
	        ivcart.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					
				  
				    if(mHighlightedPositions[position]) {
				        ivcart.setImageResource(R.drawable.btn_addtocart_normal);
				        DBCart dbc=new DBCart(context);
				        dbc.Delete_CartRow(tvpid.getText().toString());
				        mHighlightedPositions[position] = false;
				    }else {
				        ivcart.setImageResource(R.drawable.btn_addtocart_pressed);
				        DBCart dbc=new DBCart(context);
					       
				        DBCartBean dbcbean=new DBCartBean(textview.getText().toString(),tvpid.getText().toString(),"1",tvprice.getText().toString(),tvprice.getText().toString());
						dbc.addHistory(dbcbean);

				        mHighlightedPositions[position] = true;
				    }
					
				}
			});
	        textview.setText(textlist.get(position));
	        tvprice.setText(pricelist.get(position));
	        tvpid.setText(pidlist.get(position));
	        if(mHighlightedPositions[position]) {
	            ivcart.setImageResource(R.drawable.btn_addtocart_pressed);
	        }else {
	        	ivcart.setImageResource(R.drawable.btn_addtocart_normal);
	        }
	        
	        return view1;
	        

	}
	
	@Override
	public void onClick(View view) {
	    int position = (Integer)view.getTag();
	  
	    // Toggle background resource
	    RelativeLayout layout = (RelativeLayout)view.getParent();
	   ImageView iv = (ImageView)layout.getChildAt(0);
	    if(mHighlightedPositions[position]) {
	        iv.setImageResource(R.drawable.btn_addtocart_normal);
	        mHighlightedPositions[position] = false;
	    }else {
	        iv.setImageResource(R.drawable.btn_addtocart_pressed);
	        mHighlightedPositions[position] = true;
	    }
	}

}
