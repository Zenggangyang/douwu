package com.dazhukeji.douwu.ui.aty.mine;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.dazhukeji.douwu.R;
import com.dazhukeji.douwu.adapter.TeacherAdapter;
import com.dazhukeji.douwu.base.BaseAty;
import com.dazhukeji.douwu.manager.RecyclerViewManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/11/22 14:56
 * 功能描述：老师管理
 */
public class ManageTeacherAty extends BaseAty {

    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.editTv)
    TextView editTv;
    @BindView(R.id.teacher_recyclerView)
    RecyclerView teacherRecyclerView;

    private RecyclerViewManager mRecyclerViewManager;
    private List<Object> mList = new ArrayList<>();
    private TeacherAdapter mTeacherAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_manage_teacher;
    }

    @Override
    public void initView() {
        txtTitle.setText("老师管理");
        editTv.setVisibility(View.VISIBLE);

        mList.add(new Object());
        mList.add(new Object());
        mRecyclerViewManager = new RecyclerViewManager(teacherRecyclerView);
        mRecyclerViewManager.setLinearLayoutManager(RecyclerView.VERTICAL);
        mTeacherAdapter = new TeacherAdapter(R.layout.teacher_item, mList);
        teacherRecyclerView.setAdapter(mTeacherAdapter);
    }

    @Override
    public void initData() {

    }

    @OnClick(R.id.editTv)
    public void onViewClicked() {
        if ("编辑".equals(editTv.getText().toString())){
            editTv.setText("完成");
            mTeacherAdapter.showEdit(true);
        }else {
            editTv.setText("编辑");
            mTeacherAdapter.showEdit(false);

        }

    }
}
