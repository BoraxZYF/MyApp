package com.borax.myapp.activity.materialdesign;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.os.Bundle;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;

import com.borax.myapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PathInterpolatorActivity extends AppCompatActivity {

    @BindView(R.id.view)
    View view;
    @BindView(R.id.content_path_interpolator)
    RelativeLayout contentPathInterpolator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_path_interpolator);
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

    }

    @OnClick(R.id.view)
    public void onClick() {
        startAnim(view.getX(), view.getY());
    }


    private void startAnim(float x, float y) {

        LinearOutSlowInInterpolator pathInterpolator = new LinearOutSlowInInterpolator();
        Path path = new Path();
        path.lineTo(x, y);
//        path.cubicTo(100, 0, 300, 900, 500, 600);

        ObjectAnimator mAnimaotr;
        mAnimaotr = ObjectAnimator.ofFloat(view, view.X, view.Y, path);
        mAnimaotr.setInterpolator(pathInterpolator);
        mAnimaotr.setDuration(2000);
        mAnimaotr.start();

    }
}
