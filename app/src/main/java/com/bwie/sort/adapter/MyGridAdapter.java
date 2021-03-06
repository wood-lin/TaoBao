package com.bwie.sort.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwie.sort.bean.Class_rightRVBean;
import com.bwie.taobao.R;

import java.util.ArrayList;


/**
 * Created by whl on 2017/11/14.
 */

public class MyGridAdapter extends BaseAdapter {

    ArrayList<Class_rightRVBean.DatasBean.ClassListBean> list;
    Context context;


    public MyGridAdapter(ArrayList<Class_rightRVBean.DatasBean.ClassListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MyGridViewHolder holder;
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.class_gridview_right_item,viewGroup,false);
            holder = new MyGridViewHolder();
            holder.textView = (TextView) view.findViewById(R.id.class_right_gridview_text);
            view.setTag(holder);
        }else{
            holder = (MyGridViewHolder) view.getTag();
        }
        Class_rightRVBean.DatasBean.ClassListBean data = (Class_rightRVBean.DatasBean.ClassListBean) getItem(i);

        holder.textView.setText(data.getGc_name());

        return view;
    }

    static class MyGridViewHolder{
        TextView textView;
    }

}
