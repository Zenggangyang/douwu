package com.dazhukeji.douwu.ui.aty.mine;

import android.widget.TextView;

import com.dazhukeji.douwu.R;
import com.dazhukeji.douwu.base.BaseAty;
import com.dazhukeji.douwu.view.MyEditText;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/11/22 14:14
 * 功能描述：我要招聘
 */
public class OrganizationRecruitAty extends BaseAty {
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.administratorsNameEdit)
    MyEditText administratorsNameEdit;
    @BindView(R.id.addressEdit)
    MyEditText addressEdit;
    @BindView(R.id.timeEdit)
    MyEditText timeEdit;
    @BindView(R.id.ageEdit)
    MyEditText ageEdit;
    @BindView(R.id.applicationRequirementsEdit)
    MyEditText applicationRequirementsEdit;
    @BindView(R.id.typeEdit)
    MyEditText typeEdit;

    @Override
    public int getLayoutId() {
        return R.layout.activity_organization_recruit;
    }

    @Override
    public void initView() {
        txtTitle.setText("我要招聘");
    }

    @Override
    public void initData() {

    }

    @OnClick(R.id.confirmTv)
    public void onViewClicked() {
    }
}
