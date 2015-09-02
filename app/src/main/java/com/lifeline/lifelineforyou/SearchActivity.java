package com.lifeline.lifelineforyou;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import au.com.bytecode.opencsv.CSVReader;

public class SearchActivity extends Activity{
	

	    private ProgressDialog pDialog;
		private ListView lv;
		ArrayAdapter<String> adapter;
		SearchListAdapter adp;
		EditText inputSearch;
		ArrayList<HashMap<String, String>> productList;
		ArrayList<String> pidlist,prodlist;


    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		pidlist=new ArrayList<String>();
		prodlist=new ArrayList<String>();

		
//        String products[] = getResources().getStringArray(R.array.android);
		 
		 List<String[]> list = new ArrayList<String[]>();
			String next[] = {};
			try {
				InputStreamReader csvStreamReader = new InputStreamReader(
						SearchActivity.this.getAssets().open(
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
        	pidlist.add(list.get(i)[1]);
        	prodlist.add(list.get(i)[6]);
        }
//			Toast.makeText(SearchActivity.this,list.get(0)[1].toString(),Toast.LENGTH_LONG).show();
        lv = (ListView) findViewById(R.id.list_view);
        inputSearch = (EditText) findViewById(R.id.inputSearch);
        
       adp=new SearchListAdapter(SearchActivity.this, prodlist, pidlist);
//        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.product_name, prodlist);
        lv.setAdapter(adp);
        
        
        inputSearch.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
				// When user changed the Text
//				SearchActivity.this.adapter.getFilter().filter(cs);	
				SearchActivity.this.adp.getFilter().filter(cs);	
			}
			
			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub							
			}
		});
        lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				TextView tvpid=(TextView) view.findViewById(R.id.product_id);
				GetPrice gtp=new GetPrice();
				gtp.execute("http://lifelineforyou.com/fetch.php?f=price&pid="+tvpid.getText());
				
			}
		});
    }
	
	 /**
     * Async task class to get json by making HTTP call
     * */
    private class GetPrice extends AsyncTask<String, String, String> {
 
    	String product_id,product_name,price;
    	
    	String data=null;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(SearchActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();
 
        }
 
        @Override
        protected String doInBackground(String... arg0) {
            // Creating service handler class instance
            ServiceHandler sh = new ServiceHandler();
            String url=arg0[0];
            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url, ServiceHandler.GET);
           data=jsonStr;
            Log.d("Response: ", "> " + jsonStr);
 
            if (jsonStr != null) {
                try {
                		JSONObject jsonObj = new JSONObject(jsonStr);
                         product_id=jsonObj.getString("product_id");
                        product_name=jsonObj.getString("product_name");
                        price=jsonObj.getString("price");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Log.e("ServiceHandler", "Couldn't get any data from the url");
            }
 
            return null;

        }
 
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
//            Toast.makeText(SearchActivity.this,product_name,Toast.LENGTH_LONG).show();
            Intent i=new Intent(SearchActivity.this,AddToCartActivity.class);
            i.putExtra("add_to_cart_from", "SearchActivity");
            i.putExtra("product_name",product_name);
            i.putExtra("price",price);
            i.putExtra("pid",product_id);
            startActivity(i);
        }
 
    }

}
