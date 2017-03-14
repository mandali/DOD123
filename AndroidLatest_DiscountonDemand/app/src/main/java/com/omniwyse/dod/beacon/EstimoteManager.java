package com.omniwyse.dod.beacon;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.estimote.sdk.Beacon;
import com.estimote.sdk.BeaconManager;
import com.estimote.sdk.BeaconManager.MonitoringListener;
import com.estimote.sdk.Region;
import com.estimote.sdk.Utils;
import com.omniwyse.dod.R;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class EstimoteManager {
    private static final int NOTIFICATION_ID = 123;
    private static BeaconManager beaconManager;
    private static NotificationManager notificationManager;
    public static final String EXTRAS_BEACON = "extrasBeacon";
    private static final String ESTIMOTE_PROXIMITY_UUID = "B9407F30-F5F8-466E-AFF9-25556B57FE6D";
    public static final Region ALL_ESTIMOTE_BEACONS = new Region("regionId",
            UUID.fromString(ESTIMOTE_PROXIMITY_UUID), null, null);

    private static Context currentContext;

    // Create everything we need to monitor the beacons
    public static void Create(NotificationManager notificationMngr,
                              Context context, final Intent i) {


        try {
            System.out.println("Mukeshs Service Manager on Create .....");
            notificationManager = notificationMngr;
            currentContext = context;

            // Create a beacon manager
            beaconManager = new BeaconManager(currentContext);

            // We want the beacons heartbeat to be set at one second.
            beaconManager.setBackgroundScanPeriod(TimeUnit.SECONDS.toMillis(1),
                    0);

            // Method called when a beacon gets...
            beaconManager.setMonitoringListener(new MonitoringListener() {
                // ... close to us.
                @Override
                public void onEnteredRegion(Region region, List<Beacon> beacons) {
           /*         postNotificationIntent("Estimote testing",
                            "I have found an estimote !!!" + beacons.get(0).getMacAddress(), i);*/
                    for (Beacon beacon : beacons) {
                        System.out.println("The beacon " + beacon.toString() + " is about " + beacon.getMacAddress() + " meters away.");
                    }

                }

                // ... far away from us.
                @Override
                public void onExitedRegion(Region region) {
/*                    postNotificationIntent("Estimote testing",
                            "I have lost my estimote !!!", i);*/

                    System.out.println(" Mukesh  " + " Lost   " + i);
                    Toast.makeText(currentContext, " Lost Beacon ", Toast.LENGTH_SHORT).show();
                }
            });

            beaconManager.setRangingListener(new BeaconManager.RangingListener() {
                @Override
                public void onBeaconsDiscovered(Region region, List<Beacon> beacons) {
                    String mintgreen = "[E8:C8:22:9B:A5:B9]";
                    String iceblue = "[F2:FA:AB:EF:7D:67]";
                    String blueberry = "[FF:F5:D1:26:E6:66]";

                    for (int i = 0; i < beacons.size(); i++) {
                        System.out.println(" Raning Mukesh  " + " Found Beacon " + beacons.get(i).getMajor() + " Mac " + beacons.get(i).getMacAddress());
                        //  Toast.makeText(currentContext, " Ranging Found Beacon " +beacons.get(i).getMajor()+ " Mac "+beacons.get(i).getMacAddress(), Toast.LENGTH_SHORT).show();
                        if (Utils.computeProximity(beacons.get(i)) == Utils.Proximity.IMMEDIATE) {
                            // TODO Replace .IMMEDIATE with .NEAR
//                            doRequest();
                            //   Toast.makeText(currentContext, " Ranging Found Beacon " + beacons.get(i).getMajor() + " Mac " + beacons.get(i).getMacAddress(), Toast.LENGTH_SHORT).show();


                            if (beacons.get(i).getMacAddress().toString().trim().equals(mintgreen)) {
                                Toast.makeText(currentContext, "Connected to MINT GREEN BEACON", Toast.LENGTH_SHORT).show();
                            } else if (beacons.get(i).getMacAddress().toString().trim().equals(iceblue)) {
                                Toast.makeText(currentContext, "Connected to ICE BLUE  BEACON", Toast.LENGTH_SHORT).show();
                            } else if (beacons.get(i).getMacAddress().toString().trim().equals(blueberry)) {
                                Toast.makeText(currentContext, "Connected to BLUE BERRY BEACON", Toast.LENGTH_SHORT).show();
                            }
                        }


                    }
                }
            });

            // Connect to the beacon manager...
            beaconManager.connect(new BeaconManager.ServiceReadyCallback() {
                @Override
                public void onServiceReady() {
                    try {
                        // ... and start the monitoring
                        System.out.println(" Mukesh Beacon Monitoring Connected");
                        beaconManager.startMonitoring(ALL_ESTIMOTE_BEACONS);
                        beaconManager.startRanging(ALL_ESTIMOTE_BEACONS);
                    } catch (Exception e) {
                    }
                }
            });


        } catch (Exception e) {
            System.out.println("Mukeshs Service Manager on Exception ....." + e.getMessage());
        }

    }

    // Pops a notification in the task bar
    public static void postNotificationIntent(String title, String msg, Intent i) {
        i.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivities(
                currentContext, 0, new Intent[]{i},
                PendingIntent.FLAG_UPDATE_CURRENT);
        Notification notification = new Notification.Builder(currentContext)
                .setSmallIcon(R.drawable.ic_launcher).setContentTitle(title)
                .setContentText(msg).setAutoCancel(true)
                .setContentIntent(pendingIntent).build();
        notification.defaults |= Notification.DEFAULT_SOUND;
        notification.defaults |= Notification.DEFAULT_LIGHTS;
        notificationManager.notify(NOTIFICATION_ID, notification);
    }

    // Stop beacons monitoring, and closes the service
    public static void stop() {
        try {
            System.out.println(" Mukesh Beacon Monitoring Stopped.......");
            beaconManager.stopMonitoring(ALL_ESTIMOTE_BEACONS);
            beaconManager.disconnect();
        } catch (Exception e) {
            System.out.println(" Mukesh Beacon Monitoring Stopped Exception ......." + e.getMessage());
        }
    }
}
