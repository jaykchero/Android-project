package com.example.viewpagerdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Seting extends Fragment implements View.OnClickListener {

    Button exit;
    RelativeLayout on_off;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.water_setting, container, false);

        on_off=view.findViewById(R.id.on_off);
        exit = view.findViewById(R.id.exit);
        exit.setOnClickListener(this);
        on_off.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.on_off:
               Intent intent =new Intent(getActivity(),LoginActivity.class);
               startActivity(intent);
            break;

        }
    }


}