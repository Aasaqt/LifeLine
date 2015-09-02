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

public class CosmeticsSubCatActivity extends Activity {
	
	ImageView ivsubcoscall;
	ListViewAdapter listviewadapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		overridePendingTransition(R.anim.animation_enter, R.anim.animation_leave);
		setContentView(R.layout.activity_cosmetics_sub_cat);
		ActionBar ab=getActionBar();
		ab.setTitle("Cosmetics");
		ab.setHomeButtonEnabled(true);
		ab.setDisplayHomeAsUpEnabled(true);
		ivsubcoscall=(ImageView) findViewById(R.id.ivcossubcall);
        ivsubcoscall.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 Intent callIntent = new Intent(Intent.ACTION_CALL);
				 callIntent.setData(Uri.parse("tel:07307123123"));
				 startActivity(callIntent);
				
			}
		});





        ListView lvsubcosmetics=(ListView) findViewById(R.id.cosmeticssubcatlistview);
 	   
        if(getIntent().getExtras().getString("subcat2").equalsIgnoreCase("face care"))
		{
			listviewadapter = new ListViewAdapter(this, new String[] {"face cream","face serum","face sunscreen lotion"
	        		,"face wash","face toner","Cleansing milk products"});
			  lvsubcosmetics.setAdapter(listviewadapter);
			  lvsubcosmetics.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					switch (position) {
					case 0:
					{
						 GetProducts gp=new GetProducts(CosmeticsSubCatActivity.this);
							gp.execute("face Care","cosmetics","face cream");
						break;
					}
					case 1:
					{
						 GetProducts gp=new GetProducts(CosmeticsSubCatActivity.this);
							gp.execute("face Care","cosmetics","face serum");
						break;
					}
					case 2:
					{
						 GetProducts gp=new GetProducts(CosmeticsSubCatActivity.this);
							gp.execute("face Care","cosmetics","face sunscreen lotion");
						break;
					}
					case 3:
					{
						 GetProducts gp=new GetProducts(CosmeticsSubCatActivity.this);
							gp.execute("face Care","cosmetics","face wash");
						break;
					}
					case 4:
					{
						 GetProducts gp=new GetProducts(CosmeticsSubCatActivity.this);
							gp.execute("face Care","cosmetics","face toner");
						break;
					}
					case 5:
					{
						 GetProducts gp=new GetProducts(CosmeticsSubCatActivity.this);
							gp.execute("face Care","cosmetics","Cleansing milk products");
						break;
					}
					

					default:
						break;
					}
					
				}
			});
			
		}
		else if(getIntent().getExtras().getString("subcat2").equalsIgnoreCase("hair care"))
		{
			listviewadapter = new ListViewAdapter(this, new String[] {"Shampoo.","Conditioner","Oil"
	        		,"serum"/*"shampoo"*/,"Hair color"});
			  lvsubcosmetics.setAdapter(listviewadapter);
			  lvsubcosmetics.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						switch (position) {
						case 0:
						{
							  GetProducts gp=new GetProducts(CosmeticsSubCatActivity.this);
								gp.execute("hair care","cosmetics","SHAMPOO1");
							break;
						}
						case 1:
						{
							GetProducts gp=new GetProducts(CosmeticsSubCatActivity.this);
							gp.execute("hair care","cosmetics","Conditioner");
							break;
						}
						case 2:
						{
							GetProducts gp=new GetProducts(CosmeticsSubCatActivity.this);
							gp.execute("hair care","cosmetics","Oil");
							break;
						}
						case 3:
						{
							GetProducts gp=new GetProducts(CosmeticsSubCatActivity.this);
							gp.execute("hair care","cosmetics","serum");
							break;
						}
						/*case 4:
						{
							GetProducts gp=new GetProducts(CosmeticsSubCatActivity.this);
							gp.execute("hair care","cosmetics","shampoo");
							break;
						}*/
						case 4:
						{
							GetProducts gp=new GetProducts(CosmeticsSubCatActivity.this);
							gp.execute("hair care","cosmetics","Hair color");
							break;
						}

						default:
							break;
						}
						
					}
				});
		}
		else if(getIntent().getExtras().getString("subcat2").equalsIgnoreCase("Body n Bath"))
		{
			listviewadapter = new ListViewAdapter(this, new String[] {"body wash","body lotion"});
			  lvsubcosmetics.setAdapter(listviewadapter);
			  lvsubcosmetics.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						switch (position) {
						case 0:
						{
							   GetProducts gp=new GetProducts(CosmeticsSubCatActivity.this);
								gp.execute("Body n Bath","cosmetics","body wash");
							break;
						}
						case 1:
						{
							 GetProducts gp=new GetProducts(CosmeticsSubCatActivity.this);
							 gp.execute("Body n Bath","cosmetics","body lotion");
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
			Intent i=new Intent(CosmeticsSubCatActivity.this,CheckOutActivity.class);
			startActivity(i);
		}
		else if(item.getItemId()==R.id.action_hisotry)
		{
			Intent i=new Intent(CosmeticsSubCatActivity.this,HistoryActivity.class);
			startActivity(i);
		}
		else if(item.getItemId()==R.id.action_offers)
		{
			Intent i=new Intent(CosmeticsSubCatActivity.this,OfferActivity.class);
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
			AlertDialog.Builder adb = new AlertDialog.Builder(CosmeticsSubCatActivity.this);
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
             Intent i= new Intent(CosmeticsSubCatActivity.this,HelpActivity.class);
             startActivity(i);
         }
         else if(item.getItemId()==R.id.action_servicecharge)
         {
             Intent i= new Intent(CosmeticsSubCatActivity.this,ServiceCharge.class);
             startActivity(i);
         }
		else if(item.getItemId()==R.id.action_search)
		{
			Intent i=new Intent(CosmeticsSubCatActivity.this,SearchActivity.class);
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
