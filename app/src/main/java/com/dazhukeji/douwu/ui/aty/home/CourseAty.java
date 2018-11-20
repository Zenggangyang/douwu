package com.dazhukeji.douwu.ui.aty.home;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.dazhukeji.douwu.R;
import com.dazhukeji.douwu.adapter.CourseAdapter;
import com.dazhukeji.douwu.adapter.TitlesAdapter;
import com.dazhukeji.douwu.api.Constant;
import com.dazhukeji.douwu.base.BaseAty;
import com.dazhukeji.douwu.manager.RecyclerViewManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/11/15 16:36
 * 功能描述：课程列表
 */
public class CourseAty extends BaseAty {

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
    @BindView(R.id.course_recyclerView)
    RecyclerView courseRecyclerView;
    @BindView(R.id.info_frameLayout)
    FrameLayout infoFrameLayout;

    private List<String> titleList = new ArrayList<>();
    private RecyclerViewManager mRecyclerViewManager;
    private List<Object> mList = new ArrayList<>();
    private CourseAdapter mCourseAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_course;
    }

    @Override
    public void initView() {
        txtTitle.setText("课程列表");
        searchContentTv.setHint("店名、舞种、拼音");
        infoFrameLayout.setVisibility(View.VISIBLE);
        for (int i = 0; i < Constant.TITLES.length; i++) {
            titleList.add(Constant.TITLES[i]);
            mList.add(new Object());
        }
        mRecyclerViewManager = new RecyclerViewManager(titlesRecyclerView);
        mRecyclerViewManager.setLinearLayoutManager(RecyclerView.HORIZONTAL);
        titlesRecyclerView.setAdapter(new TitlesAdapter(R.layout.home_title_item,titleList));

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
