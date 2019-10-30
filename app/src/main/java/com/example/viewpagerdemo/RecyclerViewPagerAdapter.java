package com.example.viewpagerdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class RecyclerViewPagerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    List<Object> contents;
    RecyclerView recyclerView;
    public RecyclerViewPagerAdapter(List<Object> contents) {
        this.contents = contents;
    }
    public int getItemCount() {
        return contents.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_cardview, parent, false);
                    recyclerView=view.findViewById(R.id.recyclerView);
                    //recyclerView.scrollBy(1,1);
        return new RecyclerView.ViewHolder(view) {
        };

    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

}
