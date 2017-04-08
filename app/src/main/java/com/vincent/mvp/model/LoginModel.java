package com.vincent.mvp.model;

import com.vincent.mvp.bean.UserBean;
import com.vincent.mvp.nework.Result;
import com.vincent.mvp.nework.RetrofitUtils;
import com.vise.log.ViseLog;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * description ：
 * project name：MVP
 * author : Vincent
 * creation date: 2017/4/8 11:40
 *
 * @version 1.0
 */

public class LoginModel implements ILoginModel {

    private LoginListener loginListener;

    @Override
    public Result login(UserBean userBean) {
        //TODO 请求服务器，登录
//        Observable observable = new Observable()
        return null;
    }

    @Override
    public Subscription login2(UserBean userBean, final LoginListener loginListener) {
        Observable<Result> observable = RetrofitUtils.getApiService().login2(userBean.username,userBean.password);
        Subscription subscription = observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Result>() {
                    @Override
                    public void onCompleted() {
                        //TODO 登录完成了
                    }

                    @Override
                    public void onError(Throwable e) {
                        //TODO 登录错误
                        loginListener.loginFaile(e);
                    }

                    @Override
                    public void onNext(Result result) {
                        ViseLog.d("------------------");
                        loginListener.loginResult(result);
                    }
                });
        return subscription;
    }

    public interface LoginListener{

        void loginResult(Result result);

        void loginFaile(Throwable throwable);

    }

}
