package com.borax.myapp.activity.sainti.city;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.borax.myapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.yokeyword.indexablerv.IndexableAdapter;

/**
 * Created by BoraxZYF on 2017/5/27.
 */

public class CityAdapter extends IndexableAdapter<CityEntity> {

    private LayoutInflater mInflater;

    public CityAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateTitleViewHolder(ViewGroup parent) {
        View view = mInflater.inflate(R.layout.item_index_city, parent, false);
        return new IndexVH(view);
    }

    @Override
    public RecyclerView.ViewHolder onCreateContentViewHolder(ViewGroup parent) {
        View view = mInflater.inflate(R.layout.item_city, parent, false);
        return new ContentVH(view);
    }

    @Override
    public void onBindTitleViewHolder(RecyclerView.ViewHolder holder, String indexTitle) {
        IndexVH vh = (IndexVH) holder;
        vh.tvIndex.setText(indexTitle);
    }

    @Override
    public void onBindContentViewHolder(RecyclerView.ViewHolder holder, CityEntity entity) {
        ContentVH vh = (ContentVH) holder;
        vh.tvName.setText(entity.getName());
    }

    static class IndexVH extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_index)
        TextView tvIndex;

        IndexVH(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static class ContentVH extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name)
        TextView tvName;

        ContentVH(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
