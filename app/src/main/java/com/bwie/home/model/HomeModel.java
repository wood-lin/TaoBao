package com.bwie.home.model;


import com.bwie.home.bean.HomeBean;
import com.bwie.home.utils.RetroFactory;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by w h l on 2017/11/9.
 */

public class HomeModel implements IModel{
    HomeBean.DataBean list = new HomeBean.DataBean();//这样定义集合是因为它不是集合[],是个对象{}
    private OnFinishLisenter lisenter;

    //定义一个公开的接口,可以写成外部接口
    public interface OnFinishLisenter{
        //得到数据
        void OnFinish(HomeBean.DataBean list);
    }
    public void setOnHomeModel(OnFinishLisenter lisenter) {
        this.lisenter = lisenter;
    }

    /*
    * 重写IModel中 请求数据的方法
    * */
    @Override
    public void getJson(String url) {
        //得到retrofit工厂
        Observable<HomeBean> observable = RetroFactory.getInstance().getHome();
        observable.subscribeOn(Schedulers.io())//IO线程做耗时操作
                .observeOn(AndroidSchedulers.mainThread())//在主线程更新UI
                .subscribe(new Observer<HomeBean>() {//实例化一个观察者
                    //完成
                    @Override
                    public void onCompleted() {
                    }
                    //异常
                    @Override
                    public void onError(Throwable e) {
                    }
                    // 加载中
                    @Override
                    public void onNext(HomeBean homeBean) {
                        HomeBean.DataBean hd = homeBean.getData();
                        list = hd;
                        //把数据通过这个方法传入P层
                        lisenter.OnFinish(list);
                    }
                });
    }
}
