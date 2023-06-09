package com.example.lab5;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyService extends Service {
    private static final String TAG = "MyService";
    private boolean isRunning = false;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "Service onCreate");
        isRunning = true;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "Service onStartCommand");

        // Perform your service logic here

        // Return START_STICKY to indicate that the service should be restarted if it's terminated by the system
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Service onDestroy");
        isRunning = false;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        // If your service is not intended to be bound, you can simply return null here
        return null;
    }
}
