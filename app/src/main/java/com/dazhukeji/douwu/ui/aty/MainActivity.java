package com.dazhukeji.douwu.ui.aty;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;

import com.dazhukeji.douwu.R;
import com.dazhukeji.douwu.base.BaseAty;
import com.dazhukeji.douwu.ui.fgt.follow.FollowFragment;
import com.dazhukeji.douwu.ui.fgt.forum.ForumFragment;
import com.dazhukeji.douwu.ui.fgt.home.HomeFragment;
import com.dazhukeji.douwu.ui.fgt.mine.MyFragment;
import com.zhangyunfei.mylibrary.common.ActivityStack;


public class MainActivity extends BaseAty {
    private long firstTime = 0;

    private HomeFragment mHomeFragment;
    private ForumFragment mForumFragment;
    private FollowFragment mFollowFragment;
    private MyFragment mMyFragment;

    // 四个子Fragment的Tag
    public static final String TAG_HOME = "Home";
    public static final String TAG_FORUM = "Forum";
    public static final String TAG_FOLLOW = "Follow";
    public static final String TAG_MINE = "Mine";
    private String hideTag;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        mHomeFragment=new HomeFragment();
       switchFragment(mHomeFragment,TAG_HOME);
    }

    @Override
    public void initData() {
    }

    /**
     * 选择不同的fragment
     */
    private void switchFragment(Fragment fragment, String tag) {
        FragmentManager mFragmentManager = getFragmentManager();
        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();

        Fragment tagFragment = mFragmentManager.findFragmentByTag(tag);
        if (tagFragment == null) {
            mFragmentTransaction.add(R.id.fragment_container, fragment, tag);
        } else {
            mFragmentTransaction.show(tagFragment);
        }

        tagFragment = mFragmentManager.findFragmentByTag(hideTag);

        if (tagFragment != null && !tagFragment.equals(fragment)) {
            mFragmentTransaction.hide(tagFragment);
        }
        hideTag = tag;
        mFragmentTransaction.commit();
    }

    public void onTabClicked(View view) {
        int viewId = view.getId();
        switch (viewId) {
            case R.id.re_home:
                if (mHomeFragment==null){
                    mHomeFragment=new HomeFragment();
                }
                switchFragment(mHomeFragment,TAG_HOME);
                break;
            case R.id.re_forum:
                if (mForumFragment==null){
                    mForumFragment=new ForumFragment();
                }
                switchFragment(mForumFragment,TAG_FORUM);
                break;
            case R.id.re_follow:
                if (mFollowFragment==null){
                    mFollowFragment=new FollowFragment();
                }
                switchFragment(mFollowFragment,TAG_FOLLOW);

                break;
            case R.id.re_mine:
//                if (Config.isLogin()){
                if (mMyFragment==null){
                    mMyFragment=new MyFragment();
                }
                switchFragment(mMyFragment,TAG_MINE);

//                }else {
//                    startActivity(LoginAty.class);
//                }
                break;
        }
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
