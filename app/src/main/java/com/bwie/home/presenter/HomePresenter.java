package com.bwie.home.presenter;

import com.bwie.home.bean.HomeBean;
import com.bwie.home.model.HomeModel;
import com.bwie.home.view.IView;

/**
 * Created by w h l on 2017/11/9.
 * P层  建立M和V之间的关系
 */

public class HomePresenter implements HomeModel.OnFinishLisenter{
    private final IView homeView;   //V中的接口
    private final HomeModel homeModel;//M中的实现类

    //通过有参构造将M中的数据传入V中
    public HomePresenter(IView homeView) {
        this.homeView = homeView;
        this.homeModel = new HomeModel();//实例化Module
        homeModel.setOnHomeModel(this);   //这句话重点
    }

    public void getUrl(String url) {
        //得到Model中请求数据的方法
        homeModel.getJson(url);
    }

    @Override
    public void OnFinish(HomeBean.DataBean list) {
        //把从M层中传过来的数据通过以下的方法传到V层中
        homeView.getData(list);
    }
}
