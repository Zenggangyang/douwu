package com.dazhukeji.douwu.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * 创建者：zhangyunfei
 * 时间：2018/11/19 0019
 * 联系方式：32457127@qq.com
 */
public class VideoDetailsAdapter extends BaseQuickAdapter<Object,BaseViewHolder> {
    public VideoDetailsAdapter(int layoutResId, @Nullable List<Object> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Object item) {

    }
}
