package com.vincent.mvp.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.vincent.mvp.R;
import com.vincent.mvp.base.BaseActivity;
import com.vincent.mvp.customview.LoadingDialog;
import com.vincent.mvp.presenter.LoginPresenter;
import com.vise.log.ViseLog;

public class LoginActivity extends BaseActivity implements View.OnClickListener,ILoginView {

    private EditText account,password;
    private Button login1,login2;
    private LoginPresenter presenter;
    private long start = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        account = (EditText)findViewById(R.id.et_account);
        password = (EditText)findViewById(R.id.et_password);
        login1 = (Button)findViewById(R.id.btn_login_1);
        login2 = (Button)findViewById(R.id.btn_login_2);
        login1.setOnClickListener(this);
        login2.setOnClickListener(this);
        presenter = new LoginPresenter(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login_1:
                start = System.currentTimeMillis();
                presenter.login(account.getText().toString().trim(),password.getText().toString().trim());
                break;
            case R.id.btn_login_2:
                start = System.currentTimeMillis();
                presenter.login2(account.getText().toString().trim(),password.getText().toString().trim());
                break;
        }
    }

    @Override
    public void loginSuccess() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_LONG).show();
            }
        });
        ViseLog.d("请求所用时间："+(System.currentTimeMillis()-start)+"ms");
    }

    @Override
    public void loginFail(final String msg) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(LoginActivity.this,msg,Toast.LENGTH_LONG).show();
            }
        });
        ViseLog.d("请求所用时间："+(System.currentTimeMillis()-start)+"ms");
    }

}
