package com.dazhukeji.douwu.ui.aty.home;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.dazhukeji.douwu.R;
import com.dazhukeji.douwu.adapter.CourseAdapter;
import com.dazhukeji.douwu.base.BaseAty;
import com.dazhukeji.douwu.manager.RecyclerViewManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/11/21 8:44
 * 功能描述：机构课程
 */
public class DanceOrgCourseAty extends BaseAty {
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.course_recyclerView)
    RecyclerView courseRecyclerView;

    private RecyclerViewManager mRecyclerViewManager;
    private List<Object> mList = new ArrayList<>();
    private CourseAdapter mCourseAdapter;
    @Override
    public int getLayoutId() {
        return R.layout.activity_danceorg_course;
    }

    @Override
    public void initView() {
        txtTitle.setText("机构课程");

        for (int i = 0; i < 6; i++) {
            mList.add(new Object());
        }
        mRecyclerViewManager = new RecyclerViewManager(courseRecyclerView);
        mRecyclerViewManager.setLinearLayoutManager(RecyclerView.VERTICAL);
        mCourseAdapter = new CourseAdapter(R.layout.course_item, mList);
        courseRecyclerView.setAdapter(mCourseAdapter);
        mCourseAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(CourseDetailsAty.class);
            }
        });
    }

    @Override
    public void initData() {

    }
}
