package com.borax.myapp.activity.tablayout;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.borax.myapp.R;

import java.util.ArrayList;

import adapter.TabLayoutAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class TabLayoutActivity extends AppCompatActivity {

    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.content_tab_layout)
    LinearLayout contentTabLayout;

    private ArrayList<String> titles = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("TabLayout Activity");
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        initView();

    }

    private void initView() {

        createTitles();
        TabLayoutAdapter adapter = new TabLayoutAdapter(getSupportFragmentManager(), this, titles);
        viewpager.setOffscreenPageLimit(8);
        viewpager.setAdapter(adapter);
        tablayout.setupWithViewPager(viewpager);
        for (int i = 0; i < tablayout.getTabCount(); i++) {
            TabLayout.Tab tab = tablayout.getTabAt(i);
            tab.setCustomView(adapter.getTabView(i));
        }

    }

    private void createTitles() {

        titles.add("全部");
        titles.add("母婴");
        titles.add("服装");
        titles.add("食品");
        titles.add("美容护肤");
        titles.add("全部");
        titles.add("母婴");
        titles.add("服装");
        titles.add("食品");
        titles.add("美容护肤");

    }

}
