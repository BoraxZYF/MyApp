package com.borax.myapp.activity.longtimeservice;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.SystemClock;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;

import com.borax.myapp.activity.encrypt.BaseBean;
import com.orhanobut.logger.Logger;

import java.util.Date;

import api.API;
import entity.LongServiceTestBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by BoraxZYF on 2017/6/19.
 */

public class LongRunService extends Service {

    private static final String TAG = "LongRunService";


    @Nullable
    @Override

    public IBinder onBind(Intent intent) {

        PowerManager powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
        PowerManager.WakeLock wakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, TAG);
        wakeLock.acquire();

        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        new Thread(new Runnable() {
            @Override
            public void run() {

                API.SERVICE.postLongService(new Date().toString()).enqueue(new Callback<LongServiceTestBean>() {
                    @Override
                    public void onResponse(Call<LongServiceTestBean> call, Response<LongServiceTestBean> response) {
                        Logger.d("post success");
                    }

                    @Override
                    public void onFailure(Call<LongServiceTestBean> call, Throwable t) {

                    }
                });

                Logger.d("executed at " + new Date());
            }
        }).start();

        AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);
        int alarmTime = 60 * 1000 * 5;
        long trigerAtTime = SystemClock.elapsedRealtime() + alarmTime;
        Intent i = new Intent(this, AlarmReceiver.class);
        PendingIntent pi = PendingIntent.getBroadcast(this, 0, i, 0);
        manager.setExact(AlarmManager.ELAPSED_REALTIME_WAKEUP, trigerAtTime, pi);


        return super.onStartCommand(intent, flags, startId);
    }
}
