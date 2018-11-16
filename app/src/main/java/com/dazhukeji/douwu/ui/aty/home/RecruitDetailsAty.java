package com.dazhukeji.douwu.ui.aty.home;

import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dazhukeji.douwu.R;
import com.dazhukeji.douwu.base.BaseAty;
import com.dazhukeji.douwu.manager.RecyclerViewManager;
import com.zhangyunfei.mylibrary.utils.DisplayHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/11/16 9:48
 * 功能描述：招聘详情
 */
public class RecruitDetailsAty extends BaseAty{
    @BindView(R.id.back_img)
    ImageView backImg;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.pic_recyclerView)
    RecyclerView picRecyclerView;

    private RecyclerViewManager mRecyclerViewManager;
    private List<Object> mList=new ArrayList<>();
    private PicAdapter mPicAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_recruit_details;
    }

    @Override
    public void initView() {
        txtTitle.setText("招聘详情");
        mRecyclerViewManager = new RecyclerViewManager(picRecyclerView);
        mRecyclerViewManager.setLinearLayoutManager(RecyclerView.HORIZONTAL);
        mList.add(new Object());
        mList.add(new Object());
        mPicAdapter = new PicAdapter(R.layout.pic_item, mList);
        picRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                LinearLayoutManager layoutManager = (LinearLayoutManager) parent.getLayoutManager();
                if (parent.getChildAdapterPosition(view)!=(layoutManager.getItemCount()-1)){
                    outRect.right= DisplayHelper.dp2px(mContext,13);
                }
            }
        });
        picRecyclerView.setAdapter(mPicAdapter);

    }

    @Override
    public void initData() {

    }


    public static class  PicAdapter extends BaseQuickAdapter<Object,BaseViewHolder>{

        public PicAdapter(int layoutResId, @Nullable List<Object> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, Object item) {

        }
    }
}
