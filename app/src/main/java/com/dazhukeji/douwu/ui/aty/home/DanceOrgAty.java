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
import com.dazhukeji.douwu.adapter.DanceOrgAdapter;
import com.dazhukeji.douwu.adapter.TitlesAdapter;
import com.dazhukeji.douwu.api.Constant;
import com.dazhukeji.douwu.base.BaseAty;
import com.dazhukeji.douwu.manager.RecyclerViewManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/11/15 13:28
 * 功能描述：舞蹈机构
 */
public class DanceOrgAty extends BaseAty {
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
    @BindView(R.id.dance_recyclerView)
    RecyclerView danceRecyclerView;
    @BindView(R.id.info_frameLayout)
    FrameLayout infoFrameLayout;

    private List<String> titleList = new ArrayList<>();
    private RecyclerViewManager mRecyclerViewManager;
    private List<Object> mList;
    private DanceOrgAdapter mDanceOrgAdapter;
    private TitlesAdapter mTitlesAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_dance_organization;
    }

    @Override
    public void initView() {
        String title = getIntent().getExtras().getString("title");
        txtTitle.setText(title);
        infoFrameLayout.setVisibility(View.VISIBLE);

        for (int i = 0; i < Constant.TITLES.length; i++) {
            titleList.add(Constant.TITLES[i]);
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

        mList = new ArrayList<>();
        mList.add(new Object());
        mList.add(new Object());
        mList.add(new Object());
        mRecyclerViewManager = new RecyclerViewManager(danceRecyclerView);
        mRecyclerViewManager.setLinearLayoutManager(RecyclerView.VERTICAL);
        mDanceOrgAdapter = new DanceOrgAdapter(R.layout.danceorg_item, mList);
        danceRecyclerView.setAdapter(mDanceOrgAdapter);
        mDanceOrgAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(DanceOrgDetailsAty.class);
            }
        });


    }

    @Override
    public void initData() {

    }


}
