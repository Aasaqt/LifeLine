package com.lifeline.lifelineforyou;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;


public class AddToCartActivity extends Activity {
	

	
		  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		overridePendingTransition(R.anim.animation_enter, R.anim.animation_leave);
		setContentView(R.layout.activity_addtocart);
		String add_to_cart_from=getIntent().getExtras().getString("add_to_cart_from");
		ActionBar ab=getActionBar();
		ab.setTitle("Add to Cart");
		ab.setHomeButtonEnabled(true);
		ab.setDisplayHomeAsUpEnabled(true);
		ListView lvaddtocart=(ListView) findViewById(R.id.addtocartlistview);
		 ListViewAdapterAddToCart listviewadapter = null;


        //ArrayList<String> cat_list;
        //cat_list=new ArrayList<String>();
        //String itemforservicecharge[]=getResources().getStringArray(R.array.service_charge);
        //String shopopen[]=getResources().getStringArray(R.array.shop_open);
        //String shopclose[]=getResources().getStringArray(R.array.shop_close);
        //HashMap<String,Integer> hmobj=new HashMap<String, Integer>();
        //ArrayList<Integer> itemfreq=new ArrayList<Integer>();
        //SimpleDateFormat formatDate = new SimpleDateFormat("HH:mm a");
        //formatDate.setTimeZone(userContext.getUser().getTimeZone());
        //String currentdate = formatDate.format(new Date());
        //Toast.makeText(AddToCartActivity.this,currentdate,Toast.LENGTH_LONG).show();

            //itemfreq.add(Collections.frequency(cat_list, itemforservicecharge[i]));
            //hmobj.put(itemforservicecharge[i],Collections.frequency(cat_list,itemforservicecharge[i]) );

                if(add_to_cart_from.equalsIgnoreCase("SearchActivity"))
                {
                    ArrayList<String> prodlist=new ArrayList<String>();
                    ArrayList<String> pricelist=new ArrayList<String>();
                    ArrayList<String> pid_list=new ArrayList<String>();
                    prodlist.add(getIntent().getExtras().getString("product_name"));
                    pid_list.add(getIntent().getExtras().getString("pid"));
                    pricelist.add(getIntent().getExtras().getString("price"));
                    listviewadapter = new ListViewAdapterAddToCart(this,prodlist,pricelist,pid_list);
                }

                else
                {

                    ArrayList<String> prod_name=getIntent().getExtras().getStringArrayList("ProductList");
                    ArrayList<String> price=getIntent().getExtras().getStringArrayList("PriceList");
                    ArrayList<String> pid=getIntent().getExtras().getStringArrayList("PIDList");
                    ArrayList<String> prod_price=new ArrayList<String>();
                    for(int i=0;i<price.size();i++)
                    {
                        prod_price.add(price.get(i));
                    }


                    listviewadapter = new ListViewAdapterAddToCart(this,prod_name,prod_price,pid);
                }

                lvaddtocart.setAdapter(listviewadapter);
                lvaddtocart.setOnItemClickListener(new OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {
//				ImageView ivcartpress=(ImageView) view.findViewById(R.id.ivcartpress);
//				ivcartpress.setImageResource(R.drawable.btn_addtocart_pressed);


                    }
                });


        /*int flag=0,itemindex = 0;
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
                             dia.show();
                }
            }
        }*/





//        new GetContacts().execute();
        
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		 if(item.getItemId()==android.R.id.home)
		 {
            Intent homeIntent = new Intent(this, MainActivity.class);
            homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(homeIntent);
		 }
	else if(item.getItemId()==R.id.action_cart)
		{
			Intent i=new Intent(AddToCartActivity.this,CheckOutActivity.class);
			startActivity(i);
		}
		else if(item.getItemId()==R.id.action_hisotry)
		{
			Intent i=new Intent(AddToCartActivity.this,HistoryActivity.class);
			startActivity(i);
		}
		else if(item.getItemId()==R.id.action_offers)
		{
			Intent i=new Intent(AddToCartActivity.this,OfferActivity.class);
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
			AlertDialog.Builder adb = new AlertDialog.Builder(AddToCartActivity.this);
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
             Intent i= new Intent(AddToCartActivity.this,HelpActivity.class);
             startActivity(i);
        }
         else if(item.getItemId()==R.id.action_servicecharge)
         {
             Intent i= new Intent(AddToCartActivity.this,ServiceCharge.class);
             startActivity(i);
         }
		else if(item.getItemId()==R.id.action_search)
		{
			Intent i=new Intent(AddToCartActivity.this,SearchActivity.class);
			startActivity(i);
		}
		return super.onOptionsItemSelected(item);
	}
	@Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.anim_back_from, R.anim.anim_back_to);
    }

}
