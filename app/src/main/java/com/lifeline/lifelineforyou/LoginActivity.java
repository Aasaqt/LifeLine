package com.lifeline.lifelineforyou;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.BoringLayout;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.lifeline.lifelineforyou.dboperation.DBLogin;
import com.lifeline.lifelineforyou.dboperation.DBLoginBean;
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

/**
 * Created by aasaqt on 7/4/15.
 */
public class LoginActivity extends Activity {
    EditText name, phone, email, address;
    String responseText = null;
    AlertDialog dia;
    //Boolean b;
    String EMAIL_Validation = "[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.animation_enter, R.anim.animation_leave);
        setContentView(R.layout.activity_login);
        name = (EditText) findViewById(R.id.etName);
        phone = (EditText) findViewById(R.id.etphone);
        email = (EditText) findViewById(R.id.etemail);
        address = (EditText) findViewById(R.id.etaddress);
        ImageButton login = (ImageButton) findViewById(R.id.btnlogin);
        ImageButton facebookRegister = (ImageButton) findViewById(R.id.btnregisterwithfacebook);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );
        //final Boolean b = email.getText().toString().trim().matches(EMAIL_Validation);
        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(name.getText().toString().matches("") ||phone.getText().toString().matches("") ||email.getText().toString().matches("") || address.getText().toString().matches(""))
                {

                    Toast.makeText(LoginActivity.this,"Fill all the Entries",Toast.LENGTH_LONG).show();
                }else if(phone.getText().toString().length() != 10){
                    Toast.makeText(LoginActivity.this,"Enter 10 digit number",Toast.LENGTH_LONG).show();
                }else if(!email.getText().toString().trim().matches(EMAIL_Validation)){
                    Toast.makeText(LoginActivity.this,"Enter valid email id",Toast.LENGTH_LONG).show();
                }else {
                    GetUserId gt = new GetUserId();
                    gt.execute();
                }
            }});




    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.anim_back_from, R.anim.anim_back_to);
    }


    private class GetUserId extends AsyncTask<Void, Void, Void>{
        ProgressDialog pDialog;

        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            pDialog = new ProgressDialog(LoginActivity.this);
            pDialog.setMessage("Loading");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... params){
            JSONObject j1= new JSONObject();
            JSONArray jarr = new JSONArray();
            JSONObject jobjFinal = new JSONObject();
            try {
                j1.put("name",name.getText().toString());
                j1.put("phone",phone.getText().toString());
                j1.put("email",email.getText().toString());
                j1.put("address",address.getText().toString());
                jarr.put(j1);
                jobjFinal.put("login",jarr);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost httppostreq = new HttpPost("");
            try {
                StringEntity se = new StringEntity(jobjFinal.toString());
                se.setContentType("application/json;charset=UTF-8");
                se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,"application/json;charset=UTF-8"));
                httppostreq.setEntity(se);
                HttpResponse httpresponse = httpClient.execute(httppostreq);

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
            /*if (responseText.equals("")) {
                AlertDialog.Builder adb = new AlertDialog.Builder(LoginActivity.this);
                adb.setTitle("Attention");
                adb.setMessage("Try it again!");
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
            }else {*/
            //Toast.makeText(LoginActivity.this,name.getText().toString()+"\n"+phone.getText().toString(),Toast.LENGTH_LONG).show();
                DBLoginBean dblb = new DBLoginBean(responseText, name.getText().toString(), phone.getText().toString(), email.getText().toString(), address.getText().toString());
                DBLogin dbl = new DBLogin(LoginActivity.this);
                dbl.addLogin(dblb);
                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(i);
                pDialog.dismiss();


        }
    }

}


