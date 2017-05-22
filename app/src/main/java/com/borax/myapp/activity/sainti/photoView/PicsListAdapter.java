package com.borax.myapp.activity.sainti.photoView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.borax.myapp.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by BoraxZYF on 2017/5/22.
 */

public class PicsListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> list = new ArrayList<String>();

    public PicsListAdapter(Context context, ArrayList<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public String getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        ViewHolder vh = null;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.pic_item, null);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        Glide.with(context).load(list.get(i)).into(vh.image);

        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.image)
        ImageView image;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
