package com.pushbots.java_example;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.pushbots.push.utils.PBConstants;

public class CustomHandler extends BroadcastReceiver {
    private static final String TAG = "CustomHandler";

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Log.d(TAG, "action=" + action);

        // Handle Push Message when opened
        if (action.equals(PBConstants.EVENT_MSG_OPEN)) {

            //Bundle containing all fields of the opened notification
            Bundle bundle = intent.getExtras().getBundle(PBConstants.EVENT_MSG_OPEN);

            Log.i(TAG, "User clicked notification with Message: " + bundle.get("message"));

        } else if (action.equals(PBConstants.EVENT_MSG_RECEIVE)) {

            //Bundle containing all fields of the notification
            Bundle bundle = intent.getExtras().getBundle(PBConstants.EVENT_MSG_RECEIVE);
            Log.i(TAG, "User received notification with Message: " + bundle.get("message"));

        }

    }
}
