package com.dazhukeji.douwu.ui.aty.mine;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dazhukeji.douwu.R;
import com.dazhukeji.douwu.base.BaseAty;
import com.dazhukeji.douwu.view.MyEditText;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/11/22 11:06
 * 功能描述：修改个人信息
 */
public class EditPersonalInfoAty extends BaseAty {
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.head_img)
    ImageView headImg;
    @BindView(R.id.user_name_edit)
    MyEditText userNameEdit;
    @BindView(R.id.sign_edit)
    MyEditText signEdit;
    @BindView(R.id.boy_tv)
    TextView boyTv;
    @BindView(R.id.girl_tv)
    TextView girlTv;
    @BindView(R.id.confirm_revision_tv)
    TextView confirmRevisionTv;

    @Override
    public int getLayoutId() {
        return R.layout.activity_personal_info;
    }

    @Override
    public void initView() {
        txtTitle.setText("修改个人信息");
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.head_img, R.id.confirm_revision_tv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.head_img:
                break;
            case R.id.confirm_revision_tv:
                break;
        }
    }
}
