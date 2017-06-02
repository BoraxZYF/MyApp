package com.borax.myapp.activity.sainti.city;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.borax.myapp.R;
import com.borax.myapp.activity.sainti.uploadPics.PicGridAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.yokeyword.indexablerv.IndexableAdapter;
import me.yokeyword.indexablerv.IndexableLayout;
import me.yokeyword.indexablerv.SimpleHeaderAdapter;

public class PickCityActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.indexableLayout)
    IndexableLayout indexableLayout;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_city);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        initView();

    }

    private void initView() {

        indexableLayout.setLayoutManager(new LinearLayoutManager(this));
//        indexableLayout.setLayoutManager(new GridLayoutManager(this,3));

        CityAdapter adapter = new CityAdapter(this);
        indexableLayout.setAdapter(adapter);

        List<CityEntity> mDatas = new ArrayList<CityEntity>();

        mDatas = initData();

        indexableLayout.setCompareMode(IndexableLayout.MODE_FAST);

        adapter.setDatas(mDatas);

        indexableLayout.setOverlayStyle_Center();

        adapter.setOnItemContentClickListener(new IndexableAdapter.OnItemContentClickListener<CityEntity>() {
            @Override
            public void onItemClick(View v, int originalPosition, int currentPosition, CityEntity entity) {

                if (originalPosition >= 0) {
                    Toast.makeText(PickCityActivity.this, "选中:" + entity.getName(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(PickCityActivity.this, "选中Header:" + entity.getName(), Toast.LENGTH_SHORT).show();
                }

            }
        });

        adapter.setOnItemTitleClickListener(new IndexableAdapter.OnItemTitleClickListener() {
            @Override
            public void onItemClick(View v, int currentPosition, String indexTitle) {
                Toast.makeText(PickCityActivity.this, "选中：" + indexTitle, Toast.LENGTH_SHORT).show();
            }
        });

//        SimpleHeaderAdapter mHotCityAdapter = new SimpleHeaderAdapter(adapter, "热", "热门城市", initHotCitys());

        List<CityHeaderEntity> headerlist = new ArrayList<CityHeaderEntity>();
        headerlist.add(new CityHeaderEntity(initHotCitys()));

        CityHeaderAdapter headerAdapter = new CityHeaderAdapter(this, "热", "热门城市", headerlist);

        indexableLayout.addHeaderAdapter(headerAdapter);

        final List<CityEntity> gpsCity = initGpsCityDatas();
        final SimpleHeaderAdapter gpsHeaderAdapter = new SimpleHeaderAdapter(adapter, "定", "当前城市", gpsCity);
        indexableLayout.addHeaderAdapter(gpsHeaderAdapter);

        //显示真实索引
        indexableLayout.showAllLetter(true);

        indexableLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                gpsCity.get(0).setName("大连市");
                gpsHeaderAdapter.notifyDataSetChanged();
            }
        }, 3000);

    }

    private List<CityEntity> initData() {

        List<CityEntity> list = new ArrayList<CityEntity>();
        List<String> cityStrings = Arrays.asList(getResources().getStringArray(R.array.city_array));

        for (String item : cityStrings) {
            CityEntity cityEntity = new CityEntity();
            cityEntity.setName(item);
            list.add(cityEntity);
        }
        return list;
    }

    private List<CityEntity> initHotCitys() {

        List<CityEntity> list = new ArrayList<>();
        list.add(new CityEntity("杭州市"));
        list.add(new CityEntity("北京市"));
        list.add(new CityEntity("上海市"));
        list.add(new CityEntity("广州市"));
        list.add(new CityEntity("大连市"));
        return list;

    }

    private List<CityEntity> initGpsCityDatas() {
        List<CityEntity> list = new ArrayList<>();
        list.add(new CityEntity("定位中..."));
        return list;
    }

}
