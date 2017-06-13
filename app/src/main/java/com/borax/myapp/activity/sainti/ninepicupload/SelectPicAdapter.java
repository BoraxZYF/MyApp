package com.borax.myapp.activity.sainti.ninepicupload;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.borax.myapp.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by BoraxZYF on 2017/6/13.
 */

public class SelectPicAdapter extends BaseAdapter {

    private Context context;
    private List<String> list = new ArrayList<String>();
    private int width;


    public SelectPicAdapter(Context context, int width) {
        this.context = context;
        this.width = width;
        list.add("last");
    }

    public void add(List<String> list) {

        this.list.remove(this.list.size() - 1);
        this.list.addAll(list);

        if (this.list.size() != 9) {
            this.list.add("last");
        }

        notifyDataSetChanged();

    }

    public void delete(int i) {

        if (list.size() == 9 && !list.get(list.size() - 1).equals("last")) {
            list.remove(i);
            list.add("last");
        } else {
            list.remove(i);
        }

        notifyDataSetChanged();

    }

    public int getPicCount() {
        if (list.get(list.size() - 1).equals("last")) {
            return list.size() - 1;
        } else {
            return 9;
        }
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
    public View getView(final int i, View convertView, ViewGroup viewGroup) {

        ViewHolder vh = null;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.select_pic_item, viewGroup, false);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        ViewGroup.LayoutParams lp = vh.rl.getLayoutParams();
        lp.width = width;
        lp.height = width;
        vh.rl.setLayoutParams(lp);

        vh.image.setImageResource(0);
        vh.delete.setVisibility(View.VISIBLE);
        vh.image.setOnClickListener(null);

        String data = list.get(i);

        if (data.equals("last")) {
            vh.delete.setVisibility(View.GONE);
            vh.image.setImageResource(R.drawable.pic);
            vh.image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((NinePicUploadActivity) context).selectPic();
                }
            });
        } else {
            Glide.with(context).load(list.get(i)).into(vh.image);
        }

        vh.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delete(i);
            }
        });


        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.image)
        ImageView image;
        @BindView(R.id.delete)
        ImageView delete;
        @BindView(R.id.rl)
        RelativeLayout rl;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
