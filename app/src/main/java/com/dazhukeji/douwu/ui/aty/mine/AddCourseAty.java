package com.dazhukeji.douwu.ui.aty.mine;

import android.widget.TextView;

import com.dazhukeji.douwu.R;
import com.dazhukeji.douwu.base.BaseAty;

import butterknife.BindView;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/11/22 15:54
 * 功能描述：
 */
public class AddCourseAty extends BaseAty{
    @BindView(R.id.txt_title)
    TextView txtTitle;

    @Override
    public int getLayoutId() {
        return R.layout.activity_add_course;
    }

    @Override
    public void initView() {
        txtTitle.setText("添加课程");
    }

    @Override
    public void initData() {

    }
}
