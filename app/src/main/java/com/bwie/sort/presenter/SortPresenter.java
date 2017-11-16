package com.bwie.sort.presenter;

import com.bwie.sort.bean.CLass_LeftRVBean;
import com.bwie.sort.model.SortModel;
import com.bwie.sort.view.ISortView;

import java.util.ArrayList;
import java.util.Map;


/**
 * Created by whl on 2017/11/14.
 */

public class SortPresenter implements SortModel.OnLeftFinish,SortModel.OnRightFinish {
    private final ISortView userview;
    private final SortModel usermodel;

    public SortPresenter(ISortView userview) {
        this.userview = userview;
        this.usermodel = new SortModel();
        usermodel.setOnfinish(this);
        usermodel.setOnRightFinish(this);
    }



    public void getUrl(String url){
        usermodel.getUrl(url);
    }
    public void getrightUrl(String url, Map<String,String> mmap){
        usermodel.getRightUrl(url,mmap);
    }

    @Override
    public void OnLeftFinishLinsener(ArrayList<CLass_LeftRVBean.DatasBean.ClassListBean> list) {
        userview.getJson(list);
    }

    @Override
    public void onFinishLinsenter(ArrayList<CLass_LeftRVBean.DatasBean.ClassListBean> list) {
        userview.getTypeData(list);
    }
}
