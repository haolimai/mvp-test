package com.sudichina.mvptest.presenter;

import android.os.Handler;

import com.sudichina.mvptest.bean.User;
import com.sudichina.mvptest.biz.IUserBiz;
import com.sudichina.mvptest.biz.OnLoginListener;
import com.sudichina.mvptest.biz.UserBiz;
import com.sudichina.mvptest.view.IUserLoginView;

/**
 * Created by mike on 2016/8/8.
 */
public class UserLoginPresenter {
    private IUserBiz iUserBiz;
    private IUserLoginView iUserLoginView;
    private Handler mHandler = new Handler();

    public UserLoginPresenter(IUserLoginView iUserLoginView) {
        this.iUserLoginView = iUserLoginView;
        iUserBiz = new UserBiz();
    }

    public void login() {
        iUserLoginView.showLoading();
        iUserBiz.login(iUserLoginView.getUsername(), iUserLoginView.getPassword(), new OnLoginListener() {
            @Override
            public void loginSuccessed(final User user) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iUserLoginView.toMainActivity(user);
                        iUserLoginView.hiedLoading();
                    }
                });
            }

            @Override
            public void loginFailed() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iUserLoginView.showFailedError();
                        iUserLoginView.hiedLoading();
                    }
                });

            }
        });
    }

    public void clear() {
        iUserLoginView.clearUsername();
        iUserLoginView.clearPassword();
    }

}
