package com.lifeline.lifelineforyou;

import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;
import au.com.bytecode.opencsv.CSVReader;

import com.lifeline.lifelineforyou.dboperation.DBCart;
import com.lifeline.lifelineforyou.dboperation.DBCartBean;

public class CheckOutActivity extends Activity implements NumberPicker.OnValueChangeListener{
	
	ArrayList<String> itemName=new ArrayList<String>();
	ArrayList<String> itemPrice=new ArrayList<String>();
	ArrayList<String> itemQuant=new ArrayList<String>();
	ArrayList<String> itemid=new ArrayList<String>();
	ArrayList<String> itemCat=new ArrayList<String>();
	ArrayList<String> itemtotalprice=new ArrayList<String>();
	String finalAmount=null;
    AlertDialog dia;
    //NumberPicker np;
    //int quant;
    @Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_checkout);
		ActionBar ab=getActionBar();
        //ab.setTitle("My Cart");
		ab.setHomeButtonEnabled(true);
		ab.setDisplayHomeAsUpEnabled(true);

        Button btnNext=(Button) findViewById(R.id.btnCheckOutNext);
		btnNext.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
//				GetProductCat gtpc=new GetProductCat(CheckOutActivity.this,itemid);
//				gtpc.execute();
//				
				Intent i=new Intent(CheckOutActivity.this,FinalDetailsPage.class);
				i.putExtra("Request","from checkout");
				i.putExtra("product_id", itemid);
				i.putExtra("qty", itemQuant);
				i.putExtra("total", finalAmount);
				startActivity(i);
				
			}
		});
		load_cart();
		
		
	}
	
	private void load_cart()
	{
		final DBCart dbc=new DBCart(CheckOutActivity.this);
		final ArrayList<DBCartBean> dblist=dbc.Get_History();
		if(dblist.size()>0)
		{
		itemName.clear();
		itemPrice.clear();
		itemid.clear();
		itemQuant.clear();
		itemCat.clear();
		itemtotalprice.clear();
		
		ListView lvCheckout=(ListView)findViewById(R.id.lvcheckoutlist);
		for(int i=0;i<dblist.size();i++)
		{
			itemName.add(dblist.get(i).getProdName());
			itemPrice.add(dblist.get(i).getProdPrice());
			itemQuant.add(dblist.get(i).getProdQt());
			itemid.add(dblist.get(i).getProdId());
			itemtotalprice.add(dblist.get(i).getProdtotalprice());
		}
		total_amount();
		CheckOutListAdapter adp=new CheckOutListAdapter(CheckOutActivity.this, itemName, itemPrice,itemQuant,itemid,itemtotalprice)
		{
			ImageView delete;
			Button txitemquant;
			
			

			@Override
			public View getView(final int i, View view, ViewGroup viewgroup) {
				final View v = super.getView(i,view,viewgroup);
				delete=(ImageView) v.findViewById(R.id.ivcartdel);
				txitemquant=(Button) v.findViewById(R.id.tvQuantItemcart);
				delete.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						dbc.Delete_CartRow(itemid.get(i));
						reload_cart();
											
					}
				});
				txitemquant.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						final Dialog d = new Dialog(CheckOutActivity.this);
				         d.setTitle("Select Quantity");
				         d.setContentView(R.layout.number_picker);
				         Button b1 = (Button) d.findViewById(R.id.btnset);
				         Button b2 = (Button) d.findViewById(R.id.btncancel);
				         final NumberPicker np = (NumberPicker) d.findViewById(R.id.numberPickercart);
				         np.setMaxValue(100);
				         np.setMinValue(1);
				         np.setWrapSelectorWheel(false);
				         np.setOnValueChangedListener(CheckOutActivity.this);
				         b1.setOnClickListener(new OnClickListener()
				         {
				          @Override
				          public void onClick(View v) {
				        	
				        	dbc.Delete_CartRow(itemid.get(i));
							int quant=np.getValue();
							int price=Integer.parseInt(itemPrice.get(i).toString());
//							Toast.makeText(CheckOutActivity.this, String.valueOf(np.getValue()*Integer.parseInt(itemPrice.get(i).toString())), Toast.LENGTH_LONG).show();
							DBCartBean dbcbean=new DBCartBean(itemName.get(i),itemid.get(i),String.valueOf(np.getValue()),itemPrice.get(i),String.valueOf((price*quant)));
							dbc.addHistory(dbcbean);				
				            d.dismiss();
				            reload_cart();
				           }    
				          });
				         b2.setOnClickListener(new OnClickListener()
				         {
				          @Override
				          public void onClick(View v) {
				              d.dismiss();
				           }    
				          });
				       d.show();
						
					}
				});

				
				return v;
			}
			
		};
		lvCheckout.setAdapter(adp);
		}
		else
		{
			Toast.makeText(CheckOutActivity.this, "No item in the cart", Toast.LENGTH_LONG).show();
			finish();
		}
	}
	private void reload_cart()
	{
		load_cart();
	}

	public void total_amount()
	{
		
		CalculateServiceCharge calob=new CalculateServiceCharge(CheckOutActivity.this, itemid);
		calob.execute("hello");
		
		
	}
	 @Override
	    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

	         Log.i("value is",""+newVal);

	     }
	 //for action bar option
	 @Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
//			getMenuInflater().inflate(R.menu.main, menu);
			return true;
		}
		@Override
		public boolean onOptionsItemSelected(MenuItem item) {
			
	
			 if(item.getItemId()==android.R.id.home)
			 {
	            Intent homeIntent = new Intent(this, MainActivity.class);
	            homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	            startActivity(homeIntent);
			 }
			 else if(item.getItemId()==R.id.action_cart)
			{
				Intent i=new Intent(CheckOutActivity.this,CheckOutActivity.class);
				startActivity(i);
			}
			else if(item.getItemId()==R.id.action_hisotry)
			{
				Intent i=new Intent(CheckOutActivity.this,HistoryActivity.class);
				startActivity(i);
			}
			else if(item.getItemId()==R.id.action_offers)
			{
				Intent i=new Intent(CheckOutActivity.this,OfferActivity.class);
				startActivity(i);
			}
			else if(item.getItemId()==R.id.action_orderbycall)
			{
				Intent callIntent = new Intent(Intent.ACTION_CALL);
				 callIntent.setData(Uri.parse("tel:07307123123"));
				 startActivity(callIntent);
			}
			else if(item.getItemId()==R.id.action_contact)
			{
				AlertDialog dia;
				AlertDialog.Builder adb = new AlertDialog.Builder(CheckOutActivity.this);
			    adb.setTitle("Contact Us");
			    adb.setMessage("Contact us for any help on +91-7307123123"+"\n" +"or"+"\n"+"Email us on info@lifeline.com");
			    adb.setIcon(R.drawable.logo_actionbar);
			    adb.setPositiveButton("Ok",
				    new AlertDialog.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog,
						int which) {
						

					}
					
				    });
			    dia = adb.create();
	            dia.show();
			}
			else if(item.getItemId()==R.id.action_feedback)
			{
				
				String url = "https://docs.google.com/forms/d/1wQFw5hRGnpC2YJ5Ab0D8YFIcbhdO90xdyphonHb79VA/viewform";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);
			}
             else if(item.getItemId()==R.id.action_about)
             {
                 Intent i= new Intent(CheckOutActivity.this,HelpActivity.class);
                 startActivity(i);
             }
             else if(item.getItemId()==R.id.action_servicecharge)
             {
                 Intent i= new Intent(CheckOutActivity.this,ServiceCharge.class);
                 startActivity(i);
             }
			else if(item.getItemId()==R.id.action_search)
			{
				Intent i=new Intent(CheckOutActivity.this,SearchActivity.class);
				startActivity(i);
			}
			return super.onOptionsItemSelected(item);
		}
	 //action bar end
		
		public class CalculateServiceCharge extends AsyncTask<String, String, String>{
			ProgressDialog pDialog;
			Context context;
			String cat=null;
			ArrayList<String> product_id_list=new ArrayList<String>();
			ArrayList<String> cat_list;
			
			public CalculateServiceCharge(Context context,ArrayList<String> product_id_list)
			{
				this.context=context;
				this.product_id_list=product_id_list;
				cat_list=new ArrayList<String>();
			}

			@Override
		    protected void onPreExecute() {
		        super.onPreExecute();
		        // Showing progress dialog
		        pDialog = new ProgressDialog(context);
		        pDialog.setMessage("Preparing your cart...");
		        pDialog.setCancelable(false);
		        pDialog.show();


		    }
			
			@Override
			protected String doInBackground(String... params) {
				
			
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
				
				 
					 
					 	for(int j=0;j<product_id_list.size();j++)
					 	{
					 		
					 		for(int i=1;i<list.size();i++)
					        {
					 		//quant = np.getValue();
					 		if(list.get(i)[1].toString().equalsIgnoreCase(product_id_list.get(j)))
						    {
					 			//Toast.makeText(CheckOutActivity.this,String.valueOf(quant),Toast.LENGTH_LONG).show();
						    	cat_list.add(list.get(i)[2].toString());
						    }
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
		          String itemforservicecharge[]=getResources().getStringArray(R.array.service_charge);
		          HashMap<String,Integer> hmobj=new HashMap<String, Integer>(); 
		          ArrayList<Integer> itemfreq=new ArrayList<Integer>();
		   
		         for(int i=0;i<itemforservicecharge.length;i++)
		         {
		          itemfreq.add(Collections.frequency(cat_list,itemforservicecharge[i]));
		          hmobj.put(itemforservicecharge[i],Collections.frequency(cat_list,itemforservicecharge[i]) );
		         }
		         int flag=0,itemindex = 0;
		         int stax=0;
                         //String shopopen=null,shopclose=null;
		         for(int i=0;i<itemfreq.size();i++)
		         {
		        	 if(itemfreq.get(i)>0 )
		        	 {
		        		 
		        		 if(flag==1)
		        		 {
		        			 stax=30;
		        			 break;
		        		 }
		        		 else if(flag==0)
		        		 {
		        		  flag=1;
		        		  itemindex=i;
		        		 stax= Integer.parseInt(getResources().getStringArray(R.array.service_charge_price)[itemindex]);
                             /*shopopen= getResources().getStringArray(R.array.shop_open)[itemindex];
                             shopclose= getResources().getStringArray(R.array.shop_close)[itemindex];
                             AlertDialog.Builder adb = new AlertDialog.Builder(CheckOutActivity.this);
                             adb.setTitle("Attention");
                             adb.setMessage("Timing for delivery of this item is "+shopopen+" to "+shopclose);
                             adb.setIcon(R.drawable.logo_actionbar);
                             adb.setPositiveButton("Ok",
                                     new AlertDialog.OnClickListener() {
                                         @Override
                                         public void onClick(DialogInterface dialog,
                                                             int which) {

                                         }

                                     });
                             dia = adb.create();
                             dia.show();*/
		        		 }
		        	 }
		         }
		        int totalAmount=0,netAmount=0;
		        TextView tvtotalamount=(TextView)findViewById(R.id.tvCheckOutTotalAmount);
		 		TextView tvservicecharge=(TextView)findViewById(R.id.tvServiceChargeValue);
		 		TextView tvnetamount=(TextView)findViewById(R.id.tvNetAmountValue);
		 		for(int i=0;i<itemtotalprice.size();i++)
		 		{
		 			totalAmount=totalAmount+Integer.parseInt(itemtotalprice.get(i));
		 			
		 		}
		 		tvtotalamount.setText(String.valueOf(totalAmount));
		 		tvservicecharge.setText(String.valueOf(stax));
		 		tvnetamount.setText(String.valueOf(totalAmount+stax));
		        finalAmount=String.valueOf(totalAmount+stax);
		      }


		}
		public class GetProductCat extends AsyncTask<String, String, String>{
			ProgressDialog pDialog;
			Context context;
			String cat=null;
			ArrayList<String> product_id_list=new ArrayList<String>();
			ArrayList<String> cat_list;
			public GetProductCat(Context context,ArrayList<String> product_id_list)
			{
				this.context=context;
				this.product_id_list=product_id_list;
				cat_list=new ArrayList<String>();
			}

			@Override
		    protected void onPreExecute() {
		        super.onPreExecute();
		        // Showing progress dialog
		        pDialog = new ProgressDialog(context);
		        pDialog.setMessage("Preparing your cart...");
		        pDialog.setCancelable(false);
                pDialog.show();


		    }
			
			@Override
			protected String doInBackground(String... params) {
				
			
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
				
					 		
				for(int j=0;j<product_id_list.size();j++)
			 	{
			 		
			 		for(int i=1;i<list.size();i++)
			        {
			 			
			 		if(list.get(i)[1].toString().equalsIgnoreCase(product_id_list.get(j)))
				    {
			 			
				    	itemCat.add(list.get(i)[2].toString());
				    }
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


		          compareDates();
		      	
		    	
		       
		      }
			  public static final String inputFormat = "HH:mm";

			  private Date date;
			  private Date dateCompareOne;
			  private Date dateCompareTwo;

			  private String compareStringOne = "9:45";
			  private String compareStringTwo = "17:45";

			  SimpleDateFormat inputParser = new SimpleDateFormat("HH:mm:ss");

			  private void compareDates(){
			      Calendar now = Calendar.getInstance();

			      int hour = now.get(Calendar.HOUR);
			      int minute = now.get(Calendar.MINUTE);

			      date = parseDate(hour + ":" + minute);
			      dateCompareOne = parseDate(compareStringOne);
			      dateCompareTwo = parseDate(compareStringTwo);

			      if ( dateCompareOne.before( date ) ) {
//			         Toast.makeText(CheckOutActivity.this,"if", Toast.LENGTH_LONG).show();
			      }
			      else {
			    	  Date CurrentTime;
					try {
						CurrentTime = inputParser.parse(inputParser.format(new Date()));
//						Toast.makeText(CheckOutActivity.this,CurrentTime.toString(), Toast.LENGTH_LONG).show();
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    	  
				}
			  }

			  private Date parseDate(String date) {

			      try {
			          return inputParser.parse(date);
			      } catch (java.text.ParseException e) {
			          return new Date(0);
			      }
			  }


		}
	
}
