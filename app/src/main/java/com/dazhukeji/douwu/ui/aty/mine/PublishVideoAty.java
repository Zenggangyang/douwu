package com.dazhukeji.douwu.ui.aty.mine;

import android.widget.TextView;

import com.dazhukeji.douwu.R;
import com.dazhukeji.douwu.base.BaseAty;

import butterknife.BindView;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/11/15 11:29
 * 功能描述：发布视频
 */
public class PublishVideoAty extends BaseAty {
    @BindView(R.id.txt_title)
    TextView txtTitle;

    @Override
    public int getLayoutId() {
        return R.layout.layout_publish_video;
    }

    @Override
    public void initView() {
        txtTitle.setText("发布视频");
    }

    @Override
    public void initData() {

    }

}
