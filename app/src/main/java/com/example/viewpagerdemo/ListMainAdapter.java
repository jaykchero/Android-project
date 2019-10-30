package com.example.viewpagerdemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ListMainAdapter extends ArrayAdapter<Food> {

    private int resourceId;

    public ListMainAdapter(@NonNull Context context, int resource, @NonNull List<Food> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Food food = getItem(position);//获取food对象
        View view = LayoutInflater.from(getContext()).inflate(resourceId,null);
        TextView textView = view.findViewById(R.id.list_food);
        textView.setText(food.getName());
        return view;
    }
}
