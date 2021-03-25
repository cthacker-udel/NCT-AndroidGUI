package com.example.nctai_trading;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

public class particleInterfaceModel {

    private WorkManager workManager;

    public particleInterfaceModel(Context context){
        workManager = WorkManager.getInstance(context);
    }

    void applyRequest(){
        workManager.enqueue(OneTimeWorkRequest.from(particleInterface.class));
    }

}
