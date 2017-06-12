package com.borax.myapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.borax.myapp.activity.sainti.loading.CustomProgressDialog;

/**
 * Created by borax on 2016/12/8.
 */

public class BaseActivity extends AppCompatActivity {

    CustomProgressDialog dialog;

    public void showToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    public void showLoading() {
        if (dialog != null && dialog.isShowing()) {
        } else {
            dialog = new CustomProgressDialog(this, "");
            dialog.show();
        }
    }

    public void showLoading(String msg) {
        if (dialog != null && dialog.isShowing()) {
        } else {
            dialog = new CustomProgressDialog(this, msg);
            dialog.show();
        }
    }

    public void dismissLoading() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
            dialog = null;
        }
    }

}
