package com.borax.myapp.activity.view;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.borax.myapp.R;
import com.borax.myapp.activity.view.view.HorizontalScrollViewEx;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import util.Util;

public class ScrollViewWithListViewActivity extends AppCompatActivity {

    @BindView(R.id.container)
    HorizontalScrollViewEx container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view_with_list_view2);
        ButterKnife.bind(this);

        initView();

    }

    private void initView() {

        LayoutInflater inflater = getLayoutInflater();
        final int screenWidth = Util.getScreenWidth(this);
        final int screenHeight = Util.getScreenHeight(this);

        Logger.d(screenWidth);

        for (int i = 0; i < 3; i++) {
            ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.listview_content_layout, container, false);
            layout.getLayoutParams().width = screenWidth;
            TextView textView = (TextView) layout.findViewById(R.id.textview);
            textView.setText("page" + i);
            layout.setBackgroundColor(Color.rgb(255 / (i + 1), 255 / (i + 1), 255 / (i + 1)));
            createList(layout);
            container.addView(layout);

        }

    }

    private void createList(ViewGroup layout) {

        ListView listview = (ListView) layout.findViewById(R.id.listview);
        ArrayList<String> datas = new ArrayList<String>();

        for (int i = 0; i < 50; i++) {
            datas.add("name" + i);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datas);
        listview.setAdapter(adapter);

    }

}
