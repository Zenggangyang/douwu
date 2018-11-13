package com.zhangyunfei.mylibrary.base;

import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.zhangyunfei.mylibrary.R;
import com.zhangyunfei.mylibrary.broadcast.NetBroadcastReceiver;
import com.zhangyunfei.mylibrary.broadcast.NetEvent;
import com.zhangyunfei.mylibrary.common.ActivityStack;
import com.zhangyunfei.mylibrary.utils.DenisityUtils;
import com.zhangyunfei.mylibrary.utils.LogUtils;
import com.zhangyunfei.mylibrary.utils.NetWorkUtils;
import com.zhangyunfei.mylibrary.utils.PermissionHelper;
import com.zhangyunfei.mylibrary.utils.StatusBarHelper;
import com.zhangyunfei.mylibrary.utils.ToastUtils;


/**
 * 创建者：zhangyunfei
 * 创建时间：2018/7/18 14:10
 * 功能描述：
 */
public abstract class BaseActivity extends AppCompatActivity implements NetEvent, BaseView {

    private FrameLayout content;
    public TextView rootText;
    protected Context mContext;

    /**
     * 网络类型
     */
    private int netMobile;
    private NetBroadcastReceiver mNetBroadcastReceiver;
    public static NetEvent mEvent;

    private BaseApplication mApplication;

    /**
     * 是否使用沉浸式,如果不使用，需在
     * super.onCreate(savedInstanceState)之前设置为flase
     * 默认设置
     */
    public boolean changeStatusBar = true;
    private boolean isConfigChange = false;

    public abstract int getLayoutId();

    public abstract void initView();

    public abstract void initData();



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext=this;
        mApplication = BaseApplication.getApplication();
        DenisityUtils.setCustomDensity(this, mApplication);
        inspectNet();
        mEvent = this;
        isConfigChange = false;
        ActivityStack.getInstance().addActivity(this);
        if (changeStatusBar) {
            StatusBarHelper.translucent(this);
            StatusBarHelper.setStatusBarLightMode(this);
        }
        setContentView(R.layout.activity_base);
        //初始化控件
        initControls();
        initView();
    }


    private void initControls() {
        content = findViewById(R.id.content);
        rootText = new TextView(this);
        rootText.setTextSize(20);
        rootText.setTextColor(ContextCompat.getColor( this,R.color.txt_black));
        View view = View.inflate(this, getLayoutId(), null);
        content.addView(view);
        content.addView(rootText);
        if (LogUtils.isDebug) {
            rootText.setText(getClass().getName());
        } else {
            rootText.setVisibility(View.GONE);
        }
    }

    protected void showNetErrorTip() {
        ToastUtils.showToastWithImg(getText(R.string.no_net).toString(), R.mipmap.ic_wifi_off);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (isNetConnect()) {
            initData();
        } else {
            showNetErrorTip();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mNetBroadcastReceiver = new NetBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(mNetBroadcastReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mNetBroadcastReceiver);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionHelper.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        isConfigChange = true;

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (!isConfigChange) {
            ActivityStack.getInstance().finishActivity();
        }
    }

    /**
     * 初始化时判断有没有网络
     */

    public boolean inspectNet() {
        this.netMobile = NetWorkUtils.getNetWorkState(BaseActivity.this);
        return isNetConnect();

        // if (netMobile == 1) {
        // System.out.println("inspectNet：连接wifi");
        // } else if (netMobile == 0) {
        // System.out.println("inspectNet:连接移动数据");
        // } else if (netMobile == -1) {
        // System.out.println("inspectNet:当前没有网络");
        //
        // }
    }

    /**
     * 判断有无网络 。
     *
     * @return true 有网, false 没有网络.
     */
    public boolean isNetConnect() {
        if (netMobile == 1) {
            return true;
        } else if (netMobile == 0) {
            return true;
        } else if (netMobile == -1) {
            return false;

        }
        return false;
    }

    @Override
    public void onNetChange(int netMobile) {
        this.netMobile = netMobile;
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

    }
}
