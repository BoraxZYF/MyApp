package adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;

import com.borax.myapp.R;

import java.util.ArrayList;

import fragment.Fragment3;

/**
 * Created by borax on 2016/10/27.
 */

public class TabLayoutAdapter extends FragmentPagerAdapter {

    private ArrayList<String> titles = new ArrayList<String>();
    private Context context;


    public TabLayoutAdapter(FragmentManager fm, Context context,ArrayList<String> titles) {
        super(fm);
        this.context = context;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return new Fragment3();
    }

    @Override
    public int getCount() {
        return titles.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

    public View getTabView(int position){
        View view = LayoutInflater.from(context).inflate(R.layout.tab_item, null);
//        TextView tv= (TextView) view.findViewById(R.id.textView);
//        tv.setText(tabTitles[position]);
//        ImageView img = (ImageView) view.findViewById(R.id.imageView);
//        img.setImageResource(imageResId[position]);
        return view;
    }

}
