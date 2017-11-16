package com.bwie.home.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.bwie.home.bean.HomeBean;
import com.bwie.home.utils.GlideImaGlideImageLoader;
import com.bwie.taobao.R;
import com.facebook.drawee.view.SimpleDraweeView;
import com.youth.banner.Banner;

import java.util.ArrayList;


public class XRAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    HomeBean.DataBean list;
    Context mcontext;
    ArrayList  mlist;

    //枚举类型
      private  enum  Item_Type{

          Typeone ,Typetwo,Typethree,Typefour

    }
    public XRAdapter(Context context, HomeBean.DataBean data) {
        this.mcontext=context;
        this.list=data;

    }
    /**
     * 创建ViewHolder
     *
     * @param parent
     * @param viewType :不同ItemView的类型
     * @return
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == Item_Type.Typeone.ordinal()) {
            View mView = LayoutInflater.from(mcontext).inflate(R.layout.recycle_item_a, null);
            ViewHolderA viewHolder = new ViewHolderA(mView);
            return viewHolder;

        } else if (viewType == Item_Type.Typetwo.ordinal()) {

            View mView = LayoutInflater.from(mcontext).inflate(R.layout.recycle_item_b, null);
            ViewHolderB viewHolder = new ViewHolderB(mView);
            return viewHolder;
        } else if (viewType == Item_Type.Typethree.ordinal()) {
            View mView = LayoutInflater.from(mcontext).inflate(R.layout.recycle_item_c, null);
            ViewHolderC viewHolder = new ViewHolderC(mView);
            return viewHolder;
        }else if (viewType == Item_Type.Typefour.ordinal()) {
            View mView = LayoutInflater.from(mcontext).inflate(R.layout.recycle_item_d, null);
            ViewHolderD viewHolder = new ViewHolderD(mView);
            return viewHolder;
        }
        return null;
    }

    /**
     * 绑定数据：可以直接拿到已经绑定控件的Viewholder对象
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolderA) {
            mlist=new ArrayList();
            for(int i=0;i<list.getAd1().size();i++){
                mlist.add(list.getAd1().get(i).getImage());
            }
            //设置图片加载器
            ((ViewHolderA) holder).mbanner.setImageLoader(new GlideImaGlideImageLoader());
            ((ViewHolderA) holder).mbanner.setImages(mlist);
            ((ViewHolderA) holder).mbanner.start();

        } else if (holder instanceof ViewHolderC) {
            ((ViewHolderC) holder).gridView.setAdapter(new GridAdapter());
        }else if (holder instanceof ViewHolderD) {
            ((ViewHolderD) holder).recyclerView.setLayoutManager(new GridLayoutManager(mcontext,2));
            ((ViewHolderD) holder).recyclerView.setAdapter(new HomeAdapter());
        }

    }

    @Override
    public int getItemCount() {
        return 4;
    }
    //返回值赋值给onCreateViewHolder的参数 viewType
    @Override
    public int getItemViewType(int position) {
       // return super.getItemViewType(position);

        if (position == 0) {
            return Item_Type.Typeone.ordinal();
        } else if (position == 1) {
            return Item_Type.Typetwo.ordinal();
        } else if (position == 2) {
            return Item_Type.Typethree.ordinal();
        }else if (position == 3) {
            return Item_Type.Typefour.ordinal();
        }
        return -1;


    }
    class ViewHolderA extends RecyclerView.ViewHolder {
        public Banner mbanner;

        public ViewHolderA(View itemView) {
            super(itemView);

            mbanner = (Banner) itemView.findViewById(R.id.mybanner);
        }
    }


    class ViewHolderB extends RecyclerView.ViewHolder {
        public ViewHolderB(View itemView) {
            super(itemView);
        }
    }

    class ViewHolderC extends RecyclerView.ViewHolder {

        public GridView gridView;

        public ViewHolderC(View itemView) {
            super(itemView);
            gridView = (GridView) itemView.findViewById(R.id.gridview);
        }
    }
    class ViewHolderD extends RecyclerView.ViewHolder {

        public RecyclerView recyclerView;

        public ViewHolderD(View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.recyclerview);
        }
    }

    /*GridView的适配器*/
    private class GridAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            //给几项数据
            return list.getAd8().size();
        }

        @Override
        public Object getItem(int i) {
            return i;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = LayoutInflater.from(mcontext).inflate(R.layout.c_item,null);
            TextView text = (TextView) view.findViewById(R.id.tvc);
            SimpleDraweeView img = (SimpleDraweeView) view.findViewById(R.id.img_c);
            text.setText(list.getAd8().get(i).getTitle());
            Uri uri = Uri.parse(list.getAd8().get(i).getImage());
            img.setImageURI(uri);
            return view;
        }
    }
    /*RecyclerView的适配器*/
    class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                    mcontext).inflate(R.layout.d_item, parent,
                    false));
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.tv.setText(list.getDefaultGoodsList().get(position).getGoods_name());
            Uri uri = Uri.parse(list.getDefaultGoodsList().get(position).getGoods_img());
            holder.img2.setImageURI(uri);
        }

        @Override
        public int getItemCount() {
            return list.getDefaultGoodsList().size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            TextView tv;
            SimpleDraweeView img2;

            public MyViewHolder(View view) {
                super(view);
                tv = (TextView) view.findViewById(R.id.tvd);
                img2= (SimpleDraweeView) view.findViewById(R.id.img_d);

            }
        }
    }
}
