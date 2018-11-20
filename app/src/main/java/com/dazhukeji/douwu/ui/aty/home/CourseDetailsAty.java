package com.dazhukeji.douwu.ui.aty.home;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.dazhukeji.douwu.R;
import com.dazhukeji.douwu.base.BaseAty;

import butterknife.BindView;

/**
 * 创建者：zhangyunfei
 * 时间：2018/11/19 0019
 * 联系方式：32457127@qq.com
 */
public class CourseDetailsAty extends BaseAty {
    @BindView(R.id.back_img)
    ImageView backImg;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.info_frameLayout)
    FrameLayout infoFrameLayout;

    @Override
    public int getLayoutId() {
        return R.layout.activity_course_detail;
    }

    @Override
    public void initView() {
        backImg.setVisibility(View.GONE);
        txtTitle.setText("课程详情");
        infoFrameLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void initData() {

    }
}
