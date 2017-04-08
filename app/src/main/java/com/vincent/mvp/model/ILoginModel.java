package com.vincent.mvp.model;

import com.vincent.mvp.bean.UserBean;
import com.vincent.mvp.nework.Result;

import rx.Subscription;

/**
 * description ：
 * project name：MVP
 * author : Vincent
 * creation date: 2017/4/8 11:39
 *
 * @version 1.0
 */

public interface ILoginModel {

    /**
     * 请求服务器，登录
     * @param userBean
     */
    void login(UserBean userBean, LoginModel.LoginListener loginListener);

    /**
     * 登录
     * @param userBean
     * @return
     */
    Subscription login2(UserBean userBean,LoginModel.LoginListener loginListener);

}
