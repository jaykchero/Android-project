package com.example.viewpagerdemo;

import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private RadioGroup group;
    private List<Fragment> page;
    private RadioButton forecast;
    private RadioButton tese;
    private RadioButton back;
    private RadioButton set;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        viewPager=findViewById(R.id.vp_display);

        forecast=findViewById(R.id.water_forecast);
       tese=findViewById(R.id.water_test);
        back=findViewById(R.id.water_feedback);
        set=findViewById(R.id.setting);

        group=findViewById(R.id.rg);
        page=new ArrayList<>();



        page.add(new HomeFragment());
        page.add(new com.example.viewpagerdemo.List());
        page.add(new SendFragment());
        page.add(new Seting());


        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return page.get(i);
            }

            @Override
            public int getCount() {
                return page.size();
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                //当页面被滚动的时候触发
            }

            @Override
            public void onPageSelected(int i) {
     //当页面滑动已经结束的时候触发
                switch (i){
                    case 0:
                      forecast.setChecked(true);
                       break;
                    case 1:
                        tese.setChecked(true);
                        break;
                    case 2:
                        back.setChecked(true);
                        break;
                    case 3:
                       set.setChecked(true);
                        break;

                }

            }

            @Override
            public void onPageScrollStateChanged(int i) {
                //状态发生改变后触发

            }
        });



/*
      group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()

            {
                @Override
                public void onCheckedChanged (RadioGroup group,int checkedId){


                switch (checkedId) {
                    case R.id.water_forecast:
                        viewPager.setCurrentItem(0, true);
                        break;

                    case R.id.water_test:
                        viewPager.setCurrentItem(1, true);
                        break;
                    case R.id.water_feedback:
                        viewPager.setCurrentItem(2, true);
                        break;
                    case R.id.setting:
                        viewPager.setCurrentItem(3, true);
                        break;
                }
            }
            });*/





        //主页底部radiobutton的drawabletop设置图片大小
        //初始值给的这些图片
        //推荐
       /* Drawable drawable_recommend_unselected = getResources().getDrawable(R.drawable.recommend_unselected);
        drawable_recommend_unselected.setBounds(0, 0, 60, 60);//60,60为宽高
        radioRecommend.setCompoundDrawables(null, drawable_recommend_unselected, null, null);*/
        Drawable drawable_recommend_selected = getResources().getDrawable(R.drawable.forecast_selector);
        drawable_recommend_selected.setBounds(0, 0, 80, 80);//60,60为宽高
        forecast.setCompoundDrawables(null, drawable_recommend_selected, null, null);

        //段子
        Drawable drawable_smile_unselected = getResources().getDrawable(R.drawable.test_selector);
        drawable_smile_unselected.setBounds(0, 0, 80, 80);//60,60为宽高
        tese.setCompoundDrawables(null, drawable_smile_unselected, null, null);
        //视频
        Drawable drawable_video_unselected = getResources().getDrawable(R.drawable.back_selector);
        drawable_video_unselected.setBounds(0, 0, 80, 80);//60,60为宽高
        back.setCompoundDrawables(null, drawable_video_unselected, null, null);

        Drawable drawable_video_unselected1 = getResources().getDrawable(R.drawable.setting_selector);
        drawable_video_unselected1.setBounds(0, 0, 80, 80);//60,60为宽高
       set.setCompoundDrawables(null, drawable_video_unselected1, null, null);





        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {



                switch (checkedId){
                    case R.id.water_forecast://推荐按钮,选中推荐,把其他的变灰
                        viewPager.setCurrentItem(0, true);

                        Drawable drawable_recommend_selected = getResources().getDrawable(R.drawable.forecast_press);
                        drawable_recommend_selected.setBounds(0, 0, 80, 80);//60,60为宽高
                       forecast.setCompoundDrawables(null, drawable_recommend_selected, null, null);
                        //把另外两个的变灰
                        Drawable drawable_smile_unselected = getResources().getDrawable(R.drawable.monitoring_normal);
                        drawable_smile_unselected.setBounds(0, 0, 80, 80);//60,60为宽高
                       tese.setCompoundDrawables(null, drawable_smile_unselected, null, null);

                        Drawable drawable_video_unselected = getResources().getDrawable(R.drawable.falt_normal);
                        drawable_video_unselected.setBounds(0, 0, 80, 80);//60,60为宽高
                        back.setCompoundDrawables(null, drawable_video_unselected, null, null);

                        Drawable seting_unselect = getResources().getDrawable(R.drawable.tab_settings_normal);
                        seting_unselect.setBounds(0, 0, 80, 80);//60,60为宽高
                        set.setCompoundDrawables(null, seting_unselect, null, null);

                        break;
                    case R.id.water_test://段子按钮,选中段子,把其他的变灰
                        viewPager.setCurrentItem(1, true);

                        Drawable drawable_smile_selected = getResources().getDrawable(R.drawable.monitoring_press);
                        drawable_smile_selected.setBounds(0, 0, 80, 80);//60,60为宽高
                       tese.setCompoundDrawables(null, drawable_smile_selected, null, null);
                        //把另外两个的变灰
                        Drawable drawable_recommend_unselected = getResources().getDrawable(R.drawable.forecast_normal);
                        drawable_recommend_unselected.setBounds(0, 0, 80, 80);//60,60为宽高
                        forecast.setCompoundDrawables(null, drawable_recommend_unselected, null, null);

                        Drawable drawable_video_unselected1 = getResources().getDrawable(R.drawable.falt_normal);
                        drawable_video_unselected1.setBounds(0, 0, 80, 80);//60,60为宽高
                        back.setCompoundDrawables(null, drawable_video_unselected1, null, null);

                        Drawable seting_unselect1 = getResources().getDrawable(R.drawable.tab_settings_normal);
                       seting_unselect1.setBounds(0, 0, 80, 80);//60,60为宽高
                        set.setCompoundDrawables(null, seting_unselect1, null, null);


                        break;
                    case R.id.water_feedback://视频按钮,选中视频,把其他的变灰
                        viewPager.setCurrentItem(2, true);

                        Drawable drawable_video_selected= getResources().getDrawable(R.drawable.falt_press);
                        drawable_video_selected.setBounds(0, 0, 80, 80);//60,60为宽高
                        back.setCompoundDrawables(null, drawable_video_selected, null, null);
                        //把另外两个的变灰
                        Drawable drawable_recommend_unselected1 = getResources().getDrawable(R.drawable.forecast_normal);
                        drawable_recommend_unselected1.setBounds(0, 0, 80, 80);//60,60为宽高
                        forecast.setCompoundDrawables(null, drawable_recommend_unselected1, null, null);

                        Drawable drawable_smile_unselected1 = getResources().getDrawable(R.drawable.monitoring_normal);
                        drawable_smile_unselected1.setBounds(0, 0, 80, 80);//60,60为宽高
                       tese.setCompoundDrawables(null, drawable_smile_unselected1, null, null);

                        Drawable seting_unselect2 = getResources().getDrawable(R.drawable.tab_settings_normal);
                        seting_unselect2.setBounds(0, 0, 80, 80);//60,60为宽高
                        set.setCompoundDrawables(null, seting_unselect2, null, null);
                        break;


                    case R.id.setting://视频按钮,选中视频,把其他的变灰
                        viewPager.setCurrentItem(3, true);

                        Drawable drawable_video_selected1= getResources().getDrawable(R.drawable.tab_settings_pressed);
                        drawable_video_selected1.setBounds(0, 0, 80, 80);//60,60为宽高
                       set.setCompoundDrawables(null, drawable_video_selected1, null, null);
                        //把另外两个的变灰
                        Drawable drawable_recommend_unselected2 = getResources().getDrawable(R.drawable.forecast_normal);
                        drawable_recommend_unselected2.setBounds(0, 0, 80, 80);//60,60为宽高
                        forecast.setCompoundDrawables(null, drawable_recommend_unselected2, null, null);

                        Drawable drawable_smile_unselected2 = getResources().getDrawable(R.drawable.monitoring_normal);
                        drawable_smile_unselected2.setBounds(0, 0, 80, 80);//60,60为宽高
                        tese.setCompoundDrawables(null, drawable_smile_unselected2, null, null);

                        Drawable seting_unselect3 = getResources().getDrawable(R.drawable.falt_normal);
                        seting_unselect3.setBounds(0, 0, 80, 80);//60,60为宽高
                        back.setCompoundDrawables(null, seting_unselect3, null, null);
                }
            }
        });

    }







}
