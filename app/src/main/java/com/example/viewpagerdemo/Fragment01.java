package com.example.viewpagerdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.viewpagerdemo.fragment.Frag01;
import com.example.viewpagerdemo.fragment.Frag02;
import com.example.viewpagerdemo.fragment.Frag03;
import com.example.viewpagerdemo.fragment.FragmentAdapter;

import java.util.ArrayList;
import java.util.List;

public class Fragment01 extends Fragment implements ViewPager.OnPageChangeListener,View.OnClickListener{

    private List<Fragment> list;
    private View view;
    private ViewPager viewPager;
    private TextView button01,button02,button03;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_fragment,container,false);
        initView();
        return view;
    }

    private void initView() {
        viewPager=(ViewPager)view.findViewById(R.id.viewpager01);

        list=new ArrayList<>();
        button01=(TextView) view.findViewById(R.id.frag01);
        button02=(TextView) view.findViewById(R.id.frag02);
        button03=(TextView) view.findViewById(R.id.frag03);
       ;

        button01.setOnClickListener(this);
        button02.setOnClickListener(this);
        button03.setOnClickListener(this);


        //这些界面要也要一个一个先去实现
        list.add(new Frag01());
        list.add(new Frag02());
        list.add(new Frag03());


        viewPager.setAdapter(new FragmentAdapter(getFragmentManager(),list));
        viewPager.setOnPageChangeListener(this);
        viewPager.setCurrentItem(0);

    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        initBtnListener();
        switch (i){
            case 0:
                button01.setTextColor(Color.parseColor("#ff735c"));
                break;
            case 1:
                button02.setTextColor(Color.parseColor("#ff735c"));
                break;
            case 2:
                button03.setTextColor(Color.parseColor("#ff735c"));
            break;

        }

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    @Override
    public void onClick(View v) {
        initBtnListener();
        switch (v.getId()){
            case R.id.frag01:

                viewPager.setCurrentItem(0);
                break;
            case R.id.frag02:

                viewPager.setCurrentItem(1);
                break;
            case R.id.frag03:

                viewPager.setCurrentItem(2);
                break;

        }
    }

    private void initBtnListener(){

        button01.setBackgroundResource(R.color.colorAccent);
        button02.setBackgroundResource(R.color.colorAccent);
        button03.setBackgroundResource(R.color.colorAccent);

    }


}