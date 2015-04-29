package com.alejandrocelaya.broadcastreceiver;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

/**
 * Created by cta on 29/04/2015.
 */
public class SaludadorIntetService extends IntentService {

    private static final String ACTION_SALUDAR = "com.alejandrocelaya.intentservice.action.SALUDAR";
    private static final String ACTION_DESPEDIR =
            "com.alejandrocelaya.intentservice.action.DESPEDIR";

    public static final String BROADCAST_ACTION_SALUDAR =
            "com.alejandrocelaya.intentservice.broadcast.action.SALUDAR";
    public static final String BROADCAST_ACTION_DESPEDIR =
            "com.alejandrocelaya.intentservice.broadcast.action.DESPEDIR";
    public static final String EXTRA_PARAM_NOMBRE = "NOMBRE";

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     */
    public SaludadorIntetService() {
        super(SaludadorIntetService.class.getName());
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_SALUDAR.equals(action)) {
                saludar(intent.getStringExtra(EXTRA_PARAM_NOMBRE));
            } else if (ACTION_DESPEDIR.equals(action)) {
                despedir(intent.getStringExtra(EXTRA_PARAM_NOMBRE));
            }
        } else {

        }
    }

    private void saludar(String nombre) {
        broadcast(BROADCAST_ACTION_SALUDAR, nombre);
    }
    private void despedir(String nombre) {
        broadcast(BROADCAST_ACTION_DESPEDIR, nombre);
    }
    private void broadcast(String action, String nombre) {
        Intent i = new Intent(action);
        i.putExtra(EXTRA_PARAM_NOMBRE, nombre);
        sendBroadcast(i);
    }

    public static void startActionSaludar(Context context, String name) {
        startAction(context, ACTION_SALUDAR, name);
    }
    public static void startActionDespedir(Context context, String name) {
        startAction(context, ACTION_DESPEDIR, name);
    }
    private static void startAction(Context context, String action, String name) {
        Intent i = new Intent(context, SaludadorIntetService.class);
        i.setAction(action);
        i.putExtra(EXTRA_PARAM_NOMBRE, name);
        context.startService(i);
    }
}
