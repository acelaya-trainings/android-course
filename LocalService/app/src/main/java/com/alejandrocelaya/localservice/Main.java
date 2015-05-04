package com.alejandrocelaya.localservice;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class Main extends ActionBarActivity {

    private MainBinder binder;
    private MainServiceConnection conn = new MainServiceConnection();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent i = new Intent(this, MainService.class);

        switch (id) {
            case R.id.arrancar:
                startService(i);
                break;
            case R.id.enlazar:
                bindService(i, conn, BIND_AUTO_CREATE);
                break;
            case R.id.saludar:
                if (binder != null) {
                    binder.getService().saludo();
                }
                break;
            case R.id.desenlazar:
                unbindService(conn);
                break;
            case R.id.parar:
                stopService(i);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private class MainServiceConnection implements ServiceConnection {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            binder = (MainBinder) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            binder = null;
        }
    }
}
