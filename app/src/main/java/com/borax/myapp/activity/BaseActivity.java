package com.borax.myapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by borax on 2016/12/8.
 */

public class BaseActivity extends AppCompatActivity {

    public void showToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

}
