package com.example.mobifixer.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "customers.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_CUSTOMERS = "customers";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_PHONE = "phone";
    private static final String COLUMN_DEVICE = "device_model";
    private static final String COLUMN_DATE = "delivery_date";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_CUSTOMERS + " (" +
                COLUMN_ID + " TEXT PRIMARY KEY, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_PHONE + " TEXT, " +
                COLUMN_DEVICE + " TEXT, " +
                COLUMN_DATE + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CUSTOMERS);
        onCreate(db);
    }

    public boolean insertCustomer(String id, String name, String phone, String device, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, id);
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_PHONE, phone);
        values.put(COLUMN_DEVICE, device);
        values.put(COLUMN_DATE, date);

        long result = db.insert(TABLE_CUSTOMERS, null, values);
        return result != -1;
    }
    public Cursor getAllCustomers() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM customers", null);
    }

    // Method to search for a customer by phone number
    public Cursor searchCustomerByPhone(String phone) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM customers WHERE phone=?", new String[]{phone});
    }

}
