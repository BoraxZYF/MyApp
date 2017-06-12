package com.borax.myapp.activity.sainti;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.borax.myapp.R;
import com.orhanobut.logger.Logger;

import java.util.HashMap;

public class ShareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    /**作为参考
     * public void showShare(Context context, String text, String platformToShare, boolean showContentEdit, String shareurl) {

     OnekeyShare oks = new OnekeyShare();
     oks.setSilent(!showContentEdit);
     if (platformToShare != null) {
     oks.setPlatform(platformToShare);
     }
     // ShareSDK快捷分享提供两个界面第一个是九宫格 CLASSIC 第二个是SKYBLUE
     oks.setTheme(OnekeyShareTheme.CLASSIC);
     // 令编辑页面显示为Dialog模式
     oks.setDialogMode();
     // 在自动授权时可以禁用SSO方式
     oks.disableSSOWhenAuthorize();
     //        oks.setTitle("约伴旅行");
     oks.setTitle(text);
     oks.setTitleUrl(shareurl);
     // oks.setTitleUrl("http://mob.com");
     //        oks.setText(text);
     oks.setImageUrl(picurl);
     oks.setUrl(shareurl); // 微信不绕过审核分享链接

     oks.setComment("约伴旅行"); // 我对这条分享的评论，仅在人人网和QQ空间使用，否则可以不提供
     oks.setSite("约伴旅行"); // QZone分享完之后返回应用时提示框上显示的名称
     oks.setSiteUrl(shareurl);// QZone分享参数
     oks.setVenueName("约伴旅行");
     oks.setVenueDescription("约伴旅行");

     // 启动分享
     oks.show(context);
     }

     public void showShareSina(Context context, String text, String platformToShare, boolean showContentEdit, String shareurl) {

     OnekeyShare oks = new OnekeyShare();
     oks.setSilent(!showContentEdit);
     if (platformToShare != null) {
     oks.setPlatform(platformToShare);
     }
     // ShareSDK快捷分享提供两个界面第一个是九宫格 CLASSIC 第二个是SKYBLUE
     oks.setTheme(OnekeyShareTheme.CLASSIC);
     // 令编辑页面显示为Dialog模式
     oks.setDialogMode();
     // 在自动授权时可以禁用SSO方式
     oks.disableSSOWhenAuthorize();
     //        oks.setTitle("约伴旅行");
     oks.setTitle(text);
     oks.setTitleUrl(shareurl);
     // oks.setTitleUrl("http://mob.com");
     oks.setText(text);
     oks.setImageUrl(picurl);
     oks.setUrl(shareurl); // 微信不绕过审核分享链接

     oks.setComment("约伴旅行"); // 我对这条分享的评论，仅在人人网和QQ空间使用，否则可以不提供
     oks.setSite("约伴旅行"); // QZone分享完之后返回应用时提示框上显示的名称
     oks.setSiteUrl(shareurl);// QZone分享参数
     oks.setVenueName("约伴旅行");
     oks.setVenueDescription("约伴旅行");

     // 启动分享
     oks.show(context);
     }

     **/

    /**分享回调
     public void showShare(Context context, String text, String platformToShare, boolean showContentEdit, String shareurl) {

     Platform.ShareParams sp = new Platform.ShareParams();

     Logger.d(text + " " + text + shareurl + " " + shareurl + " " + picurl);

     //        text = "123";
     //        shareurl = "www.baidu.com";
     //        picurl = "https://www.baidu.com/img/bd_logo1.png";

     sp.setShareType(Platform.SHARE_IMAGE);
     sp.setTitle(text);
     if (platformToShare.equals(SinaWeibo.NAME)) {
     sp.setText(text + shareurl);
     Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
     sp.setImageData(bitmap);
     } else {
     sp.setText(text);
     sp.setImageUrl(picurl);
     }
     sp.setTitleUrl(shareurl); // 标题的超链接
     sp.setSite("约伴旅行");
     sp.setSiteUrl(shareurl);

     Platform platform = ShareSDK.getPlatform(platformToShare);
     platform.setPlatformActionListener(new PlatformActionListener() {
    @Override public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
    Logger.d("onComplete");
    showToast("分享成功");
    shareSecond();
    }

    @Override public void onError(Platform platform, int i, Throwable throwable) {
    Logger.d("onError" + "  " + throwable.toString());
    }

    @Override public void onCancel(Platform platform, int i) {
    shareSecond();
    Logger.d("onCancel");
    }
    }); // 设置分享事件回调

     // 执行图文分享
     platform.share(sp);
     }
     **/

}
