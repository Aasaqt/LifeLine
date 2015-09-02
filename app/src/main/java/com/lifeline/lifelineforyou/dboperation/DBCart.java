package com.lifeline.lifelineforyou.dboperation;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBCart extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "CartDatabase";
    private static final String TABLE_CART = "cart";
    private static final String KEY_PRODUCTQT = "productqt";
    private static final String KEY_PRODUCTID = "productid";
    private static final String KEY_PRODUCTNAME = "productname";
    private static final String KEY_PRODUCTPRICE = "productprice";
    private static final String KEY_PRODUCTPRICETOTAL = "productpricetotal";
 
    private final ArrayList<DBCartBean> YC_list = new ArrayList<DBCartBean>();
    
    public DBCart(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CART + "("
				+ KEY_PRODUCTID + " TEXT PRIMARY KEY," + KEY_PRODUCTNAME + " TEXT,"+ KEY_PRODUCTQT + " TEXT,"+KEY_PRODUCTPRICETOTAL + " TEXT,"
				+ KEY_PRODUCTPRICE +" TEXT"+ ")";
		
			db.execSQL(CREATE_CONTACTS_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_CART);
		onCreate(db);		
	}
	public void addHistory(DBCartBean cb)
	{
		try {
			SQLiteDatabase db = this.getWritableDatabase();
			ContentValues values = new ContentValues();
			values.put(KEY_PRODUCTID, cb.getProdId());
			values.put(KEY_PRODUCTNAME, cb.getProdName());
			values.put(KEY_PRODUCTQT,cb.getProdQt());
			values.put(KEY_PRODUCTPRICE,cb.getProdPrice());
			values.put(KEY_PRODUCTPRICETOTAL,cb.getProdtotalprice());
			db.insert(TABLE_CART, null, values);
			db.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Log.e("99999999999999999999999999999999999999999","9999999999999999999999999999999999999999");
			e.printStackTrace();
		} 
	}
	
	 public ArrayList<DBCartBean> Get_History() {
			try {
			    YC_list.clear();
			    String selectQuery = "SELECT  * FROM " + TABLE_CART;

			    SQLiteDatabase db = this.getWritableDatabase();
			    Cursor cursor = db.rawQuery(selectQuery, null);
			    if (cursor.moveToFirst()) {
				do {
					DBCartBean dbcBean = new  DBCartBean();
				    dbcBean.setProdId(cursor.getString(0));
				    dbcBean.setProdName(cursor.getString(1));
				    dbcBean.setProdQt(cursor.getString(2));
				    dbcBean.setProdPrice(cursor.getString(4));
				    dbcBean.setProdtotalprice(cursor.getString(3));
				    
				    YC_list.add(dbcBean);
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
	 public void Delete_CartRow(String productid) {
			SQLiteDatabase db = this.getWritableDatabase();
			db.delete(TABLE_CART, KEY_PRODUCTID + " = ?",
				new String[] { productid });
			db.close();
	 }
	 public void Delete_All_CART()
	 {
		 SQLiteDatabase db = this.getWritableDatabase();
		 db.delete(TABLE_CART,null, null);
	 }

	
}
