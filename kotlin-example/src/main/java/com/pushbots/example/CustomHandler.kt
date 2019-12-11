package com.pushbots.example

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.pushbots.push.utils.PBConstants

class CustomHandler : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val action = intent.action
        Log.d(TAG, "action=$action")
        // Handle Push Message when opened
        if (action == PBConstants.EVENT_MSG_OPEN) { //Bundle containing all fields of the opened notification
            val bundle = intent.extras!!.getBundle(PBConstants.EVENT_MSG_OPEN)
            Log.i(
                TAG,
                "User clicked notification with Message: " + bundle!!["message"]
            )
        } else if (action == PBConstants.EVENT_MSG_RECEIVE) { //Bundle containing all fields of the notification
            val bundle = intent.extras!!.getBundle(PBConstants.EVENT_MSG_RECEIVE)
            Log.i(
                TAG,
                "User received notification with Message: " + bundle!!["message"]
            )
        }
    }

    companion object {
        private const val TAG = "CustomHandler"
    }
}