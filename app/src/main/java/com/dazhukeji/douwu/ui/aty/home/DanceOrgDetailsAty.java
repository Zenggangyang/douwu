package com.dazhukeji.douwu.ui.aty.home;

import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.dazhukeji.douwu.R;
import com.dazhukeji.douwu.adapter.CourseAdapter;
import com.dazhukeji.douwu.adapter.TeacherAdapter;
import com.dazhukeji.douwu.adapter.VideoAdpater;
import com.dazhukeji.douwu.base.BaseAty;
import com.dazhukeji.douwu.manager.RecyclerViewManager;
import com.zhangyunfei.mylibrary.utils.DisplayHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/11/20 10:28
 * 功能描述：机构详情
 */
public class DanceOrgDetailsAty extends BaseAty {
    @BindView(R.id.back_img)
    ImageView backImg;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.info_frameLayout)
    FrameLayout infoFrameLayout;
    @BindView(R.id.course_child_recyclerView)
    RecyclerView courseChildRecyclerView;
    @BindView(R.id.teacher_recyclerView)
    RecyclerView teacherRecyclerView;
    @BindView(R.id.video_recyclerView)
    RecyclerView videoRecyclerView;
    private RecyclerViewManager mRecyclerViewManager;
    private List<Object> mList = new ArrayList<>();
    private CourseAdapter.ChildCourseAdapter mChildCourseAdapter;
    private VideoAdpater mVideoAdpater;

    @Override
    public int getLayoutId() {
        return R.layout.activity_danceorg_details;
    }

    @Override
    public void initView() {
        txtTitle.setText("机构详情");
        infoFrameLayout.setVisibility(View.VISIBLE);

        mList.add(new Object());
        mList.add(new Object());

        mRecyclerViewManager = new RecyclerViewManager(courseChildRecyclerView);
        courseChildRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerViewManager.setLinearLayoutManager(RecyclerView.VERTICAL);
        mChildCourseAdapter = new CourseAdapter.ChildCourseAdapter(R.layout.child_course_item, mList);
        courseChildRecyclerView.setAdapter(mChildCourseAdapter);
        courseChildRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) parent.getLayoutManager();
                if (parent.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                    outRect.bottom = DisplayHelper.dp2px(mContext, 15);
                }
            }
        });

        mRecyclerViewManager = new RecyclerViewManager(teacherRecyclerView);
        teacherRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerViewManager.setLinearLayoutManager(RecyclerView.VERTICAL);
        teacherRecyclerView.setAdapter(new TeacherAdapter(R.layout.teacher_item, mList));

        mRecyclerViewManager = new RecyclerViewManager(videoRecyclerView);
        videoRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerViewManager.setGridLayoutManager(2);

        mVideoAdpater = new VideoAdpater(R.layout.video_item, mList);
        videoRecyclerView.setAdapter(mVideoAdpater);

    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.see_tv, R.id.courseTv, R.id.danceTeacherTv, R.id.mechanismVideoTv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.see_tv:
                break;
            case R.id.courseTv:
                break;
            case R.id.danceTeacherTv:
                break;
            case R.id.mechanismVideoTv:
                startActivity(MechanismVideoAty.class);
                break;
        }
    }
}
