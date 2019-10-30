package com.example.viewpagerdemo;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;



import com.facebook.drawee.backends.pipeline.*;
import com.ryane.banner_lib.AdPageInfo;
import com.ryane.banner_lib.AdPlayBanner;
import com.ryane.banner_lib.transformer.FadeInFadeOutTransformer;
import com.ryane.banner_lib.view.TitleView;

import java.util.ArrayList;
import java.util.List;

import static com.ryane.banner_lib.AdPlayBanner.IndicatorType.POINT_INDICATOR;
import static com.ryane.banner_lib.view.TitleView.Gravity.PARENT_BOTTOM;

/**
 * Created by admin on 2017/11/7.
 */

public class ReAdapter extends RecyclerView.Adapter<ReAdapter.ViewHolder> {

    String name;

    Activity activity;

    /**
     * 获取传递的值
     * @param usn
     */
    public ReAdapter(String usn, Activity at){
        this.name = usn;
        this.activity = at;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        //找到item布局，并传入holder实现
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        //绑定数据
        viewHolder.tv.setText(name);
        Fresco.initialize(activity);
        final List<AdPageInfo> mDatas = new ArrayList<>();
        AdPageInfo info1 = new AdPageInfo(
                "春天",   //标题
                "http://bpic.588ku.com/back_pic/04/28/77/67583e7a57534fb.jpg!ww800",    //图片链接
                "",   //描述
                1     //播放顺序
        );
        AdPageInfo info2 = new AdPageInfo(
                "夏天",
                "http://bpic.588ku.com/back_pic/02/64/73/425785ba66f1346.jpg!ww800",
                "",
                2
        );
        AdPageInfo info3 = new AdPageInfo(
                "秋天",
                "http://bpic.588ku.com/back_pic/00/00/52/00/1dcd7f6338745ccc20cafcf14a56d2ae.jpg!ww800",
                "",
                3
        );
        AdPageInfo info4 = new AdPageInfo(
                "冬天",
                "http://bpic.588ku.com/back_pic/00/12/47/62563dbac37e95c.jpg!ww800",
                "",
                4
        );
        mDatas.add(info1);
        mDatas.add(info2);
        mDatas.add(info3);
        mDatas.add(info4);

        viewHolder.banner
                .setAutoPlay(true)
                .setIndicatorType(POINT_INDICATOR)
                .setNumberViewColor(0xcc00A600, 0xccea0000, 0xffffffff)
                .setInterval(3500)
                .addTitleView(new TitleView(activity).setPosition(PARENT_BOTTOM).setTitlePadding(165, 5, 155, 5).setTitleMargin(0, 0, 0, 25).setTitleSize(16).setViewBackground(0x00000000).setTitleColor(activity.getResources().getColor(R.color.white)))
                .setBannerBackground(0xff000000)
                .setOnPageClickListener(new AdPlayBanner.OnPageClickListener() {
                    @Override
                    public void onPageClick(AdPageInfo info, int postion) {
                        switch (postion){
                            case 0:
                                Toast.makeText(activity, "我是" + mDatas.get(postion).getTitle(), Toast.LENGTH_SHORT).show();
                                Log.d("图片链接：", "" + mDatas.get(postion).getPicUrl());
                                Log.d("图片标题：", "" + mDatas.get(postion).getTitle());
                                break;
                            case 1:
                                Toast.makeText(activity, "我是" + mDatas.get(postion).getTitle(), Toast.LENGTH_SHORT).show();
                                Log.d("图片链接：", "" + mDatas.get(postion).getPicUrl());
                                Log.d("图片标题：", "" + mDatas.get(postion).getTitle());
                                break;
                            case 2:
                                Toast.makeText(activity, "我是" + mDatas.get(postion).getTitle(), Toast.LENGTH_SHORT).show();
                                Log.d("图片链接：", "" + mDatas.get(postion).getPicUrl());
                                Log.d("图片标题：", "" + mDatas.get(postion).getTitle());
                                break;
                            case 3:
                                Toast.makeText(activity, "我是" + mDatas.get(postion).getTitle(), Toast.LENGTH_SHORT).show();
                                Log.d("图片链接：", "" + mDatas.get(postion).getPicUrl());
                                Log.d("图片标题：", "" + mDatas.get(postion).getTitle());
                                break;
                            default:
                                break;
                        }
                    }
                })
                .setPageTransfromer(new FadeInFadeOutTransformer())
                .setInfoList((ArrayList<AdPageInfo>) mDatas)
                .setUp();
    }

    @Override
    public int getItemCount() {
        //长度
        return 1;
    }

    /**
     * 获取控件并实现点击事件
     */
    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv;

        AdPlayBanner banner;

        public ViewHolder(View view) {
            super(view);
            tv = view.findViewById(R.id.textView);
            banner = view.findViewById(R.id.banner);
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClick.succ(v, getPosition());
                }
            });
        }
    }

    /**
     * 单击事件
     */
    private OnItemClick onItemClick;

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    public interface OnItemClick{
        void succ(View view, int position);
    }



}
