package com.example.pvny.thuvien.data;

/**
 * Created by PVNY on 19/08/2015.
 */
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

public class MySQLiteHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "dbthuvien.db";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "tblamthuc";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_CONTENT = "content";

    public MySQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_CONTENT + " TEXT, " +
                ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void AddData(ContentProvider contentProvider) {

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, contentProvider.get_name());
        values.put(COLUMN_CONTENT, contentProvider.get_content());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public void UpdateData(ContentProvider contentProvider){
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, contentProvider.get_name());
        values.put(COLUMN_CONTENT, contentProvider.get_content());
        SQLiteDatabase db = getWritableDatabase();
        db.update(TABLE_NAME, values, COLUMN_ID + "= ?", new String[]{String.valueOf(contentProvider.get_id())});
        db.close();

    }

    public void DeleteData(int _id){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + " = " + _id + ";");
        db.close();
    }

    public Cursor CursorId(int id){
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + " = " + id + ";";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public Cursor ListData(){
        SQLiteDatabase db = getReadableDatabase();
        String query = ("SELECT * FROM " + TABLE_NAME + " WHERE 1 ORDER BY " + COLUMN_CONTENT + ";");
        Cursor cursor = db.rawQuery(query, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }
}