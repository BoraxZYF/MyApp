package com.borax.myapp.activity.sainti.expandlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.borax.myapp.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by BoraxZYF on 2017/6/14.
 */

public class ExpandListAdapter extends BaseExpandableListAdapter {

    private List<String> groupList = new ArrayList<String>();
    private List<List<String>> childList = new ArrayList<List<String>>();
    private Context context;

    public ExpandListAdapter(Context context, List<String> groupList, List<List<String>> childList) {
        this.groupList = groupList;
        this.childList = childList;
        this.context = context;
    }


    @Override
    public int getGroupCount() {
        return groupList.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return childList.get(i).size();
    }

    @Override
    public String getGroup(int i) {
        return groupList.get(i);
    }

    @Override
    public String getChild(int i, int i1) {
        return childList.get(i).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View convertView, ViewGroup viewGroup) {

        GroupViewHolder vh = null;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.group_item_layout, viewGroup, false);
            vh = new GroupViewHolder(convertView);
            convertView.setTag(vh);
        } else {
            vh = (GroupViewHolder) convertView.getTag();
        }

        vh.name.setText(groupList.get(i));

        return convertView;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View convertView, ViewGroup viewGroup) {

        ChildViewHolder vh = null;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.child_item_layout, viewGroup, false);
            vh = new ChildViewHolder(convertView);
            convertView.setTag(vh);
        } else {
            vh = (ChildViewHolder) convertView.getTag();
        }

        vh.name.setText(childList.get(i).get(i1));

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    static class GroupViewHolder {
        @BindView(R.id.name)
        TextView name;

        GroupViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    static class ChildViewHolder {
        @BindView(R.id.name)
        TextView name;

        ChildViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
