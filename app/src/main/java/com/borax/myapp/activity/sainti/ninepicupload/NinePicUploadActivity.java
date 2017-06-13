package com.borax.myapp.activity.sainti.ninepicupload;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;

import com.borax.myapp.R;
import com.borax.myapp.activity.sainti.selectMultiPhotos.SelectMultiPhotoActivity;
import com.bumptech.glide.Glide;
import com.orhanobut.logger.Logger;
import com.yuyh.library.imgsel.ImageLoader;
import com.yuyh.library.imgsel.ImgSelActivity;
import com.yuyh.library.imgsel.ImgSelConfig;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import util.Util;

public class NinePicUploadActivity extends AppCompatActivity {

    @BindView(R.id.text)
    EditText text;
    @BindView(R.id.gridview)
    GridView gridview;

    SelectPicAdapter adapter;

    private ImgSelConfig config;
    private ImageLoader loader = new ImageLoader() {
        @Override
        public void displayImage(Context context, String path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nine_pic_upload);
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

        int width = Util.getScreenWidth(this);
        width = width - (Util.dip2px(this, 15) * 2) - (Util.dip2px(this, 5) * 3);

        int itemWidth = width / 3;

        Logger.d(itemWidth + "");

        adapter = new SelectPicAdapter(this, itemWidth);
        gridview.setAdapter(adapter);

    }

    public void selectPic() {

        config = new ImgSelConfig.Builder(NinePicUploadActivity.this, loader)
                // 是否多选
                .multiSelect(true)
                // 是否记住上次选中记录, 仅当multiSelect为true的时候配置，默认为true
                .rememberSelected(false)
                // “确定”按钮背景色
                .btnBgColor(Color.parseColor("#00000000"))
                // “确定”按钮文字颜色
                .btnTextColor(Color.WHITE)
                // 使用沉浸式状态栏
                .statusBarColor(Color.parseColor("#000000"))
                // 返回图标 ResId
                .backResId(R.drawable.back)
                // 标题
                .title("图片")
                // 标题文字颜色
                .titleColor(Color.WHITE)
                // TitleBar 背景色
                .titleBgColor(Color.parseColor("#000000"))
                // 裁剪大小。needCrop 为 true 的时候配置
                .cropSize(1, 1, 200, 200)
                .needCrop(true)
                // 第一个是否显示相机
                .needCamera(true)
                // 最大选择图片数量
                .maxNum(9 - adapter.getPicCount())
                .build();

        ImgSelActivity.startActivity(this, config, 800);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 800 && resultCode == RESULT_OK && data != null) {
            List<String> piclist = data.getStringArrayListExtra(ImgSelActivity.INTENT_RESULT);
            adapter.add(piclist);
        }

    }

}
