package com.example.viewpagerdemo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends ArrayAdapter<User> {
    private int resourceId1;


    public UserAdapter(@NonNull Context context, int resource, @NonNull List<User> objects) {
        super(context, resource, objects);
        resourceId1 = resource;

    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       User user = getItem(position);//获取food对象
        View view = LayoutInflater.from(getContext()).inflate(resourceId1,null);
        TextView textView = view.findViewById(R.id.list_user);
        TextView textView1 = view.findViewById(R.id.list_user1);
        textView.setText(user.getName());
        textView1.setText(user.getPassword());
        return view;
    }



}
