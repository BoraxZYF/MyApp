package com.borax.myapp.activity.sainti.spinner;

import android.content.Context;
import android.drm.DrmInfoStatus;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.borax.myapp.R;

/**
 * Created by BoraxZYF on 2017/6/13.
 */

public class SpinnerPopWindow extends PopupWindow {

    private Context context;
    private ListView listView;
    private BaseAdapter adapter;
    private AdapterView.OnItemClickListener onItemClickListener;

    public SpinnerPopWindow(Context context, BaseAdapter adapter, AdapterView.OnItemClickListener onItemClickListener) {
        super();

        this.context = context;
        this.adapter = adapter;
        this.onItemClickListener = onItemClickListener;
        init();
    }

    private void init() {

        LinearLayout ll = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.spinner_container_layout, null);
        setContentView(ll);
        setWidth(LinearLayout.LayoutParams.WRAP_CONTENT);
        setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);

        setFocusable(true);

        listView = (ListView) ll.findViewById(R.id.listview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(onItemClickListener);

        LinearLayout backll = (LinearLayout) ll.findViewById(R.id.ll);
        backll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

    }

}
