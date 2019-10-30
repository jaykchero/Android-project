package com.example.viewpagerdemo;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class RecyclerPicture extends Fragment {
        ReAdapter reAdapter;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.recycler, container, false);

        final SwipeRefreshLayout sf = (SwipeRefreshLayout)view.findViewById(R.id.swipeRefreshLayout);
        RecyclerView rc = (RecyclerView)view.findViewById(R.id.recyclerView);

        /**
         * true 表示下拉转的那个圈进行变化
         * 50代表下拉的开始高度
         * 150代表下拉的最终高度
         */
        sf.setProgressViewOffset(true, 50, 150);

        /**
         * 设置圈的颜色
         */
        sf.setColorSchemeResources(R.color.colorAccent);

        /**
         * 刷新事件
         */
        sf.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getActivity(), "暂无消息更新", Toast.LENGTH_SHORT).show();
                        sf.setRefreshing(false);
                        reAdapter.notifyDataSetChanged();
                    }
                }, 3000);
            }
        });


        /**
         * 给adapter传值
         *
         */
        reAdapter = new ReAdapter("天才", getActivity());

        /**
         * 让item垂直向下排列
         */
        rc.setLayoutManager(new LinearLayoutManager(getActivity()));

        /**
         * 绑定数据
         */
        rc.setAdapter(reAdapter);

        /**
         * item点击事件
         */
        reAdapter.setOnItemClick(new ReAdapter.OnItemClick() {
            @Override
            public void succ(View view, int position) {
                Toast.makeText(getActivity(), "当前选中的是第" + position + "个", Toast.LENGTH_SHORT).show();
            }
        });



        return view;
    }
}
