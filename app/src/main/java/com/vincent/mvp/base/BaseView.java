package com.vincent.mvp.base;

/**
 * description ：
 * project name：MVP
 * author : Vincent
 * creation date: 2017/4/8 12:59
 *
 * @version 1.0
 */

public interface BaseView {

    /**
     * 显示正在加载对话框
     */
    void loading(String msg);

    /**
     * 取消加载效果
     */
    void closeLoading();

    /**
     * 无网络
     */
    void noInternet();

    /**
     * 加载错误
     */
    void loadError();

}
