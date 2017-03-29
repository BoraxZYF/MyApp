package com.borax.myapp.activity.onstep;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextDragPopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.borax.myapp.R;

import smartisanos.api.OneStepHelper;

public class OneStepActivity extends AppCompatActivity {

    private TextView text;

    private OneStepHelper mOneStepHelper;
    private TextDragPopupWindow mTextDragPopupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_step);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        text = (TextView) findViewById(R.id.textview);

        mOneStepHelper = OneStepHelper.getInstance(OneStepActivity.this);
        text.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (mOneStepHelper.isOneStepShowing()) {
                    mOneStepHelper.dragText(text, "One Step");
                    return true;
                } else {
                    Toast.makeText(OneStepActivity.this, "还没进入OneStep模式", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

    }

}
