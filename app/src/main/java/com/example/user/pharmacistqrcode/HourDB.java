package com.example.user.pharmacistqrcode;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.util.Log;

public class HourDB extends ContentProvider {
    public static final String COL_ID = "_id";


    public class MyDatabase extends SQLiteOpenHelper {

        public MyDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String sql = "CREATE TABLE hour ("+COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,icon INTEGER, productname TEXT,  timeDate TEXT)";
            db.execSQL(sql);
            Log.d("hour", "table created");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXITS hour");
            onCreate(db);
            Log.d("hour", "table upgraded");
        }
    }




    public HourDB() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        SQLiteDatabase db = mydb.getWritableDatabase();
        int row = db.delete("hour", selection, selectionArgs);
        Log.d("hour", "delete completed");
        return  row;
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {

        SQLiteDatabase db = mydb.getWritableDatabase();
        long rowid = db.insert("hour", null, values);
        Uri nuri = ContentUris.withAppendedId(uri, rowid);

        Log.d("hour", "insert completed");
        return nuri;
    }

    MyDatabase mydb;
    @Override
    public boolean onCreate() {
        mydb = new MyDatabase(getContext(), "hour", null, 1);
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {

        SQLiteDatabase db = mydb.getReadableDatabase();
        Cursor c = db.query("hour", projection, selection, selectionArgs, null, null, sortOrder);
        Log.d("hour", "query completed");
        return c;

    }
    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        SQLiteDatabase db = mydb.getWritableDatabase();
        int row = db.update("hour", values, selection, selectionArgs);
        Log.d("hour", "update completed");
        return row;

    }
}