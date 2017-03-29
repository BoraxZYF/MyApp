package com.borax.myapp.activity.encrypt;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.borax.myapp.R;
import com.borax.myapp.activity.BaseActivity;
import com.orhanobut.logger.Logger;

import api.JsonParams;
import api.SaintiCallback;
import api.SaintiClient;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AesActivity extends BaseActivity {

    @BindView(R.id.input)
    EditText input;
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.result)
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aes);
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

    }

    @OnClick(R.id.button)
    public void onClick() {

        JsonParams params = new JsonParams();
        params.put("age", "1");
        params.put("username", "borax");
        params.put("sex", "男");

        Logger.d(params.toString());

        SaintiClient.doPost("post", params, new SaintiCallback() {
            @Override
            public void success(String json) {

                Logger.d(json);

                User user = JSON.parseObject(json, User.class);
                Logger.d(user.getUsername() + " " + user.getSex() + " " + user.getAge() + " " + user.getCity());

            }

            @Override
            public void fail(String str) {

            }
        });
//
//        SaintiClient.doGet("getlist", new SaintiCallback() {
//            @Override
//            public void success(String json) {
//
//                Toast.makeText(AesActivity.this, "success", Toast.LENGTH_SHORT).show();
//
//            }
//
//            @Override
//            public void fail(String str) {
//
//            }
//        });


    }
}
