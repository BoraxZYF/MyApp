package com.borax.myapp.activity.sainti;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.borax.myapp.R;
import com.borax.myapp.activity.sainti.adViewPager.AdViewPagerActivity;
import com.borax.myapp.activity.sainti.photoView.PicsActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SaintiActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.listview)
    ListView listview;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    String[] strs = new String[]{"启动页", "轮播图", "图片放大"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sainti);
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

        listview.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, strs));

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i) {

                    case 0: {
                        Intent intent = new Intent(SaintiActivity.this, SplashActivity.class);
                        startActivity(intent);
                        break;
                    }

                    case 1: {
                        Intent intent = new Intent(SaintiActivity.this, AdViewPagerActivity.class);
                        startActivity(intent);
                        break;
                    }

                    case 2: {
                        Intent intent = new Intent(SaintiActivity.this, PicsActivity.class);
                        startActivity(intent);
                        break;
                    }

                }

            }
        });

    }

}
