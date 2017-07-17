package com.borax.myapp.activity.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;

import com.borax.myapp.R;
import com.borax.myapp.activity.BaseActivity;
import com.borax.myapp.activity.view.view.DispatchChildButton;
import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewDispatchActivity extends BaseActivity {

    @BindView(R.id.button)
    DispatchChildButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_dispatch);
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

//        button.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return true;
//            }
//        });

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        Logger.d("Activity on TouchEvent");

        return super.onTouchEvent(event);
    }

    @OnClick(R.id.button)
    public void onViewClicked() {

        showToast("Child Button Clicked");

    }
}
