package com.borax.myapp.activity.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.Button;

import com.borax.myapp.R;
import com.orhanobut.logger.Logger;

/**
 * Created by BoraxZYF on 2017/7/24.
 */

public class BoraxRoundButton extends android.support.v7.widget.AppCompatButton {


    private int bg_color;
    private float cornerRadius;
    private float borderWidth;
    private int borderColor;


    public BoraxRoundButton(Context context) {
        this(context, null, 0);
    }

    public BoraxRoundButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BoraxRoundButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        Logger.d("context, attrs, defStyleAttr");

        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.BoraxRoundButton, defStyleAttr, 0);

        for (int i = 0; i < typedArray.getIndexCount(); i++) {

            int attr = typedArray.getIndex(i);
            switch (attr) {

                case R.styleable.BoraxRoundButton_bg_color: {
                    bg_color = typedArray.getColor(attr, Color.BLACK);
                    break;
                }

                case R.styleable.BoraxRoundButton_cornersRadius: {
                    cornerRadius = typedArray.getDimension(attr, 0);
                    break;
                }

                case R.styleable.BoraxRoundButton_borderWidth: {
                    borderWidth = typedArray.getDimension(attr, 0);
                    break;
                }

                case R.styleable.BoraxRoundButton_borderColor: {
                    borderColor = typedArray.getColor(attr, Color.BLACK);
                    break;
                }

            }

        }

        typedArray.recycle();

    }

    @Override
    protected void onDraw(Canvas canvas) {

        Paint bgPaint = new Paint();
        bgPaint.setAntiAlias(true);
        bgPaint.setStyle(Paint.Style.FILL);
        bgPaint.setColor(bg_color);
        RectF bgRectF = new RectF(borderWidth / 2, borderWidth / 2, getWidth() - borderWidth / 2, getHeight() - borderWidth / 2);
        canvas.drawRoundRect(bgRectF, cornerRadius, cornerRadius, bgPaint);

        Paint borderPaint = new Paint();
        borderPaint.setAntiAlias(true);
        borderPaint.setStyle(Paint.Style.STROKE);
        borderPaint.setColor(borderColor);
        borderPaint.setStrokeWidth(borderWidth);
        float x = ((float) (borderWidth - (borderWidth / Math.pow(3, 1 / 2.0))));
        RectF borderRectF = new RectF(x, x, getWidth() - x, getHeight() - x);
        canvas.drawRoundRect(borderRectF, cornerRadius, cornerRadius, borderPaint);

        super.onDraw(canvas);
    }

    public int getBg_color() {
        return bg_color;
    }

    public void setBg_color(int bg_color) {
        this.bg_color = bg_color;
        invalidate();
    }

    public float getCornerRadius() {
        return cornerRadius;
    }

    public void setCornerRadius(float cornerRadius) {
        this.cornerRadius = cornerRadius;
        invalidate();
    }

    public float getBorderWidth() {
        return borderWidth;
    }

    public void setBorderWidth(float borderWidth) {
        this.borderWidth = borderWidth;
        invalidate();
    }

    public int getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(int borderColor) {
        this.borderColor = borderColor;
        invalidate();
    }
}
