package com.dazhukeji.douwu.ui.aty.mine;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.dazhukeji.douwu.R;
import com.dazhukeji.douwu.adapter.VideoAdpater;
import com.dazhukeji.douwu.base.BaseAty;
import com.dazhukeji.douwu.manager.RecyclerViewManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 创建者：zhangyunfei
 * 时间：2018/11/25 0025
 * 联系方式：32457127@qq.com
 */
public class MemberVideoAty extends BaseAty {
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.head_img)
    ImageView headImg;
    @BindView(R.id.name_tv)
    TextView nameTv;
    @BindView(R.id.contentTv)
    TextView contentTv;
    @BindView(R.id.video_recyclerView)
    RecyclerView videoRecyclerView;
    private RecyclerViewManager mRecyclerViewManager;
    private List<Object> mList = new ArrayList<>();
    @Override
    public int getLayoutId() {
        return R.layout.activity_member_video;
    }

    @Override
    public void initView() {
        txtTitle.setText("我的视频");
        mRecyclerViewManager = new RecyclerViewManager(videoRecyclerView);
        mRecyclerViewManager.setGridLayoutManager(2);
        for (int i = 0; i < 5; i++) {
            mList.add(new Object());
        }
        videoRecyclerView.setAdapter(new VideoAdpater(R.layout.video_item, mList));
    }

    @Override
    public void initData() {

    }
}
