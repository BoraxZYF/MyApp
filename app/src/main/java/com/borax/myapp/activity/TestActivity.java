package com.borax.myapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.borax.myapp.R;
import com.borax.myapp.activity.encrypt.BaseBean;
import com.orhanobut.logger.Logger;

import api.API;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TestActivity extends AppCompatActivity {

    @BindView(R.id.button)
    Button button;
    @BindView(R.id.activity_test)
    RelativeLayout activityTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    public void onViewClicked() {
        API.SERVICE.getTest().enqueue(new Callback<BaseBean>() {
            @Override
            public void onResponse(Call<BaseBean> call, Response<BaseBean> response) {

                Logger.d(response.message());
                Logger.d(response.body().getData());

            }

            @Override
            public void onFailure(Call<BaseBean> call, Throwable t) {

                Logger.d(t.getMessage());

            }
        });
    }
}
