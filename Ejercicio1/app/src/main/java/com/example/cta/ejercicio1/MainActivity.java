package com.example.cta.ejercicio1;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.cta.modelo.Persona;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText et1 = (EditText) findViewById(R.id.cogernombre);
        final EditText et2 = (EditText) findViewById(R.id.cogerapellidos);

        Button b1 = (Button) findViewById(R.id.button1);
        Button b2 = (Button) findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Segunda.class);
                //i.putExtra("nombreEnviado",et1.getText().toString());
                // Con clase persona
                Persona p = new Persona();
                p.setNombre(et1.getText().toString());
                p.setApellidos(et2.getText().toString());
                i.putExtra("nombreEnviado", p);
                //
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Tercera.class);
                //i.putExtra("apellidosEnviado",et2.getText().toString());
                // Con clase persona
                Persona p = new Persona();
                p.setNombre(et1.getText().toString());
                p.setApellidos(et2.getText().toString());
                i.putExtra("apellidosEnviado", p);
                //
                startActivity(i);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
