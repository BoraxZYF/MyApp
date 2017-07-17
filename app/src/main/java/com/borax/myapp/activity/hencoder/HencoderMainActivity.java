package com.borax.myapp.activity.hencoder;

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
import android.widget.SimpleAdapter;

import com.borax.myapp.R;
import com.borax.myapp.activity.hencoder.hencoder2.Hencoder2MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HencoderMainActivity extends AppCompatActivity {

    @BindView(R.id.listview)
    ListView listview;

    String[] strs = new String[]{"View1-1绘制基础", "View1-2Paint"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hencoder_main);
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

        listview.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, strs));

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {

                    case 0: {

                        break;
                    }

                    case 1: {
                        Intent intent = new Intent(HencoderMainActivity.this, Hencoder2MainActivity.class);
                        startActivity(intent);
                        break;
                    }

                }

            }
        });


    }

}
