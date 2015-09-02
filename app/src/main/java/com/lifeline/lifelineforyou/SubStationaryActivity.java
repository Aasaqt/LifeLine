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

public class SubStationaryActivity extends Activity{

	ImageView ivsubstatcall;
	ListViewAdapter listviewadapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		overridePendingTransition(R.anim.animation_enter, R.anim.animation_leave);
		setContentView(R.layout.activity_sub_stationary);
		ActionBar ab=getActionBar();
		ab.setTitle("Stationary");
		ab.setHomeButtonEnabled(true);
		ab.setDisplayHomeAsUpEnabled(true);
		ivsubstatcall=(ImageView) findViewById(R.id.ivsubstatcall);
        ivsubstatcall.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 Intent callIntent = new Intent(Intent.ACTION_CALL);
				 callIntent.setData(Uri.parse("tel:07307123123"));
				 startActivity(callIntent);
				
			}
		});
		ListView lvsubstationary=(ListView) findViewById(R.id.substationarylistview);
		if(getIntent().getExtras().getString("subcat2").equalsIgnoreCase("PENS"))
		{
			listviewadapter = new ListViewAdapter(this, new String[] {"Fluid ink pens","Gel pens","Stick Gel Pen"
	        		,"Ball Pen","Premium Executive Pens","Cello Ballpen","Cello pouch ballpen","Cello hanger pack ball pen","Metal ballpen"
	        		,"Cello fountain pens","PEN GIFT SET","CELLO GEL PEN","GLITTER PEN SET","ROLLER PENS CELLO"});
			  lvsubstationary.setAdapter(listviewadapter);
			  lvsubstationary.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					switch (position) {
					case 0:
					{
						 GetProducts gp=new GetProducts(SubStationaryActivity.this);
							gp.execute("PENS","Stationary","fluid ink pens");
						break;
					}
					case 1:
					{
						 GetProducts gp=new GetProducts(SubStationaryActivity.this);
							gp.execute("PENS","Stationary","gel pens");
						break;
					}
					case 2:
					{
						 GetProducts gp=new GetProducts(SubStationaryActivity.this);
							gp.execute("PENS","Stationary","Stick Gel Pen");
						break;
					}
					case 3:
					{
						 GetProducts gp=new GetProducts(SubStationaryActivity.this);
							gp.execute("PENS","Stationary","Ball Pen");
						break;
					}
					case 4:
					{
						 GetProducts gp=new GetProducts(SubStationaryActivity.this);
							gp.execute("PENS","Stationary","Premium Executive Pens");
						break;
					}
					case 5:
					{
						 GetProducts gp=new GetProducts(SubStationaryActivity.this);
							gp.execute("PENS","Stationary","cello Ballpen");
						break;
					}
					case 6:
					{
						 GetProducts gp=new GetProducts(SubStationaryActivity.this);
							gp.execute("PENS","Stationary","cello pouch ballpen");
						break;
					}
					case 7:
					{
						 GetProducts gp=new GetProducts(SubStationaryActivity.this);
							gp.execute("PENS","Stationary","cello hanger pack ball pen");
						break;
					}
					case 8:
					{
						 GetProducts gp=new GetProducts(SubStationaryActivity.this);
							gp.execute("PENS","Stationary","metal ballpen");
						break;
					}
					case 9:
					{
						 GetProducts gp=new GetProducts(SubStationaryActivity.this);
							gp.execute("PENS","Stationary","cello fountain pens");
						break;
					}
					case 10:
					{
						 GetProducts gp=new GetProducts(SubStationaryActivity.this);
							gp.execute("PENS","Stationary","PEN GIFT SET");
						break;
					} 
					case 11:
					{
						 GetProducts gp=new GetProducts(SubStationaryActivity.this);
							gp.execute("PENS","Stationary","CELLO GEL PEN");
						break;
					}
					case 12:
					{
						 GetProducts gp=new GetProducts(SubStationaryActivity.this);
							gp.execute("PENS","Stationary","GLITTER PEN SET");
						break;
					}
					case 13:
					{
						 GetProducts gp=new GetProducts(SubStationaryActivity.this);
							gp.execute("PENS","Stationary","ROLLER PENS CELLO");
						break;
					}

					default:
						break;
					}
					
				}
			});
			
		}
		else if(getIntent().getExtras().getString("subcat2").equalsIgnoreCase("COLORS"))
		{
			listviewadapter = new ListViewAdapter(this, new String[] {"Sketch Pens","Oil Pastels","Wax Crayon"
	        		,"Color Pencils","POSTER COLORS"});
			  lvsubstationary.setAdapter(listviewadapter);
			  lvsubstationary.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						switch (position) {
						case 0:
						{
							  GetProducts gp=new GetProducts(SubStationaryActivity.this);
								gp.execute("COLORS","Stationary","Sketch Pens");
							break;
						}
						case 1:
						{
							 GetProducts gp=new GetProducts(SubStationaryActivity.this);
								gp.execute("COLORS","Stationary","Oil Pastels");
							break;
						}
						case 2:
						{
							 GetProducts gp=new GetProducts(SubStationaryActivity.this);
								gp.execute("COLORS","Stationary","Wax Crayon");
							break;
						}
						case 3:
						{
							 GetProducts gp=new GetProducts(SubStationaryActivity.this);
								gp.execute("COLORS","Stationary","Color Pencils");
							break;
						}
						case 4:
						{
							 GetProducts gp=new GetProducts(SubStationaryActivity.this);
								gp.execute("COLORS","Stationary","POSTER COLORS");
							break;
						}
						

						default:
							break;
						}
						
					}
				});
		}
		else if(getIntent().getExtras().getString("subcat2").equalsIgnoreCase("PEN'S REFILLS"))
		{
			listviewadapter = new ListViewAdapter(this, new String[] {"BALL PENS REFILL","GEL PENS REFILL","METAL BALL PENS REFILL"});
			  lvsubstationary.setAdapter(listviewadapter);
			  lvsubstationary.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						switch (position) {
						case 0:
						{
							   GetProducts gp=new GetProducts(SubStationaryActivity.this);
								gp.execute("PEN'S REFILLS","Stationary","BALL PENS REFILL");
							break;
						}
						case 1:
						{
							 GetProducts gp=new GetProducts(SubStationaryActivity.this);
							 gp.execute("PEN'S REFILLS","Stationary","GEL PENS REFILL");
							break;
						}
						case 2:
						{
							 GetProducts gp=new GetProducts(SubStationaryActivity.this);
							 gp.execute("PEN'S REFILLS","Stationary","METAL BALL PENS REFILL");
							break;
						}

						default:
							break;
						}
						
					}
				});
		}
		
      
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
			Intent i=new Intent(SubStationaryActivity.this,CheckOutActivity.class);
			startActivity(i);
		}
		else if(item.getItemId()==R.id.action_hisotry)
		{
			Intent i=new Intent(SubStationaryActivity.this,HistoryActivity.class);
			startActivity(i);
		}
		else if(item.getItemId()==R.id.action_offers)
		{
			Intent i=new Intent(SubStationaryActivity.this,OfferActivity.class);
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
			AlertDialog.Builder adb = new AlertDialog.Builder(SubStationaryActivity.this);
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
             Intent i= new Intent(SubStationaryActivity.this,HelpActivity.class);
             startActivity(i);
         }
         else if(item.getItemId()==R.id.action_servicecharge)
         {
             Intent i= new Intent(SubStationaryActivity.this,ServiceCharge.class);
             startActivity(i);
         }
		else if(item.getItemId()==R.id.action_search)
		{
			Intent i=new Intent(SubStationaryActivity.this,SearchActivity.class);
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
