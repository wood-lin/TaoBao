package com.bwie.user.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bwie.taobao.R;
import com.bwie.user.presenter.RegPresenter;
import com.bwie.user.utils.API;
import com.bwie.user.view.IRegView;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity implements IRegView {

    RegPresenter regPresenter;
    @BindView(R.id.reg_name)
    EditText regName;
    @BindView(R.id.reg_pass)
    EditText regPass;
    @BindView(R.id.reg_pass2)
    EditText regPass2;
    @BindView(R.id.reg_email)
    EditText regEmail;
    @BindView(R.id.login_reg)
    Button loginReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        regPresenter = new RegPresenter(this);
    }

    @Override
    public void onSuccess(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onFailed(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.login_reg)
    public void onViewClicked() {
        String name = regName.getText().toString();
        String pass = regPass.getText().toString();
        String pass2 = regPass2.getText().toString();

        Map<String,String> map = new HashMap<String, String>();

        map = new HashMap();
        map.put("mobile",name);
        map.put("password",pass);

        regPresenter.getUrl(API.REG_PATH,map);
    }
}
