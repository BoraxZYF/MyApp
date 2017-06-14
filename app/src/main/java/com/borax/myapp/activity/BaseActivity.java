package com.borax.myapp.activity;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.borax.myapp.R;
import com.borax.myapp.activity.sainti.loading.CustomProgressDialog;

import in.srain.cube.views.ptr.PtrFrameLayout;

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

    public void setRefreshHeader(PtrFrameLayout ptrFrame) {

        View header = LayoutInflater.from(this).inflate(R.layout.header_layout, null);
        ImageView image = (ImageView) header.findViewById(R.id.image);

        image.setImageResource(R.drawable.loading_anim);

        AnimationDrawable animationDrawable = (AnimationDrawable) image.getDrawable();
        animationDrawable.start();

        ptrFrame.setHeaderView(header);

    }

}
