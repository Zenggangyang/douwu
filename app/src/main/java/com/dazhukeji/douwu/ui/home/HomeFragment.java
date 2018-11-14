package com.dazhukeji.douwu.ui.home;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dazhukeji.douwu.R;
import com.dazhukeji.douwu.adapter.HomeClassifyAdapter;
import com.dazhukeji.douwu.adapter.TitlesAdapter;
import com.dazhukeji.douwu.base.BaseFgt;
import com.dazhukeji.douwu.loader.BannerLoader;
import com.dazhukeji.douwu.manager.RecyclerViewManager;
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

    private List<String> titleList = new ArrayList<>();
    private RecyclerViewManager mRecyclerViewManager;
    private List<String> images;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initialized(View view) {
        for (int i = 0; i < 8; i++) {
            titleList.add("抖音舞" + (i + 1));
        }
        mRecyclerViewManager = new RecyclerViewManager(titlesRecyclerView);
        mRecyclerViewManager.setLinearLayoutManager(RecyclerView.HORIZONTAL);
        titlesRecyclerView.setAdapter(new TitlesAdapter(titleList));

        mRecyclerViewManager = new RecyclerViewManager(classifyRecyclerView);
        mRecyclerViewManager.setLinearLayoutManager(RecyclerView.HORIZONTAL);
        classifyRecyclerView.setAdapter(new HomeClassifyAdapter());
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

}
