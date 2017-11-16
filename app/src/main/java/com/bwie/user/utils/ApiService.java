package com.bwie.user.utils;

import com.bwie.user.bean.LoginBean;
import com.bwie.user.bean.NewUserBean;

import java.util.Map;

import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by w h l on 2017/11/13.
 */

public interface ApiService {
    @POST
    Observable<LoginBean> getLogin(@Url String url, @QueryMap Map<String,String> map);

    @POST
    Observable<NewUserBean> getNewUser(@Url String url, @QueryMap Map<String,String> map);

}
