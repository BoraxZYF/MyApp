package com.borax.myapp.activity.sainti.uploadPics;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.borax.myapp.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by BoraxZYF on 2017/5/24.
 */

public class PicGridAdapter extends BaseAdapter {

    private Context context;
    private List<String> list;

    public PicGridAdapter(Context context) {
        this.context = context;
        this.list = new ArrayList<String>();
    }

    public void update(List<String> list) {
        this.list.clear();
        this.list = list;
        notifyDataSetChanged();
    }

    public void add(List<String> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        ViewHolder vh = null;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.pic_grid_item, viewGroup, false);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        Glide.with(context).load(list.get(i)).placeholder(R.drawable.pic).dontAnimate().into(vh.image);

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
