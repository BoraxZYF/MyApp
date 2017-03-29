package com.borax.myapp.activity.waveview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.borax.myapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WaveActivity extends AppCompatActivity {

    @BindView(R.id.wave)
    WaveView wave;
    @BindView(R.id.start)
    Button start;
    @BindView(R.id.stop)
    Button stop;
    @BindView(R.id.activity_wave)
    LinearLayout activityWave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wave);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.start, R.id.stop})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.start: {

                wave.start();

                break;
            }
            case R.id.stop: {

                wave.stop();

                break;
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        wave.stop();
    }
}
