package com.borax.myapp.activity.view.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Scroller;

import com.orhanobut.logger.Logger;

/**
 * Created by BoraxZYF on 2017/7/14.
 */

public class SmoothScrollView extends LinearLayout {


    private Context context;
    private Scroller mScroller;

    public SmoothScrollView(Context context) {
        super(context);
        this.context = context;
        mScroller = new Scroller(context);

    }

    public SmoothScrollView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        mScroller = new Scroller(context);

    }

    public SmoothScrollView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        mScroller = new Scroller(context);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.DKGRAY);

    }

    public void smoothScrollTo(int destX, int destY) {

        Logger.d(destX + " " + destY);

        int scrollX = getScrollX();
        int scrollY = getScrollY();

        int deltaX = destX - scrollX;
        int deltaY = destY - scrollY;

        mScroller.startScroll(scrollX, scrollY, deltaX, deltaY, 1000);
        invalidate();

    }


    @Override
    public void computeScroll() {

        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            postInvalidate();
        }

    }


}
