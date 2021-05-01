package com.example.yeasi.cgpacalculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME="cgpa.db";
    private static final String TABLE_NAME="YourCgpa";
    private static final String KEY_SN="SN";
    private static final String KEY_NAME="Name";
    private static final String KEY_ID="ID";
    private static final String KEY_SEMESTER="Semester";
    private static final String KEY_CGPA="CGPA";

    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="CREATE TABLE "+ TABLE_NAME +"(" + KEY_SN +" INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_NAME +" TEXT,"
                + KEY_ID +" TEXT,"
                + KEY_SEMESTER +" TEXT,"
                + KEY_CGPA +" TEXT" +")";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS "+TABLE_NAME;
        db.execSQL(sql);
        onCreate(db);

    }

    public boolean insertData(String name,String id,String semester,String cgpa){

        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_NAME,name);
        contentValues.put(KEY_ID,id);
        contentValues.put(KEY_SEMESTER,semester);
        contentValues.put(KEY_CGPA,cgpa);
        long result = db.insert(TABLE_NAME,null,contentValues);
        db.close();
        if(result == -1)
            return false;
        else return true;
    }

    public Cursor getAlldata(){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor res = db.rawQuery(" select * from " + TABLE_NAME,null);
        return res;
    }

    public Integer deleteData(String sn){
        SQLiteDatabase db= this.getWritableDatabase();
        return db.delete(TABLE_NAME,"SN = ?", new String[] {sn});
    }

}
