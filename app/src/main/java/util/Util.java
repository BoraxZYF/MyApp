package util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

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

        return sp.getString("crash","");

    }



}
