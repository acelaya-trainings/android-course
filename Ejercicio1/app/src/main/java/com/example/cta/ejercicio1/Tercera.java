package com.example.cta.ejercicio1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cta.modelo.Persona;

/**
 * Created by cta on 15/04/2015.
 */
public class Tercera extends ActionBarActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tercera);
        TextView tv = (TextView) findViewById(R.id.texto);
        //tv.setText(getIntent().getExtras().getString("apellidosEnviado"));
        Persona p = (Persona) getIntent().getExtras().getSerializable("apellidosEnviado");
        tv.setText(p.getApellidos());
        Button b = (Button) findViewById(R.id.mensaje);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Tercera.this, Cuarta.class));
            }
        });
    }
}
