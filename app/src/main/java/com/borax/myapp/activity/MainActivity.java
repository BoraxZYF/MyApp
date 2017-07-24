package com.borax.myapp.activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.borax.myapp.R;
import com.borax.myapp.activity.cardview.CardViewMainActivity;
import com.borax.myapp.activity.caughtcrash.CrashActivity;
import com.borax.myapp.activity.customview.CustomViewActivity;
import com.borax.myapp.activity.encrypt.EncryptActivity;
import com.borax.myapp.activity.fragment.FragmentListActivity;
import com.borax.myapp.activity.hencoder.HencoderMainActivity;
import com.borax.myapp.activity.listview.ListViewActivity;
import com.borax.myapp.activity.longtimeservice.LongServiceActivity;
import com.borax.myapp.activity.lottie.LottieActivity;
import com.borax.myapp.activity.materialdesign.MaterialDesginMainActivity;
import com.borax.myapp.activity.materialdesign4x.MaterialDesign4xMainActivity;
import com.borax.myapp.activity.mvp.MVPActivity;
import com.borax.myapp.activity.onstep.OneStepActivity;
import com.borax.myapp.activity.pulltorefresh.PullToRefreshActivity;
import com.borax.myapp.activity.recyclerviewpager.RecyclerViewPagerAcitivty;
import com.borax.myapp.activity.sainti.SaintiActivity;
import com.borax.myapp.activity.shengchong.activity.ScActivity;
import com.borax.myapp.activity.tablayout.TabLayoutActivity;
import com.borax.myapp.activity.template.TemplateActivity;
import com.borax.myapp.activity.versionupdate.VersionUpdateActivity;
import com.borax.myapp.activity.view.ViewActivity;
import com.borax.myapp.activity.viewpager.ViewPagerActivity;
import com.borax.myapp.activity.waveview.WaveActivity;
import com.borax.myapp.activity.webbiew.WebViewActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.listview)
    ListView listview;

    private final String[] strs = new String[]{"ListView", "Fragment", "View", "TabLayout", "ViewPager", "CardView"
            , "MaterialDesign", "MaterialDesign4.x", "Rebel Test", "Encrypt Retrofit Test", "MVP Test", "Lottie"
            , "CaughtCrash", "OneStep", "Shengchong Test", "RecyclerViewPager", "Version Update", "Wave Test"
            , "Template Activity", "Pull To Refresh Activity", "Sainti", "WebView", "LongTimeService"
            , "HenCoder", "CustomViewActivity"
    };
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //enable transitions
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        initView();

    }

    private void initView() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        listview.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strs));

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                                                switch (i) {
                                                    case 0: {
//                        getWindow().setExitTransition(new android.transition.Explode());
                                                        Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
//                        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle());
                                                        startActivity(intent);
                                                        break;
                                                    }
                                                    case 1: {
                                                        Intent intent = new Intent(MainActivity.this, FragmentListActivity.class);
                                                        startActivity(intent);
                                                        break;
                                                    }

                                                    case 2: {
                                                        Intent intent = new Intent(MainActivity.this, ViewActivity.class);
                                                        startActivity(intent);
                                                        break;
                                                    }

                                                    case 3: {
                                                        Intent intent = new Intent(MainActivity.this, TabLayoutActivity.class);
                                                        startActivity(intent);
                                                        break;
                                                    }

                                                    case 4: {
                                                        Intent intent = new Intent(MainActivity.this, ViewPagerActivity.class);
                                                        startActivity(intent);
                                                        break;
                                                    }

                                                    case 5: {
                                                        Intent intent = new Intent(MainActivity.this, CardViewMainActivity.class);
                                                        startActivity(intent);
                                                        break;
                                                    }

                                                    case 6: {
                                                        Intent intent = new Intent(MainActivity.this, MaterialDesginMainActivity.class);
                                                        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle());
//                        startActivity(intent);
                                                        break;
                                                    }

                                                    case 7: {
                                                        Intent intent = new Intent(MainActivity.this, MaterialDesign4xMainActivity.class);
                                                        startActivity(intent);
                                                        break;
                                                    }

                                                    //case 8: Rebel Test

                                                    case 9: {
                                                        Intent intent = new Intent(MainActivity.this, EncryptActivity.class);
                                                        startActivity(intent);
                                                        break;
                                                    }

                                                    case 10: {
                                                        Intent intent = new Intent(MainActivity.this, MVPActivity.class);
                                                        startActivity(intent);
                                                        break;
                                                    }

                                                    case 11: {
                                                        Intent intent = new Intent(MainActivity.this, LottieActivity.class);
                                                        startActivity(intent);
                                                        break;
                                                    }

                                                    case 12: {
                                                        Intent intent = new Intent(MainActivity.this, CrashActivity.class);
                                                        startActivity(intent);
                                                        break;
                                                    }

                                                    case 13: {
                                                        Intent intent = new Intent(MainActivity.this, OneStepActivity.class);
                                                        startActivity(intent);
                                                        break;
                                                    }

                                                    case 14: {
                                                        Intent intent = new Intent(MainActivity.this, ScActivity.class);
                                                        startActivity(intent);
                                                        break;
                                                    }

                                                    case 15: {
                                                        Intent intent = new Intent(MainActivity.this, RecyclerViewPagerAcitivty.class);
                                                        startActivity(intent);
                                                        break;
                                                    }

                                                    case 16: {
                                                        Intent intent = new Intent(MainActivity.this, VersionUpdateActivity.class);
                                                        startActivity(intent);
                                                        break;
                                                    }

                                                    case 17: {
                                                        Intent intent = new Intent(MainActivity.this, WaveActivity.class);
                                                        startActivity(intent);
                                                        break;
                                                    }

                                                    case 18: {
                                                        Intent intent = new Intent(MainActivity.this, TemplateActivity.class);
                                                        startActivity(intent);
                                                        break;
                                                    }

                                                    case 19: {
                                                        Intent intent = new Intent(MainActivity.this, PullToRefreshActivity.class);
                                                        startActivity(intent);
                                                        break;
                                                    }

                                                    case 20: {
                                                        Intent intent = new Intent(MainActivity.this, SaintiActivity.class);
                                                        startActivity(intent);
                                                        break;
                                                    }

                                                    case 21: {
                                                        Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
                                                        startActivity(intent);
                                                        break;
                                                    }

                                                    case 22: {
                                                        Intent intent = new Intent(MainActivity.this, LongServiceActivity.class);
                                                        startActivity(intent);
                                                        break;
                                                    }

                                                    case 23: {
                                                        Intent intent = new Intent(MainActivity.this, HencoderMainActivity.class);
                                                        startActivity(intent);
                                                        break;
                                                    }

                                                    case 24: {
                                                        Intent intent = new Intent(MainActivity.this, CustomViewActivity.class);
                                                        startActivity(intent);
                                                        break;
                                                    }

                                                }
                                            }
                                        }
        );

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
