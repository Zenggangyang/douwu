package com.dazhukeji.douwu.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/11/15 9:59
 * 功能描述：
 */
public class VideoAdpater extends BaseQuickAdapter<Object,BaseViewHolder>{
    public VideoAdpater(int layoutResId, @Nullable List<Object> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Object item) {

    }
}
