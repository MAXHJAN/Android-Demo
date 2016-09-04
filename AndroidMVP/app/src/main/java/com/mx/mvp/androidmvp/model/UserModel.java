package com.mx.mvp.androidmvp.model;

import android.content.Context;

/**
 * Created by MHJ on 2016-9-2.
 */
public interface UserModel {
    /**
     * 登陆接口
     * @param context
     * @param username
     * @param passwd
     * @param loginListener
     */
    public void login(Context context,  String username, String passwd, OnLoginListener loginListener);

    /**
     * 注册接口
     * @param context
     * @param username
     * @param passwd
     * @param regiserListener
     */
    public void register(Context context, String username, String passwd, OnRegisterListener regiserListener);
}
