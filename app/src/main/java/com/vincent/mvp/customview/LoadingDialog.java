package com.vincent.mvp.customview;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.vincent.mvp.R;

/**
 * description ：
 * project name：Hss
 * author : Vincent
 * creation date: 2017/3/14 20:00
 *
 * @version 1.0
 */

public class LoadingDialog extends DialogFragment {

    private View view;
    private TextView tvMsg;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        view = inflater.inflate(R.layout.layout_loading_dialog,null);
        tvMsg = (TextView)view.findViewById(R.id.tv_dialog_msg);
        tvMsg.setText("正在操作");
        return view;
    }

    @Override
    public void show(FragmentManager manager, String tag) {
        Log.d("LoadingDialog", "show: 显示dialog");
        super.show(manager, tag);
    }

    public void setLoadingMsg(String msg){
        if(tvMsg!=null){
            tvMsg.setText(msg);
        }
    }
}
