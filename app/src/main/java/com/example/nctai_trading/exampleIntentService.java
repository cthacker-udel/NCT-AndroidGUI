package com.example.nctai_trading;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.IntentService;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.PowerManager;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.JobIntentService;
import androidx.core.app.NotificationCompat;

import com.here.oksse.OkSse;
import com.here.oksse.ServerSentEvent;

import okhttp3.Request;

public class exampleIntentService extends IntentService {


    private PowerManager.WakeLock mWakeLock;

    private static final String CHANNEL_ID = "exampleServiceChannel";

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public exampleIntentService(String name) {
        super(name);
    }


    @Override
    public void onCreate() {
        super.onCreate();

        System.out.println("In oncreate");

       PowerManager pm = (PowerManager)getSystemService(Context.POWER_SERVICE);

        Notification updatedNotification;


        NotificationCompat.Builder notification2 = new NotificationCompat.Builder(this,CHANNEL_ID);

        Intent notificationIntent = new Intent(this,mainPage.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(this,
                0,notificationIntent,0);

        System.out.println("BUILDING NOTIFICATION");
        notification2.setContentText("NO SSE");
        notification2.setContentTitle("Next Capital Tech - AI Notification");
        notification2.setSmallIcon(R.drawable.nct_logo);
        notification2.setContentIntent(pendingIntent);
        updatedNotification = notification2.build();
        startForeground(1,updatedNotification);

    }

    @SuppressLint("MissingPermission")
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        System.out.println("in onstart command");

        ServerSentEvent.Listener listener=new ServerSentEvent.Listener() {
            @Override
            public void onOpen(ServerSentEvent sse, okhttp3.Response response)
            {
                Log.i("Retro","OnOpen");
            }
            @Override
            public void onMessage(ServerSentEvent sse, String id, String event, String message) {
                Log.i("Retro","OnMessage "+ id + "," +event +","+message);
                return;
            }
            @Override
            public void onComment(ServerSentEvent sse, String comment) {
                Log.i("Retro","Oncomment " + comment );
            }
            @Override
            public boolean onRetryTime(ServerSentEvent sse, long milliseconds) {
                Log.i("Retro","OnRetryTime " + milliseconds );
                return true;
            }
            @Override
            public boolean onRetryError(ServerSentEvent sse, Throwable throwable, okhttp3.Response response) {
                Log.i("Retro","OnRetryError "  );
                return true;
            }
            @Override
            public void onClosed(ServerSentEvent sse) {
                Log.i("Retro","Onclose "  );
            }
            @Override
            public Request onPreRetry(ServerSentEvent sse, Request originalRequest) {
                Log.i("Retro","OnPreRetry "  );
                return originalRequest;
            }
        };
        Request request = new Request.Builder().url("url").build();
        OkSse okSse = new OkSse();
        ServerSentEvent sse = okSse.newServerSentEvent(request, listener);


        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        System.out.println("In ondestroy");

        Log.d("Service", "Destroyed");

        mWakeLock.release();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

    }
}
