package com.borax.myapp.activity.view.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;

import com.orhanobut.logger.Logger;

/**
 * Created by BoraxZYF on 2017/7/17.
 */

public class DispatchChildButton extends android.support.v7.widget.AppCompatButton {
    public DispatchChildButton(Context context) {
        super(context);
    }

    public DispatchChildButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DispatchChildButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        Logger.d("ChildOnTouchEvent");

//        return false;
//        super.onTouchEvent(event);


        return true;
    }
}
