package custom.viewpager;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.borax.myapp.R;

/**
 * Created by borax on 2016/12/8.
 */

public class CustomTransformer implements ViewPager.PageTransformer {

    private static final float MIN_ALPHA = 0.5f;

    @Override
    public void transformPage(View page, float position) {

        ImageView image = (ImageView) page.findViewById(R.id.image);

        if (position < -1) {

        } else if (position <= 1) {

            page.setAlpha(Math.max(MIN_ALPHA, Math.abs(1 - position)));
            page.setScaleY(1 - Math.abs(position));
            page.setScaleX(1 - Math.abs(position));

            if (position < 0) {
                page.setRotationY(90 * position);
            } else if (position > 0) {
                page.setRotationY(90 * position);
            }

        } else {


        }
    }
}
