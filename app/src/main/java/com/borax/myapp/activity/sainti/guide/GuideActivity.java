package com.borax.myapp.activity.sainti.guide;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.borax.myapp.R;
import com.borax.myapp.activity.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GuideActivity extends BaseActivity {

    @BindView(R.id.viewpager)
    ViewPager viewpager;

    private int[] pics = new int[]{R.drawable.guide1, R.drawable.guide2, R.drawable.guide3,
            R.drawable.guide4, R.drawable.guide5};

    private List<View> list = new ArrayList<View>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        ButterKnife.bind(this);

        initView();

    }

    private void initView() {

        for (int i = 0; i < pics.length; i++) {
            View view = LayoutInflater.from(GuideActivity.this).inflate(R.layout.guide_layout, null);
            ImageView image = (ImageView) view.findViewById(R.id.image);
            image.setImageResource(pics[i]);
            list.add(view);
        }

        list.get(pics.length - 1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("最后一页");
            }
        });

        GuideAdapter adapter = new GuideAdapter(this, list);
        viewpager.setAdapter(adapter);

    }

}
