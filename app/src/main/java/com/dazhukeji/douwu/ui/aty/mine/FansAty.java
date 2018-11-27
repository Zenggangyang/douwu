package com.dazhukeji.douwu.ui.aty.mine;

import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.dazhukeji.douwu.R;
import com.dazhukeji.douwu.adapter.DynamicAdapter;
import com.dazhukeji.douwu.adapter.FansAdapter;
import com.dazhukeji.douwu.base.BaseAty;
import com.dazhukeji.douwu.manager.RecyclerViewManager;
import com.zhangyunfei.mylibrary.utils.DisplayHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/11/27 13:36
 * 功能描述：我的粉丝
 */
public class FansAty extends BaseAty {
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.fansRecyclerView)
    RecyclerView fansRecyclerView;
    @BindView(R.id.dynamicRecyclerView)
    RecyclerView dynamicRecyclerView;

    private RecyclerViewManager mRecyclerViewManager;
    private List<Object> mList = new ArrayList<>();
    @Override
    public int getLayoutId() {
        return R.layout.activity_fans;
    }

    @Override
    public void initView() {
        txtTitle.setText("我的粉丝");
        for (int i = 0; i < 5; i++) {
            mList.add(new Object());
        }
        mRecyclerViewManager = new RecyclerViewManager(fansRecyclerView);
        mRecyclerViewManager.setLinearLayoutManager(RecyclerView.HORIZONTAL);
        fansRecyclerView.setAdapter(new FansAdapter(R.layout.fans_item,mList));
        fansRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                LinearLayoutManager layoutManager= (LinearLayoutManager) parent.getLayoutManager();
                if (parent.getChildAdapterPosition(view) != layoutManager.getItemCount()+1){
                    outRect.right= DisplayHelper.dp2px(mContext,20);
                }
            }
        });

        mRecyclerViewManager = new RecyclerViewManager(dynamicRecyclerView);
        mRecyclerViewManager.setGridLayoutManager(2);
        dynamicRecyclerView.setAdapter(new DynamicAdapter(R.layout.dynamic_item,mList));
        dynamicRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                if (parent.getChildAdapterPosition(view)/2==0){
                    outRect.right= DisplayHelper.dp2px(mContext,20);
                }
            }
        });
    }

    @Override
    public void initData() {

    }

}
