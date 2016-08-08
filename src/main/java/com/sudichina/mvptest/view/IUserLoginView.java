package com.sudichina.mvptest.view;

import com.sudichina.mvptest.bean.User;

/**
 * Created by mike on 2016/8/8.
 */
public interface IUserLoginView {
    String getUsername();
    String getPassword();

    void clearUsername();
    void clearPassword();

    void showLoading();
    void hiedLoading();

    void toMainActivity(User user);
    void showFailedError();
}
