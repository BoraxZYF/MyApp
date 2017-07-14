package com.borax.myapp.activity.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ViewStubCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.borax.myapp.R;
import com.borax.myapp.activity.view.view.FollowFingerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewActivity extends AppCompatActivity {

    @BindView(R.id.listview)
    ListView listview;
    private String[] strs = new String[]{"Simple Layout", "Simple View", "Velocity Tracker",
            "Follow Finger View", "ScrollView With ListView", "GestureDetector",
            "ScrollTo/By", "SmoothScrollTo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("View Activity");
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

        listview.setAdapter(new ArrayAdapter<String>(ViewActivity.this, android.R.layout.simple_list_item_1, strs));
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i) {

                    case 0: {
                        Intent intent = new Intent(ViewActivity.this, SimpleLayoutActivity.class);
                        startActivity(intent);
                        break;
                    }

                    case 1: {
                        Intent intent = new Intent(ViewActivity.this, SimpleViewActivity.class);
                        startActivity(intent);
                        break;
                    }

                    case 2: {
                        Intent intent = new Intent(ViewActivity.this, VelocityTrackerAcitvity.class);
                        startActivity(intent);
                        break;
                    }

                    case 3: {
                        Intent intent = new Intent(ViewActivity.this, MoveViewActivity.class);
                        startActivity(intent);
                        break;
                    }

                    case 4: {
                        Intent intent = new Intent(ViewActivity.this, ScrollViewWithListViewActivity.class);
                        startActivity(intent);
                        break;
                    }

                    case 5: {
                        Intent intent = new Intent(ViewActivity.this, GestureDetectorActivity.class);
                        startActivity(intent);
                        break;
                    }

                    case 6: {
                        Intent intent = new Intent(ViewActivity.this, ScrollToByActivity.class);
                        startActivity(intent);
                        break;
                    }

                    case 7: {
                        Intent intent = new Intent(ViewActivity.this, SmoothScrollActivity.class);
                        startActivity(intent);
                        break;
                    }

                }

            }
        });

    }

}
