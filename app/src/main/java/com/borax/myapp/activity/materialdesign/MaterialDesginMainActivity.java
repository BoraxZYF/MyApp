package com.borax.myapp.activity.materialdesign;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Pair;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.borax.myapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MaterialDesginMainActivity extends AppCompatActivity {

    @BindView(R.id.button)
    Button button;
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.imagebutton)
    Button imagebutton;
    @BindView(R.id.pathinterpolator_button)
    Button pathinterpolatorButton;

    boolean isImageShow = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_desgin_main);
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

        if (isImageShow == true) {
            imagebutton.setText("隐藏");
        } else {
            imagebutton.setText("显示");
        }

    }

    //揭露效果
    private void showViewAnimation() {

        int cx = (image.getLeft() + image.getRight()) / 2;
        int cy = (image.getTop() + image.getBottom()) / 2;

//        int finalRadius = (int) Math.sqrt(image.getWidth() * image.getWidth() + image.getHeight() * image.getHeight());

        int finalRadius = image.getWidth() * 2;

        Animator anim = ViewAnimationUtils.createCircularReveal(image, cx, cy, 0, finalRadius);

        image.setVisibility(View.VISIBLE);
        anim.start();

    }

    //揭露效果
    private void dismissViewAnimation() {

        //获取中心点
        int cx = (image.getLeft() + image.getRight()) / 2;
        int cy = (image.getTop() + image.getBottom()) / 2;

        //初始圆半径
//        int initialRadius = (int) Math.sqrt(image.getWidth() * image.getWidth() + image.getHeight() * image.getHeight());
        int initialRadius = image.getWidth() * 2;

        //创建动画
        Animator anim = ViewAnimationUtils.createCircularReveal(image, cx, cy, initialRadius, 0);

        //监听动画结束后隐藏
        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                image.setVisibility(View.INVISIBLE);
            }
        });

        //执行动画
        anim.start();

    }


    @OnClick({R.id.button, R.id.image, R.id.imagebutton, R.id.recyclerview_button, R.id.pathinterpolator_button})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button: {
//                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MaterialDesginMainActivity.this,
//                        Pair.create(image, "image"),
//                        Pair.create(button, "button"));
                break;
            }
            case R.id.image: {
                Intent intent = new Intent(MaterialDesginMainActivity.this, ImageViewActivity.class);
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(MaterialDesginMainActivity.this, Pair.create((View) image, "image"), Pair.create((View) button, "button")).toBundle());
                break;
            }
            case R.id.imagebutton: {

                if (isImageShow == true) {
                    isImageShow = false;
                    imagebutton.setText("显示");
                    dismissViewAnimation();
                } else {
                    isImageShow = true;
                    imagebutton.setText("隐藏");
                    showViewAnimation();
                }

                break;
            }
            case R.id.recyclerview_button: {

                Intent intent = new Intent(MaterialDesginMainActivity.this, RecyclerViewActivity.class);
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(MaterialDesginMainActivity.this).toBundle());

                break;
            }
            case R.id.pathinterpolator_button: {

                Intent intent = new Intent(MaterialDesginMainActivity.this, PathInterpolatorActivity.class);
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(MaterialDesginMainActivity.this).toBundle());

                break;
            }
        }
    }
}
