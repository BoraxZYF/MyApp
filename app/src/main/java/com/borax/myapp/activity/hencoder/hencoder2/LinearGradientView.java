package com.borax.myapp.activity.hencoder.hencoder2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.borax.myapp.R;

/**
 * Created by BoraxZYF on 2017/7/17.
 */

public class LinearGradientView extends View {


    public LinearGradientView(Context context) {
        super(context);
    }

    public LinearGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LinearGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float r = getWidth() / 2;
        float x = r;
        float y = x;

        Shader shader = new LinearGradient(x - r, y - r, x + r, y + r,
                getResources().getColor(R.color.colorAccent),
                getResources().getColor(R.color.colorPrimary),
                Shader.TileMode.CLAMP);

        Paint paint = new Paint();
        paint.setShader(shader);
//        paint.setColor(getResources().getColor(R.color.colorPrimary));

        canvas.drawCircle(x, y, r, paint);


    }
}
