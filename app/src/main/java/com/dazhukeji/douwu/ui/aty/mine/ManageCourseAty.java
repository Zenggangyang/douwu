package com.dazhukeji.douwu.ui.aty.mine;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.dazhukeji.douwu.R;
import com.dazhukeji.douwu.adapter.CourseAdapter;
import com.dazhukeji.douwu.base.BaseAty;
import com.dazhukeji.douwu.manager.RecyclerViewManager;
import com.dazhukeji.douwu.ui.aty.home.CourseDetailsAty;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/11/22 15:47
 * 功能描述：
 */
public class ManageCourseAty extends BaseAty{
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.editTv)
    TextView editTv;
    @BindView(R.id.course_recyclerView)
    RecyclerView courseRecyclerView;

    private RecyclerViewManager mRecyclerViewManager;
    private List<Object> mList = new ArrayList<>();
    private CourseAdapter mCourseAdapter;
    @Override
    public int getLayoutId() {
        return R.layout.activity_manage_course;
    }

    @Override
    public void initView() {
        txtTitle.setText("课程管理");
        editTv.setVisibility(View.VISIBLE);
        mList.add(new Object());
        mList.add(new Object());
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

    @OnClick(R.id.editTv)
    public void onViewClicked() {
        if ("编辑".equals(editTv.getText().toString())){
            editTv.setText("添加");
        }else {
            startActivity(AddCourseAty.class);
        }

    }
}
