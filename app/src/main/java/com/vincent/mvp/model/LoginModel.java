package com.vincent.mvp.model;

import com.alibaba.fastjson.JSON;
import com.vincent.mvp.bean.UserBean;
import com.vincent.mvp.nework.Result;
import com.vincent.mvp.nework.RetrofitUtils;
import com.vise.log.ViseLog;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
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
    public void login(UserBean userBean, final LoginListener loginListener) {
        //TODO 请求服务器，登录
        Result result = null;
        Call call = RetrofitUtils.getApiService().login1(userBean.username,userBean.password);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                Result result = JSON.parseObject(JSON.toJSONString(response.body()),Result.class);
                loginListener.loginResult(result);
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                loginListener.loginFaile(t);
            }
        });
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
