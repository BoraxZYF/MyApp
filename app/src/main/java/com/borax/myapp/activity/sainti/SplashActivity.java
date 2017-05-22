package com.borax.myapp.activity.sainti;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.borax.myapp.R;
import com.borax.myapp.activity.MainActivity;

public class SplashActivity extends AppCompatActivity {

    private static final int sleepTime = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initView();

    }

    private void initView() {

        // TODO 判断是否第一次进入

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(sleepTime);

//                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
//                    startActivity(intent);
                    finish();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }


}
