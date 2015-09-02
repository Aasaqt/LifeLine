package com.lifeline.lifelineforyou;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

public class SearchListAdapter extends BaseAdapter implements Filterable
{

    Context context;
    LayoutInflater inflater;
    ArrayList<String> originalprodlist,prodlist,originalpidlist,pidlist,tmppidlist;
    private ItemFilter mFilter = new ItemFilter();

    public SearchListAdapter(Context context1,ArrayList<String> prodlist,ArrayList<String> pidlist)
    {
        context = context1;
        this.originalprodlist=prodlist;
        this.prodlist=prodlist;
        this.pidlist=pidlist;
        this.originalpidlist=pidlist;
       
    }

    public int getCount()
    {
        return prodlist.size();
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
        View view1 = inflater.inflate(R.layout.list_item, viewgroup, false);
        TextView tvprod = (TextView)view1.findViewById(R.id.product_name);
        TextView tvpid = (TextView)view1.findViewById(R.id.product_id);
        tvprod.setText(prodlist.get(i));
        tvpid.setText(pidlist.get(i));

        return view1;
    }
    
    public Filter getFilter() {
		return mFilter;
	}
 
	private class ItemFilter extends Filter {
		@Override
		protected FilterResults performFiltering(CharSequence constraint) {
			
			String filterString = constraint.toString().toLowerCase();
			
			FilterResults results = new FilterResults();
			
			final List<String> list = originalprodlist;
			tmppidlist=new ArrayList<String>();
 
			int count = list.size();
			final ArrayList<String> nlist = new ArrayList<String>(count);
 
			String filterableString ;
			
			for (int i = 0; i < count; i++) {
				filterableString = list.get(i);
				if (filterableString.toLowerCase().contains(filterString)) {
					nlist.add(filterableString);
					tmppidlist.add(originalpidlist.get(i));
					
				}
			}
			
			results.values = nlist;
			results.count = nlist.size();
 
			return results;
		}
 
		@SuppressWarnings("unchecked")
		@Override
		protected void publishResults(CharSequence constraint, FilterResults results) {
			prodlist = (ArrayList<String>) results.values;
			pidlist=tmppidlist;
			notifyDataSetChanged();
		}
 
	}
}
