package com.borax.myapp.activity.recyclerviewpager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.borax.myapp.R;
import com.lsjwzh.widget.recyclerviewpager.RecyclerViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewPagerAcitivty extends AppCompatActivity {

    @BindView(R.id.viewpager)
    RecyclerViewPager viewpager;

    RecyclerViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_pager_acitivty);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initViewPager();

    }

    private void initViewPager() {

//        LinearLayoutManager layout = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//        viewpager.setLayoutManager(layout);
//
//        adapter = new RecyclerViewPagerAdapter(this);
//        viewpager.setAdapter(adapter);
//
//        viewpager.scrollToPosition(50);

    }

}
