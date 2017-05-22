package com.borax.myapp.activity.sainti.photoView;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.borax.myapp.R;
import com.borax.myapp.activity.BaseActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.Request;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by borax on 2016/8/18.
 */
public class PhotoViewActivity extends BaseActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.view_pager)
    HackyViewPager viewPager;
    private ArrayList<String> piclist = new ArrayList<String>();
    private int current;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photoview);
        ButterKnife.bind(this);

        piclist = (ArrayList<String>) getIntent().getSerializableExtra("piclist");
        current = getIntent().getIntExtra("current", 0);

        viewPager.setAdapter(new SamplePagerAdapter());
        viewPager.setCurrentItem(current);

    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        onBackPressed();
    }

    class SamplePagerAdapter extends PagerAdapter {


        @Override
        public int getCount() {
            return piclist.size();
        }

        @Override
        public View instantiateItem(ViewGroup container, int position) {
            PhotoView photoView = new PhotoView(container.getContext());
            final PhotoViewAttacher attacher = new PhotoViewAttacher(photoView);

            Glide.with(PhotoViewActivity.this).load(piclist.get(position)).into(photoView).setRequest(new Request() {
                @Override
                public void begin() {

                }

                @Override
                public void pause() {

                }

                @Override
                public void clear() {

                }

                @Override
                public boolean isPaused() {
                    return false;
                }

                @Override
                public boolean isRunning() {
                    return false;
                }

                @Override
                public boolean isComplete() {

                    attacher.update();

                    return false;
                }

                @Override
                public boolean isResourceSet() {
                    return false;
                }

                @Override
                public boolean isCancelled() {
                    return false;
                }

                @Override
                public boolean isFailed() {
                    return false;
                }

                @Override
                public void recycle() {

                }
            });

            // Now just add PhotoView to ViewPager and return it
            container.addView(photoView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

            return photoView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

    }

}
