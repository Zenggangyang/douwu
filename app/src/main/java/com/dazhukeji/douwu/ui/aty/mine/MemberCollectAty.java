package com.dazhukeji.douwu.ui.aty.mine;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dazhukeji.douwu.R;
import com.dazhukeji.douwu.adapter.CourseAdapter;
import com.dazhukeji.douwu.adapter.VideoAdpater;
import com.dazhukeji.douwu.base.BaseAty;
import com.dazhukeji.douwu.manager.RecyclerViewManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/11/22 12:02
 * 功能描述：我的收藏
 */
public class MemberCollectAty extends BaseAty {
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.head_img)
    ImageView headImg;
    @BindView(R.id.name_tv)
    TextView nameTv;
    @BindView(R.id.contentTv)
    TextView contentTv;
    @BindView(R.id.collect_recyclerView)
    RecyclerView collectRecyclerView;
    @BindView(R.id.collectCourseTv)
    TextView collectCourseTv;
    @BindView(R.id.collectVideoTv)
    TextView collectVideoTv;

    private RecyclerViewManager mRecyclerViewManager;
    private int position = 0;
    private List<Object> mList = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_member_collect;
    }

    @Override
    public void initView() {
        txtTitle.setText("我的收藏");
        mRecyclerViewManager = new RecyclerViewManager(collectRecyclerView);
        for (int i = 0; i < 5; i++) {
            mList.add(new Object());
        }
        setSelect();
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.collectCourseTv, R.id.collectVideoTv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.collectCourseTv:
                position=0;
                break;
            case R.id.collectVideoTv:
                position=1;
                break;
        }
        setSelect();
    }

    private void setSelect() {
        collectCourseTv.setBackground(null);
        collectVideoTv.setBackground(null);
        if (0 == position) {
            mRecyclerViewManager.setLinearLayoutManager(RecyclerView.VERTICAL);
            collectCourseTv.setBackgroundResource(R.drawable.icon_title_bg);
            collectRecyclerView.setAdapter(new CourseAdapter(R.layout.course_item, mList));
        } else if (1 == position) {
            mRecyclerViewManager.setGridLayoutManager(2);
            collectVideoTv.setBackgroundResource(R.drawable.icon_title_bg);
            collectRecyclerView.setAdapter(new VideoAdpater(R.layout.video_item, mList));
        }

    }

}
