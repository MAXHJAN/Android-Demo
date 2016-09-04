package com.mx.mvp.androidmvp.view;

/**
 * Created by MHJ on 2016-9-3.
 */
public interface UserLoginView {
    String getUserName();
    String getPasswd();
    void showLoading();
    void hideLoading();
    void startActivity();
    void showLoginFail(String message);
}
