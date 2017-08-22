package com.borax.myapp.activity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.orhanobut.logger.Logger;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by zhaoyuefeng on 2017/8/22.
 */

public class LoadingView extends View {

    private Paint paint;
    private int width = 15;
    private int divider = 5;
    private int maxHeight = 0;
    private int startHeight = 60;
    private int currentHeight1 = 80;
    private int currentHeight2 = 90;
    private int currentHeight3 = 100;
    private int currentHeight4 = 110;
    private int currentHeight5 = 120;

    private int state1 = 1;//上
    private int state2 = 1;//上
    private int state3 = 1;//上
    private int state4 = 1;//上
    private int state5 = 1;//上

    public LoadingView(Context context) {
        super(context);
    }

    public LoadingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LoadingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.parseColor("#FFFFFF"));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int x1 = getWidth() / 2 - width / 2 - 2 * divider - 2 * width;
        int x2 = x1 + width + divider;
        int x3 = x2 + width + divider;
        int x4 = x3 + width + divider;
        int x5 = x4 + width + divider;

        RectF rectF1 = null;
        if (currentHeight1 > startHeight) {
            rectF1 = new RectF(x1, startHeight, x1 + width, getHeight() - startHeight);
        } else {
            rectF1 = new RectF(x1, currentHeight1, x1 + width, getHeight() - currentHeight1);
        }

        RectF rectF2 = null;
        if (currentHeight2 > startHeight) {
            rectF2 = new RectF(x2, startHeight, x2 + width, getHeight() - startHeight);
        } else {
            rectF2 = new RectF(x2, currentHeight2, x2 + width, getHeight() - currentHeight2);
        }

        RectF rectF3 = null;
        if (currentHeight3 > startHeight) {
            rectF3 = new RectF(x3, startHeight, x3 + width, getHeight() - startHeight);
        } else {
            rectF3 = new RectF(x3, currentHeight3, x3 + width, getHeight() - currentHeight3);
        }

        RectF rectF4 = null;
        if (currentHeight4 > startHeight) {
            rectF4 = new RectF(x4, startHeight, x4 + width, getHeight() - startHeight);
        } else {
            rectF4 = new RectF(x4, currentHeight4, x4 + width, getHeight() - currentHeight4);
        }

        RectF rectF5 = null;
        if (currentHeight5 > startHeight) {
            rectF5 = new RectF(x5, startHeight, x5 + width, getHeight() - startHeight);
        } else {
            rectF5 = new RectF(x5, currentHeight5, x5 + width, getHeight() - currentHeight5);
        }

        canvas.drawRect(rectF1, paint);
        canvas.drawRect(rectF2, paint);
        canvas.drawRect(rectF3, paint);
        canvas.drawRect(rectF4, paint);
        canvas.drawRect(rectF5, paint);

        postInvalidate();

    }

    @Override
    public void postInvalidate() {
        super.postInvalidate();

        switch (state1) {
            case 1: {
                //向上
                currentHeight1 -= 3;

                if (currentHeight1 <= 6) {
                    state1 = 2;
                }

                break;
            }

            case 2: {
                //向下
                currentHeight1 += 3;

                if (currentHeight1 >= startHeight) {
                    state1 = 1;
                    currentHeight1 = startHeight + 50;
                }

                break;
            }
        }

        switch (state2) {
            case 1: {
                //向上
                currentHeight2 -= 3;

                if (currentHeight2 <= 6) {
                    state2 = 2;
                }

                break;
            }

            case 2: {
                //向下
                currentHeight2 += 3;

                if (currentHeight2 >= startHeight) {
                    state2 = 1;
                    currentHeight2 = startHeight + 50;
                }

                break;
            }
        }

        switch (state3) {
            case 1: {
                //向上
                currentHeight3 -= 3;

                if (currentHeight3 <= 6) {
                    state3 = 2;
                }

                break;
            }

            case 2: {
                //向下
                currentHeight3 += 3;

                if (currentHeight3 >= startHeight) {
                    state3 = 1;
                    currentHeight3 = startHeight + 50;
                }

                break;
            }
        }

        switch (state4) {
            case 1: {
                //向上
                currentHeight4 -= 3;

                if (currentHeight4 <= 6) {
                    state4 = 2;
                }

                break;
            }

            case 2: {
                //向下
                currentHeight4 += 3;

                if (currentHeight4 >= startHeight) {
                    state4 = 1;
                    currentHeight4 = startHeight + 50;
                }

                break;
            }
        }

        switch (state5) {
            case 1: {
                //向上
                currentHeight5 -= 3;

                if (currentHeight5 <= 6) {
                    state5 = 2;
                }

                break;
            }

            case 2: {
                //向下
                currentHeight5 += 3;

                if (currentHeight5 >= startHeight) {
                    state5 = 1;
                    currentHeight5 = startHeight + 50;
                }

                break;
            }
        }


        invalidate();

    }

}
