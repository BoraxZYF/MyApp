package com.borax.myapp.activity.sainti.loading;

/**
 * Created by Administrator on 2016/11/29.
 */


import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.borax.myapp.R;

public class CustomProgressDialog extends ProgressDialog {

    private Context mContext;
    private String mLoadingTip;
    private TextView mLoadingTv;
    private ImageView image;


    public CustomProgressDialog(Context context, String content) {
        super(context, R.style.dialog);
        this.mContext = context;
        if (TextUtils.isEmpty(content)) {
            this.mLoadingTip = "加载中...";
        } else {
            this.mLoadingTip = content;
        }
        setCanceledOnTouchOutside(false);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress_layout);
        initView();
        initData();
    }

    private void initData() {
        mLoadingTv.setText(mLoadingTip);

    }

    public void setContent(String str) {
        mLoadingTv.setText(str);
    }

    private void initView() {
        mLoadingTv = (TextView) findViewById(R.id.progress_tv);
        image = (ImageView) findViewById(R.id.image);

        image.setImageResource(R.drawable.loading_anim);

        AnimationDrawable animationDrawable = (AnimationDrawable) image.getDrawable();
        animationDrawable.start();

    }


}
