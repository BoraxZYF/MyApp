package com.borax.myapp.activity.caughtcrash;

import android.app.Application;

/**
 * Created by borax on 2017/2/17.
 */

public class CrashApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
//        CrashHandler crashHandler = CrashHandler.getInstance();
//        crashHandler.init(getApplicationContext());
    }
}
