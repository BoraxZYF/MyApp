package custom.viewpager;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by borax on 2016/12/7.
 */

public class DepthPageTransformer implements ViewPager.PageTransformer {

    private static final float MIN_SCALE = 0.75f;

    @Override
    public void transformPage(View view, float position) {

        int pageWidth = view.getWidth();

        if (position < -1) {
            view.setAlpha(0);
        } else if (position <= 0) {
            view.setAlpha(1);
            view.setTranslationX(0);
            view.setScaleX(1);
            view.setScaleY(1);
        } else if (position <= 1) {
            view.setAlpha(1 - position);
            view.setTranslationX(pageWidth * -position);
            float scaleFrator = MIN_SCALE + (1 - MIN_SCALE) * (1 - Math.abs(position));
            view.setScaleX(scaleFrator);
            view.setScaleY(scaleFrator);
        } else {
            view.setAlpha(0);
        }
    }
}
