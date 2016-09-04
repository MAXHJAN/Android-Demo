package com.mx.mvp.androidmvp.presenter;

import android.content.Context;
import android.os.Handler;

import com.mx.mvp.androidmvp.model.OnLoginListener;
import com.mx.mvp.androidmvp.model.OnRegisterListener;
import com.mx.mvp.androidmvp.model.UserModel;
import com.mx.mvp.androidmvp.model.UserModelImp;
import com.mx.mvp.androidmvp.utils.Constant;
import com.mx.mvp.androidmvp.view.UserLoginView;
import com.mx.mvp.androidmvp.view.UserRegisterView;

/**
 * Created by MHJ on 2016-9-3.
 */
public class UserPresenter {
    private UserModel userModel;
    private UserLoginView userLoginView;
    private UserRegisterView userRegisterView;
    private Handler handler = new Handler();
    private Context context;

    public UserPresenter(Context context, UserLoginView userLoginView) {
        this.context = context;
        this.userLoginView = userLoginView;
        this.userModel = new UserModelImp();
    }

    public UserPresenter(Context context, UserRegisterView userRegisterView) {
        this.context = context;
        this.userRegisterView = userRegisterView;
        this.userModel = new UserModelImp();
    }

    public void login() {
        if (userLoginView.getUserName().equals("") && userLoginView.getPasswd().equals("")) {
            userLoginView.showLoginFail("用户名或密码不能为空!");
            return;
        }
        userLoginView.showLoading();
        userModel.login(context, userLoginView.getUserName(), userLoginView.getPasswd(), new OnLoginListener() {
            @Override
            public void loginSuccess() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.startActivity();
                        userLoginView.hideLoading();
                    }
                });
            }

            @Override
            public void loginFail(final String message) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (message.equals(Constant.FAIL)) {
                            userLoginView.showLoginFail("登录失败");
                        }
                        if (message.equals(Constant.ERROR)) {
                            userLoginView.showLoginFail("密码错误");
                        }
                        userLoginView.hideLoading();
                    }
                });


            }
        });
    }

    public void register() {
        if (userRegisterView.getUserName().equals("") && userRegisterView.getPasswd().equals("")) {
            userRegisterView.showRegisterFail("用户名或密码不能为空!");
            return;
        }
        userRegisterView.showLoading();
        userModel.register(context, userRegisterView.getUserName(), userRegisterView.getPasswd(), new OnRegisterListener() {
            @Override
            public void registerSuccess() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        userRegisterView.hideLoading();
                        userRegisterView.startActivity();
                    }
                });

            }

            @Override
            public void registerFail() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        userRegisterView.hideLoading();
                        userRegisterView.showRegisterFail("注册失败");
                    }
                });
            }
        });
    }
}
