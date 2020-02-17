package com.gradle.plugin.pushbots_plugin_example

import android.app.Application
import com.pushbots.push.Pushbots

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // Initialize PushBots
        Pushbots.sharedInstance().init(this)
    }
}