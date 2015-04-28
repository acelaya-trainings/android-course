package com.alejandrocelaya.notifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Main extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                Notification notification = new Notification(
                        android.R.drawable.stat_notify_error,
                        "Se ha producido un error",
                        System.currentTimeMillis()
                );

                CharSequence title = "Esta es nuestra noti";
                CharSequence detalles = "Se ha producido un error";
                Intent i = new Intent(Main.this, Main.class);
                PendingIntent pi = PendingIntent.getActivity(Main.this, 0, i, 0);

                notification.setLatestEventInfo(Main.this, title, detalles, pi);
                nm.notify(0, notification);
            }
        });
    }

}
