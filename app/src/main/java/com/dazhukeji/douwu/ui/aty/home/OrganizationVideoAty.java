package com.dazhukeji.douwu.ui.aty.home;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.dazhukeji.douwu.R;
import com.dazhukeji.douwu.adapter.VideoAdpater;
import com.dazhukeji.douwu.base.BaseAty;
import com.dazhukeji.douwu.manager.RecyclerViewManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/11/20 15:24
 * 功能描述：机构视频
 */
public class OrganizationVideoAty extends BaseAty {
    @BindView(R.id.back_img)
    ImageView backImg;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.video_recyclerView)
    RecyclerView videoRecyclerView;
    private RecyclerViewManager mRecyclerViewManager;
    private List<Object> mList;
    private VideoAdpater mVideoAdpater;

    @Override
    public int getLayoutId() {
        return R.layout.activity_mechanism_video;
    }

    @Override
    public void initView() {
        txtTitle.setText("机构视频");
        mRecyclerViewManager = new RecyclerViewManager(videoRecyclerView);
        mRecyclerViewManager.setGridLayoutManager(2);
        videoRecyclerView.setNestedScrollingEnabled(false);
        mList=new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            mList.add(new Object());
        }
        mVideoAdpater = new VideoAdpater(R.layout.video_item,mList);
        videoRecyclerView.setAdapter(mVideoAdpater);
        mVideoAdpater.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(VideoDetailsAty.class);
            }
        });
    }

    @Override
    public void initData() {

    }

}
