package com.borax.myapp.activity.sainti.spinner.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.borax.myapp.R;
import com.borax.myapp.activity.sainti.spinner.entity.MenuCellBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by BoraxZYF on 2017/6/13.
 */

public class MenuSpinnerAdapter extends BaseAdapter {

    private Context context;
    private List<MenuCellBean> list = new ArrayList<MenuCellBean>();

    public MenuSpinnerAdapter(Context context, List<MenuCellBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public MenuCellBean getItem(int i) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.menu_spinner_item, viewGroup, false);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        vh.name.setText(list.get(i).getName());

        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.name)
        TextView name;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
