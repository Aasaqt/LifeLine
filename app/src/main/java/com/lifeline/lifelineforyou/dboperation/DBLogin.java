package com.lifeline.lifelineforyou.dboperation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by aasaqt on 7/4/15.
 */
public class DBLogin extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "LoginDatabase";
    private static final String TABLE_LOGIN = "login";
    private static final String KEY_ADDRESS = "address";
    private static final String KEY_LOGINID = "loginid";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_NUMBER = "number";
    private static final String KEY_EMAIL = "email";

    private final ArrayList<DBLoginBean> YC_list = new ArrayList<DBLoginBean>();


    public DBLogin(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_LOGIN + "("
                + KEY_LOGINID + " TEXT PRIMARY KEY," + KEY_USERNAME + " TEXT,"+ KEY_NUMBER + " TEXT,"+KEY_EMAIL + " TEXT,"
                + KEY_ADDRESS +" TEXT"+ ")";

        db.execSQL(CREATE_CONTACTS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOGIN);
        onCreate(db);
    }
    public void addLogin(DBLoginBean lb)
    {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(KEY_LOGINID, lb.getLoginId());
            values.put(KEY_USERNAME, lb.getUserName());
            values.put(KEY_NUMBER,lb.getNumber());
            values.put(KEY_EMAIL,lb.getEmail());
            values.put(KEY_ADDRESS,lb.getAddress());
            db.insert(TABLE_LOGIN, null, values);
            db.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            Log.e("99999999999999999999999999999999999999999", "9999999999999999999999999999999999999999");
            e.printStackTrace();
        }
    }
    public ArrayList<DBLoginBean> Get_Login() {
        try {
            YC_list.clear();
            String selectQuery = "SELECT  * FROM " + TABLE_LOGIN;

            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);
            if (cursor.moveToFirst()) {
                do {
                    DBLoginBean dbcBean = new  DBLoginBean();
                    dbcBean.setLoginId(cursor.getString(0));
                    dbcBean.setUserName(cursor.getString(1));
                    dbcBean.setNumber(cursor.getString(2));
                    dbcBean.setEmail(cursor.getString(3));
                    dbcBean.setAddress(cursor.getString(4));

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

}
