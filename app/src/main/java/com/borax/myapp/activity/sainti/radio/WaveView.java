package com.borax.myapp.activity.sainti.radio;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by borax on 2017/3/22.
 */

public class WaveView extends View {

    private int maxWidth = 300;
    private List<WaveBean> itemlist = new ArrayList<WaveBean>();

    private Paint paint;

    private boolean isStarting = false;

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
        itemlist.add(new WaveBean());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        setBackgroundColor(Color.TRANSPARENT);

        for (int i = 0; i < itemlist.size(); i++) {

            WaveBean bean = itemlist.get(i);

            paint.setAlpha(bean.getAlpha());

            canvas.drawCircle(getWidth() / 2, getHeight() / 2, bean.getWidth() + 85, paint);

            if (isStarting && bean.getAlpha() > 0 && bean.getWidth() < maxWidth) {
                bean.setAlpha(bean.getAlpha() - 1);
                bean.setWidth(bean.getWidth() + 1);
            }

        }

        if (isStarting && itemlist.get(itemlist.size() - 1).getWidth() == 70) {
            itemlist.add(new WaveBean());
        }

        if (isStarting && itemlist.size() == 10) {
            itemlist.remove(0);
        }

        invalidate();

    }

    public void start() {
        isStarting = true;
    }

    public void stop() {
        isStarting = false;
        itemlist.clear();
        itemlist.add(new WaveBean());
    }

    public boolean isStarting() {
        return isStarting;
    }

    class WaveBean {

        private int width = 0;
        private int alpha = 255;

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getAlpha() {
            return alpha;
        }

        public void setAlpha(int alpha) {
            this.alpha = alpha;
        }
    }


}
