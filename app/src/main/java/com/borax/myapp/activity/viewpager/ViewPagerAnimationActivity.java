package com.borax.myapp.activity.viewpager;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.borax.myapp.R;
import com.borax.myapp.activity.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import adapter.ViewPagerAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import custom.viewpager.CustomTransformer;
import custom.viewpager.DepthPageTransformer;
import custom.viewpager.ZoomOutPageTransformer;

public class ViewPagerAnimationActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.content_depth_page_transformer)
    RelativeLayout contentDepthPageTransformer;

    private List<View> viewlist = new ArrayList<View>();
    private int[] piclist = new int[]{R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic1, R.drawable.pic2, R.drawable.pic3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_depth_page_transformer);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add(Menu.NONE, Menu.NONE, 0, "DepthPageTransformer");
        menu.add(Menu.NONE, Menu.NONE, 1, "ZoomOutPageTransformer");
        menu.add(Menu.NONE, Menu.NONE, 2, "CustomTransformer");

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getOrder()) {

            case 0: {
                viewpager.setPageTransformer(true, new DepthPageTransformer());
                break;
            }

            case 1: {
                viewpager.setPageTransformer(true, new ZoomOutPageTransformer());
                break;
            }

            case 2: {
                viewpager.setPageTransformer(true, new CustomTransformer());
                break;
            }

        }

        return super.onOptionsItemSelected(item);
    }

    private void initView() {

        for (int i = 0; i < 10; i++) {

            View view = LayoutInflater.from(this).inflate(R.layout.viewpager_item, null);
            View background = view.findViewById(R.id.background);
            TextView text = (TextView) view.findViewById(R.id.text);
            ImageView image = (ImageView) view.findViewById(R.id.image);

            text.setText(i + "");
            image.setImageResource(piclist[i]);

            if (i % 2 == 0) {
                background.setBackgroundResource(R.color.colorAccent);
            } else {
                background.setBackgroundResource(R.color.colorPrimary);
            }
            viewlist.add(view);
        }

        viewpager.setAdapter(new ViewPagerAdapter(viewlist));
    }

}
