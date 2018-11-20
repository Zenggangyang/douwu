package com.dazhukeji.douwu.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/11/15 14:17
 * 功能描述：
 */
public class DanceOrgAdapter extends BaseQuickAdapter<Object,BaseViewHolder> {
    public DanceOrgAdapter(int layoutResId, @Nullable List<Object> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Object item) {
        /*@BindView(R.id.title_tv)
        TextView titleTv;
        @BindView(R.id.classify_tv)
        TextView classifyTv;
        @BindView(R.id.address_tv)
        TextView addressTv;
        @BindView(R.id.ratingBar)
        RatingBar ratingBar;
        @BindView(R.id.score_tv)
        TextView scoreTv;*/
    }
}
