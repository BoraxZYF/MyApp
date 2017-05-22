package com.borax.myapp.activity.sainti.adViewPager;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.borax.myapp.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdViewPagerActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.ly_dots)
    LinearLayout lyDots;
    @BindView(R.id.rl_adroot)
    RelativeLayout rlAdroot;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    private ArrayList<String> urls = new ArrayList<String>();
    private CustomDetailViewPagerUtil viewPagerUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_view_pager);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        initView();

    }

    private void initView() {

        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1494927169141&di=a1d8ea1d9c3fea15d51b30b090ac67bf&imgtype=0&src=http%3A%2F%2Fimg2.niutuku.com%2Fdesk%2F1208%2F1510%2Fntk-1510-24060.jpg");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1494927169140&di=c7919fa535093da2ed45fdcea0f1d622&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F3%2F58e5fe5c34284.jpg");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1494927169140&di=44ae7a898eda1439f5d45c410f251018&imgtype=0&src=http%3A%2F%2Fbizhi.zhuoku.com%2F2013%2F04%2F07%2Fzhuoku%2Fzhuoku040.jpg");

        viewPagerUtil = new CustomDetailViewPagerUtil(this, viewpager, lyDots, 6, 4, urls);
        viewPagerUtil.initVps();


    }

}
