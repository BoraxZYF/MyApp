package com.borax.myapp.activity.sainti.photoView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.borax.myapp.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PicsActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.listview)
    ListView listview;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    PicsListAdapter adapter;

    ArrayList<String> list = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pics);
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

        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1494927169141&di=a1d8ea1d9c3fea15d51b30b090ac67bf&imgtype=0&src=http%3A%2F%2Fimg2.niutuku.com%2Fdesk%2F1208%2F1510%2Fntk-1510-24060.jpg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1494927169140&di=c7919fa535093da2ed45fdcea0f1d622&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F3%2F58e5fe5c34284.jpg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1494927169140&di=44ae7a898eda1439f5d45c410f251018&imgtype=0&src=http%3A%2F%2Fbizhi.zhuoku.com%2F2013%2F04%2F07%2Fzhuoku%2Fzhuoku040.jpg");

        adapter = new PicsListAdapter(this, list);

        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(PicsActivity.this, PhotoViewActivity.class);
                intent.putExtra("piclist", list);
                intent.putExtra("current", i);
                startActivity(intent);

            }
        });

    }

}
