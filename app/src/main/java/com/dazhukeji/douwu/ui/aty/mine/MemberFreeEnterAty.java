package com.dazhukeji.douwu.ui.aty.mine;

import android.view.View;

import com.dazhukeji.douwu.R;
import com.dazhukeji.douwu.base.BaseAty;

import butterknife.OnClick;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/11/26 11:26
 * 功能描述：
 */
public class MemberFreeEnterAty extends BaseAty {
    @Override
    public int getLayoutId() {
        return R.layout.activity_member_free_enter;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }


    @OnClick({R.id.orgLinearLayout, R.id.teacherLinearLayout, R.id.nextTv, R.id.rootLayout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.orgLinearLayout:
                startActivity(BeComeOrgAty.class);
                break;
            case R.id.teacherLinearLayout:
                startActivity(BeComeTeacherAty.class);
                break;
            case R.id.nextTv:
                break;
            case R.id.rootLayout:
                break;
        }
        finish();
    }
}
