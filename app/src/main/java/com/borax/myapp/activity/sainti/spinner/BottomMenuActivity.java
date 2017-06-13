package com.borax.myapp.activity.sainti.spinner;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.borax.myapp.R;
import com.borax.myapp.activity.BaseActivity;
import com.borax.myapp.activity.sainti.spinner.adapter.MenuSpinnerAdapter;
import com.borax.myapp.activity.sainti.spinner.entity.MenuCellBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import util.Util;

public class BottomMenuActivity extends BaseActivity {

    @BindView(R.id.menu)
    TextView menu;

    private SpinnerPopWindow spinnerPopWindow;
    private List<MenuCellBean> menuSpinnerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_menu);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        fab.setVisibility(View.GONE);

        initView();

    }

    private void initView() {

        menuSpinnerList = new ArrayList<MenuCellBean>();
        menuSpinnerList.add(new MenuCellBean(0, "选项1"));
        menuSpinnerList.add(new MenuCellBean(1, "选项2"));
        menuSpinnerList.add(new MenuCellBean(2, "选项3"));
        menuSpinnerList.add(new MenuCellBean(3, "选项4"));
        menuSpinnerList.add(new MenuCellBean(4, "选项5"));

        MenuSpinnerAdapter adapter = new MenuSpinnerAdapter(BottomMenuActivity.this, menuSpinnerList);

        AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                MenuCellBean data = menuSpinnerList.get(i);

                showToast(data.getType() + " " + data.getName());
                menu.setText(data.getName());
                spinnerPopWindow.dismiss();
            }
        };

        spinnerPopWindow = new SpinnerPopWindow(this, adapter, onItemClickListener);
        spinnerPopWindow.setBackgroundDrawable(new BitmapDrawable());
        spinnerPopWindow.setOutsideTouchable(true);

    }

    @OnClick(R.id.menu)
    public void onViewClicked() {
        spinnerPopWindow.setWidth(menu.getWidth());
        spinnerPopWindow.showAsDropDown(menu, 0, -Util.dip2px(BottomMenuActivity.this, 260));
    }
}
