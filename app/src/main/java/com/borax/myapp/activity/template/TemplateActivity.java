package com.borax.myapp.activity.template;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.borax.myapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TemplateActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.listview)
    ListView listview;

    private final String[] strs = new String[]{"BaiscActivity", "ButtomNavigationActivity", "EmptyActivity", "FullScreenActivity", "LoginActivity", "NabigationDrawerActivity", "SettingsActivity"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template);
        ButterKnife.bind(this);

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

                        Intent intent = new Intent(TemplateActivity.this, BaiscActivity.class);
                        startActivity(intent);

                        break;
                    }

                    case 1: {

                        Intent intent = new Intent(TemplateActivity.this, BottomNavigationActivity.class);
                        startActivity(intent);

                        break;
                    }

                    case 2: {

                        Intent intent = new Intent(TemplateActivity.this, EmptyActivity.class);
                        startActivity(intent);

                        break;
                    }

                    case 3: {

                        Intent intent = new Intent(TemplateActivity.this, FullscreenActivity.class);
                        startActivity(intent);

                        break;
                    }

                    case 4: {

                        Intent intent = new Intent(TemplateActivity.this, LoginActivity.class);
                        startActivity(intent);

                        break;
                    }

                    case 5: {

                        Intent intent = new Intent(TemplateActivity.this, NavigationDrawerActivity.class);
                        startActivity(intent);

                        break;
                    }

                    case 6: {

                        Intent intent = new Intent(TemplateActivity.this, SettingsActivity.class);
                        startActivity(intent);

                        break;
                    }

                }

            }
        });

    }
}
