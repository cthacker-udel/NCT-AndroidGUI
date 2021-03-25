package com.example.nctai_trading;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

import java.util.concurrent.TimeUnit;

public class particleInterfaceModel {

    private WorkManager workManager;

    public particleInterfaceModel(Context context){
        workManager = WorkManager.getInstance(context);
    }

    void applyRequest(){
        PeriodicWorkRequest periodicWorkRequest = new PeriodicWorkRequest.Builder(particleInterface.class,16, TimeUnit.MINUTES).build();
        workManager.enqueue(periodicWorkRequest);
        //workManager.enqueue(OneTimeWorkRequest.from(particleInterface.class));
    }

}
