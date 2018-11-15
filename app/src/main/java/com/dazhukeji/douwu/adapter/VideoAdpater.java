package com.dazhukeji.douwu.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dazhukeji.douwu.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/11/15 9:59
 * 功能描述：
 */
public class VideoAdpater extends RecyclerView.Adapter<VideoAdpater.MyViewHolder> {

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 8;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.head_img)
        ImageView headImg;
        @BindView(R.id.name_tv)
        TextView nameTv;
        @BindView(R.id.num_tv)
        TextView numTv;
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
