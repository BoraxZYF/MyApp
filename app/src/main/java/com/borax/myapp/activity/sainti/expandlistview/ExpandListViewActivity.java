package com.borax.myapp.activity.sainti.expandlistview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ExpandableListView;

import com.borax.myapp.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExpandListViewActivity extends AppCompatActivity {

    @BindView(R.id.listview)
    ExpandableListView listview;

    List<String> groupList;
    List<List<String>> childList;

    ExpandListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expand_list_view);
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

        groupList = new ArrayList<String>();
        childList = new ArrayList<List<String>>();

        initGroup();
        initChild();

        adapter = new ExpandListAdapter(this, groupList, childList);

        listview.setAdapter(adapter);


    }

    private void initGroup() {

        for (int i = 0; i < 10; i++) {
            groupList.add("group" + i);
        }

    }

    private void initChild() {

        for (int i = 0; i < groupList.size(); i++) {

            List<String> list = new ArrayList<String>();

            for (int j = 0; j < 5; j++) {
                list.add("group " + i + " child " + j);
            }

            childList.add(list);

        }
    }


}
