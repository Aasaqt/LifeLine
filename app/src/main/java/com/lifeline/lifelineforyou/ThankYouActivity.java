package com.lifeline.lifelineforyou;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ThankYouActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_thankyou);
		TextView tvorderno=(TextView) findViewById(R.id.tvordernothankyou);
		TextView tvdate=(TextView) findViewById(R.id.tvdatethank);
		TextView tvtotal=(TextView) findViewById(R.id.tvtotalthank);
		
		tvorderno.setText(getIntent().getExtras().getString("orderNo"));
		tvtotal.setText(getIntent().getExtras().getString("total"));
		tvdate.setText(getIntent().getExtras().getString("date"));
	}
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		Intent i=new Intent(ThankYouActivity.this,MainActivity.class);
		i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(i);
	}
}
