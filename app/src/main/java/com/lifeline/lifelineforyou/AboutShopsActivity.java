package com.lifeline.lifelineforyou;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class AboutShopsActivity extends Activity{
	ListView lv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_aboutshop);
		lv=(ListView)findViewById(R.id.listviewaboutshop);
		String[] content={"Stationary","General Store","Cosmetics","Sweet Shop","Food","Bakery","Medicine","Fruits"};
		String[] subcontent={"Johar stationary","Ravi General store","9 to 9 cosmetics","University sweets"," NFS(Sidh Punjabi),LAVA(sector-8), Chinese food (babu ram patel market) ,stu-c(Fresh bite),Dark Moon Kitchen ",
				"Classic 44","ESS VEE Medicos","Ramesh & Sons Fruit Shop(Sec-23)"};
		HelpAdapter hadp=new HelpAdapter(this, content, subcontent);
		lv.setAdapter(hadp);
	}
		
}
