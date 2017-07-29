package com.sha.mycart.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SHA on 28/7/2017.
 */

public class Db extends SQLiteOpenHelper {
    public static String  DATABASE = "database.db";
    public static String TABLE ="mytable";
    public static String FNAME ="fname";
    public static String LNAME ="lname";
    public static String br;
    public Db(Context context) {
        super(context, DATABASE, null, 1);


    }


    @Override
    public void onCreate(SQLiteDatabase db) {
    br= "CREATE TABLE "+TABLE+"("+FNAME+ " Text, "+LNAME+ " Text);";
        db.execSQL(br);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE+" ;");
    }
    public void insertdata(String fname,String lname ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();


        contentValues.put(FNAME, fname);
        contentValues.put(LNAME, lname);
        db.insert(TABLE,null,contentValues);


    }
    public List<datamodel> getdata() {
        List<datamodel> data=new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from "+TABLE+" ;",null);
        StringBuffer stringBuffer = new StringBuffer();
        datamodel dm = null;
        while (cursor.moveToNext()) {
            dm = new datamodel();
            String fname = cursor.getString(cursor.getColumnIndexOrThrow("fname"));
            String lname = cursor.getString(cursor.getColumnIndexOrThrow("lname"));
            dm.setFName(fname);
            dm.setLName(lname);
            stringBuffer.append(dm);
            // stringBuffer.append(dataModel);
            data.add(dm);
        }

return data;
    }

}
