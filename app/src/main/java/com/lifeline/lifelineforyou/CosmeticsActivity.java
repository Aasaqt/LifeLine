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

public class CosmeticsActivity extends Activity {

	ImageView ivcoscall;
    AlertDialog dia;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		overridePendingTransition(R.anim.animation_enter, R.anim.animation_leave);
		setContentView(R.layout.activity_cosmetics);
		ActionBar ab=getActionBar();
		ab.setTitle("Cosmetics");
		ab.setHomeButtonEnabled(true);
		ab.setDisplayHomeAsUpEnabled(true);
		ivcoscall=(ImageView) findViewById(R.id.ivcoscall);
        ivcoscall.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 Intent callIntent = new Intent(Intent.ACTION_CALL);
				 callIntent.setData(Uri.parse("tel:07307123123"));
				 startActivity(callIntent);
				
			}
		});



       /* SimpleDateFormat formatDate = new SimpleDateFormat("hh:mm a");
        //formatDate.setTimeZone(userContext.getUser().getTimeZone());
        String currentdate = formatDate.format(new Date());
        String open= "09:00 AM";
        String close = "09:00 PM";
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



        ListView lvcosmetics=(ListView) findViewById(R.id.cosmeticslistview);
 	   
        ListViewAdapter listviewadapter = new ListViewAdapter(this, new String[] {"Face Care","Skin Care",
        		"Facial Kit","Manicure-Pedicure","Hair care","Body n Bath","FEM care","Veet Hair Remove","Waxing products",
        		"Face Pack","Face mask","Hair Mehandi","Hand Wash","Bathing Soap","Toothpaste","Sanitary Pads"
        		,"Stayfree Pads","Sofy Pads","Mouth Wash","Make Up","Kajal",
        		"Eyeliner","Eye Mascara","Eye Liner"});
        lvcosmetics.setAdapter(listviewadapter);
        //if(date.compareTo(date1) > 0  && date.compareTo(date2) <0 ) {
            lvcosmetics.setOnItemClickListener(new OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    switch (position) {
                        case 0: {
                            Intent i = new Intent(CosmeticsActivity.this, CosmeticsSubCatActivity.class);
                            i.putExtra("subcat2", "face care");
                            startActivity(i);
                            break;
                        }
                        case 1: {
                            GetProducts gp = new GetProducts(CosmeticsActivity.this);
                            gp.execute("Skin Care", "cosmetics", "");
                            break;
                        }
                        case 2: {
                            GetProducts gp = new GetProducts(CosmeticsActivity.this);
                            gp.execute("Facial Kit", "cosmetics", "");
                            break;
                        }
                        case 3: {
                            GetProducts gp = new GetProducts(CosmeticsActivity.this);
                            gp.execute("Manicure/ Pedicure", "cosmetics", "");
                            break;
                        }
                        case 4: {
                            Intent i = new Intent(CosmeticsActivity.this, CosmeticsSubCatActivity.class);
                            i.putExtra("subcat2", "hair care");
                            startActivity(i);
                            break;
                        }
                        case 5: {
                            Intent i = new Intent(CosmeticsActivity.this, CosmeticsSubCatActivity.class);
                            i.putExtra("subcat2", "Body n Bath");
                            startActivity(i);
                            break;
                        }
                        case 6: {
                            GetProducts gp = new GetProducts(CosmeticsActivity.this);
                            gp.execute("FEM care", "cosmetics", "");
                            break;
                        }
                        case 7: {
                            GetProducts gp = new GetProducts(CosmeticsActivity.this);
                            gp.execute("Veet Hair Remove", "cosmetics", "");
                            break;
                        }
                        case 8: {
                            GetProducts gp = new GetProducts(CosmeticsActivity.this);
                            gp.execute("Waxing products", "cosmetics", "");
                            break;
                        }
                        case 9: {
                            GetProducts gp = new GetProducts(CosmeticsActivity.this);
                            gp.execute("Face Pack", "cosmetics", "");
                            break;
                        }
                        case 10: {
                            GetProducts gp = new GetProducts(CosmeticsActivity.this);
                            gp.execute("Face mask", "cosmetics", "");
                            break;
                        }
                        case 11: {
                            GetProducts gp = new GetProducts(CosmeticsActivity.this);
                            gp.execute("Hair Mehandi", "cosmetics", "");
                            break;
                        }
                        case 12: {
                            GetProducts gp = new GetProducts(CosmeticsActivity.this);
                            gp.execute("Hand Wash", "cosmetics", "");
                            break;
                        }
                        case 13: {
                            GetProducts gp = new GetProducts(CosmeticsActivity.this);
                            gp.execute("Bathing Soap", "cosmetics", "");
                            break;
                        }
                        case 14: {
                            GetProducts gp = new GetProducts(CosmeticsActivity.this);
                            gp.execute("Toothpaste", "cosmetics", "");
                            break;
                        }
                        case 15: {
                            GetProducts gp = new GetProducts(CosmeticsActivity.this);
                            gp.execute("Sanitary Pads", "cosmetics", "");
                            break;
                        }
                        case 16: {
                            GetProducts gp = new GetProducts(CosmeticsActivity.this);
                            gp.execute("Stayfree Pads", "cosmetics", "");
                            break;
                        }
                        case 17: {
                            GetProducts gp = new GetProducts(CosmeticsActivity.this);
                            gp.execute("Sofy Pads", "cosmetics", "");
                            break;
                        }
                        case 18: {
                            GetProducts gp = new GetProducts(CosmeticsActivity.this);
                            gp.execute("Mouth Wash", "cosmetics", "");
                            break;
                        }
                        case 19: {
                            GetProducts gp = new GetProducts(CosmeticsActivity.this);
                            gp.execute("Make Up", "cosmetics", "");
                            break;
                        }
                        case 20: {
                            GetProducts gp = new GetProducts(CosmeticsActivity.this);
                            gp.execute("Kajal", "cosmetics", "");
                            break;
                        }
                        case 21: {
                            GetProducts gp = new GetProducts(CosmeticsActivity.this);
                            gp.execute("Eyeliner", "cosmetics", "");
                            break;
                        }
                        case 22: {
                            GetProducts gp = new GetProducts(CosmeticsActivity.this);
                            gp.execute("Eye Mascara", "cosmetics", "");
                            break;
                        }
                        case 23: {
                            GetProducts gp = new GetProducts(CosmeticsActivity.this);
                            gp.execute("Eye Liner", "cosmetics", "");
                            break;
                        }
                        default:
                            break;
                    }

                }
            });
        //}else {

          /*  AlertDialog.Builder adb = new AlertDialog.Builder(CosmeticsActivity.this);
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
			Intent i=new Intent(CosmeticsActivity.this,CheckOutActivity.class);
			startActivity(i);
		}
		else if(item.getItemId()==R.id.action_hisotry)
		{
			Intent i=new Intent(CosmeticsActivity.this,HistoryActivity.class);
			startActivity(i);
		}
		else if(item.getItemId()==R.id.action_offers)
		{
			Intent i=new Intent(CosmeticsActivity.this,OfferActivity.class);
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
			AlertDialog.Builder adb = new AlertDialog.Builder(CosmeticsActivity.this);
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
    else if(item.getItemId()==R.id.action_servicecharge)
    {
        Intent i= new Intent(CosmeticsActivity.this,ServiceCharge.class);
        startActivity(i);
    }
    else if(item.getItemId()==R.id.action_about)
    {
        Intent i= new Intent(CosmeticsActivity.this,HelpActivity.class);
        startActivity(i);
    }
		else if(item.getItemId()==R.id.action_search)
		{
			Intent i=new Intent(CosmeticsActivity.this,SearchActivity.class);
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
