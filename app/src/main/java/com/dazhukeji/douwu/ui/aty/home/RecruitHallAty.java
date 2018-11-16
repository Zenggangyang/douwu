package com.dazhukeji.douwu.ui.aty.home;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.dazhukeji.douwu.R;
import com.dazhukeji.douwu.adapter.RecruitHallAdapter;
import com.dazhukeji.douwu.base.BaseAty;
import com.dazhukeji.douwu.manager.RecyclerViewManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/11/16 8:39
 * 功能描述：招聘大厅
 */
public class RecruitHallAty extends BaseAty {
    @BindView(R.id.back_img)
    ImageView backImg;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.recruit_recyclerView)
    RecyclerView recruitRecyclerView;

    private RecyclerViewManager mRecyclerViewManager;
    private List<Object> mList=new ArrayList<>();
    private RecruitHallAdapter mRecruitHallAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_recruit_hall;
    }

    @Override
    public void initView() {
        txtTitle.setText("招聘大厅");
        for (int i = 0; i < 3; i++) {
            mList.add(new Object());
        }
        mRecyclerViewManager = new RecyclerViewManager(recruitRecyclerView);
        mRecyclerViewManager.setLinearLayoutManager(RecyclerView.VERTICAL);
        mRecruitHallAdapter = new RecruitHallAdapter(R.layout.recruit_item, mList);
        recruitRecyclerView.setAdapter(mRecruitHallAdapter);
        mRecruitHallAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(RecruitDetailsAty.class);
            }
        });
    }

    @Override
    public void initData() {

    }

}
