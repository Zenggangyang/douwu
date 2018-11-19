package com.dazhukeji.douwu.ui.aty.home;

import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.dazhukeji.douwu.R;
import com.dazhukeji.douwu.adapter.VideoDetailsAdapter;
import com.dazhukeji.douwu.base.BaseAty;
import com.dazhukeji.douwu.manager.RecyclerViewManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 创建者：zhangyunfei
 * 时间：2018/11/19 0019
 * 联系方式：32457127@qq.com
 */
public class VideoDetailsAty extends BaseAty {
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.chat_recyclerView)
    RecyclerView chatRecyclerView;
    private RecyclerViewManager mRecyclerViewManager;
    private List<Object> mList;

    @Override
    public int getLayoutId() {
        return R.layout.activity_video_details;
    }

    @Override
    public void initView() {
        txtTitle.setText("视频播放");
        chatRecyclerView.setFocusable(false);
        mRecyclerViewManager = new RecyclerViewManager(chatRecyclerView);
        mRecyclerViewManager.setLinearLayoutManager(RecyclerView.VERTICAL);
        chatRecyclerView.setNestedScrollingEnabled(false);
        mList=new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            mList.add(new Object());
        }
        chatRecyclerView.setAdapter(new VideoDetailsAdapter(R.layout.chat_item,mList));
    }

    @Override
    public void initData() {

    }

}
