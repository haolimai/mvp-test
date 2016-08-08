package com.sudichina.mvptest.biz;

import com.sudichina.mvptest.bean.User;

/**
 * Created by mike on 2016/8/8.
 */
public class UserBiz implements IUserBiz {
    @Override
    public void login(final String username, final String password, final OnLoginListener onLoginListener) {
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if ("zhy".equals(username) && "123".equals(password)) {
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    onLoginListener.loginSuccessed(user);
                } else {
                    onLoginListener.loginFailed();
                }
            }
        }.start();
    }
}
