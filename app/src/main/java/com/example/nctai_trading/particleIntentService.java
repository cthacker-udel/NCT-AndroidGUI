package com.example.nctai_trading;

import android.app.IntentService;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.PowerManager;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import com.example.nctai_trading.particle.particleMethods;

import java.io.IOException;

public class particleIntentService extends IntentService {

    private static final String TAG = "ExampleIntentService";

    private PowerManager.WakeLock wakeLock;

    private static final String CHANNEL_ID = "exampleServiceChannel";
    particleMethods particleMethods = new particleMethods();
    com.example.nctai_trading.particle.particleMethods.eventRequests eventRequests = particleMethods.new eventRequests();

    public particleIntentService(){
        super(TAG);
    }

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public particleIntentService(String name) {
        super(TAG);
        setIntentRedelivery(true);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        PowerManager powerManager = (PowerManager)getSystemService(POWER_SERVICE);
        wakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "ExampleApp:Wakelock");
        wakeLock.acquire(60000);

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

        int iterations = 1;

        try {
            eventRequests.openStreamOfServerSentEvents("TEST_APL_msg");
        } catch (IOException e) {
            e.printStackTrace();
        }

        while(true){
            try {
                if(particleMethods.getSSEData().equals("")){
                    continue;
                }
                else{
                    System.out.println("Iteration:" + iterations++);
                    notification2.setContentText(particleMethods.getSSEData());
                    notification2.setContentTitle("Next Capital Tech - AI Notification");
                    notification2.setSmallIcon(R.drawable.nct_logo);
                    notification2.setContentIntent(pendingIntent);
                    updatedNotification = notification2.build();
                    startForeground(1,updatedNotification);
                    particleMethods.setSSEData("");
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        String input = intent.getStringExtra("inputExtra");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
