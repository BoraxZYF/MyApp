package com.borax.myapp.activity.cardview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Gallery;
import android.widget.RelativeLayout;

import com.borax.myapp.R;

import java.util.ArrayList;
import java.util.List;

import adapter.CardViewGalleryAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CardViewGalleryActivity extends AppCompatActivity {

    @BindView(R.id.gallery)
    Gallery gallery;
    @BindView(R.id.content_card_view_gralley)
    RelativeLayout contentCardViewGralley;

    private List<String> list = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view_gralley);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initView();
    }

    private void initView() {

        for (int i = 0; i < 20; i++) {
            list.add(i + "");
        }

        gallery.setAdapter(new CardViewGalleryAdapter(this, list));

    }

}
