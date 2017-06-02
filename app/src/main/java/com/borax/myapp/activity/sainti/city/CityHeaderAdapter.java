package com.borax.myapp.activity.sainti.city;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.borax.myapp.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.yokeyword.indexablerv.IndexableHeaderAdapter;

/**
 * Created by BoraxZYF on 2017/5/27.
 */

public class CityHeaderAdapter extends IndexableHeaderAdapter {

    private Context context;
    private List<CityHeaderEntity> list = new ArrayList<CityHeaderEntity>();

    public CityHeaderAdapter(Context context, String index, String indexTitle, List datas) {
        super(index, indexTitle, datas);
        this.context = context;
        this.list = datas;

    }

    @Override
    public int getItemViewType() {
        return 1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateContentViewHolder(ViewGroup parent) {

        View view = LayoutInflater.from(context).inflate(R.layout.city_header_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindContentViewHolder(RecyclerView.ViewHolder holder, Object entity) {

        final HeaderGridAdapter adapter = new HeaderGridAdapter(context, list.get(0).getList());
        ViewHolder vh = (ViewHolder) holder;
        vh.gridview.setAdapter(adapter);
        vh.gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(context, "选中城市：" + adapter.getItem(i).getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.gridview)
        GridView gridview;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
