package com.sha.mycart.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.style.TtsSpan;
import android.widget.TextView;

/**
 * Created by SHA on 27/7/2017.
 */

public class SqliteDb extends SQLiteOpenHelper
{


    public SqliteDb(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "TEST.db", factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("Create Table Data(ID INTEGER PRIMARY KEY AUTOINCREMENT, FIRSTNAME TEXT UNIQUE,LASTNAME TEXT);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS Data");
        onCreate(db);

    }
    public void insert_data(String fn,String ln)
    {
        ContentValues contentValues=new ContentValues();
        contentValues.put("FirstName",fn);
        contentValues.put("lastname",ln);
        this.getWritableDatabase().insertOrThrow("Data","",contentValues);

    }

    public void delete_data(String fn)
    {

        this.getWritableDatabase().delete("Data","FirstName='"+fn+"'",null);
    }

    public void update_data(String od,String nw)
    {
        this.getWritableDatabase().execSQL("UPDATE Data SET FirstName='"+nw+"' WHERE FirstName='"+od+"'");


    }

    public void list_data(TextView textView)
    {
        Cursor cursor=this.getReadableDatabase().rawQuery("Select * from Data",null);
        textView.setText("");
        while (cursor.moveToNext())
        {
textView.append(cursor.getString(1)+" "+cursor.getString(2)+"\n");
        }
    }
}
