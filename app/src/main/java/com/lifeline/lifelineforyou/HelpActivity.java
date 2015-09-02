package com.lifeline.lifelineforyou;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class HelpActivity extends Activity{
	
	ListView lv_help;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_help);
		lv_help=(ListView)findViewById(R.id.listviewhelp);
		String[] content={"Share","Rate","Version","About Stores","Developed By"};
		String[] subcontent={"Share this app with your friends","Rate this app","1.1.2","Details about shops","Future Corp"};
		HelpAdapter hadp=new HelpAdapter(HelpActivity.this, content, subcontent);
		lv_help.setAdapter(hadp);
		lv_help.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				if(arg2==0)
				{
					 Intent intent = new Intent(Intent.ACTION_SEND);

                     intent.setType("text/plain");

                     intent.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=com.lifeline.lifelineforyou");

                     intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Check out this cool app!");

                     startActivity(Intent.createChooser(intent, "Share Using"));
				}
				else if(arg2==1)
				{
						String url = "https://play.google.com/store/apps/details?id=com.lifeline.lifelineforyou";
						Intent i = new Intent(Intent.ACTION_VIEW);
						i.setData(Uri.parse(url));
						startActivity(i);
				}
				else if(arg2==2)
				{
					
				}
				else if(arg2==3)
				{
					Intent i=new Intent(HelpActivity.this,AboutShopsActivity.class);
					startActivity(i);
				}
				
				else if(arg2==4)
				{
					//String url = "https://www.linkedin.com/in/gourav92singh";
					//Intent i = new Intent(Intent.ACTION_VIEW);
					//i.setData(Uri.parse(url));
					//startActivity(i);
				}
				
			}
		});
	}
}
