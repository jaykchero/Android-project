package com.example.viewpagerdemo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DateBaseHelper extends SQLiteOpenHelper {
    private SQLiteDatabase db;
    public DateBaseHelper(Context context) {
        super(context, "test_db", null, 1);
        db=getReadableDatabase();


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="create table user(name varchar(20),password varchar(20))";
        db.execSQL(sql);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");
        onCreate(db);

    }
    public  void add(String name,String password){
        db.execSQL("INSERT INTO user (name,password) VALUES(?,?)",new Object[]{name,password});

    }
    public void delete(String name,String password){
        db.execSQL("DELETE FROM user WHERE name = AND password ="+name+password);
    }
    public void updata(String password){
        db.execSQL("UPDATE user SET password = ?",new Object[]{password});
    }



    public  ArrayList<User>getAllDate(){
        ArrayList<User> list=new ArrayList<User>();
        Cursor cursor =db.query("user",null,null,null,null,null,"name DESC");

        while(cursor.moveToNext()){
            String name =cursor.getString(cursor.getColumnIndex("name"));
            String password =cursor.getString(cursor.getColumnIndex("password"));
            list.add(new User(name,password));



        }
        return list;


    }

}
