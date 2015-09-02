package com.lifeline.lifelineforyou;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.lifeline.lifelineforyou.dboperation.DBHandlerHistory;
import com.lifeline.lifelineforyou.dboperation.DBHistoryBean;

public class HistoryActivity extends Activity{

	 ArrayList orderNo;
	 ArrayList<String> totalAmount;
	 ArrayList<String> date;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_history);
		ListView lvhistory=(ListView) findViewById(R.id.historylist);
		DBHistoryBean dbhb=new DBHistoryBean(240,"20000","24/23/1222");
		DBHandlerHistory dbh=new DBHandlerHistory(HistoryActivity.this);
//		dbh.addHistory(dbhb);
		ArrayList<DBHistoryBean> dblist=new ArrayList<DBHistoryBean>();
		dblist=dbh.Get_History();
	if(dblist.size()!=0)
	{
		orderNo=new ArrayList();
		totalAmount=new ArrayList<String>();
		date=new ArrayList<String>();
		for(int i=0;i<dblist.size();i++)
		{
			orderNo.add("#"+dblist.get(i).getOrderNo());
			totalAmount.add(dblist.get(i).getTotalAmount());
			date.add(dblist.get(i).getDate());
			
		}
		HistoryListAdapter adp=new HistoryListAdapter(HistoryActivity.this,orderNo, totalAmount, date);
		lvhistory.setAdapter(adp);
	}
		
	}
}
