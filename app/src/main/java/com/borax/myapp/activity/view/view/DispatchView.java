package com.borax.myapp.activity.view.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import com.orhanobut.logger.Logger;

/**
 * Created by BoraxZYF on 2017/7/17.
 */

public class DispatchView extends LinearLayout {


    public DispatchView(Context context) {
        super(context);
    }

    public DispatchView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DispatchView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        boolean flag = super.dispatchTouchEvent(ev);

        Logger.d("dispatchTouchEvent: " + flag);

        return flag;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        Logger.d("onInterceptTouchEvent");

        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        Logger.d("onTouchEvent");

//        return false;

        return super.onTouchEvent(event);
    }
}
