package view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.borax.myapp.R;

/**
 * Created by borax on 2016/10/24.
 */

public class MyView extends View {

    private Paint mPaint;

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        mPaint.setColor(getResources().getColor(R.color.colorPrimaryDark));
        canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);
        mPaint.setColor(getResources().getColor(R.color.colorAccent));
        mPaint.setTextSize(50);
        mPaint.setTextAlign(Paint.Align.CENTER);
        String text = "Hello View";
        canvas.drawText(text, 0, getHeight() / 2, mPaint);

    }
}
