package com.gradle.plugin.pushbots_plugin_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pushbots.push.PushUtils
import com.pushbots.push.Pushbots

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Pushbots.sharedInstance().registerForRemoteNotifications()
    }
}
