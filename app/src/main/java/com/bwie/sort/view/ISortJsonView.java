package com.bwie.sort.view;

import android.widget.GridView;

import com.bwie.sort.bean.Class_rightRVBean;

import java.util.ArrayList;


/**
 * Created by whl on 2017/11/14.
 */

public interface ISortJsonView {
    void getrightUser(ArrayList<Class_rightRVBean.DatasBean.ClassListBean> list, GridView gridView);
}
