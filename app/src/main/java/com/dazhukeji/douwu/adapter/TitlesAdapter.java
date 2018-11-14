package com.dazhukeji.douwu.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dazhukeji.douwu.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 创建者：zhangyunfei
 * 时间：2018/11/14 0014
 * 联系方式：32457127@qq.com
 */
public class TitlesAdapter extends RecyclerView.Adapter<TitlesAdapter.ViewHolder> {

    private List<String> titles;

    public TitlesAdapter(List<String> titles) {
        this.titles = titles;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_title_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.homeTitleTv.setText(titles.get(position));
    }

    @Override
    public int getItemCount() {
        return titles.size() > 0 ? titles.size() : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.home_title_tv)
        TextView homeTitleTv;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
