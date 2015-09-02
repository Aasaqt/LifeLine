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

public class GeneralStoreActivity extends Activity {
	ImageView ivgscall;
    AlertDialog dia;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		overridePendingTransition(R.anim.animation_enter, R.anim.animation_leave);
		setContentView(R.layout.activity_generalstore);
		ActionBar ab=getActionBar();
		ab.setTitle("General Store");
		ab.setHomeButtonEnabled(true);
		ab.setDisplayHomeAsUpEnabled(true);
		ivgscall=(ImageView) findViewById(R.id.ivgscall);
        ivgscall.setOnClickListener(new OnClickListener() {
			
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
        String open= "11:00 AM";
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



		ListView lvstationary=(ListView) findViewById(R.id.generalstorelistview);
	   
        ListViewAdapter listviewadapter = new ListViewAdapter(this, new String[] {"Ayurvedic","Beverages and Juices","Biscuit and Namkeen",
        		"Blades and Shaving Cream","Cell Torch","Chocolate","Conditioner","Creams and Lotion","Daal","Deos and Perfumes","Grocery",
        		"Dry Fruits","Dyes","Electronics","FMCG Food","FMCG Non Food","Health Supplement","Insect Killer","Kiryana",
        		"Livguard","Plastic Material","Pooja Samagri","Refined Oil","Rice","Sauce","Shampoo","Soap","Spices","Surf",
        		"Tea","Toothpaste"});
        lvstationary.setAdapter(listviewadapter);
        //if(date.compareTo(date1) > 0  && date.compareTo(date2) <0 ) {
            lvstationary.setOnItemClickListener(new OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                        long arg3) {
                    switch (arg2) {
                        case 0: {
                            GetProducts gp = new GetProducts(GeneralStoreActivity.this);
                            gp.execute("ayurvedic", "general_store", "");
                            break;
                        }
                        case 1: {
                            GetProducts gp = new GetProducts(GeneralStoreActivity.this);
                            gp.execute("beverages", "general_store", "");
                            break;
                        }
                        case 2: {
                            GetProducts gp = new GetProducts(GeneralStoreActivity.this);
                            gp.execute("biscuit namkeen", "general_store", "");
                            break;
                        }
                        case 3: {
                            GetProducts gp = new GetProducts(GeneralStoreActivity.this);
                            gp.execute("blade", "general_store", "");
                            break;
                        }
                        case 4: {
                            GetProducts gp = new GetProducts(GeneralStoreActivity.this);
                            gp.execute("cell torch", "general_store", "");
                            break;
                        }
                        case 5: {
                            GetProducts gp = new GetProducts(GeneralStoreActivity.this);
                            gp.execute("choclates", "general_store", "");
                            break;
                        }
                        case 6: {
                            GetProducts gp = new GetProducts(GeneralStoreActivity.this);
                            gp.execute("conditioner1", "general_store", "");
                            break;
                        }
                        case 7: {
                            GetProducts gp = new GetProducts(GeneralStoreActivity.this);
                            gp.execute("creams", "general_store", "");
                            break;
                        }
                        case 8: {
                            GetProducts gp = new GetProducts(GeneralStoreActivity.this);
                            gp.execute("daal", "general_store", "");
                            break;
                        }
                        case 9: {
                            GetProducts gp = new GetProducts(GeneralStoreActivity.this);
                            gp.execute("deo", "general_store", "");
                            break;
                        }
                        case 10: {
                            GetProducts gp = new GetProducts(GeneralStoreActivity.this);
                            gp.execute("grocery", "general_store", "");
                            break;
                        }
                        case 11: {
                            GetProducts gp = new GetProducts(GeneralStoreActivity.this);
                            gp.execute("dry fruit", "general_store", "");
                            break;
                        }
                        case 12: {
                            GetProducts gp = new GetProducts(GeneralStoreActivity.this);
                            gp.execute("dyes", "general_store", "");
                            break;
                        }
                        case 13: {
                            GetProducts gp = new GetProducts(GeneralStoreActivity.this);
                            gp.execute("electronics", "general_store", "");
                            break;
                        }
                        case 14: {
                            GetProducts gp = new GetProducts(GeneralStoreActivity.this);
                            gp.execute("fmcg food", "general_store", "");
                            break;
                        }
                        case 15: {
                            GetProducts gp = new GetProducts(GeneralStoreActivity.this);
                            gp.execute("fmcg non food", "general_store", "");
                            break;
                        }
                        case 16: {
                            GetProducts gp = new GetProducts(GeneralStoreActivity.this);
                            gp.execute("health supplement        ", "general_store", "");
                            break;
                        }
                        case 17: {
                            GetProducts gp = new GetProducts(GeneralStoreActivity.this);
                            gp.execute("insect killer", "general_store", "");
                            break;
                        }
                        case 18: {
                            GetProducts gp = new GetProducts(GeneralStoreActivity.this);
                            gp.execute("kiryana", "general_store", "");
                            break;
                        }
                        case 19: {
                            GetProducts gp = new GetProducts(GeneralStoreActivity.this);
                            gp.execute("livguard batteries", "general_store", "");
                            break;
                        }
                        case 20: {
                            GetProducts gp = new GetProducts(GeneralStoreActivity.this);
                            gp.execute("plastic material", "general_store", "");
                            break;
                        }
                        case 21: {
                            GetProducts gp = new GetProducts(GeneralStoreActivity.this);
                            gp.execute("puja samagri", "general_store", "");
                            break;
                        }
                        case 22: {
                            GetProducts gp = new GetProducts(GeneralStoreActivity.this);
                            gp.execute("refined", "general_store", "");
                            break;
                        }
                        case 23: {
                            GetProducts gp = new GetProducts(GeneralStoreActivity.this);
                            gp.execute("rice", "general_store", "");
                            break;
                        }
                        case 24: {
                            GetProducts gp = new GetProducts(GeneralStoreActivity.this);
                            gp.execute("sauces", "general_store", "");
                            break;
                        }
                        case 25: {
                            GetProducts gp = new GetProducts(GeneralStoreActivity.this);
                            gp.execute("shampoo", "general_store", "");
                            break;
                        }
                        case 26: {
                            GetProducts gp = new GetProducts(GeneralStoreActivity.this);
                            gp.execute("soap", "general_store", "");
                            break;
                        }
                        case 27: {
                            GetProducts gp = new GetProducts(GeneralStoreActivity.this);
                            gp.execute("spices", "general_store", "");
                            break;
                        }
                        case 28: {
                            GetProducts gp = new GetProducts(GeneralStoreActivity.this);
                            gp.execute("surf all", "general_store", "");
                            break;
                        }
                        case 29: {
                            GetProducts gp = new GetProducts(GeneralStoreActivity.this);
                            gp.execute("tea", "general_store", "");
                            break;
                        }
                        case 30: {
                            GetProducts gp = new GetProducts(GeneralStoreActivity.this);
                            gp.execute("toothpaste1", "general_store", "");
                            break;
                        }
				/*case 31:
				{
					GetProducts gp=new GetProducts(GeneralStoreActivity.this);
					gp.execute("winter","general_store","");
					break;
				}*/

                        default:
                            break;
                    }

                }
            });
        //}else {

          /*  AlertDialog.Builder adb = new AlertDialog.Builder(GeneralStoreActivity.this);
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
			Intent i=new Intent(GeneralStoreActivity.this,CheckOutActivity.class);
			startActivity(i);
		}
		else if(item.getItemId()==R.id.action_hisotry)
		{
			Intent i=new Intent(GeneralStoreActivity.this,HistoryActivity.class);
			startActivity(i);
		}
		else if(item.getItemId()==R.id.action_offers)
		{
			Intent i=new Intent(GeneralStoreActivity.this,OfferActivity.class);
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
			AlertDialog.Builder adb = new AlertDialog.Builder(GeneralStoreActivity.this);
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
             Intent i= new Intent(GeneralStoreActivity.this,HelpActivity.class);
             startActivity(i);
         }
         else if(item.getItemId()==R.id.action_servicecharge)
         {
             Intent i= new Intent(GeneralStoreActivity.this,ServiceCharge.class);
             startActivity(i);
         }
		else if(item.getItemId()==R.id.action_search)
		{
			Intent i=new Intent(GeneralStoreActivity.this,SearchActivity.class);
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
