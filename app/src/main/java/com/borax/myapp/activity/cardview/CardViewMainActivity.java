package com.borax.myapp.activity.cardview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.borax.myapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CardViewMainActivity extends AppCompatActivity {

    @BindView(R.id.listview)
    ListView listview;
    @BindView(R.id.content_card_view_main)
    RelativeLayout contentCardViewMain;
    private String[] strs = new String[]{"CardView", "CardViewGallery"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view_main);
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

        initView();

    }

    private void initView() {

        listview.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strs));
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i) {

                    case 0: {
                        Intent intent = new Intent(CardViewMainActivity.this, CardViewActivity.class);
                        startActivity(intent);
                        break;
                    }

                    case 1: {
                        Intent intent = new Intent(CardViewMainActivity.this, CardViewGalleryActivity.class);
                        startActivity(intent);
                        break;
                    }

                }

            }
        });

    }

}
