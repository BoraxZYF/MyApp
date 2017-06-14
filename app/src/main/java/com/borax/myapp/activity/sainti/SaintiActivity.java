package com.borax.myapp.activity.sainti;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.borax.myapp.R;
import com.borax.myapp.activity.pulltorefresh.PullToRefreshActivity;
import com.borax.myapp.activity.sainti.adViewPager.AdViewPagerActivity;
import com.borax.myapp.activity.sainti.city.PickCityActivity;
import com.borax.myapp.activity.sainti.download.DownloadMainActivity;
import com.borax.myapp.activity.sainti.expandlistview.ExpandListViewActivity;
import com.borax.myapp.activity.sainti.gesture.CreateGestureActivity;
import com.borax.myapp.activity.sainti.guide.GuideActivity;
import com.borax.myapp.activity.sainti.loading.LoadingActivity;
import com.borax.myapp.activity.sainti.ninepicupload.NinePicUploadActivity;
import com.borax.myapp.activity.sainti.photoView.PicsActivity;
import com.borax.myapp.activity.sainti.radio.UploadRadioActivity;
import com.borax.myapp.activity.sainti.selectMultiPhotos.SelectMultiPhotoActivity;
import com.borax.myapp.activity.sainti.selectSinglePhoto.SelectSingleActivity;
import com.borax.myapp.activity.sainti.spinner.BottomMenuActivity;
import com.borax.myapp.activity.sainti.spinner.TopMenuActivity;
import com.borax.myapp.activity.sainti.uploadPics.UploadPicsActivity;
import com.borax.myapp.activity.sainti.video.VideoActivity;
import com.borax.myapp.activity.sainti.waterfall.WaterfallActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SaintiActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.listview)
    ListView listview;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    String[] strs = new String[]{"启动页", "轮播图", "图片放大", "多图上传", "下载", "图表",
            "城市选择", "选择多图", "选择单图", "视频播放", "语音上传", "Loading", "引导页", "分享",
            "支付", "瀑布流", "九宫格图片上传", "顶部菜单", "底部菜单", "分组列表", "下拉刷新自定义动画", "手势解锁",
            "评星", "扫描二维码", "flowlayout"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sainti);
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

        initView();

    }

    private void initView() {

        listview.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, strs));

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i) {

                    case 0: {
                        Intent intent = new Intent(SaintiActivity.this, SplashActivity.class);
                        startActivity(intent);
                        break;
                    }

                    case 1: {
                        Intent intent = new Intent(SaintiActivity.this, AdViewPagerActivity.class);
                        startActivity(intent);
                        break;
                    }

                    case 2: {
                        Intent intent = new Intent(SaintiActivity.this, PicsActivity.class);
                        startActivity(intent);
                        break;
                    }

                    case 3: {
                        Intent intent = new Intent(SaintiActivity.this, UploadPicsActivity.class);
                        startActivity(intent);
                        break;
                    }

                    case 4: {
                        Intent intent = new Intent(SaintiActivity.this, DownloadMainActivity.class);
                        startActivity(intent);
                        break;
                    }

                    case 5: {
                        Toast.makeText(SaintiActivity.this, "MPChart", Toast.LENGTH_SHORT).show();
                        break;
                    }

                    case 6: {
                        Intent intent = new Intent(SaintiActivity.this, PickCityActivity.class);
                        startActivity(intent);
                        break;
                    }

                    case 7: {
                        Intent intent = new Intent(SaintiActivity.this, SelectMultiPhotoActivity.class);
                        startActivity(intent);
                        break;
                    }

                    case 8: {
                        Intent intent = new Intent(SaintiActivity.this, SelectSingleActivity.class);
                        startActivity(intent);
                        break;
                    }

                    case 9: {
                        Intent intent = new Intent(SaintiActivity.this, VideoActivity.class);
                        startActivity(intent);
                        break;
                    }

                    case 10: {
                        Intent intent = new Intent(SaintiActivity.this, UploadRadioActivity.class);
                        startActivity(intent);
                        break;
                    }

                    case 11: {
                        Intent intent = new Intent(SaintiActivity.this, LoadingActivity.class);
                        startActivity(intent);
                        break;
                    }

                    case 12: {
                        Intent intent = new Intent(SaintiActivity.this, GuideActivity.class);
                        startActivity(intent);
                        break;
                    }

                    case 13: {
                        Intent intent = new Intent(SaintiActivity.this, ShareActivity.class);
                        startActivity(intent);
                        break;
                    }

                    case 15: {
                        Intent intent = new Intent(SaintiActivity.this, WaterfallActivity.class);
                        startActivity(intent);
                        break;
                    }

                    case 16: {
                        Intent intent = new Intent(SaintiActivity.this, NinePicUploadActivity.class);
                        startActivity(intent);
                        break;
                    }

                    case 17: {
                        Intent intent = new Intent(SaintiActivity.this, TopMenuActivity.class);
                        startActivity(intent);
                        break;
                    }

                    case 18: {
                        Intent intent = new Intent(SaintiActivity.this, BottomMenuActivity.class);
                        startActivity(intent);
                        break;
                    }

                    case 19: {
                        Intent intent = new Intent(SaintiActivity.this, ExpandListViewActivity.class);
                        startActivity(intent);
                        break;
                    }

                    case 20: {
                        Intent intent = new Intent(SaintiActivity.this, PullToRefreshActivity.class);
                        startActivity(intent);
                        break;
                    }

                    case 21: {
                        Intent intent = new Intent(SaintiActivity.this, CreateGestureActivity.class);
                        startActivity(intent);
                        break;
                    }

                }

            }
        });

    }

}
