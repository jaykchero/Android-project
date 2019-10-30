package com.example.viewpagerdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.example.viewpagerdemo.web.BaseActivity;
import com.example.viewpagerdemo.web.CommonRequest;
import com.example.viewpagerdemo.web.CommonResponse;
import com.example.viewpagerdemo.web.ResponseHandler;

public class Login2Activity extends BaseActivity {

    private String URL_LOGIN = "http://192.168.170.1:8080/MyServlet/LoginServlet";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);


        final EditText etName = (EditText) findViewById(R.id.login_user2);
        final EditText etPassword = (EditText) findViewById(R.id.login_passwd2);

        Button btnLogin = (Button) findViewById(R.id.login_btn2);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(etName.getText().toString(), etPassword.getText().toString());
            }
        });




    }

    private void login(String name, String password) {


        final CommonRequest request = new CommonRequest();
        request.addRequestParam("name", name);
        request.addRequestParam("password", password);
        sendHttpPostRequest(URL_LOGIN, request, new ResponseHandler() {
            @Override
            public void success(CommonResponse response) {

                Toast.makeText(Login2Activity.this, "登陆成功", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Login2Activity.this,MainActivity.class);
                startActivity(intent);



            }

            @Override
            public void fail(String failCode, String failMsg) {
                Toast.makeText(Login2Activity.this, "用户或密码错误！！！", Toast.LENGTH_LONG).show();

            }
        });

    }

    }

