package com.bwie.home.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.bwie.home.adapter.XRAdapter;
import com.bwie.home.bean.HomeBean;
import com.bwie.home.presenter.HomePresenter;
import com.bwie.home.utils.Api;
import com.bwie.home.view.IView;
import com.bwie.taobao.R;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by w h l on 2017/10/11.
 */

public class Fragment_home extends Fragment implements IView {

    HomePresenter homePresenter;    //实例化P层
    XRAdapter adapter;
    @BindView(R.id.id_zxing)
    ImageView idZxing;
    @BindView(R.id.editText)
    EditText editText;
    @BindView(R.id.id_message)
    ImageView idMessage;
    @BindView(R.id.xre_xrv)
    XRecyclerView xreXrv;
    Unbinder unbinder;
    private HomeBean.DataBean mylist;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);

        //实例化P层,参数类型是IView
        homePresenter = new HomePresenter(this);
        homePresenter.getUrl(Api.BASE_PATH);//P层中网络请求的方法

        return view;
    }

    @Override
    public void getData(HomeBean.DataBean list) {
        //加布局管理器
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xreXrv.setLayoutManager(layoutManager);
        //关联适配器
        XRAdapter  mxradapter=new XRAdapter(getActivity(),list);
        xreXrv.setAdapter(mxradapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
