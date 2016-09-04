package com.mx.mvp.androidmvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.mx.mvp.androidmvp.utils.SharedPrefsUtil;

/**
 * Created by MHJ on 2016-9-4.
 * 显示登陆信息
 */
public class ShowInfoActivity extends AppCompatActivity{
    private TextView text_UserName;
    private TextView text_Passwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_info);
        initView();
    }

    private void initView(){
        text_UserName= (TextView) findViewById(R.id.username);
        text_Passwd= (TextView) findViewById(R.id.passwd);
        text_UserName.setText("用户名："+SharedPrefsUtil.getValue(this,"Config","username",""));
        text_Passwd.setText("密   码："+SharedPrefsUtil.getValue(this,"Config","passwd",""));
    }
}
