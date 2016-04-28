package com.example.benben.fresco.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.benben.fresco.R;

/**
 * Created by benben on 2016/4/28.
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainHolder> {
    private String[] mDatas = null;
    private OnItemClickListener mListener;

    public MainAdapter(String[] mDatas) {
        this.mDatas = mDatas;
    }
    /**创建ViewHolder*/
    @Override
    public MainHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false);
        MainHolder mHolder = new MainHolder(view);
        return mHolder;
    }

    /**绑定ViewHolder*/
    @Override
    public void onBindViewHolder(final MainHolder holder, final int position) {
        holder.mName.setText(mDatas[position]);

        /**设置监听*/
        if (mListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();//得到当前点击item的位置
                    mListener.ItemClickListener(holder.itemView, pos);//把事情交个实现类接口去做
                }
            });
        }
    }

    /**得到数据的数量*/
    @Override
    public int getItemCount() {
        return mDatas.length;
    }

    /**自定义的holder，持有每个item界面的所有元素*/
    public class MainHolder extends RecyclerView.ViewHolder {
        private TextView mName;
        public MainHolder(View itemView) {
            super(itemView);
            mName = (TextView) itemView.findViewById(R.id.item_main_name);
        }
    }

    /**添加点击事件*/
    public interface OnItemClickListener{
        void ItemClickListener(View view, int position);
    }

    public void setOnClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }
}
