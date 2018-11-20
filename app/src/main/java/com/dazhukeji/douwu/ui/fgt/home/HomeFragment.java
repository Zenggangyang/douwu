package com.dazhukeji.douwu.ui.fgt.home;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.dazhukeji.douwu.R;
import com.dazhukeji.douwu.adapter.HomeClassifyAdapter;
import com.dazhukeji.douwu.adapter.TitlesAdapter;
import com.dazhukeji.douwu.adapter.VideoAdpater;
import com.dazhukeji.douwu.api.Constant;
import com.dazhukeji.douwu.api.OnItemClickListener;
import com.dazhukeji.douwu.base.BaseFgt;
import com.dazhukeji.douwu.loader.BannerLoader;
import com.dazhukeji.douwu.manager.RecyclerViewManager;
import com.dazhukeji.douwu.ui.aty.home.CourseAty;
import com.dazhukeji.douwu.ui.aty.home.DanceOrgAty;
import com.dazhukeji.douwu.ui.aty.home.NoticeDetailsAty;
import com.dazhukeji.douwu.ui.aty.home.RecruitHallAty;
import com.dazhukeji.douwu.ui.aty.home.TeacherAty;
import com.dazhukeji.douwu.ui.aty.home.VideoAty;
import com.dazhukeji.douwu.ui.aty.home.VideoDetailsAty;
import com.dazhukeji.douwu.ui.aty.mine.PublishVideoAty;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.zaaach.citypicker.CityPicker;
import com.zaaach.citypicker.adapter.OnPickListener;
import com.zaaach.citypicker.model.City;
import com.zaaach.citypicker.model.HotCity;
import com.zaaach.citypicker.model.LocateState;
import com.zaaach.citypicker.model.LocatedCity;
import com.zhangyunfei.mylibrary.utils.DisplayHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 首页
 */
public class HomeFragment extends BaseFgt {
    @BindView(R.id.titles_recyclerView)
    RecyclerView titlesRecyclerView;
    @BindView(R.id.banner)
    Banner mBanner;
    @BindView(R.id.classify_recyclerView)
    RecyclerView classifyRecyclerView;
    @BindView(R.id.video_recyclerView)
    RecyclerView video_recyclerView;
    @BindView(R.id.select_tv)
    TextView selectTv;
    @BindView(R.id.pop_relativeLayout)
    RelativeLayout popRelativeLayout;
    @BindView(R.id.location_tv)
    TextView locationTv;
    @BindView(R.id.notice_img)
    ImageView noticeImg;
    @BindView(R.id.video_img)
    ImageView videoImg;
    @BindView(R.id.pic_img)
    ImageView picImg;
    @BindView(R.id.lewu_img)
    ImageView lewuImg;
    @BindView(R.id.music_img)
    ImageView musicImg;


    private List<String> titleList = new ArrayList<>();
    private RecyclerViewManager mRecyclerViewManager;
    private List<Integer> images;
    private HomeClassifyAdapter mClassifyAdapter;

    private PopupWindow mPopupWindow;
    private VideoAdpater mVideoAdpater;
    private List<Object> mList;
    private TitlesAdapter mTitlesAdapter;


    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initialized(View view) {
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

        mRecyclerViewManager = new RecyclerViewManager(classifyRecyclerView);
        mRecyclerViewManager.setLinearLayoutManager(RecyclerView.HORIZONTAL);
        mClassifyAdapter = new HomeClassifyAdapter();
        classifyRecyclerView.setAdapter(mClassifyAdapter);
        mClassifyAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onClickListener(int position) {
                Bundle bundle = new Bundle();
                switch (position) {
                    case 0:
                        bundle.putString("title", Constant.CLASSIFY_TITLES[position]);
                        startActivity(DanceOrgAty.class, bundle);
                        break;
                    case 1:
                        startActivity(TeacherAty.class);
                        break;
                    case 2:
                        startActivity(CourseAty.class);
                        break;
                    case 3:
                        startActivity(VideoAty.class);
                        break;
                    case 4:
                        startActivity(RecruitHallAty.class);
                        break;
                }
            }
        });

        mRecyclerViewManager = new RecyclerViewManager(video_recyclerView);
        mRecyclerViewManager.setGridLayoutManager(2);
        video_recyclerView.setNestedScrollingEnabled(false);
        mList=new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            mList.add(new Object());
        }
        mVideoAdpater = new VideoAdpater(R.layout.video_item,mList);
        video_recyclerView.setAdapter(mVideoAdpater);
        mVideoAdpater.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(VideoDetailsAty.class);
            }
        });
        images = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            //            images.add("http://e.hiphotos.baidu.com/image/pic/item/c83d70cf3bc79f3dd43c5964b7a1cd11738b2980.jpg");
            images.add(R.drawable.icon_douwu_bg);
        }
        //设置banner样式
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器
        mBanner.setImageLoader(new BannerLoader());
        //设置图片集合
        mBanner.setImages(images);
        //设置banner动画效果
        mBanner.setBannerAnimation(Transformer.DepthPage);
        //设置自动轮播，默认为true
        mBanner.isAutoPlay(true);
        //设置轮播时间
        mBanner.setDelayTime(2000);
        //设置指示器位置（当banner模式中有指示器时）
        mBanner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        mBanner.start();
    }

    @Override
    protected void requestData() {
    }

    @Override
    public void onStart() {
        super.onStart();
        //开始轮播
        mBanner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        //结束轮播
        mBanner.stopAutoPlay();
    }

    @OnClick({R.id.location_tv, R.id.pop_relativeLayout, R.id.notice_img,R.id.video_img, R.id.pic_img, R.id.lewu_img, R.id.music_img})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.location_tv:
                setCity();
                break;
            case R.id.pop_relativeLayout:
                setPop();
                break;
            case R.id.notice_img:
                startActivity(NoticeDetailsAty.class);
                break;
            case R.id.video_img:
                setPic();
                startActivity(PublishVideoAty.class);
                break;
            case R.id.pic_img:
                setPic();
                startActivity(PublishVideoAty.class);
                break;
            case R.id.lewu_img:
                setPic();
                break;
            case R.id.music_img:
                setPic();
                startActivity(PublishVideoAty.class);
                break;
        }
    }

    private void setPic() {
        if (videoImg.getVisibility()== View.VISIBLE){
            videoImg.setVisibility(View.GONE);
            picImg.setVisibility(View.GONE);
            musicImg.setVisibility(View.GONE);
        }else {
            videoImg.setVisibility(View.VISIBLE);
            picImg.setVisibility(View.VISIBLE);
            musicImg.setVisibility(View.VISIBLE);
        }
    }

    private void setCity() {
        List<HotCity> hotCities = new ArrayList<>();
        hotCities.add(new HotCity("北京", "北京", "101010100"));
        hotCities.add(new HotCity("上海", "上海", "101020100"));
        hotCities.add(new HotCity("广州", "广东", "101280101"));
        hotCities.add(new HotCity("深圳", "广东", "101280601"));
        hotCities.add(new HotCity("杭州", "浙江", "101210101"));

        CityPicker.getInstance()
                .setFragmentManager(getFragmentManager())    //此方法必须调用
                .enableAnimation(true)    //启用动画效果
                .setAnimationStyle(R.style.DefaultCityPickerAnimation)    //自定义动画
                .setLocatedCity(new LocatedCity("杭州", "浙江", "101210101"))  //APP自身已定位的城市，默认为null（定位失败）
                .setHotCities(hotCities)    //指定热门城市
                .setOnPickListener(new OnPickListener() {
                    @Override
                    public void onPick(int position, City data) {
                        Toast.makeText(mContext, data.getName(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onLocate() {
                        //开始定位，这里模拟一下定位
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                //定位完成之后更新数据
                                CityPicker.getInstance()
                                        .locateComplete(new LocatedCity("深圳", "广东", "101280601"), LocateState.SUCCESS);
                            }
                        }, 2000);
                    }
                })
                .show();
    }

    private void setPop() {
        if (null == mPopupWindow) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.layout_pop, null);
            TextView timeTv = view.findViewById(R.id.time_tv);
            TextView collecTv = view.findViewById(R.id.collect_tv);
            mPopupWindow = new PopupWindow(view, DisplayHelper.dp2px(mContext, 100),
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            mPopupWindow.setBackgroundDrawable(null);
            mPopupWindow.setOutsideTouchable(false);
            mPopupWindow.showAsDropDown(popRelativeLayout);
            timeTv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Drawable drawableLeft = getResources().getDrawable(
                            R.drawable.icon_time);

                    selectTv.setCompoundDrawablesWithIntrinsicBounds(drawableLeft,
                            null, null, null);
                    selectTv.setCompoundDrawablePadding(2);
                    selectTv.setText("时间");
                    mPopupWindow.dismiss();
                }
            });
            collecTv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Drawable drawableLeft = getResources().getDrawable(
                            R.drawable.icon_star);

                    selectTv.setCompoundDrawablesWithIntrinsicBounds(drawableLeft,
                            null, null, null);
                    selectTv.setCompoundDrawablePadding(2);
                    selectTv.setText("收藏度");
                    mPopupWindow.dismiss();
                }
            });
        } else {
            if (mPopupWindow.isShowing()) {
                mPopupWindow.dismiss();
            } else {
                mPopupWindow.showAsDropDown(popRelativeLayout);
            }
        }
    }

}
