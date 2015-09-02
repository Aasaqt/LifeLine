package com.lifeline.lifelineforyou.dboperation;

import java.util.ArrayList;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHandlerHistory extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "HistoryDatabase";
    private static final String TABLE_HISTORY = "history";
    private static final String KEY_ORDERNO = "orderno";
    private static final String KEY_ORDERAMOUNT = "orderamount";
    private static final String KEY_ORDERDATE = "orderdate";
 
    private final ArrayList<DBHistoryBean> YC_list = new ArrayList<DBHistoryBean>();
    
    public DBHandlerHistory(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_HISTORY + "("
				+ KEY_ORDERNO + " INTEGER PRIMARY KEY," + KEY_ORDERAMOUNT + " TEXT,"
				+ KEY_ORDERDATE +" TEXT"+ ")";
		
			db.execSQL(CREATE_CONTACTS_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_HISTORY);
		onCreate(db);		
	}
	public void addHistory(DBHistoryBean hb)
	{
		try {
			SQLiteDatabase db = this.getWritableDatabase();
			ContentValues values = new ContentValues();
			values.put(KEY_ORDERNO, hb.getOrderNo());
			values.put(KEY_ORDERAMOUNT, hb.getTotalAmount());
			values.put(KEY_ORDERDATE,hb.getDate());  
			db.insert(TABLE_HISTORY, null, values);
			db.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Log.e("99999999999999999999999999999999999999999","9999999999999999999999999999999999999999");
			e.printStackTrace();
		} 
	}
	
	 public ArrayList<DBHistoryBean> Get_History() {
			try {
			    YC_list.clear();
			    String selectQuery = "SELECT  * FROM " + TABLE_HISTORY;

			    SQLiteDatabase db = this.getWritableDatabase();
			    Cursor cursor = db.rawQuery(selectQuery, null);
			    if (cursor.moveToFirst()) {
				do {
					DBHistoryBean dbhBean = new  DBHistoryBean();
				    dbhBean.setOrderNo(Integer.parseInt(cursor.getString(0)));
				    dbhBean.setTotalAmount(cursor.getString(1));
				    dbhBean.setDate(cursor.getString(2));
				    
				    YC_list.add(dbhBean);
				} while (cursor.moveToNext());
			    }

			    // return contact list
			    cursor.close();
			    db.close();
			    return YC_list;
			} catch (Exception e) {
			    // TODO: handle exception
			    Log.e("=========================================================@@@@@@@@@@@@@@@@@", "" +"");
			}

			return YC_list;
		    }
//	 public void Delete_YourChoice(int id) {
//			SQLiteDatabase db = this.getWritableDatabase();
//			db.delete(TABLE_VERTICALHOME, KEY_ID + " = ?",
//				new String[] { String.valueOf(id) });
//			db.close();
//	 }
//	 public void Delete_All_YourChoices()
//	 {
//		 SQLiteDatabase db = this.getWritableDatabase();
//		 db.delete(TABLE_VERTICALHOME,null, null);
//	 }

	
}
