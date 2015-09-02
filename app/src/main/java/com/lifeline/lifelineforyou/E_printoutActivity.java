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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class E_printoutActivity extends Activity implements AdapterView.OnItemSelectedListener {
    private Spinner spinner;
    private static final String[] paths = {"1", "2", "3"};
    Intent i;
    Button btnsendfile;
    AlertDialog dia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.animation_enter, R.anim.animation_leave);
        setContentView(R.layout.activity_e_printout);
        ActionBar ab = getActionBar();
        ab.setTitle("E Printout");
        ab.setHomeButtonEnabled(true);
        ab.setDisplayHomeAsUpEnabled(true);
        btnsendfile = (Button) findViewById(R.id.btnsendprintfile);
        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(E_printoutActivity.this,
                android.R.layout.simple_spinner_item, paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

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
        }
        if(date.compareTo(date1) > 0  && date.compareTo(date2) <0 ) {*/
            spinner.setOnItemSelectedListener(this);
        //}else {

          /*  AlertDialog.Builder adb = new AlertDialog.Builder(E_printoutActivity.this);
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
        if (item.getItemId() == android.R.id.home) {
            Intent homeIntent = new Intent(this, MainActivity.class);
            homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(homeIntent);
        } else if (item.getItemId() == R.id.action_cart) {
            Intent i = new Intent(E_printoutActivity.this, CheckOutActivity.class);
            startActivity(i);
        } else if (item.getItemId() == R.id.action_hisotry) {
            Intent i = new Intent(E_printoutActivity.this, HistoryActivity.class);
            startActivity(i);
        } else if (item.getItemId() == R.id.action_offers) {
            Intent i = new Intent(E_printoutActivity.this, OfferActivity.class);
            startActivity(i);
        } else if (item.getItemId() == R.id.action_orderbycall) {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:07307123123"));
            startActivity(callIntent);
        }
        else if(item.getItemId()==R.id.action_servicecharge)
        {
            Intent i= new Intent(E_printoutActivity.this,ServiceCharge.class);
            startActivity(i);
        }
        else if (item.getItemId() == R.id.action_contact) {
            AlertDialog dia;
            AlertDialog.Builder adb = new AlertDialog.Builder(E_printoutActivity.this);
            adb.setTitle("Contact Us");
            adb.setMessage("Contact us for any help on +91-7307123123" + "\n" + "or" + "\n" + "Email us on info@lifeline.com");
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
        } else if (item.getItemId() == R.id.action_feedback) {

            String url = "https://docs.google.com/forms/d/1wQFw5hRGnpC2YJ5Ab0D8YFIcbhdO90xdyphonHb79VA/viewform";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        } else if (item.getItemId() == R.id.action_about) {
            Intent i = new Intent(E_printoutActivity.this, HelpActivity.class);
            startActivity(i);
        } else if (item.getItemId() == R.id.action_search) {
            Intent i = new Intent(E_printoutActivity.this, SearchActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.anim_back_from, R.anim.anim_back_to);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                // Whatever you want to happen when the first item gets selected
                btnsendfile.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        i = new Intent(E_printoutActivity.this, FinalDetailsPage.class);
                        i.putExtra("Request", "E_printout");
                        i.putExtra("extra", "1");
                        startActivity(i);

                    }
                });


                break;
            case 1:
                // Whatever you want to happen when the second item gets selected
                btnsendfile.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        i = new Intent(E_printoutActivity.this, FinalDetailsPage.class);
                        i.putExtra("Request", "E_printout");
                        i.putExtra("extra", "2");
                        startActivity(i);

                    }
                });

                break;
            case 2:
                // Whatever you want to happen when the thrid item gets selected
                btnsendfile.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        i = new Intent(E_printoutActivity.this, FinalDetailsPage.class);
                        i.putExtra("Request", "E_printout");
                        i.putExtra("extra", "3");
                        startActivity(i);

                    }
                });

                break;
            default:

                break;
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
