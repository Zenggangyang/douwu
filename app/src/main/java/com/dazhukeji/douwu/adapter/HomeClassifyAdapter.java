package com.dazhukeji.douwu.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dazhukeji.douwu.R;
import com.zhangyunfei.mylibrary.utils.DisplayHelper;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 创建者：zhangyunfei
 * 时间：2018/11/14 0014
 * 联系方式：32457127@qq.com
 */
public class HomeClassifyAdapter extends RecyclerView.Adapter<HomeClassifyAdapter.ViewHolder> {


    private Context mContext;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.home_classify_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RecyclerView.LayoutParams params=new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.width= DisplayHelper.getScreenWidth(mContext)/getItemCount();
        holder.classifyLayout.setLayoutParams(params);
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.classify_img)
        ImageView classifyImg;
        @BindView(R.id.classify_tv)
        TextView classifyTv;
        @BindView(R.id.classify_layout)
        LinearLayout classifyLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
