package com.bwie.sort.view;


import com.bwie.sort.bean.CLass_LeftRVBean;

import java.util.ArrayList;

/**
 * Created by whl on 2017/11/14.
 */

public interface ISortView {
    void getJson(ArrayList<CLass_LeftRVBean.DatasBean.ClassListBean> list);
    void getTypeData(ArrayList<CLass_LeftRVBean.DatasBean.ClassListBean> list);
}
