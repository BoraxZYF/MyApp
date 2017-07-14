package com.borax.myapp.activity.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.borax.myapp.R;
import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GestureDetectorActivity extends AppCompatActivity implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener {

    GestureDetector mGestureDetector;
    @BindView(R.id.text)
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture_detector);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mGestureDetector = new GestureDetector(this, this);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        boolean consume = mGestureDetector.onTouchEvent(event);

        return consume;
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {

        text.setText("onDown");

        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

        text.setText("onShowPress");

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {

        text.setText("onSingleTapUp");

        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {

        text.setText("onScroll");

        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

        text.setText("onLongPress");

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {

        text.setText("onFling");

        return false;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {

        text.setText("onSingleTapConfirmed");

        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {

        text.setText("onDoubleTap");

        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {

        text.setText("onDoubleTapEvent");


        return false;
    }
}
