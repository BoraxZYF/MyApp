package custom.viewpager;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by borax on 2016/12/8.
 */

public class ZoomOutPageTransformer implements ViewPager.PageTransformer {

    private static final float MIN_SCALE = 0.9f;
    private static final float MIN_ALPHA = 0.5f;

    @Override
    public void transformPage(View view, float position) {

        int pageWidth = view.getWidth();
        int pageHeight = view.getHeight();

        if (position < -1) {
            //(-,-1)
            //处于不可见位置的pager
            view.setAlpha(MIN_ALPHA);
            view.setScaleY(MIN_SCALE);
            view.setScaleX(MIN_SCALE);
        } else if (position <= 1) {
            //[-1,1]
            float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
            float vertMargin = pageHeight * (1 - scaleFactor) / 2;
            float horzMargin = pageWidth * (1 - scaleFactor) / 2;

            if (position < 0) {
                //[-1,0)
                view.setTranslationX(horzMargin - vertMargin / 2);
            } else {
                //(0,1)
                view.setTranslationX(-horzMargin + vertMargin / 2);
            }

            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);

            view.setAlpha(MIN_ALPHA + (scaleFactor - MIN_SCALE) / (1 - MIN_SCALE) * (1 - MIN_ALPHA));

//            view.setAlpha(Math.min(MIN_ALPHA, 1 / Math.abs(position)));

        } else {
            //(1,+)
//            view.setAlpha(0);
            view.setAlpha(MIN_ALPHA);
            view.setScaleY(MIN_SCALE);
            view.setScaleX(MIN_SCALE);
        }
    }
}
