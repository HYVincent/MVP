package com.vincent.mvp.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.vincent.mvp.R;
import com.vincent.mvp.customview.LoadingDialog;

/**
 * description ：
 * project name：MVP
 * author : Vincent
 * creation date: 2017/4/8 13:00
 *
 * @version 1.0
 */

public  class BaseActivity extends AppCompatActivity implements BaseView{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_base);
        Log.d("onCreate", "onCreate: ...");
    }


    @Override
    public void loading(String msg) {
        //TODO 在这里写加载效果
    }

    @Override
    public void closeLoading() {
        //TODO 在这里写取消
    }

    @Override
    public void noInternet() {

    }

    @Override
    public void loadError() {

    }
}
