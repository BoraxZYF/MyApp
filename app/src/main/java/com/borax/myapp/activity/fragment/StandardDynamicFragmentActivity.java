package com.borax.myapp.activity.fragment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.View;

import com.borax.myapp.R;

import fragment.Fragment1;
import fragment.Fragment2;

public class StandardDynamicFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard_dynamic_fragment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Standard Dynamic Fragment");

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

        Display display = getWindowManager().getDefaultDisplay();

        if (display.getHeight() > display.getWidth()) {
            Fragment fragment = new Fragment1();
            getFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        } else {
            Fragment fragment = new Fragment2();
            getFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        }

    }

}
