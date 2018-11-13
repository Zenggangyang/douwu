package com.dazhukeji.douwu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.KeyEvent;

import com.dazhukeji.douwu.base.BaseAty;
import com.zhangyunfei.mylibrary.common.ActivityStack;


public class MainActivity extends BaseAty {
    private long firstTime = 0;


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
    }

    @Override
    public void initData() {
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void exit() {
        if (System.currentTimeMillis() - firstTime < 1500) {
            ActivityStack.getInstance().appExit();
        } else {
            firstTime = System.currentTimeMillis();
            showShortToast("再按一次返回桌面", Gravity.CENTER);
        }
    }
}
