package com.omniwyse.dod.beacon;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

public class EstimoteService extends Service {
	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		try {
			System.out.println("Mukesh IN  Servie is Start.....");
			EstimoteManager.Create((NotificationManager) this
					.getSystemService(Context.NOTIFICATION_SERVICE), getApplicationContext(),
					intent);
		} catch (Exception e) {
			System.out.println("Mukeshs Servie is start exception ....."+e.getMessage());
		}
		return START_STICKY;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		EstimoteManager.stop();
		System.out.println("Mukeshs Servie is Stop exception .....");
	}
}
