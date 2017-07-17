package com.borax.myapp.activity.hencoder.hencoder2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.borax.myapp.R;

/**
 * Created by BoraxZYF on 2017/7/17.
 */

public class RadialGradientView extends View {
    public RadialGradientView(Context context) {
        super(context);
    }

    public RadialGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RadialGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float r = getWidth() / 2;
        float x = r;
        float y = x;

        Shader shader = new android.graphics.RadialGradient(x, y, r / 3,
                getResources().getColor(R.color.colorPrimary),
                getResources().getColor(R.color.colorAccent), Shader.TileMode.REPEAT);

        Paint paint = new Paint();
        paint.setShader(shader);

        canvas.drawCircle(x, y, r, paint);

    }
}
