package com.mx.mvp.androidmvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.mx.mvp.androidmvp.presenter.UserPresenter;
import com.mx.mvp.androidmvp.view.UserLoginView;

public class MainActivity extends AppCompatActivity implements UserLoginView, View.OnClickListener {

    private EditText edit_User;
    private EditText edit_Passwd;
    private Button btn_Login;
    private ProgressBar progressBar;
    private UserPresenter mUserLoginPresenter = new UserPresenter(this,this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inits();
    }

    private void inits() {
        edit_User = (EditText) findViewById(R.id.username);
        edit_Passwd = (EditText) findViewById(R.id.passwd);
        btn_Login = (Button) findViewById(R.id.btn_login);
        btn_Login.setOnClickListener(this);
        progressBar= (ProgressBar) findViewById(R.id.id_pb_loading);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_register) {
           startActivity(new Intent(this,RegisterActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_login) {
            mUserLoginPresenter.login();
            return;
        }
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
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this,ShowInfoActivity.class));
    }

    @Override
    public void showLoginFail(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
