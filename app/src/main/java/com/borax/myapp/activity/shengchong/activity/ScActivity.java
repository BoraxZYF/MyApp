package com.borax.myapp.activity.shengchong.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;

import com.borax.myapp.R;
import com.borax.myapp.activity.recyclerviewpager.RecyclerViewPagerAdapter;
import com.borax.myapp.activity.shengchong.entity.DateBean;
import com.lsjwzh.widget.recyclerviewpager.RecyclerViewPager;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import util.DateUtils;

public class ScActivity extends AppCompatActivity {

    @BindView(R.id.viewpager)
    RecyclerViewPager viewpager;

    Toolbar toolbar;

    RecyclerViewPagerAdapter adapter;

    int currentYear = 0;
    int currentYearWeek = 0;
    int currentYearWeekNum = 0;
    int lastYear = 0;
    int lastYearWeekNum = 0;
    int lastYearStartWeek = 0;
    int nextYear = 0;
    int nextYearLastWeek = 0;

    int currentDayPage = 0;

    List<DateBean> dateList = new ArrayList<DateBean>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sc);
        ButterKnife.bind(this);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initDate();
        initView();
    }

    private void initView() {

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        viewpager.setLayoutManager(layoutManager);
        adapter = new RecyclerViewPagerAdapter(this, dateList);

        viewpager.setAdapter(adapter);

        viewpager.scrollToPosition(currentDayPage);

        viewpager.addOnPageChangedListener(new RecyclerViewPager.OnPageChangedListener() {
            @Override
            public void OnPageChanged(int i, int i1) {

                if (i1 != currentDayPage) {
                    DateBean date = dateList.get((i1) * 7);
                    toolbar.setTitle(date.getYear() + "年" + date.getMonth()  + "月 ");
                } else {
                    toolbar.setTitle("圣宠管家");
                }

            }
        });

    }

    private void initDate() {

        //获取今年、上一年、下一年
        currentYear = Integer.parseInt(DateUtils.getCurrentYear());
        lastYear = currentYear - 1;
        nextYear = currentYear + 1;

        //获取今天、上一年、下一年的今天是第几周
        Date lastYearDate = DateUtils.parseToDate(lastYear + "-" + DateUtils.getCurrentMonthDay());
        Date nextYearDate = DateUtils.parseToDate(nextYear + "-" + DateUtils.getCurrentMonthDay());
        currentYearWeek = DateUtils.getWeekOfYear(DateUtils.getCurrentDate());
        lastYearStartWeek = DateUtils.getWeekOfYear(lastYearDate);
        nextYearLastWeek = DateUtils.getWeekOfYear(nextYearDate);

        //防止最后一周跨年，1月的周>50则为今年第0周
        int currentMonth = Integer.parseInt(DateUtils.getCurrentMonth());

        if (currentMonth == 1) {
            if (currentYearWeek > 50) {
                currentYearWeek = 0;
            }

            if (lastYearStartWeek > 50) {
                lastYearStartWeek = 0;
            }

            if (nextYearLastWeek > 50) {
                nextYearLastWeek = 0;
            }
        }

        //获取今年、上一年最多有几周
        currentYearWeekNum = DateUtils.getMaxWeekNumOfYear(currentYear);
        lastYearWeekNum = DateUtils.getMaxWeekNumOfYear(lastYear);

        for (int i = lastYearStartWeek; i <= lastYearWeekNum; i++) {
            dateList.addAll(DateUtils.getDaysOfWeek(lastYear, i));
        }

        for (int i = 0; i <= currentYearWeekNum; i++) {
            dateList.addAll(DateUtils.getDaysOfWeek(currentYear, i));
            if (i == currentYearWeek) {
                currentDayPage = lastYearWeekNum - lastYearStartWeek + i;
                Logger.d(currentDayPage);
            }
        }

        for (int i = 0; i <= nextYearLastWeek; i++) {
            dateList.addAll(DateUtils.getDaysOfWeek(nextYear, i));
        }

        Logger.d(currentDayPage);

    }


}
