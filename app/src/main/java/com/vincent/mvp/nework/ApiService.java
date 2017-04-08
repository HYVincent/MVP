package com.vincent.mvp.nework;

import com.vincent.mvp.base.Config;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * description ：
 * project name：MVP
 * author : Vincent
 * creation date: 2017/4/8 15:10
 *
 * @version 1.0
 */

public interface ApiService {

    /**
     * 用户登录 正常方式
     * @param phone
     * @param login
     * @return
     */
    @POST(Config.USER_LOGIN)
    Call<Result> login1(@Query("phone") String phone, @Query("password") String login);

    /**
     * 用户登录 rx
     * @param phone
     * @param password
     * @return
     */
    @POST(Config.USER_LOGIN)
    Observable<Result> login2(@Query("phone")String phone,@Query("password")String password);


}
