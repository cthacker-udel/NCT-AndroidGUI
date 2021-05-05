package com.example.nctai_trading;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.content.ContextCompat;

import com.example.nctai_trading.particle.SimpleEventHandler;

public class MyBroadcastReceivcer extends BroadcastReceiver {

    private AlarmManager manager;

    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("On receive");
            Intent serviceIntent = new Intent(context, exampleIntentService.class);
            ContextCompat.startForegroundService(context, serviceIntent);
            manager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
            Intent start_alarm = new Intent(context,MyBroadcastReceivcer.class);
            start_alarm.setAction("ALARM_START");
            PendingIntent pi = PendingIntent.getBroadcast(context,0,start_alarm,0);
            manager.setInexactRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+3000,3000,pi);
            System.out.println("Broadcast fired");
    }
}
