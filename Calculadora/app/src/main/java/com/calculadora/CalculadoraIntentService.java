package com.calculadora;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.view.View;

public class CalculadoraIntentService extends IntentService{

    private static final String ACTION_SUMAR =
            "com.example.intentservice.action.SUMAR";
    private static final String ACTION_RESTAR =
            "com.example.intentservice.action.RESTAR";
    private static final String ACTION_MULTIPLICAR =
            "com.example.intentservice.action.MULTIPLICAR";
    public static final String BROADCAST_ACTION_SUMAR=
            "com.example.intentservice.broadcast.action.SUMAR";
    public static final String BROADCAST_ACTION_RESTAR=
            "com.example.intentservice.broadcast.action.RESTAR";
    public static final String BROADCAST_ACTION_MULTIPLICAR=
            "com.example.intentservice.broadcast.action.MULTIPLICAR";
    public static final String EXTRA_PARAM_NUM1 = "NUM1";
    public static final String EXTRA_PARAM_NUM2 = "NUM2";
    public static final String EXTRA_PARAM_RESULTADO = "RESULTADO";

    public CalculadoraIntentService() {
        super("CalculadoraIntentService");
    }

    public static void startActionSumar
            (Context context, int numero1, int numero2){
        Intent intent = new Intent(context, CalculadoraIntentService.class);
        intent.setAction(ACTION_SUMAR);
        intent.putExtra(EXTRA_PARAM_NUM1, numero1);
        intent.putExtra(EXTRA_PARAM_NUM2, numero2);
        context.startService(intent);
    }

    public static void startActionRestar
            (Context context, int numero1, int numero2){
        Intent intent = new Intent(context, CalculadoraIntentService.class);
        intent.setAction(ACTION_RESTAR);
        intent.putExtra(EXTRA_PARAM_NUM1, numero1);
        intent.putExtra(EXTRA_PARAM_NUM2, numero2);
        context.startService(intent);
    }

    public static void startActionMultiplicar
            (Context context, int numero1, int numero2){
        Intent intent = new Intent(context, CalculadoraIntentService.class);
        intent.setAction(ACTION_MULTIPLICAR);
        intent.putExtra(EXTRA_PARAM_NUM1, numero1);
        intent.putExtra(EXTRA_PARAM_NUM2, numero2);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if(intent!=null){
            String action = intent.getAction();
            if(ACTION_SUMAR.equals(action)){
                int num1 = intent.getIntExtra(EXTRA_PARAM_NUM1, 0);
                int num2 = intent.getIntExtra(EXTRA_PARAM_NUM2, 0);
                sumar(num1, num2);
            }
            else if(ACTION_RESTAR.equals(action)){
                int num1 = intent.getIntExtra(EXTRA_PARAM_NUM1, 0);
                int num2 = intent.getIntExtra(EXTRA_PARAM_NUM2, 0);
                restar(num1, num2);
            }
            else if(ACTION_MULTIPLICAR.equals(action)){
                int num1 = intent.getIntExtra(EXTRA_PARAM_NUM1, 0);
                int num2 = intent.getIntExtra(EXTRA_PARAM_NUM2, 0);
                multiplicar(num1, num2);
            }
        }
    }

    private void multiplicar(int num1, int num2) {
        Intent intent = new Intent(BROADCAST_ACTION_MULTIPLICAR);
        int resultado = num1*num2;
        intent.putExtra(EXTRA_PARAM_RESULTADO, resultado);
        sendBroadcast(intent);
    }

    private void restar(int num1, int num2) {
        Intent intent = new Intent(BROADCAST_ACTION_RESTAR);
        int resultado = num1-num2;
        intent.putExtra(EXTRA_PARAM_RESULTADO, resultado);
        sendBroadcast(intent);
    }

    private void sumar(int num1, int num2) {
        Intent intent = new Intent(BROADCAST_ACTION_SUMAR);
        int resultado = num1+num2;
        intent.putExtra(EXTRA_PARAM_RESULTADO, resultado);
        sendBroadcast(intent);
    }
}
