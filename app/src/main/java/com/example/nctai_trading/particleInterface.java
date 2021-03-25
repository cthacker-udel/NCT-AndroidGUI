package com.example.nctai_trading;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.Worker;
import androidx.work.WorkerFactory;
import androidx.work.WorkerParameters;

public class particleInterface extends Worker {

    private static final String TAG = particleInterface.class.getSimpleName();

    public particleInterface(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        Context applicationContext = getApplicationContext();
        System.out.println("Running doWork!");
        WorkerUtils.makeStatusNotification("Running do work",applicationContext);

        return null;
    }
}
