package com.lifeline.lifelineforyou;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lifeline.lifelineforyou.dboperation.DBCart;
import com.lifeline.lifelineforyou.dboperation.DBHandlerHistory;
import com.lifeline.lifelineforyou.dboperation.DBHistoryBean;
import com.lifeline.lifelineforyou.dboperation.DBLogin;
import com.lifeline.lifelineforyou.dboperation.DBLoginBean;

public class FinalDetailsPage extends Activity{
	AlertDialog dia;
	String responseText=null;
    //String finalname=null;
	//String finalphone=null;
	 //String finalemail=null;
	 //String finaladdress=null;
	String finalname,finalphone,finalemail,finaladdress;
    ProgressDialog pd;
    ArrayList<String> name;
    ArrayList<String> email;
    ArrayList<String> address;
    ArrayList<String> number;
    EditText etfinalname,etfinalphone,etfinalemail,etfinaladdress;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_final_details);
        etfinalname = (EditText) findViewById(R.id.etfinalName);
        etfinalphone = (EditText) findViewById(R.id.etfinalphone);
        etfinalemail = (EditText) findViewById(R.id.etfinalemail);
        etfinaladdress = (EditText) findViewById(R.id.etfinaladdress);
		final String medicinereq=getIntent().getExtras().getString("Request");
        final String spinnerreq=getIntent().getExtras().getString("extra");
		final EditText etfinalname=(EditText) findViewById(R.id.etfinalName);
		final EditText etfinalphone=(EditText) findViewById(R.id.etfinalphone);
		final EditText etfinalemail=(EditText) findViewById(R.id.etfinalemail);
		final EditText etfinaladdress=(EditText) findViewById(R.id.etfinaladdress);

	    //finalname=etfinalname.getText().toString();
        //Toast.makeText(FinalDetailsPage.this,finalname,Toast.LENGTH_LONG).show();
	    //finalphone=etfinalphone.getText().toString();
	    //finalemail=etfinalemail.getText().toString();
	    //finaladdress=etfinaladdress.getText().toString();
        DBLoginBean dbhb=new DBLoginBean("1","aas","","","");
        DBLogin dbh=new DBLogin(FinalDetailsPage.this);
//		dbh.addHistory(dbhb);
        ArrayList<DBLoginBean> dblist=new ArrayList<DBLoginBean>();
        dblist=dbh.Get_Login();
        if(dblist.size()!=0) {

            name = new ArrayList<String>();
            number = new ArrayList<String>();
            email = new ArrayList<String>();
            address = new ArrayList<String>();
            for(int i=0;i<dblist.size();i++) {
                name.add(dblist.get(i).getUserName());
                email.add(dblist.get(i).getEmail());
                number.add(dblist.get(i).getNumber());
                address.add(dblist.get(i).getAddress());

                etfinalname.setText(name.get(i), TextView.BufferType.NORMAL);
                etfinalphone.setText(number.get(i), TextView.BufferType.NORMAL);
                etfinalemail.setText(email.get(i), TextView.BufferType.NORMAL);
                etfinaladdress.setText(address.get(i), TextView.BufferType.NORMAL);

            }
        }


        // Toast.makeText(FinalDetailsPage.this, name+"\n" + email+"\n"+number+"\n"+address,Toast.LENGTH_LONG).show();

//		Toast.makeText(FinalDetailsPage.this,getIntent().getStringArrayListExtra("product_id").get(0), Toast.LENGTH_LONG).show();
		Button btnplaceorder=(Button) findViewById(R.id.btnfinalplaceorder);
		if(medicinereq.equalsIgnoreCase("Medicine"))
		{
			btnplaceorder.setText("Email Image & Place Order");
		}
		else if(medicinereq.equalsIgnoreCase("E_printout"))
		{
			btnplaceorder.setText("Email File & Place Order");
		}
		btnplaceorder.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				/*Toast.makeText(FinalDetailsPage.this,finalname,Toast.LENGTH_LONG).show();
                Toast.makeText(FinalDetailsPage.this,finalphone,Toast.LENGTH_LONG).show();
                Toast.makeText(FinalDetailsPage.this,finaladdress,Toast.LENGTH_LONG).show();
                Toast.makeText(FinalDetailsPage.this,finalemail,Toast.LENGTH_LONG).show();*/


				if(etfinalname.getText().toString().matches("") ||etfinalphone.getText().toString().matches("") ||etfinalemail.getText().toString().matches("") || etfinaladdress.getText().toString().matches(""))
				{
					
					Toast.makeText(FinalDetailsPage.this,"Fill all the Entries",Toast.LENGTH_LONG).show();
				}
				else
				{
					if(etfinalphone.getText().length()==10)
					{
					if(medicinereq.equalsIgnoreCase("Medicine"))
					{
						AlertDialog.Builder adb = new AlertDialog.Builder(FinalDetailsPage.this);
					    adb.setTitle("Attention");
					    adb.setMessage("Please attach the image file in email on next page");
					    adb.setIcon(R.drawable.logo_actionbar);
					    adb.setPositiveButton("Ok",
						    new AlertDialog.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
								int which) {
								Intent intent = new Intent(Intent.ACTION_SEND);
								intent.setType("text/plain");
								intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"lifelineorders@gmail.com"});
								intent.putExtra(Intent.EXTRA_SUBJECT, "Medicine Order");
								intent.putExtra(Intent.EXTRA_TEXT, "Name:"+etfinalname.getText().toString()+"\n"+"Phone:"+etfinalphone.getText().toString()+"\n"+"Email:"+etfinalemail.getText().toString()+"\n"+"Address:"+etfinaladdress.getText().toString());
								startActivity(Intent.createChooser(intent, "Send Email"));
                                Thread th=new Thread(){

                                    @Override
                                    public void run(){
                                        try
                                        {

                                            Thread.sleep(5000);
                                            FinalDetailsPage.this.runOnUiThread(new Runnable() {

                                                @Override
                                                public void run() {
                                                    AlertDialog.Builder adb = new AlertDialog.Builder(FinalDetailsPage.this);
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

                                        }catch (InterruptedException e) {
                                            // TODO: handle exception
                                        }
                                    }
                                };
                                th.start();

							}
							
						    });
					    dia = adb.create();
			            dia.show();
						
					}
					else if(medicinereq.equalsIgnoreCase("med_det"))
					{
						AlertDialog.Builder adb = new AlertDialog.Builder(FinalDetailsPage.this);
					    adb.setTitle("Attention");
					    adb.setMessage("Please click send button on next page");
					    adb.setIcon(R.drawable.logo_actionbar);
					    adb.setPositiveButton("Ok",
						    new AlertDialog.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
								int which) {
								Intent intent = new Intent(Intent.ACTION_SEND);
								intent.setType("text/plain");
								intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"lifelineorders@gmail.com"});
								intent.putExtra(Intent.EXTRA_SUBJECT, "Medicine Order");
								intent.putExtra(Intent.EXTRA_TEXT, "Name:"+etfinalname.getText().toString()+"\n"+"Phone:"+etfinalphone.getText().toString()+"\n"+"Email:"+etfinalemail.getText().toString()+"\n"+"Address:"+etfinaladdress.getText().toString()
										+"\n\n"+"Medicine Details"+"\n"+getIntent().getExtras().getString("med_list"));
								startActivity(Intent.createChooser(intent, "Send Email"));

                                Thread th=new Thread(){

                                    @Override
                                    public void run(){
                                        try
                                        {

                                            Thread.sleep(5000);
                                            FinalDetailsPage.this.runOnUiThread(new Runnable() {

                                                @Override
                                                public void run() {
                                                    AlertDialog.Builder adb = new AlertDialog.Builder(FinalDetailsPage.this);
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

                                        }catch (InterruptedException e) {
                                            // TODO: handle exception
                                        }
                                    }
                                };
                                th.start();
							}
							
						    });
					    dia = adb.create();
			            dia.show();
						
					}
					else if(medicinereq.equalsIgnoreCase("E_printout"))
					{
						AlertDialog.Builder adb = new AlertDialog.Builder(FinalDetailsPage.this);
					    adb.setTitle("Attention");
					    adb.setMessage("Please attach the file in email on next page");
					    adb.setIcon(R.drawable.logo_actionbar);
					    adb.setPositiveButton("Ok",
						    new AlertDialog.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
								int which) {
								Intent intent = new Intent(Intent.ACTION_SEND);
								intent.setType("text/plain");
								intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"lifelineorders@gmail.com"});
								intent.putExtra(Intent.EXTRA_SUBJECT, "E_printout Order");
                                if(spinnerreq.equalsIgnoreCase("1")){
                                    intent.putExtra(Intent.EXTRA_TEXT, "Name:"+etfinalname.getText().toString()+"\n"+"Phone:"+etfinalphone.getText().toString()+"\n"+"Email:"+etfinalemail.getText().toString()+"\n"+"Address:"+etfinaladdress.getText().toString()+"\n"+"Plan : 1");
                                }else if(spinnerreq.equalsIgnoreCase("2")){
                                    intent.putExtra(Intent.EXTRA_TEXT, "Name:"+etfinalname.getText().toString()+"\n"+"Phone:"+etfinalphone.getText().toString()+"\n"+"Email:"+etfinalemail.getText().toString()+"\n"+"Address:"+etfinaladdress.getText().toString()+"\n"+"Plan : 2");
                                }else if(spinnerreq.equalsIgnoreCase("3")){
                                    intent.putExtra(Intent.EXTRA_TEXT, "Name:"+etfinalname.getText().toString()+"\n"+"Phone:"+etfinalphone.getText().toString()+"\n"+"Email:"+etfinalemail.getText().toString()+"\n"+"Address:"+etfinaladdress.getText().toString()+"\n"+"Plan : 3");
                                }
								startActivity(Intent.createChooser(intent, "Send Email"));
                                Thread th=new Thread(){

                                    @Override
                                    public void run(){
                                        try
                                        {

                                            Thread.sleep(5000);
                                            FinalDetailsPage.this.runOnUiThread(new Runnable() {

                                                @Override
                                                public void run() {
                                                    AlertDialog.Builder adb = new AlertDialog.Builder(FinalDetailsPage.this);
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

                                        }catch (InterruptedException e) {
                                            // TODO: handle exception
                                        }
                                    }
                                };
                                th.start();

							}
							
						    });
					    dia = adb.create();
			            dia.show();
						
					}
					else if(medicinereq.equalsIgnoreCase("from checkout"))
					{	
						sendorder();
//						AlertDialog.Builder adb = new AlertDialog.Builder(FinalDetailsPage.this);
//					    adb.setTitle("Please check shop timings before order");
//					    adb.setMessage("Fruits: 9am to 9pm"+"\n"+"Lava:11am- 11pm"+"\n"+
//					    				"Chinese Food:10am-10pm"+"\n"+"Bakery:10am -10pm"+"\n"
//					    		+"Medicine:9.30am - 10.30pm"+"\n"+"General store:11am-9pm"+"\n"+
//					    				"Stationery/E-Printout:9.30am -10pm..on sunday:-12pm-10pm"
//					    		+"\n"+
//					    		"Sweets:8am-8.30pm"+"\n"+
//					    				"Cosmetics:9am -9pm(on sunday:-4pm - 8pm)"+"\n"+
//					    		"Nfs:8.pm-.1.am"+"\n"+"Stu-c:9.am-9 pm"+"\nDark Moon:- 5 pm- 1 am");
//					    adb.setIcon(R.drawable.logo_actionbar);
//					    adb.setPositiveButton("",
//						    new AlertDialog.OnClickListener() {
//							@Override
//							public void onClick(DialogInterface dialog,
//								int which) {
								
//							}
//							
//						    });
//					    adb.setNegativeButton("Cancel", new AlertDialog.OnClickListener() {
//							@Override
//							public void onClick(DialogInterface dialog,
//								int which) {
//								 Intent homeIntent = new Intent(FinalDetailsPage.this, MainActivity.class);
//						            homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//						            startActivity(homeIntent);
//								 
//							}
//							
//						    });
//					    dia = adb.create();
//			            dia.show();
//						
					}
					}
					else
					{
						AlertDialog.Builder adb = new AlertDialog.Builder(FinalDetailsPage.this);
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

		
	}
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
//		return true;
//	}
	public void sendorder()
	{
		GetUserData gt=new GetUserData(getIntent().getExtras().getStringArrayList("product_id"),getIntent().getExtras().getStringArrayList("qty"));

        gt.execute();
	}
	private class GetUserData extends AsyncTask<Void, Void, Void>
	{
		ProgressDialog pDialog;
		ArrayList<String> product_id, qty;

		public GetUserData(ArrayList<String> product_id,ArrayList<String> qty) {
			this.product_id=product_id;
			this.qty=qty;
		}
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			    pDialog = new ProgressDialog(FinalDetailsPage.this);
		        pDialog.setMessage("Sending your order");
		        pDialog.setCancelable(false);
                pDialog.show();
            /*for(int i=0;i<product_id.size();i++)
            {
                //JSONObject jorder=new JSONObject();
                //jorder.put("product_id",product_id.get(i));
                //jorder.put("qty",qty.get(i));
                //jarr.put(jorder);
                Toast.makeText(FinalDetailsPage.this,product_id.get(i)+"=" + qty.get(i),Toast.LENGTH_LONG).show();

            }*/
        }
		
		@Override
		protected Void doInBackground(Void... params) {
		
        	JSONObject j1=new JSONObject();
            //Toast.makeText(FinalDetailsPage.this,qty.get(i),Toast.LENGTH_LONG).show();
        	//JSONObject j=new JSONObject();
        	JSONArray jarr=new JSONArray();
        	JSONObject jobjfinal=new JSONObject();
        	try {

        		j1.put("phone",etfinalphone.getText().toString());
        		j1.put("name",etfinalname.getText().toString());
        		j1.put("email", etfinalemail.getText().toString());
        		j1.put("address",etfinaladdress.getText().toString());
        		jarr.put(j1);
                //jobjfinal.put("order",jarr);
        		for(int i=0;i<product_id.size();i++)
        		{
        			JSONObject jorder=new JSONObject();
        			jorder.put("product_id",product_id.get(i));
            		jorder.put("qty",qty.get(i));
            		jarr.put(jorder);
                   //
        		}
      
            	jobjfinal.put("order",jarr);
            	

			} catch (JSONException e) {
	
				e.printStackTrace();
			}
        	DefaultHttpClient httpclient = new DefaultHttpClient();
        	HttpPost httppostreq = new HttpPost("http://lifelineforyou.com/placeorder.php");
        	try {
				StringEntity se = new StringEntity(jobjfinal.toString());
				se.setContentType("application/json;charset=UTF-8");
				se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,"application/json;charset=UTF-8"));
				httppostreq.setEntity(se);
				HttpResponse httpresponse = httpclient.execute(httppostreq);
				
				try {
				responseText = EntityUtils.toString(httpresponse.getEntity());


						}catch (Exception e) {
				e.printStackTrace();
				Log.i("Parse Exception", e + "");

			} 
        	}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		@Override
		protected void onPostExecute(Void result) {

			super.onPostExecute(result);	
			String resp[]=responseText.split(": ");
			resp[1].replaceAll("\\s","");
			Date date=new Date();
 			String newDate=new SimpleDateFormat("dd-MM-yyyy").format(date);
			DBHistoryBean dbhb=new DBHistoryBean(Integer.parseInt(resp[1]),getResources().getString(R.string.Rs)+" "+getIntent().getExtras().getString("total"),newDate);
			DBHandlerHistory dbh=new DBHandlerHistory(FinalDetailsPage.this);
			dbh.addHistory(dbhb);
			Intent i=new Intent(FinalDetailsPage.this,ThankYouActivity.class);
			i.putExtra("orderNo", "#"+resp[1]);
			i.putExtra("total",getResources().getString(R.string.Rs)+" "+ getIntent().getExtras().getString("total"));
			i.putExtra("date", newDate);
			startActivity(i);
			DBCart dbc=new DBCart(FinalDetailsPage.this);
			dbc.Delete_All_CART();
			pDialog.dismiss();
		}
		
		
	}

}
