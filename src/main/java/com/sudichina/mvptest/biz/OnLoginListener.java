package com.sudichina.mvptest.biz;

import com.sudichina.mvptest.bean.User;

/**
 * Created by mike on 2016/8/8.
 */
public interface OnLoginListener {
    void loginSuccessed(User user);
    void loginFailed();
}
