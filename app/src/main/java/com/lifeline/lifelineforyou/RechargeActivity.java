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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RechargeActivity extends Activity {

	AlertDialog dia;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		overridePendingTransition(R.anim.animation_enter, R.anim.animation_leave);
		setContentView(R.layout.activity_recharge);
		ActionBar ab=getActionBar();
		ab.setTitle("Recharge");
		ab.setHomeButtonEnabled(true);
		ab.setDisplayHomeAsUpEnabled(true);
		final EditText etopname=(EditText) findViewById(R.id.spinner_operatorname);
		final EditText etcontact=(EditText) findViewById(R.id.et_contactNumber);
		final EditText etrechagretype=(EditText) findViewById(R.id.spinner_rechargetype);
		final EditText etamount=(EditText) findViewById(R.id.et_amount);
		final EditText etname=(EditText) findViewById(R.id.et_recharge_name);
		final EditText etphonedetail=(EditText) findViewById(R.id.et_phonedetails);
		final EditText etemail=(EditText) findViewById(R.id.et_email);
		final EditText etaddress=(EditText) findViewById(R.id.et_address);
		Button btnsend=(Button) findViewById(R.id.btnrechargesend);

        /*SimpleDateFormat formatDate = new SimpleDateFormat("hh:mm a");
        //formatDate.setTimeZone(userContext.getUser().getTimeZone());
        String currentdate = formatDate.format(new Date());
        String open= "09:00 AM";
        String close = "01:00 AM";
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
        //if(date.compareTo(date1) > 0  || date.compareTo(date2) <0 ) {
            btnsend.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (etname.getText().toString().matches("") || etphonedetail.getText().toString().matches("") || etemail.getText().toString().matches("") || etaddress.getText().toString().matches("")
                            || etopname.getText().toString().matches("") || etcontact.getText().toString().matches("") || etamount.getText().toString().matches("") || etrechagretype.getText().toString().matches("")) {
                        Toast.makeText(RechargeActivity.this, "Fill all the Entries", Toast.LENGTH_LONG).show();
                    } else {
                        if (etphonedetail.getText().length() == 10 && etcontact.getText().length() == 10) {
                            AlertDialog.Builder adb = new AlertDialog.Builder(RechargeActivity.this);
                            adb.setTitle("Attention");
                            adb.setMessage("Please click send button on next page after selecting email account");
                            adb.setIcon(R.drawable.logo_actionbar);
                            adb.setPositiveButton("Ok",
                                    new AlertDialog.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog,
                                                            int which) {


                                            Intent intent = new Intent(Intent.ACTION_SEND);
                                            intent.setType("text/plain");
                                            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"lifelineorders@gmail.com"});
                                            intent.putExtra(Intent.EXTRA_SUBJECT, "Recharge Order");
                                            intent.putExtra(Intent.EXTRA_TEXT, "Name:" + etname.getText().toString() + "\n" + "Phone:" + etphonedetail.getText().toString() + "\n" + "Email:" + etemail.getText().toString() + "\n" + "Address:" + etaddress.getText().toString()
                                                    + "\n\n" + "Recharge Details" + "\n" + "Operator Name:" + etopname.getText().toString() + "\n" + "Phone Number:" + etcontact.getText().toString() + "\n" + "Recharge Type : " + etrechagretype.getText().toString() + "\n" + "Amount:" + etamount.getText().toString());
                                            startActivity(Intent.createChooser(intent, "Send Email"));
                                            Thread th = new Thread() {

                                                @Override
                                                public void run() {
                                                    try {

                                                        Thread.sleep(5000);
                                                        RechargeActivity.this.runOnUiThread(new Runnable() {

                                                            @Override
                                                            public void run() {
                                                                AlertDialog.Builder adb = new AlertDialog.Builder(RechargeActivity.this);
                                                                adb.setTitle("Success");
                                                                adb.setMessage("Your order has been sent");
                                                                adb.setIcon(R.drawable.logo_actionbar);
                                                                adb.setPositiveButton("Ok",
                                                                        new AlertDialog.OnClickListener() {
                                                                            @Override
                                                                            public void onClick(DialogInterface dialog,
                                                                                                int which) {
                                                                                //Intent homeIntent = new Intent(this, MainActivity.class);
                                                                            }
                                                                        });
                                                                dia = adb.create();
                                                                dia.show();
                                                            }
                                                        });

                                                    } catch (InterruptedException e) {
                                                        // TODO: handle exception
                                                    }
                                                }
                                            };
                                            th.start();


                                        }

                                    });
                            dia = adb.create();
                            dia.show();
                        } else {
                            AlertDialog.Builder adb = new AlertDialog.Builder(RechargeActivity.this);
                            adb.setTitle("Attention");
                            adb.setMessage("Please enter 10 digit only!");
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
                }


            });
        /*}else {

            AlertDialog.Builder adb = new AlertDialog.Builder(RechargeActivity.this);
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
		
//		Spinner spinner = (Spinner) findViewById(R.id.spinner_operatorname);
//		
//		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
//		        R.array.operator_array, android.R.layout.simple_spinner_item);
//		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//		spinner.setAdapter(adapter);
      
//		Spinner spinner_rechargetype = (Spinner) findViewById(R.id.spinner_rechargetype);
//		
//		ArrayAdapter<CharSequence> adapterrechagretype = ArrayAdapter.createFromResource(this,
//		        R.array.recharge_type, android.R.layout.simple_spinner_item);
//		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//		spinner_rechargetype.setAdapter(adapterrechagretype);

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
		 else if(item.getItemId()==android.R.id.home)
		 {
            Intent homeIntent = new Intent(this, MainActivity.class);
            homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(homeIntent);
		 }
		 else if(item.getItemId()==R.id.action_cart)
		{
			Intent i=new Intent(RechargeActivity.this,CheckOutActivity.class);
			startActivity(i);
		}
		else if(item.getItemId()==R.id.action_hisotry)
		{
			Intent i=new Intent(RechargeActivity.this,HistoryActivity.class);
			startActivity(i);
		}
		else if(item.getItemId()==R.id.action_offers)
		{
			Intent i=new Intent(RechargeActivity.this,OfferActivity.class);
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
			AlertDialog.Builder adb = new AlertDialog.Builder(RechargeActivity.this);
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
             Intent i= new Intent(RechargeActivity.this,HelpActivity.class);
             startActivity(i);
         }
         else if(item.getItemId()==R.id.action_servicecharge)
         {
             Intent i= new Intent(RechargeActivity.this,ServiceCharge.class);
             startActivity(i);
         }
		else if(item.getItemId()==R.id.action_search)
		{
			Intent i=new Intent(RechargeActivity.this,SearchActivity.class);
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
