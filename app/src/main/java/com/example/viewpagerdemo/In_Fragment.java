package com.example.viewpagerdemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class In_Fragment extends ListFragment {
    List<Food> mFoodList = new ArrayList<Food>();

    List<User>users=new ArrayList<User>();




    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initFood();
        ListMainAdapter adapter = new ListMainAdapter(getContext(),R.layout.list_main,mFoodList);
        this.setListAdapter(adapter);

       /*UserAdapter adapter1 = new UserAdapter(getContext(),R.layout.list_main,users);
        this.setListAdapter(adapter1);*/


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_in, container, false);

        return view;
    }
    private void initFood(){
        mFoodList.add(new Food("apple"));
        mFoodList.add(new Food("banana"));
        mFoodList.add(new Food("hot"));
    }

}
