package com.borax.myapp.activity.sainti.uploadPics;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import com.alibaba.fastjson.JSON;
import com.borax.myapp.R;
import com.borax.myapp.activity.encrypt.AesUtil;
import com.borax.myapp.activity.encrypt.BaseBean;
import com.bumptech.glide.Glide;
import com.orhanobut.logger.Logger;
import com.yuyh.library.imgsel.ImageLoader;
import com.yuyh.library.imgsel.ImgSelActivity;
import com.yuyh.library.imgsel.ImgSelConfig;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import api.API;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import entity.ImgListBean;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UploadPicsActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.select_pic)
    Button selectPic;
    @BindView(R.id.gridview)
    GridView gridview;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    PicGridAdapter adapter;

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
        setContentView(R.layout.activity_upload_pics);
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

        adapter = new PicGridAdapter(this);
        gridview.setAdapter(adapter);

    }

    @OnClick({R.id.select_pic})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.select_pic: {

                config = new ImgSelConfig.Builder(loader)
                        // 是否多选
                        .multiSelect(true)
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
                        .maxNum(9 - adapter.getCount())
                        .build();

                ImgSelActivity.startActivity(this, config, 800);

                break;
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 800 && resultCode == RESULT_OK && data != null) {
            uploaPic(data);
        }

    }

    private void uploaPic(Intent data) {

        List<String> piclist = data.getStringArrayListExtra(ImgSelActivity.INTENT_RESULT);

//        adapter.add(piclist);

        Map<String, RequestBody> map = new HashMap<String, RequestBody>();

        for (int i = 0; i < piclist.size(); i++) {
            File file = new File(piclist.get(i));
            RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
            map.put("file[]\"; filename=\"image " + i + ".png\"", requestBody);
        }

        API.SERVICE.postUploadPic(map).enqueue(new Callback<BaseBean>() {
            @Override
            public void onResponse(Call<BaseBean> call, Response<BaseBean> response) {

                try {
                    String data = response.body().getData();
                    data = data.replace("[/]", "+");
                    Logger.d(data);
                    String json = AesUtil.desEncrypt(data);
                    Logger.d(json);

                    ArrayList<ImgListBean> list = new ArrayList<ImgListBean>();
                    list = (ArrayList<ImgListBean>) JSON.parseArray(json, ImgListBean.class);

                    updatePic(list);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<BaseBean> call, Throwable t) {
                Logger.d(t.getMessage());
            }
        });


    }

    private void updatePic(ArrayList<ImgListBean> list) {

        List<String> piclist = new ArrayList<String>();

        for (ImgListBean data : list) {
            piclist.add(data.getImg_url());
        }

        adapter.add(piclist);

    }


}
