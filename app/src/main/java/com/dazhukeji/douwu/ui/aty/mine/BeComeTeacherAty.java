package com.dazhukeji.douwu.ui.aty.mine;

import android.widget.TextView;

import com.dazhukeji.douwu.R;
import com.dazhukeji.douwu.base.BaseAty;

import butterknife.BindView;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/11/26 13:57
 * 功能描述：成为教师
 */
public class BeComeTeacherAty extends BaseAty{
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public void initView() {
        txtTitle.setText("课程列表");

    }

    @Override
    public void initData() {

    }
}
