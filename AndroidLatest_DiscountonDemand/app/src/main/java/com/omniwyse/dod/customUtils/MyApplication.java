package com.omniwyse.dod.customUtils;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import com.estimote.sdk.BeaconManager;
import com.estimote.sdk.Region;
import com.omniwyse.dod.ui.LoginActivity;
import com.omniwyse.dod.ui.MainActivity;

import java.util.UUID;

/**
 * Created by omniwyse on 08-03-2017.
 */

public class MyApplication extends Application {
    private BeaconManager beaconManager;

    @Override
    public void onCreate() {
        super.onCreate();


    }


}
