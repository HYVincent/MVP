package com.vincent.mvp.presenter;

/**
 * description ：
 * project name：MVP
 * author : Vincent
 * creation date: 2017/4/8 12:42
 *
 * @version 1.0
 */

public interface ILogonPresenter {

    /**
     * 登录 实际上是参数的传递
     * @param account
     * @param password
     */
    void login(String account,String password);

    /**
     * 登录
     * @param account
     * @param password
     */
    void login2(String account,String password);

}
