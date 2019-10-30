package com.example.viewpagerdemo.web;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.viewpagerdemo.DialogUtil;
import com.example.viewpagerdemo.LoadingDialogUtil;
import com.example.viewpagerdemo.Login2Activity;

public class BaseActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    protected void sendHttpPostRequest(String url, CommonRequest request, ResponseHandler responseHandler) {
        new HttpPostTask(request, mHandler, responseHandler).execute(url);

    }

    protected Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if(msg.what == Constant.HANDLER_HTTP_SEND_FAIL) {
                LogUtil.logErr(msg.obj.toString());

                LoadingDialogUtil.cancelLoading();
                Toast.makeText(BaseActivity.this, "请求失败", Toast.LENGTH_LONG).show();
            } else if (msg.what == Constant.HANDLER_HTTP_RECEIVE_FAIL) {
                LogUtil.logErr(msg.obj.toString());

                LoadingDialogUtil.cancelLoading();
                Toast.makeText(BaseActivity.this, "请求失败", Toast.LENGTH_LONG).show();
            }
        }
    };

}
