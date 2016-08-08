package com.sudichina.mvptest.biz;

/**
 * Created by mike on 2016/8/8.
 */
public interface IUserBiz {
    void login(String username,String password,OnLoginListener onLoginListener);
}
