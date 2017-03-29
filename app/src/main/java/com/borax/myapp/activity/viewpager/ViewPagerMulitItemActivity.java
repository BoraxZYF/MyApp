package com.borax.myapp.activity.viewpager;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.borax.myapp.R;

import java.util.ArrayList;
import java.util.List;

import adapter.ViewPagerAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import custom.viewpager.ZoomOutPageTransformer;

public class ViewPagerMulitItemActivity extends AppCompatActivity {

    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.activity_view_pager_mulit_item)
    RelativeLayout activityViewPagerMulitItem;

    private List<View> viewlist = new ArrayList<View>();
    private int[] piclist = new int[]{R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic1, R.drawable.pic2, R.drawable.pic3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_mulit_item);
        ButterKnife.bind(this);

        initView();

    }


    public void initView() {

        for (int i = 0; i < 10; i++) {

            View view = LayoutInflater.from(this).inflate(R.layout.viewpager_item, null);
            View background = view.findViewById(R.id.background);
            TextView text = (TextView) view.findViewById(R.id.text);
            ImageView image = (ImageView) view.findViewById(R.id.image);

            text.setText(i + "");
            image.setImageResource(piclist[i]);

            if (i % 2 == 0) {
                background.setBackgroundResource(R.color.colorPrimary);
            } else {
                background.setBackgroundResource(R.color.colorPrimaryDark);
            }
            viewlist.add(view);
        }

        activityViewPagerMulitItem.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return viewpager.dispatchTouchEvent(motionEvent);
            }
        });
        viewpager.setOffscreenPageLimit(3);
        viewpager.setPageMargin(30);
        viewpager.setAdapter(new ViewPagerAdapter(viewlist));
        viewpager.setPageTransformer(true, new ZoomOutPageTransformer());

    }
}
