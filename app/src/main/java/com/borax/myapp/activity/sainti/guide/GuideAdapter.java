package com.borax.myapp.activity.sainti.guide;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import adapter.ViewPagerAdapter;

/**
 * Created by BoraxZYF on 2017/6/12.
 */

public class GuideAdapter extends PagerAdapter {

    private List<View> list;
    private Context context;

    public GuideAdapter(Context context, List<View> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(list.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        container.addView(list.get(position));

        return list.get(position);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
