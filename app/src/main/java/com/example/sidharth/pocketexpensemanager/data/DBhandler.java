package com.example.sidharth.pocketexpensemanager.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by root on 29/3/17.
 */

public class DBhandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "expense.db";
    private static final String TABLE_NAME = "expense";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_DATE = "_date";
    private static final String COLUMN_DESCRIPTION = "_description";
    private static final String COLUMN_CATEGORY = "_category";
    private static final String COLUMN_MONEY = "_money";

    public DBhandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_DATE + " DATE, " +
                COLUMN_DESCRIPTION + " TEXT, " +
                COLUMN_CATEGORY + " TEXT, " +
                COLUMN_MONEY + " INTEGER" +
                ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }
    //add new data
    public void addData(Category_DB category_db) {

        ContentValues values = new ContentValues();
        values.put(COLUMN_DATE, category_db.get_date());
        values.put(COLUMN_DESCRIPTION, category_db.get_description());
        values.put(COLUMN_CATEGORY, category_db.get_category());
        values.put(COLUMN_MONEY, category_db.get_money());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    //print data base
    public String databaseTOstring() {
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE 1;";

        Cursor c= db.rawQuery(query,null);
        c.moveToFirst();
        while (!c.isAfterLast()){
            if(c.getString(c.getColumnIndex("_date"))!=null){
                dbString += c.getString(c.getColumnIndex("_date"));
                dbString += c.getString(c.getColumnIndex("_description"));
                dbString += c.getString(c.getColumnIndex("_category"));
                dbString += c.getString(c.getColumnIndex("_money"));
                dbString += "\n";


            }
        }
        db.close();
        return dbString;

    }
}
