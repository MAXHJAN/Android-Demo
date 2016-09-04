package com.mx.mvp.androidmvp.view;

/**
 * Created by MHJ on 2016-9-4.
 */
public interface UserRegisterView {
    String getUserName();
    String getPasswd();
    void showLoading();
    void hideLoading();
    void startActivity();
    void showRegisterFail(String message);
}
