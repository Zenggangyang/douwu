package com.dazhukeji.douwu.ui.aty.home;

import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

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

    private List<String> titleList = new ArrayList<>();
    private RecyclerViewManager mRecyclerViewManager;
    @Override
    public int getLayoutId() {
        return R.layout.activity_dance_organization;
    }

    @Override
    public void initView() {
        String title = getIntent().getExtras().getString("title");
        txtTitle.setText(title);

        for (int i = 0; i < Constant.TITLES.length; i++) {
            titleList.add(Constant.TITLES[i]);
        }
        mRecyclerViewManager = new RecyclerViewManager(titlesRecyclerView);
        mRecyclerViewManager.setLinearLayoutManager(RecyclerView.HORIZONTAL);
        titlesRecyclerView.setAdapter(new TitlesAdapter(titleList));

        mRecyclerViewManager = new RecyclerViewManager(danceRecyclerView);
        mRecyclerViewManager.setLinearLayoutManager(RecyclerView.VERTICAL);
        danceRecyclerView.setAdapter(new DanceOrgAdapter());



    }

    @Override
    public void initData() {

    }


}
