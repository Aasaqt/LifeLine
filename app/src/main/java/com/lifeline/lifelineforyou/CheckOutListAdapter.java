package com.lifeline.lifelineforyou;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CheckOutListAdapter extends BaseAdapter
{

    Context context;
    LayoutInflater inflater;
    ArrayList<String> itemName;
    ArrayList<String> itemPrice;
    ArrayList<String> itemQuant;
    ArrayList<String> itemid;
    ArrayList<String> itemtotalprice;

    public CheckOutListAdapter(Context context1, ArrayList<String> itemName,ArrayList<String> itemPrice,ArrayList<String> itemQuant,ArrayList<String> itemid,ArrayList<String> itemtotalprice)
    {
        context = context1;
        this.itemName=itemName;
        this.itemPrice=itemPrice;
        this.itemQuant=itemQuant;
        this.itemid=itemid;
        this.itemtotalprice=itemtotalprice;
       
    }

    public int getCount()
    {
        return itemName.size();
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
        View view1 = inflater.inflate(R.layout.checkoutlistrow, viewgroup, false);
        TextView tvitemName = (TextView)view1.findViewById(R.id.tvItemName);
        TextView tvitemPrice = (TextView)view1.findViewById(R.id.tvItemPrice);
        TextView tvitemid = (TextView)view1.findViewById(R.id.tvItemid);
        TextView tvitemQuant=(TextView)view1.findViewById(R.id.tvQuantItemcart);
        tvitemName.setText(itemName.get(i));
        tvitemPrice.setText(itemtotalprice.get(i));
        tvitemid.setText(itemid.get(i));
        tvitemQuant.setText(itemQuant.get(i).toString());

        return view1;
    }
}
