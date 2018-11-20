package com.dazhukeji.douwu.ui.aty.home;

import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.dazhukeji.douwu.R;
import com.dazhukeji.douwu.adapter.CourseAdapter;
import com.dazhukeji.douwu.base.BaseAty;
import com.dazhukeji.douwu.manager.RecyclerViewManager;
import com.zhangyunfei.mylibrary.utils.DisplayHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 创建者：zhangyunfei
 * 时间：2018/11/20 0020
 * 联系方式：32457127@qq.com
 */
public class TeacherCourseAty extends BaseAty {
    @BindView(R.id.txt_title)
    TextView txtTitle;

    @BindView(R.id.course_child_recyclerView)
    RecyclerView courseChildRecyclerView;

    private RecyclerViewManager mRecyclerViewManager;
    private List<Object> mList = new ArrayList<>();

    private CourseAdapter.ChildCourseAdapter mChildCourseAdapter;
    @Override
    public int getLayoutId() {
        return R.layout.activity_teacher_course;
    }

    @Override
    public void initView() {
        txtTitle.setText("教师课程");

        mList.add(new Object());
        mList.add(new Object());
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
    }

    @Override
    public void initData() {

    }
}
