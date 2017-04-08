package com.vincent.mvp.nework;



import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vincent.mvp.base.Config;
import com.vise.log.ViseLog;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * description ：
 * project name：MyAppProject
 * author : Vincent
 * creation date: 2017/2/23 10:12
 *
 * @version 1.0
 */

public class RetrofitUtils {

    private static Retrofit retrofit;
    private static long DEFAULT_TIMEOUT = 10*10000;

    /**
     * 获取一个默认配置BaseUrl地址的
     * @return
     */
    private static Retrofit getRetrofit(){
        //解决请求的错误  Use JsonReader.setLenient(true) to accept malformed JSON at line 1 column 1 path $
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

          return   retrofit = new Retrofit.Builder()
                    .baseUrl(Config.SERVICE_API_ADDRESS)
//                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addConverterFactory(FastJsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // 使用RxJava作为回调适配器
                    .client(new OkHttpClient.Builder()
                            .connectTimeout(DEFAULT_TIMEOUT,TimeUnit.SECONDS)
                            .writeTimeout(DEFAULT_TIMEOUT,TimeUnit.SECONDS)
                            .readTimeout(DEFAULT_TIMEOUT,TimeUnit.SECONDS)
                            .addInterceptor(new Interceptor() {
                                @Override
                                public Response intercept(Chain chain) throws IOException {
                                    Request request = chain.request();
                                    ViseLog.d("请求地址-->"+request.url());
                                    ViseLog.d(request);
                                    ViseLog.d("本次请求是否为https-->"+request.isHttps());
                                    return chain.proceed(request);
                                }
                            }).build())
                    .build();
    }

    /**
     * 动态配置BaseUrl
     * @param baseUrl
     * @return
     */
    private static   Retrofit getRetrofit (String baseUrl){
        //解决请求的错误  Use JsonReader.setLenient(true) to accept malformed JSON at line 1 column 1 path $
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

            return retrofit = new Retrofit.Builder()
//                    .baseUrl(Config.SERVICE_API_ADDRESS)
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(new OkHttpClient.Builder()
                            .addInterceptor(new Interceptor() {
                                @Override
                                public Response intercept(Chain chain) throws IOException {
                                    Request request = chain.request();
                                    ViseLog.d("请求地址-->"+request.url());
                                    ViseLog.d(request);
                                    ViseLog.d("本次请求是否为https-->"+request.isHttps());
                                    return chain.proceed(request);
                                }
                            }).build())
                    .build();
    }

    public static ApiService getApiService(){
        return getRetrofit().create(ApiService.class);
    }

    public static ApiService getApiService(String baseUrl){
        return getRetrofit(baseUrl).create(ApiService.class);
    }
}
