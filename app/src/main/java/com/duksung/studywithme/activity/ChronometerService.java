package com.duksung.studywithme.activity;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

/**
 * chronometer 백그라운드에서 멈추지 않는 현상이 있음.
 * 이를 해결하기 위한 클래스를 만드려고 하는 흔적..
 */
public class ChronometerService extends Service {
    private Thread mThread;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (mThread == null){
            mThread = new Thread("MyThread"){
                @Override
                public void run() {

                }
            };
            mThread.start();
        }


        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
