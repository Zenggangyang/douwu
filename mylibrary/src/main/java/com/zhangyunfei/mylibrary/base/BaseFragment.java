package com.zhangyunfei.mylibrary.base;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhangyunfei.mylibrary.utils.ToastUtils;


/**
 * 创建者：zhangyunfei
 * 创建时间：2018/7/19 10:48
 * 功能描述：
 */
public abstract class BaseFragment extends Fragment implements BaseView{

    private Context mContext;
    protected boolean isViewVisible;//fragment是否可见

    /**
     * 用于设置页面布局
     */
    protected abstract int getLayoutResId();

    /**
     * 初始化数据
     */
    protected abstract void initialized(View view);

    protected abstract void requestData();



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext=context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(getLayoutResId(), container, false);
        initialized(layout);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        requestData();
    }


    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden){
            isViewVisible = true;
            requestData();
        }
    }

    public Context getContext(){
        if (mContext==null){
            mContext=BaseApplication.getAppContext();
        }
       return mContext;
    }

    @Override
    public void showLoading(String title) {
    }

    @Override
    public void stopLoading() {
    }

    @Override
    public void onComplete(String requestUrl, String jsonStr) {

    }

    @Override
    public void onFailure(String msg) {
        ToastUtils.showShort(msg, Gravity.CENTER);
    }

}
