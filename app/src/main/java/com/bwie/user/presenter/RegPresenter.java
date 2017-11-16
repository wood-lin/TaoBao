package com.bwie.user.presenter;

import com.bwie.user.model.RegModel;
import com.bwie.user.view.IRegView;

import java.util.Map;


/**
 * Created by Administrator on 2017/11/10 0010.
 */

public class RegPresenter implements RegModel.OnNewUserFinish {
    private final IRegView iRegView;
    private final RegModel regModel;

    public RegPresenter(IRegView iRegView) {
        this.iRegView = iRegView;
        this.regModel = new RegModel();
        regModel.setOnfinish(this);
    }

    public void getUrl(String url, Map<String,String> map){
        regModel.getUrl(url,map);
    }

    @Override
    public void OnFinishListener(String str,String msg) {
        if(str.equals("0")){
            iRegView.onSuccess(msg);
        }else{
            iRegView.onFailed(msg);
        }
    }
}
