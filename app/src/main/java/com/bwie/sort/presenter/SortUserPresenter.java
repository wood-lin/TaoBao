package com.bwie.sort.presenter;

import android.content.Context;
import android.widget.GridView;

import com.bwie.sort.adapter.MyGridAdapter;
import com.bwie.sort.bean.Class_rightRVBean;
import com.bwie.sort.model.SortUserModel;
import com.bwie.sort.view.ISortJsonView;

import java.util.ArrayList;
import java.util.Map;


/**
 * Created by whl on 2017/11/14.
 */

public class SortUserPresenter implements SortUserModel.OnRightUserFinish {
    private final ISortJsonView userview;
    private final SortUserModel usermodel;
    GridView gridView;
    Context context;

    MyGridAdapter adapter;

    public SortUserPresenter(ISortJsonView userview) {
        this.userview = userview;
        this.usermodel = new SortUserModel();
        usermodel.setOnfinish(this);
    }

    public void getUrl(String url, Map<String,String> mmap, GridView gridView, Context context){
        this.gridView = gridView;
        this.context = context;
        usermodel.getUrl(url,mmap);

    }

    @Override
    public void onRightUserFinishLinsenter(ArrayList<Class_rightRVBean.DatasBean.ClassListBean> list) {

        userview.getrightUser(list,gridView);

    }
}
