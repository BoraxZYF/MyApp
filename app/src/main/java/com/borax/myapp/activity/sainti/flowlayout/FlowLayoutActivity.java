package com.borax.myapp.activity.sainti.flowlayout;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.borax.myapp.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FlowLayoutActivity extends AppCompatActivity {

    @BindView(R.id.flow_layout)
    FlowLayout flowLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow_layout);
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

        List<String> list = new ArrayList<String>();
        list.add("aaaaaaaaaaaaaaaaaaa");
        list.add("bbbbbbbbbb");
        list.add("cccccccccccccc");
        list.add("ssss");
        list.add("tttttttt");
        list.add("aaa");
        list.add("bbbbbbb");
        list.add("cccccccccccccc");
        list.add("ssss");
        list.add("tttttttt");

        for (String str : list) {

            View view = LayoutInflater.from(this).inflate(R.layout.flow_item, null);
            TextView text = (TextView) view.findViewById(R.id.text);
            text.setText(str);

            flowLayout.addView(view);

        }

    }

}
