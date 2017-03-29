package com.borax.myapp.activity.caughtcrash;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.orhanobut.logger.Logger;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import util.Util;

/**
 * Created by borax on 2017/2/17.
 */

public class CrashHandler implements Thread.UncaughtExceptionHandler {

    public static final String TAG = "CrashHandler";

    private Thread.UncaughtExceptionHandler mDefaultHandler;

    private static CrashHandler instance;

    private Context mContext;

    private Map<String, String> infos = new HashMap<String, String>();

    private DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd--HH-mm-ss");

    private CrashHandler() {
    }

    public static CrashHandler getInstance() {
        if (instance == null)
            instance = new CrashHandler();
        return instance;
    }

    public void init(Context context) {
        mContext = context;
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {

        if (!handleException(throwable) && mDefaultHandler != null) {
            mDefaultHandler.uncaughtException(thread, throwable);
        } else {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);

        }
    }

    private boolean handleException(Throwable ex) {

        if (ex == null) {
            return false;
        }

        collectDeviceInfo(mContext);
        saveCatchInfo(ex);
//        new Thread() {
//
//            @Override
//            public void run() {
//                Looper.prepare();
//                Toast.makeText(mContext, "很抱歉，程序出现异常，即将退出", Toast.LENGTH_SHORT).show();
//                Looper.loop();
//            }
//        }.start();

        return true;
    }

    public void collectDeviceInfo(Context context) {

        try {
            PackageManager pm = context.getPackageManager();
            PackageInfo packageInfo = pm.getPackageInfo(context.getPackageName(), PackageManager.GET_ACTIVITIES);
            if (packageInfo != null) {
                String versionName = packageInfo.versionName == null ? "null" : packageInfo.versionName;
                String versionCode = packageInfo.versionCode + "";
                infos.put("versionName", versionName);
                infos.put("versionCode", versionCode);
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

//        Field[] fields = Build.class.getDeclaredFields();
//
//        for (Field field : fields) {
//
//            try {
//                field.setAccessible(true);
//                infos.put(field.getName(), field.get(null).toString());
//                Log.d(TAG, field.getName() + " : " + field.get(null));
//            } catch (IllegalAccessException e) {
//                Log.e(TAG, "an error occured when collect crash info", e);
//            }
//        }
    }

    private void saveCatchInfo(Throwable ex) {

        String sb = "";

        for (Map.Entry<String, String> entry : infos.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            sb += " key =" + value + "\n";
        }

        Writer writer = new StringWriter();
        PrintWriter printWriter = new PrintWriter(writer);
        ex.printStackTrace(printWriter);
        Throwable cause = ex.getCause();

        while (cause != null) {
            cause.printStackTrace(printWriter);
            cause = cause.getCause();
        }

        ex.getMessage();

        printWriter.close();
        String result = writer.toString();
        sb += result;

        sb = sb.replace("'","#");
        Logger.d(sb);

        final String sql = "insert into UncaughtExceptionHandler(ExceptionTitle,ExceptionMeg)values('" + "" + "'," + "'" + sb + "');";

        Logger.d(sql);

        Util.saveLog(mContext, sql);
    }
}
