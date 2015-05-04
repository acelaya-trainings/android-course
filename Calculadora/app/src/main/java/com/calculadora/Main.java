package com.calculadora;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Main extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText num1 = (EditText) findViewById(R.id.numero1);
        final EditText num2 = (EditText) findViewById(R.id.numero2);
        final TextView resultado = (TextView) findViewById(R.id.resultado);

        BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                int resolucion = intent.getIntExtra
                        (CalculadoraIntentService.EXTRA_PARAM_RESULTADO,0);
                switch (intent.getAction()){
                    case CalculadoraIntentService.BROADCAST_ACTION_SUMAR:
                        resultado.setText(String.valueOf(resolucion));
                        break;
                    case CalculadoraIntentService.BROADCAST_ACTION_RESTAR:
                        resultado.setText(String.valueOf(resolucion));
                        break;
                    case CalculadoraIntentService.BROADCAST_ACTION_MULTIPLICAR:
                        resultado.setText(String.valueOf(resolucion));
                        break;
                }
            }
        };

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(CalculadoraIntentService.BROADCAST_ACTION_SUMAR);
        intentFilter.addAction(CalculadoraIntentService.BROADCAST_ACTION_RESTAR);
        intentFilter.addAction(CalculadoraIntentService.BROADCAST_ACTION_MULTIPLICAR);
        intentFilter.addCategory(Intent.CATEGORY_DEFAULT);
        registerReceiver(receiver, intentFilter);

        Button sumar = (Button) findViewById(R.id.sumar);
        sumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numeroCadena1=num1.getText().toString();
                String numeroCadena2=num2.getText().toString();
                int numero1 =  Integer.parseInt(numeroCadena1);
                int numero2 =  Integer.parseInt(numeroCadena2);
                CalculadoraIntentService.startActionSumar(Main.this,
                        numero1,numero2);
            }
        });

        Button restar = (Button) findViewById(R.id.restar);
        restar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numeroCadena1=num1.getText().toString();
                String numeroCadena2=num2.getText().toString();
                int numero1 =  Integer.parseInt(numeroCadena1);
                int numero2 =  Integer.parseInt(numeroCadena2);
                CalculadoraIntentService.startActionRestar(Main.this,
                        numero1, numero2);
            }
        });
        Button multiplicar = (Button) findViewById(R.id.multiplicar);
        multiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numeroCadena1=num1.getText().toString();
                String numeroCadena2=num2.getText().toString();
                int numero1 =  Integer.parseInt(numeroCadena1);
                int numero2 =  Integer.parseInt(numeroCadena2);
                CalculadoraIntentService.startActionMultiplicar(Main.this,
                        numero1, numero2);
            }
        });
    }
}
