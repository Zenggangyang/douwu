package com.dazhukeji.douwu.ui.fgt.follow;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dazhukeji.douwu.R;
import com.dazhukeji.douwu.adapter.DanceOrgAdapter;
import com.dazhukeji.douwu.adapter.TeacherAdapter;
import com.dazhukeji.douwu.base.BaseFgt;
import com.dazhukeji.douwu.manager.RecyclerViewManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/11/14 11:47
 * 功能描述：关注
 */
public class FollowFragment extends BaseFgt {
    @BindView(R.id.back_img)
    ImageView backImg;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.layout_bar)
    RelativeLayout layoutBar;
    @BindView(R.id.teacher_tv)
    TextView teacherTv;
    @BindView(R.id.mechanism_tv)
    TextView mechanismTv;
    @BindView(R.id.follow_recyclerView)
    RecyclerView followRecyclerView;
    private RecyclerViewManager mRecyclerViewManager;
    private int position = 0;
    private List<Object> mList=new ArrayList<>();

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_follow;
    }

    @Override
    protected void initialized(View view) {
        backImg.setVisibility(View.GONE);
        txtTitle.setText("我的关注");
        mRecyclerViewManager = new RecyclerViewManager(followRecyclerView);
        mRecyclerViewManager.setLinearLayoutManager(RecyclerView.VERTICAL);
        for (int i = 0; i < 5; i++) {
            mList.add(new Object());
        }
        setSelect();
    }

    @Override
    protected void requestData() {

    }


    @OnClick({R.id.teacher_tv, R.id.mechanism_tv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.teacher_tv:
                position = 0;
                break;
            case R.id.mechanism_tv:
                position = 1;
                break;
        }
        setSelect();
    }

    private void setSelect() {
        teacherTv.setBackground(null);
        mechanismTv.setBackground(null);
        if (0 == position) {
            teacherTv.setBackgroundResource(R.drawable.icon_title_bg);
            followRecyclerView.setAdapter(new TeacherAdapter(R.layout.teacher_item,mList));
        } else if (1 == position) {
            mechanismTv.setBackgroundResource(R.drawable.icon_title_bg);
            followRecyclerView.setAdapter(new DanceOrgAdapter(R.layout.danceorg_item, mList));
        }

    }
}
