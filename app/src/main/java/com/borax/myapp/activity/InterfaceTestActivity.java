package com.borax.myapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.alibaba.fastjson.JSON;
import com.borax.myapp.R;
import com.orhanobut.logger.Logger;

import api.API;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import entity.TestEntity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InterfaceTestActivity extends AppCompatActivity {

    @BindView(R.id.button)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface_test);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    public void onViewClicked() {

        API.SERVICE.postTest(18841148357l,"1231231").enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                Logger.d(response.body());

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Logger.d(t.getMessage());
            }
        });

    }
}
