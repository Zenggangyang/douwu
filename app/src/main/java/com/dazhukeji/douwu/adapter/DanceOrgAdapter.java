package com.dazhukeji.douwu.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.dazhukeji.douwu.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/11/15 14:17
 * 功能描述：
 */
public class DanceOrgAdapter extends RecyclerView.Adapter<DanceOrgAdapter.MyViewHolder> {

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.danceorg_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.title_tv)
        TextView titleTv;
        @BindView(R.id.classify_tv)
        TextView classifyTv;
        @BindView(R.id.address_tv)
        TextView addressTv;
        @BindView(R.id.ratingBar)
        RatingBar ratingBar;
        @BindView(R.id.score_tv)
        TextView scoreTv;
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
