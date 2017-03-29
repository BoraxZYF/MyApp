package com.borax.myapp.activity.waveview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by borax on 2017/3/21.
 */

public class WaveView extends View {

    private Paint paint;
    private int maxWidth = 500;
    //是否运行
    private boolean isStarting = false;
    private List<Integer> alphaList = new ArrayList<Integer>();
    private List<Integer> startWidthList = new ArrayList<Integer>();


    public WaveView(Context context) {
        super(context);
        init();
    }

    public WaveView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public WaveView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

        paint = new Paint();
        paint.setColor(Color.parseColor("#ffc849"));
        alphaList.add(255);
        startWidthList.add(0);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setBackgroundColor(Color.TRANSPARENT);

        for (int i = 0; i < alphaList.size(); i++) {

            int alpha = alphaList.get(i);
            int startWidth = startWidthList.get(i);

            paint.setAlpha(alpha);

            canvas.drawCircle(getWidth() / 2, getHeight() / 2, startWidth, paint);

            if (isStarting && alpha > 0 && startWidth < maxWidth) {
                alphaList.set(i, (alpha - 1));
                startWidthList.set(i, (startWidth + 1));
            }
        }

        if (isStarting && startWidthList.get(startWidthList.size() - 1) == 60) {
            alphaList.add(255);
            startWidthList.add(0);
        }

        if (isStarting && startWidthList.size() == 10) {
            startWidthList.remove(0);
            alphaList.remove(0);
        }

        invalidate();
    }

    public void start() {
        isStarting = true;
    }

    public void stop() {
        isStarting = false;
    }

    public boolean isStarting() {
        return isStarting;
    }
}
