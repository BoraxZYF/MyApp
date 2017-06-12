package com.borax.myapp.activity.sainti.waterfall;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.borax.myapp.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WaterfallActivity extends AppCompatActivity {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;

    WaterfallAdapter adapter;

    List<PicBean> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waterfall);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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

        recyclerview.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        SpaceItemDecoration decoration = new SpaceItemDecoration(16);
        recyclerview.addItemDecoration(decoration);

        initData();

        WaterfallAdapter adapter = new WaterfallAdapter(WaterfallActivity.this, list);
        recyclerview.setAdapter(adapter);

    }

    private void initData() {

        list = new ArrayList<PicBean>();
        list.add(new PicBean(R.drawable.pic, "text1"));
        list.add(new PicBean(R.drawable.pic1, "text2"));
        list.add(new PicBean(R.drawable.pic2, "text3"));
        list.add(new PicBean(R.drawable.pic3, "text4"));
        list.add(new PicBean(R.drawable.wechat, "text5"));
        list.add(new PicBean(R.drawable.wechatc, "text6"));

    }


}
