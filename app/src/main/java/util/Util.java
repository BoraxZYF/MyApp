package util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.WindowManager;

/**
 * Created by borax on 2017/2/17.
 */

public class Util {

    public static void saveLog(Context context, String str) {

        SharedPreferences sp;
        SharedPreferences.Editor editor;

        sp = context.getSharedPreferences("test", Activity.MODE_PRIVATE);
        editor = sp.edit();

        editor.putString("crash", str);
        editor.commit();

    }

    public static String getLog(Context context) {

        SharedPreferences sp;
        sp = context.getSharedPreferences("test", Activity.MODE_PRIVATE);

        return sp.getString("crash", "");

    }

    public static int getScreenWidth(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        return width;
    }

    public static int getScreenHeight(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        int height = wm.getDefaultDisplay().getHeight();
        return height;
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

}
