package com.borax.myapp.activity.view.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;

import com.orhanobut.logger.Logger;

/**
 * Created by BoraxZYF on 2017/3/29.
 */

public class VelocityTrackerView extends View {
    public VelocityTrackerView(Context context) {
        super(context);
    }

    public VelocityTrackerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public VelocityTrackerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        VelocityTracker velocityTracker = VelocityTracker.obtain();
        velocityTracker.addMovement(event);

        velocityTracker.computeCurrentVelocity(500);
        float xVelocity = velocityTracker.getXVelocity();
        float yVelocity = velocityTracker.getYVelocity();

        Logger.d("xVelocity: " + xVelocity + "  yVelocity： " + yVelocity);

        return super.onTouchEvent(event);
    }
}
