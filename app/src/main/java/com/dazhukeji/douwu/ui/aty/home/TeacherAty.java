package com.dazhukeji.douwu.ui.aty.home;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.dazhukeji.douwu.R;
import com.dazhukeji.douwu.adapter.TeacherAdapter;
import com.dazhukeji.douwu.adapter.TitlesAdapter;
import com.dazhukeji.douwu.api.Constant;
import com.dazhukeji.douwu.base.BaseAty;
import com.dazhukeji.douwu.manager.RecyclerViewManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/11/15 14:29
 * 功能描述：老师列表
 */
public class TeacherAty extends BaseAty {
    @BindView(R.id.back_img)
    ImageView backImg;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.layout_bar)
    RelativeLayout layoutBar;
    @BindView(R.id.titles_recyclerView)
    RecyclerView titlesRecyclerView;
    @BindView(R.id.search_content_tv)
    EditText searchContentTv;
    @BindView(R.id.search_tv)
    TextView searchTv;
    @BindView(R.id.teacher_recyclerView)
    RecyclerView teacherRecyclerView;

    private List<String> titleList = new ArrayList<>();
    private RecyclerViewManager mRecyclerViewManager;
    private List<Object> mList=new ArrayList<>();
    private TeacherAdapter mTeacherAdapter;
    private TitlesAdapter mTitlesAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_teacher;
    }

    @Override
    public void initView() {
        txtTitle.setText("老师列表");

        for (int i = 0; i < Constant.TITLES.length; i++) {
            titleList.add(Constant.TITLES[i]);
            mList.add(new Object());
        }
        mRecyclerViewManager = new RecyclerViewManager(titlesRecyclerView);
        mRecyclerViewManager.setLinearLayoutManager(RecyclerView.HORIZONTAL);
        mTitlesAdapter = new TitlesAdapter(R.layout.home_title_item, titleList);
        titlesRecyclerView.setAdapter(mTitlesAdapter);
        mTitlesAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mTitlesAdapter.setSelectPosition(position);
            }
        });

        mRecyclerViewManager = new RecyclerViewManager(teacherRecyclerView);
        mRecyclerViewManager.setLinearLayoutManager(RecyclerView.VERTICAL);
        mTeacherAdapter = new TeacherAdapter(R.layout.teacher_item, mList);
        teacherRecyclerView.setAdapter(mTeacherAdapter);
        mTeacherAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(TeacherDetailsAty.class);
            }
        });


    }

    @Override
    public void initData() {

    }

}
