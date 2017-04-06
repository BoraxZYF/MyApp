package com.borax.myapp.activity.view.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.nineoldandroids.view.ViewHelper;
import com.orhanobut.logger.Logger;

/**
 * Created by BoraxZYF on 2017/3/29.
 */

public class FollowFingerView extends LinearLayout {

    int mLastX;
    int mLastY;

    public FollowFingerView(Context context) {
        super(context);
    }

    public FollowFingerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FollowFingerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getRawX();
        int y = (int) event.getRawY();

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN: {
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                int deltaX = x - mLastX;
                int deltaY = y - mLastY;
                Logger.d("deltaX: " + deltaX + "  deltaY: " + deltaY);
                int translationX = (int) (ViewHelper.getTranslationX(this) + deltaX);
                int translationY = (int) (ViewHelper.getTranslationY(this) + deltaY);

                ViewHelper.setTranslationX(this, translationX);
                ViewHelper.setTranslationY(this, translationY);

                break;
            }
            case MotionEvent.ACTION_UP: {
                break;
            }
        }

        mLastX = x;
        mLastY = y;

        return true;
    }
}
