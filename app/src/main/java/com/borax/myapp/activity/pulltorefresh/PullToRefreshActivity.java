package com.borax.myapp.activity.pulltorefresh;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.borax.myapp.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.srain.cube.views.ptr.PtrDefaultHandler2;
import in.srain.cube.views.ptr.PtrFrameLayout;

public class PullToRefreshActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.listview)
    ListView listview;
    @BindView(R.id.ptrframe)
    MyPtrClassicFrameLayout ptrframe;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    int page = 1;

    private ArrayList<String> strs = new ArrayList<String>();
    private PtrListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_to_refresh);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        initData();


    }

    private void initView() {

        ptrframe.disableWhenHorizontalMove(true);
        ptrframe.setPtrHandler(new PtrDefaultHandler2() {
            @Override
            public void onLoadMoreBegin(PtrFrameLayout frame) {
                loadmore();
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                initData();
            }
        });


    }

    private void initData() {

        page = 1;

        for (int i = 0; i < 10; i++) {
            strs.add("item : " + i);
        }

        ptrframe.refreshComplete();

        adapter = new PtrListAdapter(PullToRefreshActivity.this, strs);
        listview.setAdapter(adapter);

    }

    private void loadmore() {

        page++;

        ArrayList<String> list = new ArrayList<String>();

        for (int i = 0; i < 5; i++) {
            list.add("new item : " + i + "  page : " + page);
        }

        ptrframe.refreshComplete();

        adapter.addItem(list);
    }

}
