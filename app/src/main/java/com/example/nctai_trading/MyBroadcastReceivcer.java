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

    private  AlarmManager manager2;

    static int iterations = 0;

    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("On receive");
            String prefix = intent.getStringExtra("prefix");
            Intent serviceIntent = new Intent(context, exampleIntentService.class);
            serviceIntent.putExtra("prefix",prefix);
            manager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
            manager2 = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
            PendingIntent particleIntent = PendingIntent.getService(context,0,serviceIntent,0);
            Intent start_alarm = new Intent(context,MyBroadcastReceivcer.class);
            start_alarm.setAction("ALARM_START");
            manager2.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+3000,particleIntent);
            PendingIntent pi = PendingIntent.getBroadcast(context,0,start_alarm,0);
            manager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+3000,pi);
            System.out.println("Broadcast fired" + iterations++);
    }
}
