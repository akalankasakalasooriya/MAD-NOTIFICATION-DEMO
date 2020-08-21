package com.sliitapp.notificationdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button okBtn = findViewById(R.id.button);



        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                    CharSequence name = "Notification";
                    String description = "click to open page";
                    int importance = NotificationManager.IMPORTANCE_DEFAULT;
                    NotificationChannel notificationChannel = new NotificationChannel("80",name,importance);
                    NotificationManager notificationManager = getSystemService(NotificationManager.class);
                    notificationManager.createNotificationChannel(notificationChannel);



                    Intent intent =new Intent(MainActivity.this,Register.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,0,intent,0);
                    NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this,"80")
                            .setSmallIcon(R.drawable.ic_launcher_background)
                            .setContentTitle("My Notification")
                            .setContentText("Hello world")
                            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                            .setContentIntent(pendingIntent)
                            .setAutoCancel(true);


                    NotificationManagerCompat notificationManagerCompat =  NotificationManagerCompat.from(MainActivity.this);
                    notificationManager.notify(0, builder.build());




                }


            }
        });


    }
}