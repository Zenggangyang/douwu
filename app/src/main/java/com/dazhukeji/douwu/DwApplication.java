package com.dazhukeji.douwu;

import com.zhangyunfei.mylibrary.base.BaseApplication;
import com.zhangyunfei.mylibrary.utils.LogUtils;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/11/13 10:55
 * 功能描述：
 */
public class DwApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.isDebug=true;
    }
}
