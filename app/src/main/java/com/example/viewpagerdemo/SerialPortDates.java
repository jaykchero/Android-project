package com.example.viewpagerdemo;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.viewpagerdemo.web.BaseFragment;
import com.example.viewpagerdemo.web.CommonRequest;
import com.example.viewpagerdemo.web.CommonResponse;
import com.example.viewpagerdemo.web.ResponseHandler;

import java.util.ArrayList;
import java.util.HashMap;
public class SerialPortDates extends BaseFragment {


    View view;

    private String URL_PRODUCT = "http://192.168.170.1:8080/MyServlet/SerialPortDatas";
    ListView listView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getListData();



    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_list, container, false);
       listView = (ListView) view.findViewById(R.id.lv3);
        return view;
    }

    private void getListData() {


        CommonRequest request = new CommonRequest();
        sendHttpPostRequest(URL_PRODUCT, request, new ResponseHandler() {
            @Override
            public void success(CommonResponse response) {
                LoadingDialogUtil.cancelLoading();

                if (response.getDataList().size() > 0) {
                    com.example.viewpagerdemo.List.ProductAdapter adapter = new com.example.viewpagerdemo.List.ProductAdapter(getContext(), response.getDataList());
                   listView.setAdapter(adapter);
                } else {

                }
            }

            @Override
            public void fail(String failCode, String failMsg) {

            }
        });
    }


    static class ProductAdapter extends BaseAdapter {
        private Context context;
        private ArrayList<HashMap<String, String>> list;

        public ProductAdapter(Context context, ArrayList<HashMap<String, String>> list) {
            this.context = context;
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.item_product, parent, false);
                holder = new ViewHolder();
                holder.tvName = (TextView) convertView.findViewById(R.id.tv_name);
                holder.tvDescribe = (TextView) convertView.findViewById(R.id.tv_describe);
                holder.tvPrice = (TextView) convertView.findViewById(R.id.tv_price);

                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            HashMap<String, String> map = list.get(position);
            holder.tvName.setText(map.get("order"));
            holder.tvDescribe.setText(map.get("temper"));
            holder.tvPrice.setText("哎哟，不错哦");

            return convertView;
        }

        static class ViewHolder {
            private TextView tvName;
            private TextView tvDescribe;
            private TextView tvPrice;
        }
    }



}
