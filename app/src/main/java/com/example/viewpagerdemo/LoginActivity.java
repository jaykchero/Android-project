package com.example.viewpagerdemo;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    Button login_btn;
    EditText user_name;
    EditText user_pass;

    DateBaseHelper dateBaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dateBaseHelper = new DateBaseHelper(this);
        login_btn = findViewById(R.id.login_btn);

        SQLiteDatabase db = dateBaseHelper.getWritableDatabase();

        login_btn.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        user_name = findViewById(R.id.login_user);
        user_pass = findViewById(R.id.login_passwd);
        String name = user_name.getText().toString().trim();
        String pass = user_pass.getText().toString().trim();
        dateBaseHelper.add("1","1");


        switch (v.getId()) {
            case R.id.login_btn:
                if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(pass)) {
                    ArrayList<User> date = dateBaseHelper.getAllDate();
                    boolean match = false;
                    for (int i = 0; i < date.size(); i++) {
                        User user = date.get(i);
                        if (name.equals(user.getName()) && pass.equals(user.getPassword())) {
                            match = true;


                        } else {
                            match = false;

                        }


                    }

                    if (match) {
                        Toast.makeText(LoginActivity.this, "登陆成功", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();

                    } else {
                        Toast.makeText(LoginActivity.this, "密码或用户名错误", Toast.LENGTH_LONG).show();
                    }


                }


        }


    }
}

