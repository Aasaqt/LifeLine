package com.lifeline.lifelineforyou;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import au.com.bytecode.opencsv.CSVReader;

public class GetProducts extends AsyncTask<String, String, String>{
	ProgressDialog pDialog;
	Context context;
	ArrayList<String> pidlist=new ArrayList<String>();
	ArrayList<String> prodlist=new ArrayList<String>();
	ArrayList<String> pricelist=new ArrayList<String>();
	
	public GetProducts(Context context)
	{
		this.context=context;
	}

	@Override
    protected void onPreExecute() {
        super.onPreExecute();
        // Showing progress dialog
        pDialog = new ProgressDialog(context);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.show();

    }
	@Override
	protected String doInBackground(String... params) {
		String subCat=params[0];
		String cat=params[1];
		String sub_subCat=params[2];
		List<String[]> list = new ArrayList<String[]>();
		String next[] = {};
		try {
			InputStreamReader csvStreamReader = new InputStreamReader(
					context.getAssets().open(
							"result.csv"));

			CSVReader reader = new CSVReader(csvStreamReader);
			for (;;) {
				next = reader.readNext();
				if (next != null) {
					list.add(next);
				} else {
					break;
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		 for(int i=1;i<list.size();i++)
	        {
			 
			 
			    if(list.get(i)[3].toString().equalsIgnoreCase(subCat) && list.get(i)[2].toString().equalsIgnoreCase(cat)&&list.get(i)[4].toString().equalsIgnoreCase(sub_subCat))
			    {
	        	pidlist.add(list.get(i)[1]);
	        	prodlist.add(list.get(i)[6]);
	        	pricelist.add(list.get(i)[7]);
			    }
	        }
		
		 return null;
	}
	
	  @Override
      protected void onPostExecute(String result) {
          super.onPostExecute(result);
          // Dismiss the progress dialog
          if (pDialog.isShowing())
              pDialog.dismiss();
//          Toast.makeText(SearchActivity.this,product_name,Toast.LENGTH_LONG).show();
          Intent i=new Intent(context,AddToCartActivity.class);
            i.putExtra("add_to_cart_from","normal");
	    	i.putExtra("ProductList",prodlist);
	    	i.putExtra("PIDList", pidlist);
			i.putExtra("PriceList", pricelist);
			context.startActivity(i);
      }

}
