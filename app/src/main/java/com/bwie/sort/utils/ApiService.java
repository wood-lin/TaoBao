package com.bwie.sort.utils;

import com.bwie.sort.bean.CLass_LeftRVBean;
import com.bwie.sort.bean.Class_rightRVBean;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by w h l on 2017/11/14.
 */

public interface ApiService {
    @GET("mobile/index.php?act=goods_class")
    Observable<CLass_LeftRVBean> getLeft();

    @POST
    Observable<CLass_LeftRVBean> getRight(@Url String url, @QueryMap Map<String,String> map);

    @POST
    Observable<Class_rightRVBean> getrightjson(@Url String url);
}
