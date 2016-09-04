package com.mx.mvp.androidmvp.model;

import android.content.Context;

import com.mx.mvp.androidmvp.utils.SharedPrefsUtil;

/**
 * Created by MHJ on 2016-9-2.
 * 登陆 注册接口实现实现
 */
public class UserModelImp implements UserModel{

    @Override
    public void login(final Context context, final String username, final String passwd, final OnLoginListener loginListener) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String name= SharedPrefsUtil.getValue(context,"Config","username","");
                String pasd= SharedPrefsUtil.getValue(context,"Config","username","");
                if (name.equals(username)){
                    if (pasd.equals(passwd))
                    {
                        loginListener.loginSuccess();
                    }else{
                        loginListener.loginFail("ERROR");
                    }

                }else{
                    loginListener.loginFail("FAIL");
                }
            }
        }).start();
    }

    @Override
    public void register(final Context context, final String username, final String passwd, final OnRegisterListener registerListener) {
             new Thread(new Runnable() {
                 @Override
                 public void run() {
                     try {
                         Thread.sleep(3000);
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                     SharedPrefsUtil.putValue(context,"Config","username",username);
                     SharedPrefsUtil.putValue(context,"Config","passwd",passwd);
                     registerListener.registerSuccess();
                 }
             }).start();
    }
}
