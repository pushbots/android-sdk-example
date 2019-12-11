package com.pushbots.java_example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.pushbots.push.Pushbots;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Switch notSwitcher = findViewById(R.id.notificationState);

        // Register for Push-Bots Notification
        Pushbots.sharedInstance().registerForRemoteNotifications();



        // Listen on notification receive
        Pushbots.sharedInstance().receivedCallback(new Pushbots.notificationReceivedHandler() {
            @Override
            public void received(Bundle bundle) {
                Log.d(TAG, "received: " + bundle.toString());
            }
        });

        // Listen on notifications open
        Pushbots.sharedInstance().openedCallback(new Pushbots.notificationOpenedHandler() {
            @Override
            public void opened(Bundle bundle) {
                Log.d(TAG, "opened: " + bundle.toString());
            }
        });

        // Listen on user's id's update
        Pushbots.sharedInstance().idsCallback(new Pushbots.idHandler() {
            @Override
            public void userIDs(String s, String s1) {
                Log.d(TAG, "userIDs: " + s + ", " + s1);
            }
        });




        // Turn on/off the notification
        notSwitcher.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Pushbots.sharedInstance().toggleNotifications(b);

            }
        });


        // Set custom notification handler
//        Pushbots.sharedInstance().setCustomHandler(CustomHandler.class);


        // Set custom data to device, to make easy handle it on dashboard
        Pushbots.setEmail("abc@pushbots.com");
        Pushbots.setName("PUSH BOTS");
        Pushbots.setAlias("PUSHER");
    }
}
