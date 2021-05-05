package com.example.nctai_trading;

import android.app.IntentService;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.PowerManager;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import com.example.nctai_trading.particle.SimpleEventHandler;
import com.example.nctai_trading.particle.particleMethods;
import com.launchdarkly.eventsource.EventSource;
import com.squareup.okhttp.HttpUrl;

import java.io.IOException;
import java.net.URI;
import java.time.Duration;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public class particleIntentService extends IntentService {

    private static final String TAG = "ExampleIntentService";

    private final Executor executor = new Executor() {
        @Override
        public void execute(Runnable command) {
            command.run();
        }
    };



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

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onCreate() {
        super.onCreate();

        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("\n\nExecute this\n\n");
            }
        });

        NotificationCompat.Builder notification2 = new NotificationCompat.Builder(this,CHANNEL_ID);

        Intent notificationIntent = new Intent(this,mainPage.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(this,
                0,notificationIntent,0);

        Notification updatedNotification;

        System.out.println("REACHED IF");
        notification2.setContentText("NO SSE");
        notification2.setContentTitle("Next Capital Tech - AI Notification");
        notification2.setSmallIcon(R.drawable.nct_logo);
        notification2.setContentIntent(pendingIntent);
        updatedNotification = notification2.build();
        startForeground(1,updatedNotification);

        /*

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

        try {
            System.out.println("OPENED TRY");
            //eventRequests.openStreamOfServerSentEvents("test");

            particleMethods particleMethods = new com.example.nctai_trading.particle.particleMethods();

            com.example.nctai_trading.particle.particleMethods.accessTokenRequests accessTokenRequests = particleMethods.new accessTokenRequests();

            SimpleEventHandler eventHandler = new SimpleEventHandler();

            String accesstoken = accessTokenRequests.getAccessToken("password").getAccessToken();
            HttpUrl.Builder urlBuilder = HttpUrl.parse(String.format("https://api.particle.io/v1/events/%s","test")).newBuilder();
            urlBuilder.addQueryParameter("access_token",accesstoken);

            EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(urlBuilder.build().toString())).reconnectTime(Duration.ofMillis(3000));

            try(EventSource eventSource = builder.build()) {
                System.out.println("In event source try");
                eventSource.start();
                Thread.sleep(60000);
                //timer.schedule(sleepTask,500);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("BEFORE WHILE");
        while(true){
            try {
                if(particleMethods.getSSEData().equals("")){
                    System.out.println("REACHED IF");
                    notification2.setContentText("NO SSE");
                    notification2.setContentTitle("Next Capital Tech - AI Notification");
                    notification2.setSmallIcon(R.drawable.nct_logo);
                    notification2.setContentIntent(pendingIntent);
                    updatedNotification = notification2.build();
                    startForeground(1,updatedNotification);
                    break;
                }
                else{
                    System.out.println("REACHED ELSE");
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
        */

        // 1 attempt, 2nd attempt, 3rd attempt, 4th attempt, 5th attempt
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
