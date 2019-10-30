package com.example.viewpagerdemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Out_Fragment extends ListFragment {

    private SQLiteDatabase db;
    DateBaseHelper dateBaseHelper;
    List<User> users=new ArrayList<User>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       init();


       UserAdapter adapter1 = new UserAdapter(getContext(),R.layout.list_main,users);
        this.setListAdapter(adapter1);


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.feedback, container, false);

        return view;
    }

    private void init() {

        dateBaseHelper = new DateBaseHelper(getContext());
        db=dateBaseHelper.getWritableDatabase();
        users=new ArrayList<User>();
        Cursor cursor=db.query("user",null,null,null,null,null,null);
        while (cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String password=cursor.getString(cursor.getColumnIndex("password"));
            User p=new User(name,password);
            users.add(p);

        }
    }
}


