package com.dazhukeji.douwu.ui.fgt.mine;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dazhukeji.douwu.R;
import com.dazhukeji.douwu.base.BaseFgt;

import butterknife.BindView;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/11/14 11:48
 * 功能描述：
 */
public class MyFragment extends BaseFgt {
    @BindView(R.id.back_img)
    ImageView backImg;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initialized(View view) {
        backImg.setVisibility(View.GONE);
        txtTitle.setText("个人中心");
    }

    @Override
    protected void requestData() {

    }
}
