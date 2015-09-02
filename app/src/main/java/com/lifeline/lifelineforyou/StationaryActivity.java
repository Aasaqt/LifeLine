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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class StationaryActivity extends Activity{


	ImageView ivstatcall;
    AlertDialog dia;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		overridePendingTransition(R.anim.animation_enter, R.anim.animation_leave);
		setContentView(R.layout.activity_stationary);
		{

			AlertDialog.Builder adb = new AlertDialog.Builder(StationaryActivity.this);
		    adb.setTitle("Attention!");
		    adb.setMessage("In Case of any extra details shopkeeper will call you.(Like Color of markers,charts,pens etc.)");
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
		ActionBar ab=getActionBar();
		ab.setTitle("Stationary");
		ab.setHomeButtonEnabled(true);
		ab.setDisplayHomeAsUpEnabled(true);
		ivstatcall=(ImageView) findViewById(R.id.ivstatcall);
        ivstatcall.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 Intent callIntent = new Intent(Intent.ACTION_CALL);
				 callIntent.setData(Uri.parse("tel:07307123123"));
				 startActivity(callIntent);
				
			}
		});


        /*SimpleDateFormat formatDate = new SimpleDateFormat("hh:mm a");
        //formatDate.setTimeZone(userContext.getUser().getTimeZone());
        String currentdate = formatDate.format(new Date());
        String open= "09:30 AM";
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
		ListView lvstationary=(ListView) findViewById(R.id.stationarylistview);
	   
        ListViewAdapter listviewadapter = new ListViewAdapter(this, new String[] {"PENS","Mechanical Pencil","Pencils"
        		,"Geometry Box","Scales","Eraser","Sharpener","COLORS","PEN'S REFILLS"
        		,"NOTEBOOKS","NOTEPAD","FEVICOL","FEVISTICK","STATIONARY TAPES","STAPLERS","STATIONARY PUNCH"
        		,"PINS","CUTTER","CHARTS","MARKERS","HIGHLIGHTERS","ENVELOPE","COMPASS","WHITE BOARD MARKER"
        		,"SHEETS","WRITING PAD","NOTEBOOK","EXAMINATION BOARD"});
        lvstationary.setAdapter(listviewadapter);
        //if(date.compareTo(date1) > 0  && date.compareTo(date2) <0 ) {
            lvstationary.setOnItemClickListener(new OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                        long arg3) {
                    switch (arg2) {
                        case 0: {
                            Intent i = new Intent(StationaryActivity.this, SubStationaryActivity.class);
                            i.putExtra("subcat2", "PENS");
                            startActivity(i);

                            break;
                        }
                        case 1:

                        {

                            GetProducts gp = new GetProducts(StationaryActivity.this);
                            gp.execute("Mechanical Pencil", "Stationary", "");

                            break;
                        }
                        case 2:

                        {

                            GetProducts gp = new GetProducts(StationaryActivity.this);
                            gp.execute("Pencils", "Stationary", "");
                            break;
                        }
                        case 3: {

                            GetProducts gp = new GetProducts(StationaryActivity.this);
                            gp.execute("Geometry Box", "Stationary", "");

                            break;
                        }
                        case 4: {

                            GetProducts gp = new GetProducts(StationaryActivity.this);
                            gp.execute("Scales", "Stationary", "");

                            break;
                        }
                        case 5: {
                            GetProducts gp = new GetProducts(StationaryActivity.this);
                            gp.execute("Eraser", "Stationary", "");

                            break;
                        }
                        case 6: {

                            GetProducts gp = new GetProducts(StationaryActivity.this);
                            gp.execute("Sharpener", "Stationary", "");

                            break;
                        }
                        case 7: {

                            Intent i = new Intent(StationaryActivity.this, SubStationaryActivity.class);
                            i.putExtra("subcat2", "COLORS");
                            startActivity(i);

                            break;
                        }
                        case 8: {

                            Intent i = new Intent(StationaryActivity.this, SubStationaryActivity.class);
                            i.putExtra("subcat2", "PEN'S REFILLS");
                            startActivity(i);

                            break;
                        }
                        case 9: {

                            GetProducts gp = new GetProducts(StationaryActivity.this);
                            gp.execute("NOTEBOOKS", "Stationary", "");
                            break;
                        }
                        case 10: {
                            GetProducts gp = new GetProducts(StationaryActivity.this);
                            gp.execute("NOTEPAD", "Stationary", "");
                            break;
                        }
                        case 11: {
                            GetProducts gp = new GetProducts(StationaryActivity.this);
                            gp.execute("FEVICOL", "Stationary", "");
                            break;
                        }
                        case 12: {
                            GetProducts gp = new GetProducts(StationaryActivity.this);
                            gp.execute("FEVISTICK", "Stationary", "");
                            break;
                        }
                        case 13: {
                            GetProducts gp = new GetProducts(StationaryActivity.this);
                            gp.execute("STATIONERY TAPES", "Stationary", "");
                            break;
                        }
                        case 14: {
                            GetProducts gp = new GetProducts(StationaryActivity.this);
                            gp.execute("STAPLERS", "Stationary", "");
                            break;
                        }
                        case 15: {
                            GetProducts gp = new GetProducts(StationaryActivity.this);
                            gp.execute("STATIONERY PUNCH", "Stationary", "");
                            break;
                        }
                        case 16: {
                            GetProducts gp = new GetProducts(StationaryActivity.this);
                            gp.execute("PINS", "Stationary", "");
                            break;
                        }
                        case 17: {
                            GetProducts gp = new GetProducts(StationaryActivity.this);
                            gp.execute("CUTTER", "Stationary", "");
                            break;
                        }
                        case 18: {
                            GetProducts gp = new GetProducts(StationaryActivity.this);
                            gp.execute("CHARTS", "Stationary", "");
                            break;
                        }
                        case 19: {
                            GetProducts gp = new GetProducts(StationaryActivity.this);
                            gp.execute("MARKERS", "Stationary", "");
                            break;
                        }
                        case 20: {
                            GetProducts gp = new GetProducts(StationaryActivity.this);
                            gp.execute("HIGHLIGHTERS", "Stationary", "");
                            break;
                        }
                        case 21: {
                            GetProducts gp = new GetProducts(StationaryActivity.this);
                            gp.execute("ENVELOPE", "Stationary", "");
                            break;
                        }
                        case 22: {
                            GetProducts gp = new GetProducts(StationaryActivity.this);
                            gp.execute("COMPASS", "Stationary", "");
                            break;
                        }
                        case 23: {
                            GetProducts gp = new GetProducts(StationaryActivity.this);
                            gp.execute("WHITE BOARD MARKER", "Stationary", "");
                            break;
                        }
                        case 24: {
                            GetProducts gp = new GetProducts(StationaryActivity.this);
                            gp.execute("SHEETS", "Stationary", "");
                            break;
                        }
                        case 25: {
                            GetProducts gp = new GetProducts(StationaryActivity.this);
                            gp.execute("WRITING PAD", "Stationary", "");
                            break;
                        }
                        case 26: {
                            GetProducts gp = new GetProducts(StationaryActivity.this);
                            gp.execute("NOTEBOOK", "Stationary", "");
                            break;
                        }
                        case 27: {
                            GetProducts gp = new GetProducts(StationaryActivity.this);
                            gp.execute("EXAMIANTION BOARD", "Stationary", "");
                            break;
                        }

                        default:

                            break;
                    }
//				Intent intent = new Intent(StationaryActivity.this,AddToCartActivity.class);
//				intent.putExtra("add_to_cart_from","normal");
//                startActivity(intent);


                }
            });
        /*}else {

            AlertDialog.Builder adb = new AlertDialog.Builder(StationaryActivity.this);
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
			Intent i=new Intent(StationaryActivity.this,CheckOutActivity.class);
			startActivity(i);
		}
		else if(item.getItemId()==R.id.action_hisotry)
		{
			Intent i=new Intent(StationaryActivity.this,HistoryActivity.class);
			startActivity(i);
		}
		else if(item.getItemId()==R.id.action_offers)
		{
			Intent i=new Intent(StationaryActivity.this,OfferActivity.class);
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
			AlertDialog.Builder adb = new AlertDialog.Builder(StationaryActivity.this);
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
             Intent i= new Intent(StationaryActivity.this,HelpActivity.class);
             startActivity(i);
         }
         else if(item.getItemId()==R.id.action_servicecharge)
         {
             Intent i= new Intent(StationaryActivity.this,ServiceCharge.class);
             startActivity(i);
         }
		else if(item.getItemId()==R.id.action_search)
		{
			Intent i=new Intent(StationaryActivity.this,SearchActivity.class);
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
