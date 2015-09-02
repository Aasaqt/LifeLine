package com.lifeline.lifelineforyou;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends Activity {
	AlertDialog dia;
	
	String[] itemName={"Stationary","General Store","Cosmetics","Fruits","     Food","  Medicine","    Bakery","e-printout"};
	ImageView ivmaincall;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		overridePendingTransition(R.anim.animation_enter, R.anim.animation_leave);
		setContentView(R.layout.activity_main);
		getOverflowMenu();
		GridView gridView = (GridView)findViewById(R.id.gridview);
//		gridView.setAdapter(new GridViewAdapter(MainActivity.this, itemName));
        gridView.setAdapter(new MyAdapter(this));
        gridView.setOnItemClickListener(new OnItemClickListener() 
        {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) 
            {

                if (position==0)
					{
            		 Intent intent = new Intent(MainActivity.this,StationaryActivity.class);
	                    startActivity(intent);
					}
					else if (position==1)
					{
					        
			            Intent intent = new Intent(MainActivity.this,GeneralStoreActivity.class);
	                    startActivity(intent);
					}
					else if (position==2)
					{
						 Intent intent = new Intent(MainActivity.this,CosmeticsActivity.class);
		                    startActivity(intent);
					}
					else if (position==3)
					{
                        GetProducts gp=new GetProducts(MainActivity.this);
                        gp.execute("","fruits","");

					}
					else if (position==4)
					{
						 Intent intent = new Intent(MainActivity.this,FoodActivity.class);
		                    startActivity(intent);
					}
					else if (position==5)
					{
						 Intent intent = new Intent(MainActivity.this,HealthActivity.class);
		                    startActivity(intent);
					}
					else if (position==6)
					{
						 Intent intent = new Intent(MainActivity.this,BakeryActivity.class);
		                    startActivity(intent);
					}
					
					/*else if (position==7)
					{
						 Intent intent = new Intent(MainActivity.this,RechargeActivity.class);
		                    startActivity(intent);
					}*/
					else if (position==7)
					{
						 Intent intent = new Intent(MainActivity.this,E_printoutActivity.class);
		                    startActivity(intent);
					}
					/*else if (position==9)
					{
                        Intent intent = new Intent(MainActivity.this,PUSweetsActivity.class);
                        startActivity(intent);
					}*/
            	  
            }
        });
        ivmaincall=(ImageView) findViewById(R.id.ivmaincall);
        ivmaincall.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 Intent callIntent = new Intent(Intent.ACTION_CALL);
				 callIntent.setData(Uri.parse("tel:07307123123"));
				 startActivity(callIntent);
				
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
		if(item.getItemId()==R.id.action_cart)
		{
			Intent i=new Intent(MainActivity.this,CheckOutActivity.class);
			startActivity(i);
		}
		else if(item.getItemId()==R.id.action_hisotry)
		{
			Intent i=new Intent(MainActivity.this,HistoryActivity.class);
			startActivity(i);
		}
		else if(item.getItemId()==R.id.action_offers)
		{
			Intent i=new Intent(MainActivity.this,OfferActivity.class);
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
			AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
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
			Intent i= new Intent(MainActivity.this,HelpActivity.class);
			startActivity(i);
		}
        else if(item.getItemId()==R.id.action_servicecharge)
        {
            Intent i= new Intent(MainActivity.this,ServiceCharge.class);
            startActivity(i);
        }
		else if(item.getItemId()==R.id.action_search)
		{
			Intent i=new Intent(MainActivity.this,SearchActivity.class);
			startActivity(i);
		}
		return super.onOptionsItemSelected(item);
	}
	private class MyAdapter extends BaseAdapter
    {
        private List<Item> items = new ArrayList<Item>();
        private LayoutInflater inflater;

        public MyAdapter(Context context)
        {
            inflater = LayoutInflater.from(context);
            items.add(new Item("Stationary", R.drawable.icon_ststionary));
            items.add(new Item("General Store", R.drawable.icon_general_store));
            items.add(new Item("Cosmetics", R.drawable.icon_cosmetics));
            items.add(new Item("     Fruits", R.drawable.icon_fruits));
            items.add(new Item("     Food", R.drawable.icon_food));
            items.add(new Item("  Medicine", R.drawable.icon_medicine));
            items.add(new Item("    Bakery", R.drawable.icon_bakery));
            //items.add(new Item(" Recharge", R.drawable.icon_recharge));
            items.add(new Item("  Printouts", R.drawable.icon_printouts));
            //items.add(new Item("Custom Order", R.drawable.sports));
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int i)
        {
            return items.get(i);
        }

        @Override
        public long getItemId(int i)
        {
            return items.get(i).drawableId;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup)
        {
            View v = view;
            ImageView picture;
            TextView name;

            if(v == null)
            {
               v = inflater.inflate(R.layout.home_gridview_item, viewGroup, false);
               v.setTag(R.id.grid_item_image, v.findViewById(R.id.grid_item_image));
               v.setTag(R.id.grid_item_label, v.findViewById(R.id.grid_item_label));
            }
            
            picture = (ImageView)v.getTag(R.id.grid_item_image);
            name = (TextView)v.getTag(R.id.grid_item_label);
            	
            Item item = (Item)getItem(i);
            picture.setImageResource(item.drawableId);
            name.setText(item.name);
            
            return v;
        }

      
    }
    private class Item
    {
        final String name;
        int drawableId;

        Item(String name, int drawableId)
        {
            this.name = name;
            this.drawableId = drawableId;
        }
    }
    
    private void getOverflowMenu() {

        try {
           ViewConfiguration config = ViewConfiguration.get(this);
           Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
           if(menuKeyField != null) {
               menuKeyField.setAccessible(true);
               menuKeyField.setBoolean(config, false);
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
     }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.anim_back_from, R.anim.anim_back_to);
    }
}
