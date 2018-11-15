package com.dazhukeji.douwu.ui.aty.home;

import android.graphics.Color;
import android.widget.CalendarView;
import android.widget.Toast;

import com.dazhukeji.douwu.R;
import com.dazhukeji.douwu.base.BaseAty;

import butterknife.BindView;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/11/15 17:37
 * 功能描述：
 */
public class CalendarAty extends BaseAty {
    @BindView(R.id.calendarView)
    CalendarView calendarView;

    @Override
    public int getLayoutId() {
        return R.layout.layout_calendar;
    }

    @Override
    public void initView() {
        calendarView.setBackgroundColor(Color.WHITE);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                String content = year + "-" + (month + 1) + "-" + dayOfMonth;
                Toast.makeText(mContext, "你选择了:\n" + content, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void initData() {

    }

}
