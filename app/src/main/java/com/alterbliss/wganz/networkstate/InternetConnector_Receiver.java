package com.alterbliss.wganz.networkstate;

import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.util.Log;

/**
 * Created by adminmini on 2018/04/10.
 */

public class InternetConnector_Receiver extends BroadcastReceiver {

    public InternetConnector_Receiver() {
    }


    @Override
    public void onReceive(Context context, Intent intent) {

        try {

            boolean isVisible = MyApplication.isActivityVisible();// Check if
            // activity
            // is
            // visible
            // or not
            Log.i("Activity is Visible ", "Is activity visible : " + isVisible);

            // If it is visible then trigger the task else do nothing
            if (isVisible == true) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context
                        .getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connectivityManager
                        .getActiveNetworkInfo();

                // Check internet connection and according to state change the
                // text of activity by calling method
                if (networkInfo != null && networkInfo.isConnected()) {

                    new MainActivity().changeTextStatus(true);
                } else {
                    new MainActivity().changeTextStatus(false);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

