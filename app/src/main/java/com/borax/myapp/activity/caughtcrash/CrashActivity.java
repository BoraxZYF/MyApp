package com.borax.myapp.activity.caughtcrash;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.borax.myapp.R;
import com.orhanobut.logger.Logger;

import butterknife.ButterKnife;
import butterknife.OnClick;
import util.Util;

public class CrashActivity extends AppCompatActivity {

    String s = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crash);
        ButterKnife.bind(this);

        String crash = Util.getLog(this);

        Logger.d(crash);

//        if (!TextUtils.isEmpty(crash)) {
//            API.CRASHSERVICE.postData("updateData", crash).enqueue(new Callback<CrashBean>() {
//                @Override
//                public void onResponse(Call<CrashBean> call, Response<CrashBean> response) {
//                    Logger.d("success");
//                    Logger.d(response.body().getMessage());
//
//                    Util.saveLog(CrashActivity.this, "");
//
//                }
//
//                @Override
//                public void onFailure(Call<CrashBean> call, Throwable t) {
//                    Logger.d(t.getMessage());
//                }
//            });
//        }

    }

    @OnClick(R.id.button)
    public void onClick() {

        Logger.d(s);

//        API.CRASHSERVICE.postData("updateData", sql).enqueue(new Callback<CrashBean>() {
//            @Override
//            public void onResponse(Call<CrashBean> call, Response<CrashBean> response) {
//                Logger.d("success");
//                Logger.d(response.body().getMessage());
//            }
//
//            @Override
//            public void onFailure(Call<CrashBean> call, Throwable t) {
//                Logger.d(t.getMessage());
//            }
//        });


    }
}
