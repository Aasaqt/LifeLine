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

public class FoodSubCatActivity extends Activity {

	ImageView ivsubfoodcall;
	ListViewAdapter listviewadapter ;
    AlertDialog dia;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sub_food);ActionBar ab=getActionBar();
		ab.setTitle("Food");
		ab.setHomeButtonEnabled(true);
		ab.setDisplayHomeAsUpEnabled(true);
		ivsubfoodcall=(ImageView) findViewById(R.id.ivsubfoodcall);
        ivsubfoodcall.setOnClickListener(new OnClickListener() {
			
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
        String opennfs= "07:00 PM";
        String closenfs = "01:00 AM";
        String openstuc= "09:00 AM";
        String closestuc = "09:00 PM";
        String openlava= "11:00 AM";
        String closelava = "11:00 PM";
        String openchinese= "10:00 AM";
        String closechinese = "10:00 PM";
        String opendark= "05:00 PM";
        String closedark = "01:00 AM";
        String opensweets= "09:00 AM";
        String closesweets = "08:30 PM";

        //Toast.makeText(BakeryActivity.this,currentdate +"\n" + open +"\n" +close,Toast.LENGTH_LONG).show();
        //long timecurrent = 0,timeopen = 0,timeclose = 0;
        Date date = null,date1 = null,date2 = null,date3 = null,date4 = null,date5 = null,date6 = null,date7 = null,date8 = null,date9 = null,date10 = null,date11 = null,date12 = null;
        try {
            date=formatDate.parse(currentdate);
            date1=formatDate.parse(opennfs);
            date2= formatDate.parse(closenfs);
            date3= formatDate.parse(openstuc);
            date4= formatDate.parse(closestuc);
            date5= formatDate.parse(openlava);
            date6= formatDate.parse(closelava);
            date7= formatDate.parse(openchinese);
            date8= formatDate.parse(closechinese);
            date9= formatDate.parse(opendark);
            date10= formatDate.parse(closedark);
            date11= formatDate.parse(opensweets);
            date12= formatDate.parse(closesweets);


            // Toast.makeText(BakeryActivity.this,date +"\n" + date1 +"\n" +date2,Toast.LENGTH_LONG).show();
        } catch (ParseException e) {
            e.printStackTrace();
        }*/


		ListView lvsubfood=(ListView) findViewById(R.id.subfoodlistview);
	   
         if(getIntent().getExtras().getString("subcat2").equalsIgnoreCase("nfs"))
 		{
 			listviewadapter = new ListViewAdapter(this, new String[] {"DINNER","BREAKFAST","ROTI & RICE"
 	        		,"CHINESE & VEG","SNACKS."});
 			  lvsubfood.setAdapter(listviewadapter);
         //   if(date.compareTo(date1) > 0  || date.compareTo(date2) <0 ) {
                lvsubfood.setOnItemClickListener(new OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {
                        switch (position) {
                            case 0: {
                                GetProducts gp = new GetProducts(FoodSubCatActivity.this);
                                gp.execute("NFS", "nfs", "DINNER");
                                break;
                            }
                            case 1: {
                                GetProducts gp = new GetProducts(FoodSubCatActivity.this);
                                gp.execute("NFS", "nfs", "BREAKFAST");
                                break;
                            }
                            case 2: {
                                GetProducts gp = new GetProducts(FoodSubCatActivity.this);
                                gp.execute("NFS", "nfs", "ROTI & RICE");
                                break;
                            }
                            case 3: {
                                GetProducts gp = new GetProducts(FoodSubCatActivity.this);
                                gp.execute("NFS", "nfs", "CHINESE & VEG");
                                break;
                            }
                            case 4: {
                                GetProducts gp = new GetProducts(FoodSubCatActivity.this);
                                gp.execute("NFS", "NFS", "Snacks");
                                break;
                            }


                            default:
                                break;
                        }

                    }
                });
           // }else {

             /*   AlertDialog.Builder adb = new AlertDialog.Builder(FoodSubCatActivity.this);
                adb.setTitle("Attention");
                adb.setMessage("The store is closed for now and timing for delivery of this item is "+opennfs+" to "+closenfs);
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
 		else if(getIntent().getExtras().getString("subcat2").equalsIgnoreCase("stu-c"))
 		{
 			listviewadapter = new ListViewAdapter(this, new String[] {"LUNCH/DINNER","FAST FOOD"});
 			  lvsubfood.setAdapter(listviewadapter);
            //if(date.compareTo(date3) > 0  && date.compareTo(date4) <0 ) {
                lvsubfood.setOnItemClickListener(new OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {
                        switch (position) {
                            case 0: {
                                GetProducts gp = new GetProducts(FoodSubCatActivity.this);
                                gp.execute("STU-C FRESH BITE", "stu_c", "LUNCH/DINNER");
                                break;
                            }
                            case 1: {
                                GetProducts gp = new GetProducts(FoodSubCatActivity.this);
                                gp.execute("STU-C FRESH BITE", "stu_c", "FAST FOOD");
                                break;
                            }
                            default:
                                break;
                        }

                    }
                });
            //}else {

               /* AlertDialog.Builder adb = new AlertDialog.Builder(FoodSubCatActivity.this);
                adb.setTitle("Attention");
                adb.setMessage("The store is closed for now and timing for delivery of this item is "+openstuc+" to "+closestuc);
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
 		else if(getIntent().getExtras().getString("subcat2").equalsIgnoreCase("lava"))
 		{
 			listviewadapter = new ListViewAdapter(this, new String[] {"MUTTON SPECIAL","VEG. SOUPS",
 					"NON VEG. SOUPS","TANDOORI VEG. SNACKS","CHINESE STARTERS",
 					"NON.VEG. TANDOORI SNACKS","FISH","VEG. MAIN COURSE",
 					"NON VEG. MAIN COURSE","ROTI/NAAN","COMBOS",
 					"COOKED RICE","RAITA","CHINESE MAIN COURSE","VEG NOODLES",
 					"NON. VEG. NOODLES","CHOUPSEY.","MOMOS","WRAPS N ROLLS"});
 			  lvsubfood.setAdapter(listviewadapter);
            //if(date.compareTo(date5) > 0  && date.compareTo(date6) <0 ) {
                lvsubfood.setOnItemClickListener(new OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {
                        switch (position) {
                            case 0: {
                                GetProducts gp = new GetProducts(FoodSubCatActivity.this);
                                gp.execute("LAVA", "lava", "MUTTON SPECIAL");
                                break;
                            }
                            case 1: {
                                GetProducts gp = new GetProducts(FoodSubCatActivity.this);
                                gp.execute("LAVA", "lava", "VEG. SOUPS");
                                break;
                            }
                            case 2: {
                                GetProducts gp = new GetProducts(FoodSubCatActivity.this);
                                gp.execute("LAVA", "lava", "NON VEG. SOUPS");
                                break;
                            }
                            case 3: {
                                GetProducts gp = new GetProducts(FoodSubCatActivity.this);
                                gp.execute("LAVA", "lava", "TANDOORI VEG. SNACKS");
                                break;
                            }
                            case 4: {
                                GetProducts gp = new GetProducts(FoodSubCatActivity.this);
                                gp.execute("LAVA", "lava", "CHINESE STARTERS");
                                break;
                            }
                            case 5: {
                                GetProducts gp = new GetProducts(FoodSubCatActivity.this);
                                gp.execute("LAVA", "lava", "NON.VEG. TANDOORI SNACKS");
                                break;
                            }
                            case 6: {
                                GetProducts gp = new GetProducts(FoodSubCatActivity.this);
                                gp.execute("LAVA", "lava", "FISH");
                                break;
                            }
                            case 7: {
                                GetProducts gp = new GetProducts(FoodSubCatActivity.this);
                                gp.execute("LAVA", "lava", "VEG. MAIN COURSE");
                                break;
                            }
                            case 8: {
                                GetProducts gp = new GetProducts(FoodSubCatActivity.this);
                                gp.execute("LAVA", "lava", "NON VEG. MAIN COURSE");
                                break;
                            }
                            case 9: {
                                GetProducts gp = new GetProducts(FoodSubCatActivity.this);
                                gp.execute("LAVA", "lava", "ROTI/NAAN");
                                break;
                            }
                            case 10: {
                                GetProducts gp = new GetProducts(FoodSubCatActivity.this);
                                gp.execute("LAVA", "lava", "COMBOS");
                                break;
                            }
                            case 11: {
                                GetProducts gp = new GetProducts(FoodSubCatActivity.this);
                                gp.execute("LAVA", "lava", "COOKED RICE");
                                break;
                            }

                            case 12: {
                                GetProducts gp = new GetProducts(FoodSubCatActivity.this);
                                gp.execute("LAVA", "lava", "RAITA");
                                break;
                            }
                            case 13: {
                                GetProducts gp = new GetProducts(FoodSubCatActivity.this);
                                gp.execute("LAVA", "lava", "CHINESE MAIN COURSE");
                                break;
                            }
                            case 14: {
                                GetProducts gp = new GetProducts(FoodSubCatActivity.this);
                                gp.execute("LAVA", "lava", "VEG NOODLES");
                                break;
                            }
                            case 15: {
                                GetProducts gp = new GetProducts(FoodSubCatActivity.this);
                                gp.execute("LAVA", "lava", "NON. VEG. NOODLES");
                                break;
                            }
                            case 16: {
                                GetProducts gp = new GetProducts(FoodSubCatActivity.this);
                                gp.execute("LAVA", "lava", "CHOUPSEY1");
                                break;
                            }
                            case 17: {
                                GetProducts gp = new GetProducts(FoodSubCatActivity.this);
                                gp.execute("LAVA", "lava", "MOMOS");
                                break;
                            }
                            case 18: {
                                GetProducts gp = new GetProducts(FoodSubCatActivity.this);
                                gp.execute("LAVA", "lava", "WRAPS N ROLLS");
                                break;
                            }


                            default:
                                break;
                        }

                    }
                });
            //}else {

              /*  AlertDialog.Builder adb = new AlertDialog.Builder(FoodSubCatActivity.this);
                adb.setTitle("Attention");
                adb.setMessage("The store is closed for now and timing for delivery of this item is "+openlava+" to "+closelava);
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
 		else if(getIntent().getExtras().getString("subcat2").equalsIgnoreCase("chinese food"))
 		{
 			listviewadapter = new ListViewAdapter(this, new String[] {"NOODLES","THUPPA","SOUPS","SPRING ROLLS","RICE."
 					,"SNACKS..","VEGETABLES","CHOUPSEY"});
 			  lvsubfood.setAdapter(listviewadapter);
            //if(date.compareTo(date7) > 0  && date.compareTo(date8) <0 ) {
                lvsubfood.setOnItemClickListener(new OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {
                        switch (position) {
                            case 0: {
                                GetProducts gp = new GetProducts(FoodSubCatActivity.this);
                                gp.execute("CHINESE FOOD CORNER", "chinese_food", "NOODLES");
                                break;
                            }
                            case 1: {
                                GetProducts gp = new GetProducts(FoodSubCatActivity.this);
                                gp.execute("CHINESE FOOD CORNER", "chinese_food", "THUPPA");
                                break;
                            }
                            case 2: {
                                GetProducts gp = new GetProducts(FoodSubCatActivity.this);
                                gp.execute("CHINESE FOOD CORNER", "chinese_food", "SOUPS");
                                break;
                            }
                            case 3: {
                                GetProducts gp = new GetProducts(FoodSubCatActivity.this);
                                gp.execute("CHINESE FOOD CORNER", "chinese_food", "SPRING ROLLS");
                                break;
                            }
                            case 4: {
                                GetProducts gp = new GetProducts(FoodSubCatActivity.this);
                                gp.execute("CHINESE FOOD CORNER", "chinese_food", "RICE1");
                                break;
                            }
                            case 5: {
                                GetProducts gp = new GetProducts(FoodSubCatActivity.this);
                                gp.execute("CHINESE FOOD CORNER", "chinese_food", "SNACKS2");
                                break;
                            }
                            case 6: {
                                GetProducts gp = new GetProducts(FoodSubCatActivity.this);
                                gp.execute("CHINESE FOOD CORNER", "chinese_food", "VEGETABLES");
                                break;
                            }
                            case 7: {
                                GetProducts gp = new GetProducts(FoodSubCatActivity.this);
                                gp.execute("CHINESE FOOD CORNER", "chinese_food", "CHOUPSEY");
                                break;
                            }

                            default:
                                break;
                        }

                    }
                });
            //}else {

              /*  AlertDialog.Builder adb = new AlertDialog.Builder(FoodSubCatActivity.this);
                adb.setTitle("Attention");
                adb.setMessage("The store is closed for now and timing for delivery of this item is "+openchinese+" to "+closechinese);
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
 		else if(getIntent().getExtras().getString("subcat2").equalsIgnoreCase("pu_sweets"))
 		{
 			listviewadapter = new ListViewAdapter(this, new String[] {"Sweets","Snacks"});
 			  lvsubfood.setAdapter(listviewadapter);
            //if(date.compareTo(date11) > 0  && date.compareTo(date12) <0 ) {
                lvsubfood.setOnItemClickListener(new OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {
                        switch (position) {
                            case 0: {
                                GetProducts gp = new GetProducts(FoodSubCatActivity.this);
                                gp.execute("sweets", "pu_sweets", "");
                                break;

                            }
                            case 1: {
                                GetProducts gp = new GetProducts(FoodSubCatActivity.this);
                                gp.execute("snacks", "pu_sweets", "");
                                break;
                            }

                            default:
                                break;
                        }

                    }
                });
            //}else {

              /*  AlertDialog.Builder adb = new AlertDialog.Builder(FoodSubCatActivity.this);
                adb.setTitle("Attention");
                adb.setMessage("The store is closed for now and timing for delivery of this item is "+opensweets+" to "+closesweets);
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
 		else if(getIntent().getExtras().getString("subcat2").equalsIgnoreCase("dark_moon_kitchen"))
 		{
 			listviewadapter = new ListViewAdapter(this, new String[] {"SOUPS","TANDOORI KHAZANA","INDIAN VEG","INDIAN NON VEG","BIRYANI"
 					,"COMBOS","ITALIAN PASTA ","ITALIAN PIZZA","RICE & BREADS","ADD ONS","DARK MOON SPECIAL","CHINESE","BURGERS & SANDWICHES","WRAPS & ROLLS"
 					,"BEVERAGES","DESSERTS"});
 			  lvsubfood.setAdapter(listviewadapter);
            //if(date.compareTo(date9) > 0  || date.compareTo(date10) <0 ) {
                lvsubfood.setOnItemClickListener(new OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {
                        switch (position) {
                            case 0: {
                                GetProducts gp = new GetProducts(FoodSubCatActivity.this);
                                gp.execute("SOUPS__", "dark_moon_kitchen", "");
                                break;
                            }
                            case 1: {
                                GetProducts gp = new GetProducts(FoodSubCatActivity.this);
                                gp.execute("TANDOORI KHAZANA", "dark_moon_kitchen", "");
                                break;
                            }
                            case 2: {
                                GetProducts gp = new GetProducts(FoodSubCatActivity.this);
                                gp.execute("INDIAN VEG__", "dark_moon_kitchen", "");
                                break;
                            }
                            case 3: {
                                GetProducts gp = new GetProducts(FoodSubCatActivity.this);
                                gp.execute("INDIAN NON VEG__", "dark_moon_kitchen", "");
                                break;
                            }
                            case 4: {
                                GetProducts gp = new GetProducts(FoodSubCatActivity.this);
                                gp.execute("BIRYANI__", "dark_moon_kitchen", "");
                                break;
                            }
                            case 5: {
                                GetProducts gp = new GetProducts(FoodSubCatActivity.this);
                                gp.execute("COMBOS__", "dark_moon_kitchen", "");
                                break;
                            }
                            case 6: {
                                GetProducts gp = new GetProducts(FoodSubCatActivity.this);
                                gp.execute("ITALIAN", "dark_moon_kitchen", "PASTA_", "");
                                //gp.execute("ITALIAN","dark_moon_kitchen","PIZZA_(8 SLICES)");
                                break;
                            }
                            case 7: {
                                GetProducts gp = new GetProducts(FoodSubCatActivity.this);
                                //gp.execute("ITALIAN","dark_moon_kitchen","PASTA_","PIZZA_(8 SLICES)");
                                gp.execute("ITALIAN", "dark_moon_kitchen", "PIZZA_(8 SLICES)");
                                break;
                            }
                            case 8: {
                                GetProducts gp = new GetProducts(FoodSubCatActivity.this);
                                gp.execute("RICE & BREADS__", "dark_moon_kitchen", "");
                                break;
                            }
                            case 9: {
                                GetProducts gp = new GetProducts(FoodSubCatActivity.this);
                                gp.execute("ADD ONS__", "dark_moon_kitchen", "");
                                break;
                            }
                            case 10: {
                                GetProducts gp = new GetProducts(FoodSubCatActivity.this);
                                gp.execute("DARK MOON SPECIAL", "dark_moon_kitchen", "");
                                break;
                            }
                            case 11: {
                                GetProducts gp = new GetProducts(FoodSubCatActivity.this);
                                gp.execute("CHINESE__", "dark_moon_kitchen", "");
                                break;
                            }
                            case 12: {
                                GetProducts gp = new GetProducts(FoodSubCatActivity.this);
                                gp.execute("BURGERS & SANDWICHES", "dark_moon_kitchen", "");
                                break;
                            }
                            case 13: {
                                GetProducts gp = new GetProducts(FoodSubCatActivity.this);
                                gp.execute("WRAPS & ROLLS__", "dark_moon_kitchen", "");
                                break;
                            }
                            case 14: {
                                GetProducts gp = new GetProducts(FoodSubCatActivity.this);
                                gp.execute("BEVERAGES__", "dark_moon_kitchen", "");
                                break;
                            }
                            case 15: {
                                GetProducts gp = new GetProducts(FoodSubCatActivity.this);
                                gp.execute("DESSERTS__", "dark_moon_kitchen", "");
                                break;
                            }


                            default:
                                break;
                        }

                    }
                });
            //}else {

               /* AlertDialog.Builder adb = new AlertDialog.Builder(FoodSubCatActivity.this);
                adb.setTitle("Attention");
                adb.setMessage("The store is closed for now and timing for delivery of this item is "+opendark+" to "+closedark);
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
			Intent i=new Intent(FoodSubCatActivity.this,CheckOutActivity.class);
			startActivity(i);
		}
		else if(item.getItemId()==R.id.action_hisotry)
		{
			Intent i=new Intent(FoodSubCatActivity.this,HistoryActivity.class);
			startActivity(i);
		}
		else if(item.getItemId()==R.id.action_offers)
		{
			Intent i=new Intent(FoodSubCatActivity.this,OfferActivity.class);
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
			AlertDialog.Builder adb = new AlertDialog.Builder(FoodSubCatActivity.this);
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
             Intent i= new Intent(FoodSubCatActivity.this,HelpActivity.class);
             startActivity(i);
         }
         else if(item.getItemId()==R.id.action_servicecharge)
         {
             Intent i= new Intent(FoodSubCatActivity.this,ServiceCharge.class);
             startActivity(i);
         }
		else if(item.getItemId()==R.id.action_search)
		{
			Intent i=new Intent(FoodSubCatActivity.this,SearchActivity.class);
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
