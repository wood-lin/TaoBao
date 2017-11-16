package com.bwie.sort.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.bwie.sort.bean.CLass_LeftRVBean;
import com.bwie.sort.bean.Class_rightRVBean;
import com.bwie.sort.presenter.SortUserPresenter;
import com.bwie.sort.utils.API;
import com.bwie.sort.view.ISortJsonView;
import com.bwie.taobao.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by whl on 2017/11/14.
 */

public class ClassRightRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements ISortJsonView {

    ArrayList<CLass_LeftRVBean.DatasBean.ClassListBean> list;
    Context context;
    MyGridAdapter gridadapter;

    SortUserPresenter sortUserPresenter;
    boolean is = true;

    ArrayList<Class_rightRVBean.DatasBean.ClassListBean> list2 = new ArrayList<>();

    public ClassRightRVAdapter(ArrayList<CLass_LeftRVBean.DatasBean.ClassListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.class_right,parent,false);
        RightViewHolder viewHolder = new RightViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((RightViewHolder)holder).textView.setText(list.get(position).getGc_name());

        Map<String,String> mmap = new HashMap<>();
        mmap.put("gc_id",list.get(position).getGc_id());
        sortUserPresenter = new SortUserPresenter(this);
        sortUserPresenter.getUrl(API.SORT_PATH,mmap,((RightViewHolder)holder).gridview,context);
//        if(is == true){
//
//            is = false;
//        }
//
//        if (list3 != null){
//
//            ((RightViewHolder)holder).gridview.setAdapter(gridadapter);
//        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void getrightUser(ArrayList<Class_rightRVBean.DatasBean.ClassListBean> list,GridView gridview) {
        gridadapter = new MyGridAdapter(list,context);
        gridview.setAdapter(gridadapter);

    }

    class RightViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        public GridView gridview;
        public RightViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.class_tv_type_text);
            gridview = (GridView) itemView.findViewById(R.id.class_right_gridview);
        }
    }

    //声明成员变量
    public OnRecycleViewItemClickListener recycleViewItemClickListener;

    //定义点击接口
    public interface OnRecycleViewItemClickListener{
        void recycleViewItemClickListener(int position, View view, RecyclerView.ViewHolder viewHolder);
    }

    //提供set方法
    public void setRecycleViewItemClickListener(OnRecycleViewItemClickListener recycleViewItemClickListener) {
        this.recycleViewItemClickListener = recycleViewItemClickListener;
    }

}
