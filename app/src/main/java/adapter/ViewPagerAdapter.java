package adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by borax on 2016/12/7.
 */

public class ViewPagerAdapter extends PagerAdapter {

    private List<View> viewlist = new ArrayList<View>();

    public ViewPagerAdapter(List<View> viewList) {
        this.viewlist = viewList;
    }

    @Override
    public int getCount() {
        return viewlist.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(viewlist.get(position));
        return viewlist.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(viewlist.get(position));
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
