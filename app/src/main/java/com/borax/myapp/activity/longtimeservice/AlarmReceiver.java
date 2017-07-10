package com.borax.myapp.activity.longtimeservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by BoraxZYF on 2017/6/19.
 */

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i = new Intent(context, LongRunService.class);
        context.startService(i);
    }
}
