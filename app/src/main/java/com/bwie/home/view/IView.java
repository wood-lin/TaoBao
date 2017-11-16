package com.bwie.home.view;

import com.bwie.home.bean.HomeBean;

/**
 * Created by w h l on 2017/11/9.
 * 在View中定义一个接口
 *
 * (定义一个得到数据的方法)
 */

public interface IView {
    //得到P层的网络请求数据
    void getData(HomeBean.DataBean list);
}
