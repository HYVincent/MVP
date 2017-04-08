package com.vincent.mvp.base;

import android.app.Application;
import android.util.Log;

import com.vise.log.ViseLog;
import com.vise.log.inner.DefaultTree;

/**
 * description ：
 * project name：MVP
 * author : Vincent
 * creation date: 2017/4/8 15:09
 *
 * @version 1.0
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initViseLog();
    }

    /**
     * 初始化日志工具
     */
    private void initViseLog() {
//        ViseLog.init("Supplier");
        ViseLog.getLogConfig()
                .configAllowLog(true)//是否输出日志
                .configShowBorders(true)//是否排版显示
                .configTagPrefix("ViseLog")//设置标签前缀
                .configFormatTag("%d{HH:mm:ss:SSS} %t %c{-5}")//个性化设置标签，默认显示包名
                .configLevel(Log.VERBOSE);//设置日志最小输出级别，默认Log.VERBOSE
        ViseLog.plant(new DefaultTree());//添加打印日志信息到Logcat的树
    }

}
