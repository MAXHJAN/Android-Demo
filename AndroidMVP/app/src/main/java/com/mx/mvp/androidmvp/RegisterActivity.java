package com.mx.mvp.androidmvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.mx.mvp.androidmvp.presenter.UserPresenter;
import com.mx.mvp.androidmvp.view.UserRegisterView;

/**
 * Created by MHJ on 2016-9-3.
 */
public class RegisterActivity extends AppCompatActivity implements UserRegisterView {

    private EditText edit_User;
    private EditText edit_Passwd;
    private Button btn_Login;
    private ProgressBar progressBar;
    private UserPresenter userPresenter=new UserPresenter(this,this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        inits();
    }

    private void inits() {
        edit_User = (EditText) findViewById(R.id.username);
        edit_Passwd = (EditText) findViewById(R.id.passwd);
        btn_Login = (Button) findViewById(R.id.btn_login);
        progressBar= (ProgressBar) findViewById(R.id.pb_loading);
        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userPresenter.register();
            }
        });
    }

    @Override
    public String getUserName() {
        return edit_User.getText().toString().trim();
    }

    @Override
    public String getPasswd() {
        return edit_Passwd.getText().toString().trim();
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void startActivity() {
      startActivity(new Intent(this,ShowInfoActivity.class));
    }

    @Override
    public void showRegisterFail(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
