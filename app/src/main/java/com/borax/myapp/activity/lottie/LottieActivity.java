package com.borax.myapp.activity.lottie;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.borax.myapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LottieActivity extends AppCompatActivity {

    @BindView(R.id.animation)
    LottieAnimationView animation;
    @BindView(R.id.last)
    Button last;
    @BindView(R.id.next)
    Button next;

    String[] jsonlist = {"Logo/LogoSmall.json", "Tests/Alarm.json", "Tests/CheckSwitch.json", "Tests/EllipseTrimPath.json", "Tests/Hosts.json", "Tests/LightBulb.json"
            , "Tests/LoopPlayOnce.json", "Tests/SplitDimensions.json", "Tests/TrimPathFill.json", "Tests/TrimPathsFull.json"};

    int current = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottie);
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

        initView();

    }

    private void initView() {

        last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (current == 0) {
                    Toast.makeText(LottieActivity.this, "This is last one", Toast.LENGTH_SHORT).show();
                    return;
                }

                current--;
                animation.setAnimation(jsonlist[current]);
                animation.playAnimation();
                animation.loop(true);
            }
        });


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (current == jsonlist.length - 1) {
                    Toast.makeText(LottieActivity.this, "This is final one", Toast.LENGTH_SHORT).show();
                    return;
                }

                current++;
                animation.setAnimation(jsonlist[current]);
                animation.playAnimation();
                animation.loop(true);

            }
        });


    }

}
