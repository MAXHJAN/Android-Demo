package com.mx.mvp.androidmvp.model;

/**
 * Created by MHJ on 2016-9-2.
 * 登陆监听
 */
public interface OnLoginListener {
    void loginSuccess();
    void loginFail(String message);
}
