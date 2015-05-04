package com.alejandrocelaya.localservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

/**
 * Created by cta on 04/05/2015.
 */
public class MainService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return new MainBinder(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Arrancando servicio", Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Toast.makeText(this, "Desenlazando servicio", Toast.LENGTH_SHORT).show();
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Destruyendo servicio", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    public void saludo() {
        Toast.makeText(this, "Hola Alejandro!!", Toast.LENGTH_SHORT).show();
    }
}
