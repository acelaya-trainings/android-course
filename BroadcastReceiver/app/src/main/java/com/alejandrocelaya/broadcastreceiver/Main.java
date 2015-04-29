package com.alejandrocelaya.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class Main extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BroadcastReceiver br = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String nombre = intent.getStringExtra(SaludadorIntetService.EXTRA_PARAM_NOMBRE);
                switch (intent.getAction()) {
                    case SaludadorIntetService.BROADCAST_ACTION_SALUDAR:
                        displayToast(context, String.format("Hola %s!!", nombre));
                        break;
                    case SaludadorIntetService.BROADCAST_ACTION_DESPEDIR:
                        displayToast(context, String.format("Adiós %s!!", nombre));
                        break;
                    default:
                }
            }
        };

        IntentFilter filter = new IntentFilter();
        filter.addAction(SaludadorIntetService.BROADCAST_ACTION_SALUDAR);
        filter.addAction(SaludadorIntetService.BROADCAST_ACTION_DESPEDIR);
        filter.addCategory(Intent.CATEGORY_DEFAULT);
        registerReceiver(br, filter);
    }

    private void displayToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.saludar) {
            SaludadorIntetService.startActionSaludar(this, "Alejandro. Saludar");
            return true;
        } else if (id == R.id.despedir) {
            SaludadorIntetService.startActionDespedir(this, "Alejandro. Despedir");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
