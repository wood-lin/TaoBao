package com.bwie.user.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.taobao.R;
import com.bwie.user.presenter.LoginPresenter;
import com.bwie.user.utils.API;
import com.bwie.user.utils.MessageEvent;
import com.bwie.utils.SharedPreferencesUtils;
import com.bwie.user.view.ILoginView;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements ILoginView {

    LoginPresenter loginPresenter;
    String name;
    String pass;
    @BindView(R.id.login_name)
    EditText loginName;
    @BindView(R.id.login_pass)
    EditText loginPass;
    @BindView(R.id.text_register)
    TextView textRegister;
    @BindView(R.id.btn_login)
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        loginPresenter = new LoginPresenter(this);
    }

    @Override
    public void onSuccess(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        Intent data = new Intent();
        data.putExtra("user_phone", name);
        setResult(RESULT_OK, data);

        SharedPreferencesUtils.setParam(LoginActivity.this, "LOGIN_CODE", "0");

        EventBus.getDefault().post(new MessageEvent(name));

        finish();
    }

    @Override
    public void onFailed(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        SharedPreferencesUtils.setParam(LoginActivity.this, "LOGIN_CODE", "1");
    }

    @OnClick({R.id.login_name, R.id.login_pass, R.id.text_register, R.id.btn_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_name:
                break;
            case R.id.login_pass:
                break;
            case R.id.text_register:
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
                break;
            case R.id.btn_login:
                name = loginName.getText().toString();
                pass = loginPass.getText().toString();

                Map<String,String> map = new HashMap();
                map.put("mobile",name);
                map.put("password",pass);
                loginPresenter.getUrl(API.LOGIN_PATH,map);
                break;
        }
    }
}
