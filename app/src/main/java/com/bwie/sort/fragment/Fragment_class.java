package com.bwie.sort.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.sort.adapter.ClassLeftRVAdapter;
import com.bwie.sort.adapter.ClassRightRVAdapter;
import com.bwie.sort.bean.CLass_LeftRVBean;
import com.bwie.sort.presenter.SortPresenter;
import com.bwie.sort.utils.API;
import com.bwie.sort.view.ISortView;
import com.bwie.taobao.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by w h l on 2017/10/11.
 */

public class Fragment_class extends Fragment implements ISortView {

    View view;
    ArrayList<CLass_LeftRVBean.DatasBean.ClassListBean> left_list = new ArrayList<>();
    SortPresenter sortPresenter;
    ClassLeftRVAdapter leftadapter;
    ClassRightRVAdapter rightadapter;
    @BindView(R.id.recycle_left)
    RecyclerView recycleLeft;
    @BindView(R.id.recycle_right)
    RecyclerView recycleRight;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.class_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);

        recycleLeft.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycleRight.setLayoutManager(new LinearLayoutManager(getActivity()));
        sortPresenter = new SortPresenter(this);
        sortPresenter.getUrl(API.SORT_PATH);

        return view;
    }

    @Override
    public void getJson(ArrayList<CLass_LeftRVBean.DatasBean.ClassListBean> list) {
        left_list = list;
        leftadapter = new ClassLeftRVAdapter(left_list,getActivity());
        recycleLeft.setAdapter(leftadapter);

        leftadapter.setRecycleViewItemClickListener(new ClassLeftRVAdapter.OnRecycleViewItemClickListener() {
            @Override
            public void recycleViewItemClickListener(int position, View view, RecyclerView.ViewHolder viewHolder) {

                leftadapter.setTagPosition(position);
                leftadapter.notifyDataSetChanged();
                Map<String,String> mmap = new HashMap<String, String>();
                mmap.put("gc_id",left_list.get(position).getGc_id());
                sortPresenter.getrightUrl(API.SORT_PATH,mmap);

            }
        });
    }

    @Override
    public void getTypeData(ArrayList<CLass_LeftRVBean.DatasBean.ClassListBean> list) {
        ArrayList<CLass_LeftRVBean.DatasBean.ClassListBean> list2 = new ArrayList<CLass_LeftRVBean.DatasBean.ClassListBean>();
        list2 = list;
        rightadapter = new ClassRightRVAdapter(list2,getActivity());
        recycleRight.setAdapter(rightadapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
