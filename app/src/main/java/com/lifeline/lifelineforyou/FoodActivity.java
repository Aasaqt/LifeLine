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

public class FoodActivity extends Activity {

	ImageView ivfoodcall;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		overridePendingTransition(R.anim.animation_enter, R.anim.animation_leave);
		setContentView(R.layout.activity_food);
		ActionBar ab=getActionBar();
		ab.setTitle("Food");
		ab.setHomeButtonEnabled(true);
		ab.setDisplayHomeAsUpEnabled(true);
		ivfoodcall=(ImageView) findViewById(R.id.ivfoodcall);
        ivfoodcall.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 Intent callIntent = new Intent(Intent.ACTION_CALL);
				 callIntent.setData(Uri.parse("tel:07307123123"));
				 startActivity(callIntent);
				
			}
		});
		ListView lvstationary=(ListView) findViewById(R.id.foodlistview);
	   
        ListViewAdapter listviewadapter = new ListViewAdapter(this, new String[] {"NFS","Stu-C","Lava","Chinese Food","Dark Moon Kitchen","University Sweets"});
        lvstationary.setAdapter(listviewadapter);
        lvstationary.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				switch (arg2) {
				case 0:
				{
					Intent i=new Intent(FoodActivity.this,FoodSubCatActivity.class);
					i.putExtra("subcat2", "nfs");
					startActivity(i);
					break;
				}
				case 1:
				{
					Intent i=new Intent(FoodActivity.this,FoodSubCatActivity.class);
					i.putExtra("subcat2", "stu-c");
					startActivity(i);
					break;
				}
				case 2:
				{
					Intent i=new Intent(FoodActivity.this,FoodSubCatActivity.class);
					i.putExtra("subcat2", "lava");
					startActivity(i);
					break;
				}
				case 3:
				{
					Intent i=new Intent(FoodActivity.this,FoodSubCatActivity.class);
					i.putExtra("subcat2", "chinese food");
					startActivity(i);
					break;
				}
				case 4:
				{
					Intent i=new Intent(FoodActivity.this,FoodSubCatActivity.class);
					i.putExtra("subcat2", "dark_moon_kitchen");
					startActivity(i);
					break;
				}
				case 5:
				{
					Intent i=new Intent(FoodActivity.this,FoodSubCatActivity.class);
					i.putExtra("subcat2", "pu_sweets");
					startActivity(i);
					break;
				}


				default:
					break;
				}

			}
		});
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
			Intent i=new Intent(FoodActivity.this,CheckOutActivity.class);
			startActivity(i);
		}
		else if(item.getItemId()==R.id.action_hisotry)
		{
			Intent i=new Intent(FoodActivity.this,HistoryActivity.class);
			startActivity(i);
		}
		else if(item.getItemId()==R.id.action_offers)
		{
			Intent i=new Intent(FoodActivity.this,OfferActivity.class);
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
             Intent i= new Intent(FoodActivity.this,ServiceCharge.class);
             startActivity(i);
         }
		else if(item.getItemId()==R.id.action_contact)
		{
			AlertDialog dia;
			AlertDialog.Builder adb = new AlertDialog.Builder(FoodActivity.this);
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
             Intent i= new Intent(FoodActivity.this,HelpActivity.class);
             startActivity(i);
         }
		else if(item.getItemId()==R.id.action_search)
		{
			Intent i=new Intent(FoodActivity.this,SearchActivity.class);
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
