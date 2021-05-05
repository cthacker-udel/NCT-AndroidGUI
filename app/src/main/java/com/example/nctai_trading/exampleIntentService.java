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
import android.icu.text.SymbolTable;
import android.os.IBinder;
import android.os.PowerManager;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.JobIntentService;
import androidx.core.app.NotificationCompat;

import com.example.nctai_trading.particle.particleMethods;
import com.here.oksse.OkSse;
import com.here.oksse.ServerSentEvent;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Request;

public class exampleIntentService extends IntentService {


    private PowerManager.WakeLock mWakeLock;

    private static final String TAG = "ExampleIntentService";

    private static final String CHANNEL_ID = "exampleServiceChannel";

    public static String particleCommand = " ";

    Notification updatedNotification;

    public exampleIntentService(){
        super(TAG);
    }

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public exampleIntentService(String name) {
        super(name);
        System.out.println("In constructor");
    }


    @Override
    public void onCreate() {
        super.onCreate();

        System.out.println("In oncreate");

       PowerManager pm = (PowerManager)getSystemService(Context.POWER_SERVICE);


       /*
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
        */


    }

    @SuppressLint("MissingPermission")
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        System.out.println("in onstart command");

        String prefix = intent.getStringExtra("prefix");

        com.example.nctai_trading.particle.particleMethods particleMethods = new particleMethods();

        exchangeInterface exchangeInterface = new exchangeInterface();

        com.example.nctai_trading.particle.particleMethods.accessTokenRequests accessTokenRequests = particleMethods.new accessTokenRequests();

        String accesstoken = null;
        try {
            accesstoken = accessTokenRequests.getAccessToken("password").getAccessToken();
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpUrl.Builder urlBuilder = HttpUrl.parse(String.format("https://api.particle.io/v1/events/%s",prefix)).newBuilder();
        urlBuilder.addQueryParameter("access_token",accesstoken);
        String urlokhttp3 = urlBuilder.build().toString();

        ServerSentEvent.Listener listener=new ServerSentEvent.Listener() {
            @Override
            public void onOpen(ServerSentEvent sse, okhttp3.Response response)
            {
                Log.i("Retro","OnOpen");
            }
            @Override
            public void onMessage(ServerSentEvent sse, String id, String event, String message) {
                Log.i("Retro","OnMessage "+ id + "," +event +","+message);
                sse.close();
                particleCommand = message;
                System.out.println("-----------PARTICLE COMMAND = " + particleCommand + "--------------");
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
        Request request = new Request.Builder().url(urlokhttp3).build();
        OkSse okSse = new OkSse();
        ServerSentEvent sse = okSse.newServerSentEvent(request, listener);

        NotificationCompat.Builder notification2 = new NotificationCompat.Builder(this,CHANNEL_ID);

        Intent notificationIntent = new Intent(this,mainPage.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(this,
                0,notificationIntent,0);

        System.out.println("BUILDING NOTIFICATION");
        if(particleCommand.equals(" ")) {
            System.out.println("REACHED FIRST IF : PARTICLE COMMAND = " + particleCommand);
            return START_NOT_STICKY;
        }
        System.out.println("About to build notification");
        exchangeInterface.setDataReceived(particleCommand.split("\\{\"data\":\"")[0].replaceAll("\"",""));
        //{"data":"TTTTTTEEEESSSTTTTT","ttl":60,"published_at":"2021-05-05T08:26:19.211Z","coreid":"api"}
        notification2.setContentText(particleCommand);
        notification2.setContentTitle("Next Capital Tech - AI Notification");
        notification2.setSmallIcon(R.drawable.nct_logo);
        notification2.setContentIntent(pendingIntent);
        updatedNotification = notification2.build();
        startForeground(1,updatedNotification);
        System.out.println("STARTING NOTIFICATION");
        particleCommand = " ";

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
        System.out.println("in onbind");
        return null;
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        System.out.println("in onhandle intent");
    }
}
