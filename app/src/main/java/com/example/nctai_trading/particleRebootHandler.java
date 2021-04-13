package com.example.nctai_trading;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class particleRebootHandler extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals("android.intent.action.BOOT_COMPLETED")){
            // set the alarm here
        }
    }
}
