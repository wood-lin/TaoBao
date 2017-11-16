package com.bwie.user.presenter;

import android.content.Context;

import com.bwie.user.model.LoginModel;
import com.bwie.user.view.ILoginView;

import java.util.Map;


/**
 * Created by Administrator on 2017/11/9 0009.
 */

public class LoginPresenter implements LoginModel.OnLoginFinish {
    private final ILoginView iLoginView;
    private final LoginModel loginModel;
    Context context;

    public LoginPresenter(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        this.loginModel = new LoginModel();
        loginModel.setOnfinish(this);
    }

    public void getUrl(String url, Map<String, String> mmap){
        loginModel.getUrl(url,mmap);
    }

    @Override
    public void OnLoginFinishListen(String str,String msg) {
        if(str.equals("0")){
            iLoginView.onSuccess(msg);
            //保存数据

        }else{
            iLoginView.onFailed(msg);
        }
    }
}
