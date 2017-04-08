package com.vincent.mvp.presenter;

import android.text.TextUtils;

import com.vincent.mvp.base.BasePresenter;
import com.vincent.mvp.bean.UserBean;
import com.vincent.mvp.model.ILoginModel;
import com.vincent.mvp.model.LoginModel;
import com.vincent.mvp.nework.Result;
import com.vincent.mvp.view.ILoginView;
import com.vise.log.ViseLog;

import rx.Subscription;

/**
 * description ：
 * project name：MVP
 * author : Vincent
 * creation date: 2017/4/8 11:40
 *
 * @version 1.0
 */

public class LoginPresenter extends BasePresenter implements ILogonPresenter{

    private ILoginModel loginModel;
    private ILoginView loginView;

    public LoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
        loginModel = new LoginModel();
    }

    @Override
    public void login(String account, String password) {
        loginView.loading("正在登录");
        UserBean userBean = null;
        if(TextUtils.isEmpty(account)){
            userBean = new UserBean("18696855784","555555");
        }else {
            userBean = new UserBean(account,password);
        }

        //result 登录结果处理
        /*Result result = loginModel.login(userBean);
        if(result.getStatus().equals("1")){
            loginView.loginSuccess();
        }else {
            loginView.loginFail(result.getMsg());
        }
        loginView.closeLoading();*/

        Subscription subscription = loginModel.login2(userBean, new LoginModel.LoginListener() {
           @Override
           public void loginResult(Result result) {
               if(result.getStatus().equals("1")){
                   loginView.loginSuccess();
               }else {
                    loginView.loginFail(result.getMsg());
               }
           }

           @Override
           public void loginFaile(Throwable throwable) {
               ViseLog.e(throwable);
                loginView.loginFail("请求错误");
           }
       });
        addSubscription(subscription);
    }
}
