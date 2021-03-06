package com.bwie.sort.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.sort.bean.CLass_LeftRVBean;
import com.bwie.taobao.R;

import java.util.ArrayList;


/**
 * Created by whl on 2017/11/14.
 */

public class ClassLeftRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<CLass_LeftRVBean.DatasBean.ClassListBean> list;
    Context context;

    public static int tagPosition;

    public static int getTagPosition() {
        return tagPosition;
    }

    public static void setTagPosition(int tagPosition) {
        ClassLeftRVAdapter.tagPosition = tagPosition;
    }



    public ClassLeftRVAdapter(ArrayList<CLass_LeftRVBean.DatasBean.ClassListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.class_left,parent,false);
        final MyLeftViewHolder viewHolder = new MyLeftViewHolder(view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recycleViewItemClickListener.recycleViewItemClickListener(viewHolder.getPosition(),view,viewHolder);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MyLeftViewHolder)holder).textView.setText(list.get(position).getGc_name());
        if(position == getTagPosition()){
            holder.itemView.setBackgroundResource(R.color.gold);
        }else{
            holder.itemView.setBackgroundResource(R.color.moccasin);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyLeftViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public MyLeftViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.class_leftrv_text);

        }
    }

    public OnRecycleViewItemClickListener recycleViewItemClickListener;

    //定义点击接口
    public interface OnRecycleViewItemClickListener {
        void recycleViewItemClickListener(int position, View view, RecyclerView.ViewHolder viewHolder);
    }

    //提供set方法
    public void setRecycleViewItemClickListener(OnRecycleViewItemClickListener recycleViewItemClickListener) {
        this.recycleViewItemClickListener = recycleViewItemClickListener;
    }

}
