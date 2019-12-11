package com.pushbots.java_example;

import android.app.Application;

import com.pushbots.push.Pushbots;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Initialize PushBots
        Pushbots.sharedInstance().init(this);
    }
}
