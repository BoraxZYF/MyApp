package com.borax.myapp.activity.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.borax.myapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ScrollToByActivity extends AppCompatActivity {

    @BindView(R.id.view)
    View mView;
    @BindView(R.id.scrollto)
    Button scrollto;
    @BindView(R.id.scrollby)
    Button scrollby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_to_by);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.scrollto, R.id.scrollby})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.scrollto: {

                mView.scrollTo(-+400, -+400);

                break;
            }
            case R.id.scrollby: {

                mView.scrollBy(-+30, -+30);

                break;
            }
        }
    }
}
