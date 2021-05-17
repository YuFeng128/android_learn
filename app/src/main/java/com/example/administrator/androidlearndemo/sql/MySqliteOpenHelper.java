package com.example.administrator.androidlearndemo.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2021/5/5 0005.
 */

public class MySqliteOpenHelper extends SQLiteOpenHelper {
    public static final String mId = "mId";
    public static final String mValue = "mValue";

    public static final String tb_gas_data = "tb_gas_data";
    public static final String tb_temp_data = "tb_temp_data";
    public static final String tb_hum_data = "tb_hum_data";
    public static final String tb_smoke_data = "tb_smoke_data";
    public static final String tb_ill_data = "tb_ill_data";

    public MySqliteOpenHelper(Context context) {
        super(context, "db_data.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table " + tb_gas_data + "(" + mId + " integer primary key autoincrement," + mValue + " float)";
        db.execSQL(sql);
        sql = "create table " + tb_temp_data + "(" + mId + " integer primary key autoincrement," + mValue + " float)";
        db.execSQL(sql);
        sql = "create table " + tb_hum_data + "(" + mId + " integer primary key autoincrement," + mValue + " float)";
        db.execSQL(sql);
        sql = "create table " + tb_smoke_data + "(" + mId + " integer primary key autoincrement," + mValue + " float)";
        db.execSQL(sql);
        sql = "create table " + tb_ill_data + "(" + mId + " integer primary key autoincrement," + mValue + " float)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
