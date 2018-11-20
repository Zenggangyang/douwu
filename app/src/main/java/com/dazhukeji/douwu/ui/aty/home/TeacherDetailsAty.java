package com.dazhukeji.douwu.ui.aty.home;

import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.dazhukeji.douwu.R;
import com.dazhukeji.douwu.adapter.CourseAdapter;
import com.dazhukeji.douwu.adapter.VideoAdpater;
import com.dazhukeji.douwu.base.BaseAty;
import com.dazhukeji.douwu.manager.RecyclerViewManager;
import com.dazhukeji.douwu.view.RatingBar;
import com.zhangyunfei.mylibrary.utils.DisplayHelper;
import com.zhangyunfei.mylibrary.utils.GlideApp;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;

/**
 * 创建者：zhangyunfei
 * 时间：2018/11/20 0020
 * 联系方式：32457127@qq.com
 */
public class TeacherDetailsAty extends BaseAty {
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.ratingBar)
    RatingBar ratingBar;
    @BindView(R.id.score_tv)
    TextView scoreTv;
    @BindView(R.id.videoplayer)
    JzvdStd videoplayer;
    @BindView(R.id.course_child_recyclerView)
    RecyclerView courseChildRecyclerView;
    @BindView(R.id.video_recyclerView)
    RecyclerView videoRecyclerView;

    private RecyclerViewManager mRecyclerViewManager;
    private List<Object> mList = new ArrayList<>();

    private CourseAdapter.ChildCourseAdapter mChildCourseAdapter;
    private VideoAdpater mVideoAdpater;
    @Override
    public int getLayoutId() {
        return R.layout.activity_teacher_details;
    }

    @Override
    public void initView() {
        txtTitle.setText("老师详情");
        videoplayer.setUp("http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4"
                , "" , Jzvd.SCREEN_WINDOW_NORMAL);
        GlideApp.with(this).load("http://jzvd-pic.nathen.cn/jzvd-pic/1bb2ebbe-140d-4e2e-abd2-9e7e564f71ac.png").into(videoplayer.thumbImageView);

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

        mRecyclerViewManager = new RecyclerViewManager(videoRecyclerView);
        videoRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerViewManager.setGridLayoutManager(2);

        mVideoAdpater = new VideoAdpater(R.layout.video_item, mList);
        videoRecyclerView.setAdapter(mVideoAdpater);

    }
    @Override
    public void onBackPressed() {
        if (Jzvd.backPress()) {
            return;
        }
        super.onBackPressed();
    }
    @Override
    protected void onPause() {
        super.onPause();
        Jzvd.releaseAllVideos();
    }
    @Override
    public void initData() {

    }

    @OnClick({R.id.courseTv, R.id.mechanismVideoTv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.courseTv:
                startActivity(TeacherCourseAty.class);
                break;
            case R.id.mechanismVideoTv:
                startActivity(TeacherVideoAty.class);
                break;
        }
    }
}
