package com.vincent.mvp.view;

import com.vincent.mvp.base.BaseView;

/**
 * description ：
 * project name：MVP
 * author : Vincent
 * creation date: 2017/4/8 11:41
 *
 * @version 1.0
 */

public interface ILoginView extends BaseView{

    /**
     * 登录成功
     */
    void loginSuccess();

    /**
     * 登录失败
     */
    void loginFail(String msg);

}
