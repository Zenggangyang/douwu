package com.dazhukeji.douwu.ui.fgt.mine;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dazhukeji.douwu.R;
import com.dazhukeji.douwu.base.BaseFgt;
import com.dazhukeji.douwu.ui.aty.mine.EditPersonalInfoAty;
import com.dazhukeji.douwu.ui.aty.mine.ManageCourseAty;
import com.dazhukeji.douwu.ui.aty.mine.ManageTeacherAty;
import com.dazhukeji.douwu.ui.aty.mine.MemberCollectAty;
import com.dazhukeji.douwu.ui.aty.mine.MemberFollowAty;
import com.dazhukeji.douwu.ui.aty.mine.MemberFreeEnterAty;
import com.dazhukeji.douwu.ui.aty.mine.MemberVideoAty;
import com.dazhukeji.douwu.ui.aty.mine.OrganizationRecruitAty;
import com.dazhukeji.douwu.ui.aty.mine.PurchasedCoursesAty;
import com.dazhukeji.douwu.ui.aty.mine.VoucherAty;

import butterknife.BindView;
import butterknife.OnClick;

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
    @BindView(R.id.head_img)
    ImageView headImg;
    @BindView(R.id.logo_img)
    ImageView logoImg;
    @BindView(R.id.name_tv)
    TextView nameTv;
    @BindView(R.id.contentTv)
    TextView contentTv;
    @BindView(R.id.organizationLinearLayout)
    LinearLayout organizationLinearLayout;
    @BindView(R.id.teacherLinearLayout)
    LinearLayout teacherLinearLayout;

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


    @OnClick({R.id.edit_img, R.id.memberCollectLinearLayout, R.id.memberCourseLinearLayout, R.id.memberChatLinearLayout, R.id.memberFreeEnterLinearLayout, R.id.memberVoucherLinearLayout, R.id.memberVideoLinearLayout, R.id.memberFollowLinearLayout, R.id.organizationRecruitLinearLayout, R.id.organizationManageTeacherLinearLayout, R.id.organizationManageOrgLinearLayout, R.id.organizationSendVideoLinearLayout, R.id.organizationFansLinearLayout, R.id.organizationInfoLinearLayout, R.id.organizationManageCourseLinearLayout, R.id.teacherSendVideoLinearLayout, R.id.teacherManageCourseLinearLayout, R.id.teacherManageTeacherLinearLayout, R.id.teacherFansLinearLayout, R.id.teacherInfoLinearLayout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.edit_img:
                startActivity(EditPersonalInfoAty.class);
                break;
            case R.id.memberCollectLinearLayout:
                startActivity(MemberCollectAty.class);
                break;
            case R.id.memberCourseLinearLayout:
                startActivity(PurchasedCoursesAty.class);
                break;
            case R.id.memberChatLinearLayout:
                break;
            case R.id.memberFreeEnterLinearLayout:
                startActivity(MemberFreeEnterAty.class);
                break;
            case R.id.memberVoucherLinearLayout:
                startActivity(VoucherAty.class);
                break;
            case R.id.memberVideoLinearLayout:
                startActivity(MemberVideoAty.class);
                break;
            case R.id.memberFollowLinearLayout:
                startActivity(MemberFollowAty.class);
                break;
            case R.id.organizationRecruitLinearLayout:
                startActivity(OrganizationRecruitAty.class);
                break;
            case R.id.organizationManageTeacherLinearLayout:
                startActivity(ManageTeacherAty.class);
                break;
            case R.id.organizationManageOrgLinearLayout:
                break;
            case R.id.organizationSendVideoLinearLayout:
                break;
            case R.id.organizationFansLinearLayout:
                break;
            case R.id.organizationInfoLinearLayout:
                break;
            case R.id.organizationManageCourseLinearLayout:
                startActivity(ManageCourseAty.class);
                break;
            case R.id.teacherSendVideoLinearLayout:
                break;
            case R.id.teacherManageCourseLinearLayout:
                startActivity(ManageCourseAty.class);
                break;
            case R.id.teacherManageTeacherLinearLayout:
                startActivity(ManageTeacherAty.class);
                break;
            case R.id.teacherFansLinearLayout:
                break;
            case R.id.teacherInfoLinearLayout:
                break;
        }
    }
}
