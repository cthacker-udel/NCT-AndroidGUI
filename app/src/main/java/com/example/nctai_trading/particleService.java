package com.example.nctai_trading;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import com.example.nctai_trading.particle.particleMethods;

import java.io.IOException;

public class particleService extends Service {
    private static final String CHANNEL_ID = "exampleServiceChannel";
    particleMethods particleMethods = new particleMethods();
    com.example.nctai_trading.particle.particleMethods.eventRequests eventRequests = particleMethods.new eventRequests();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String input = intent.getStringExtra("inputExtra");

        Intent notificationIntent = new Intent(this,mainPage.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,
                0,notificationIntent,0);

        Notification notifcation = new NotificationCompat.Builder(this,CHANNEL_ID)
                .setContentTitle("Next Capital Tech")
                .setContentText("AI is running")
                .setSmallIcon(R.drawable.nct_logo)
                .setContentIntent(pendingIntent)
                .build();

        NotificationCompat.Builder notification2 = new NotificationCompat.Builder(this,CHANNEL_ID);

        Notification updatedNotification;

        while(true){
            try {
                eventRequests.openStreamOfServerSentEvents("TEST_APL_msg");
                if(particleMethods.getSSEData().equals("")){
                    continue;
                }
                else{
                    notification2.setContentText(particleMethods.getSSEData());
                    notification2.setContentTitle("Next Capital Tech - AI Notification");
                    notification2.setSmallIcon(R.drawable.nct_logo);
                    notification2.setContentIntent(pendingIntent);
                    updatedNotification = notification2.build();
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        startForeground(1,updatedNotification);

        return START_NOT_STICKY;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
