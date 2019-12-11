package com.pushbots.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.CompoundButton
import android.widget.Switch
import com.pushbots.push.Pushbots

class MainActivity : AppCompatActivity() {

    val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val notSwitch = findViewById<Switch>(R.id.notificationState)

        Pushbots.sharedInstance().apply {

            // Register for Bush-Bots notification
            registerForRemoteNotifications()

            // Listen on notification receive
            receivedCallback { bundle -> Log.d(TAG, "received: $bundle") }


            // Listen on notification open
            openedCallback { bundle -> Log.d(TAG, "opened: $bundle") }

            // Listen on user's ids callback
            idsCallback { s, s2 ->
                Log.d("TAG", "ID: $s, $s2")
            }

            // Set custom handler for notification
//            setCustomHandler(CustomHandler::class.java)

        }


        // Turn on/off the notification
        notSwitch.setOnCheckedChangeListener { p0, checked ->
            Pushbots.sharedInstance().toggleNotifications(checked)
        }

        // Set custom data to device, to make easy handle it on dashboard
        Pushbots.setEmail("abc@pushbots.com")
        Pushbots.setName("PUSH BOTS")
        Pushbots.setAlias("PUSHER")
    }
}
