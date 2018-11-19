package com.dazhukeji.douwu.ui.aty.home;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.dazhukeji.douwu.R;
import com.dazhukeji.douwu.adapter.TitlesAdapter;
import com.dazhukeji.douwu.adapter.VideoAdpater;
import com.dazhukeji.douwu.api.Constant;
import com.dazhukeji.douwu.base.BaseAty;
import com.dazhukeji.douwu.manager.RecyclerViewManager;
import com.zhangyunfei.mylibrary.utils.DisplayHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/11/19 16:17
 * 功能描述：精彩视频
 */
public class VideoAty extends BaseAty {
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.titles_recyclerView)
    RecyclerView titlesRecyclerView;
    @BindView(R.id.search_content_tv)
    EditText searchContentTv;
    @BindView(R.id.search_tv)
    TextView searchTv;
    @BindView(R.id.select_tv)
    TextView selectTv;
    @BindView(R.id.select2_tv)
    TextView selectTv2;
    @BindView(R.id.time_relativeLayout)
    RelativeLayout timeRelativeLayout;
    @BindView(R.id.video_relativeLayout)
    RelativeLayout videoRelativeLayout;
    @BindView(R.id.video_recyclerView)
    RecyclerView videoRecyclerView;
    private PopupWindow mTimePopupWindow;
    private PopupWindow mVideoPopupWindow;
    private RecyclerViewManager mRecyclerViewManager;
    private List<String> mTitleList=new ArrayList<>();
    private VideoAdpater mVideoAdpater;
    private List<Object> mList;

    @Override
    public int getLayoutId() {
        return R.layout.activity_video;
    }

    @Override
    public void initView() {
        txtTitle.setText("精彩视频");
        searchContentTv.setHint("请输入您要搜索的名称");
        Drawable drawableLeft3 = getResources().getDrawable(
                R.drawable.icon_video_teacher);
        selectTv2.setCompoundDrawablesWithIntrinsicBounds(drawableLeft3,
                null, null, null);
        selectTv2.setCompoundDrawablePadding(2);

        for (int i = 0; i < Constant.TITLES.length; i++) {
            mTitleList.add(Constant.TITLES[i]);
        }
        mRecyclerViewManager = new RecyclerViewManager(titlesRecyclerView);
        mRecyclerViewManager.setLinearLayoutManager(RecyclerView.HORIZONTAL);
        titlesRecyclerView.setAdapter(new TitlesAdapter(mTitleList));

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

    @OnClick({R.id.search_tv, R.id.time_relativeLayout, R.id.video_relativeLayout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.search_tv:
                break;
            case R.id.time_relativeLayout:
                setTimePop();
                break;
            case R.id.video_relativeLayout:
                setVideoPop();
                break;
        }
    }

    private void setTimePop() {
        if (null == mTimePopupWindow) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.layout_pop, null);
            TextView timeTv = view.findViewById(R.id.time_tv);
            TextView collecTv = view.findViewById(R.id.collect_tv);
            mTimePopupWindow = new PopupWindow(view, DisplayHelper.dp2px(mContext, 100),
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            mTimePopupWindow.setBackgroundDrawable(null);
            mTimePopupWindow.setOutsideTouchable(false);
            mTimePopupWindow.showAsDropDown(timeRelativeLayout);
            timeTv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Drawable drawableLeft = getResources().getDrawable(
                            R.drawable.icon_time);

                    selectTv.setCompoundDrawablesWithIntrinsicBounds(drawableLeft,
                            null, null, null);
                    selectTv.setCompoundDrawablePadding(2);
                    selectTv.setText("时间");
                    mTimePopupWindow.dismiss();
                }
            });
            collecTv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Drawable drawableLeft = getResources().getDrawable(
                            R.drawable.icon_heart);

                    selectTv.setCompoundDrawablesWithIntrinsicBounds(drawableLeft,
                            null, null, null);
                    selectTv.setCompoundDrawablePadding(2);
                    selectTv.setText("收藏度");
                    mTimePopupWindow.dismiss();
                }
            });
        } else {
            if (mTimePopupWindow.isShowing()) {
                mTimePopupWindow.dismiss();
            } else {
                mTimePopupWindow.showAsDropDown(timeRelativeLayout);
            }
        }
    }

    private void setVideoPop() {
        if (null == mVideoPopupWindow) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.layout_pop, null);
            TextView timeTv = view.findViewById(R.id.time_tv);
            TextView collecTv = view.findViewById(R.id.collect_tv);
            TextView videoTv = view.findViewById(R.id.video_tv);
            videoTv.setVisibility(View.VISIBLE);
            timeTv.setText("教师视频");
            Drawable drawableLeft = getResources().getDrawable(
                    R.drawable.icon_video_teacher);
            timeTv.setCompoundDrawablesWithIntrinsicBounds(drawableLeft,
                    null, null, null);
            timeTv.setCompoundDrawablePadding(2);
            collecTv.setText("机构视频");
            Drawable drawableLeft2 = getResources().getDrawable(
                    R.drawable.icon_video_jigou);
            collecTv.setCompoundDrawablesWithIntrinsicBounds(drawableLeft2,
                    null, null, null);
            collecTv.setCompoundDrawablePadding(2);
            videoTv.setText("精彩视频");

            mVideoPopupWindow = new PopupWindow(view, DisplayHelper.dp2px(mContext, 100),
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            mVideoPopupWindow.setBackgroundDrawable(null);
            mVideoPopupWindow.setOutsideTouchable(false);
            mVideoPopupWindow.showAsDropDown(videoRelativeLayout);
            timeTv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Drawable drawableLeft = getResources().getDrawable(
                            R.drawable.icon_video_teacher);

                    selectTv2.setCompoundDrawablesWithIntrinsicBounds(drawableLeft,
                            null, null, null);
                    selectTv2.setCompoundDrawablePadding(2);
                    selectTv2.setText("教师视频");
                    mVideoPopupWindow.dismiss();
                }
            });
            collecTv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Drawable drawableLeft = getResources().getDrawable(
                            R.drawable.icon_video_jigou);

                    selectTv2.setCompoundDrawablesWithIntrinsicBounds(drawableLeft,
                            null, null, null);
                    selectTv2.setCompoundDrawablePadding(2);
                    selectTv2.setText("机构视频");
                    mVideoPopupWindow.dismiss();
                }
            });
            videoTv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Drawable drawableLeft = getResources().getDrawable(
                            R.drawable.icon_star);

                    selectTv2.setCompoundDrawablesWithIntrinsicBounds(drawableLeft,
                            null, null, null);
                    selectTv2.setCompoundDrawablePadding(2);
                    selectTv2.setText("精彩视频");
                    mVideoPopupWindow.dismiss();
                }
            });
        } else {
            if (mVideoPopupWindow.isShowing()) {
                mVideoPopupWindow.dismiss();
            } else {
                mVideoPopupWindow.showAsDropDown(videoRelativeLayout);
            }
        }
    }
}
