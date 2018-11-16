package com.dazhukeji.douwu.ui.fgt.home;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

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
import com.dazhukeji.douwu.ui.aty.home.RecruitHallAty;
import com.dazhukeji.douwu.ui.aty.home.TeacherAty;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

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


    private List<String> titleList = new ArrayList<>();
    private RecyclerViewManager mRecyclerViewManager;
    private List<String> images;
    private HomeClassifyAdapter mClassifyAdapter;

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
        titlesRecyclerView.setAdapter(new TitlesAdapter(titleList));

        mRecyclerViewManager = new RecyclerViewManager(classifyRecyclerView);
        mRecyclerViewManager.setLinearLayoutManager(RecyclerView.HORIZONTAL);
        mClassifyAdapter = new HomeClassifyAdapter();
        classifyRecyclerView.setAdapter(mClassifyAdapter);
        mClassifyAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onClickListener(int position) {
                Bundle bundle=new Bundle();
                switch (position){
                    case 0:
                        bundle.putString("title",Constant.CLASSIFY_TITLES[position]);
                        startActivity(DanceOrgAty.class,bundle);
                        break;
                    case 1:
                        startActivity(TeacherAty.class);
                        break;
                    case 2:
                        startActivity(CourseAty.class);
                        break;
                    case 3:
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
        video_recyclerView.setAdapter(new VideoAdpater());

        images = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            images.add("http://e.hiphotos.baidu.com/image/pic/item/c83d70cf3bc79f3dd43c5964b7a1cd11738b2980.jpg");
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

}
