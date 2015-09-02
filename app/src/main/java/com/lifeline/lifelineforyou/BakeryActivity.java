package com.lifeline.lifelineforyou;

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
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BakeryActivity extends Activity {

	ImageView ivbakerycall;
    AlertDialog dia;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		overridePendingTransition(R.anim.animation_enter, R.anim.animation_leave);
		setContentView(R.layout.activity_bakery);
		ivbakerycall=(ImageView) findViewById(R.id.ivbakerycall);
		ivbakerycall.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 Intent callIntent = new Intent(Intent.ACTION_CALL);
				 callIntent.setData(Uri.parse("tel:07307123123"));
				 startActivity(callIntent);
				
			}
		});
		ActionBar ab=getActionBar();
		ab.setTitle("Bakery");
		ab.setHomeButtonEnabled(true);
		ab.setDisplayHomeAsUpEnabled(true);
        /*SimpleDateFormat formatDate = new SimpleDateFormat("hh:mm a");
        //formatDate.setTimeZone(userContext.getUser().getTimeZone());
        String currentdate = formatDate.format(new Date());
        String open= "10:00 AM";
        String close = "10:00 PM";
        //Toast.makeText(BakeryActivity.this,currentdate +"\n" + open +"\n" +close,Toast.LENGTH_LONG).show();
        //long timecurrent = 0,timeopen = 0,timeclose = 0;
       Date date = null,date1 = null,date2 = null;
        try {
            date=formatDate.parse(currentdate);
            date1=formatDate.parse(open);
            date2= formatDate.parse(close);
           // Toast.makeText(BakeryActivity.this,date +"\n" + date1 +"\n" +date2,Toast.LENGTH_LONG).show();
        } catch (ParseException e) {
            e.printStackTrace();
        }*/

        //timecurrent = date.getTime();
        //timeopen =date1.getTime();
        //timeclose = date2.getTime();

        //Toast.makeText(BakeryActivity.this,timecurrent +"\n" + timeopen +"\n" +timeclose,Toast.LENGTH_LONG).show();

        ListView lvstationary=(ListView) findViewById(R.id.bakerylistview);
	   
        ListViewAdapter listviewadapter = new ListViewAdapter(this, new String[] {"Ayurvedic items","Snacks",
        		"Fruit Cake","Pastry","Pudding","Roll","Cakes","Indian Meal","Chinese","Maida","Birthday Items","Other items"});
        lvstationary.setAdapter(listviewadapter);

        //if(date.compareTo(date1) > 0  && date.compareTo(date2) <0 ) {

            lvstationary.setOnItemClickListener(new OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                        long arg3) {
                    switch (arg2) {
                        case 0: {
                            GetProducts gp = new GetProducts(BakeryActivity.this);
                            gp.execute("Ayurvedic items", "Bakery", "");
                            break;
                        }
                        case 1: {
                            GetProducts gp = new GetProducts(BakeryActivity.this);
                            gp.execute("Snacks3", "Bakery", "");
                            break;
                        }
                        case 2: {
                            GetProducts gp = new GetProducts(BakeryActivity.this);
                            gp.execute("Fruit Cake", "Bakery", "");
                            break;
                        }
                        case 3: {
                            GetProducts gp = new GetProducts(BakeryActivity.this);
                            gp.execute("Pastry", "Bakery", "");
                            break;
                        }
                        case 4: {
                            GetProducts gp = new GetProducts(BakeryActivity.this);
                            gp.execute("Pudding", "Bakery", "");
                            break;
                        }
                        case 5: {
                            GetProducts gp = new GetProducts(BakeryActivity.this);
                            gp.execute("Roll", "Bakery", "");
                            break;
                        }
                        case 6: {
                            GetProducts gp = new GetProducts(BakeryActivity.this);
                            gp.execute("Cakes", "Bakery", "");
                            break;
                        }
                        case 7: {
                            GetProducts gp = new GetProducts(BakeryActivity.this);
                            gp.execute("Indian Meal", "Bakery", "");
                            break;
                        }
                        case 8: {
                            GetProducts gp = new GetProducts(BakeryActivity.this);
                            gp.execute("Chinese", "Bakery", "");
                            break;
                        }
                        case 9: {
                            GetProducts gp = new GetProducts(BakeryActivity.this);
                            gp.execute("Maida", "Bakery", "");
                            break;
                        }
                        case 10: {
                            GetProducts gp = new GetProducts(BakeryActivity.this);
                            gp.execute("Birthday Items", "Bakery", "");
                            break;
                        }
                        case 11: {
                            GetProducts gp = new GetProducts(BakeryActivity.this);
                            gp.execute("Other items", "Bakery", "");
                            break;
                        }
                        default:
                            break;
                    }

                }
            });
        //}else {
/*
            AlertDialog.Builder adb = new AlertDialog.Builder(BakeryActivity.this);
            adb.setTitle("Attention");
            adb.setMessage("The store is closed for now and timing for delivery of this item is "+open+" to "+close);
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
        }*/
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
			Intent i=new Intent(BakeryActivity.this,CheckOutActivity.class);
			startActivity(i);
		}
		else if(item.getItemId()==R.id.action_hisotry)
		{
			Intent i=new Intent(BakeryActivity.this,HistoryActivity.class);
			startActivity(i);
		}
		else if(item.getItemId()==R.id.action_offers)
		{
			Intent i=new Intent(BakeryActivity.this,OfferActivity.class);
			startActivity(i);
		}
		else if(item.getItemId()==R.id.action_orderbycall)
		{
			Intent callIntent = new Intent(Intent.ACTION_CALL);
			 callIntent.setData(Uri.parse("tel:07307123123"));
			 startActivity(callIntent);
		}
         else if(item.getItemId()==R.id.action_servicecharge)
         {
             Intent i= new Intent(BakeryActivity.this,ServiceCharge.class);
             startActivity(i);
         }
		else if(item.getItemId()==R.id.action_contact)
		{
			AlertDialog dia;
			AlertDialog.Builder adb = new AlertDialog.Builder(BakeryActivity.this);
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
             Intent i= new Intent(BakeryActivity.this,HelpActivity.class);
             startActivity(i);
         }
		else if(item.getItemId()==R.id.action_search)
		{
			Intent i=new Intent(BakeryActivity.this,SearchActivity.class);
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
