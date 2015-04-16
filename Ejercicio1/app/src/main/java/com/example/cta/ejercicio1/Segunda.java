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
public class Segunda extends ActionBarActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segunda);

        TextView tv = (TextView) findViewById(R.id.texto);
        //tv.setText(getIntent().getExtras().getString("nombreEnviado"));
        Persona p = (Persona) getIntent().getExtras().getSerializable("nombreEnviado");
        tv.setText(p.getNombre());
        Button b = (Button) findViewById(R.id.mensaje);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Segunda.this, Cuarta.class));
            }
        });
    }
}
