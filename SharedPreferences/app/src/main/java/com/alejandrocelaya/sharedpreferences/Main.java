package com.alejandrocelaya.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;


public class Main extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button guardar = (Button) findViewById(R.id.button);
        Button cargar = (Button) findViewById(R.id.button2);
        final TextView txtNombre = (TextView) findViewById(R.id.textView);
        final TextView txtEmail = (TextView) findViewById(R.id.textView2);
        final TextView txtEdad = (TextView) findViewById(R.id.textView3);
        final CheckBox checkActivo = (CheckBox) findViewById(R.id.checkBox);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences =
                        getSharedPreferences("MisPreferencias", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();

                editor.putString("nombre", "Alejandro");
                editor.putString("email", "email@domain.com");
                editor.putBoolean("activo", true);
                editor.putInt("edad", 26);
                editor.commit();
            }
        });
        cargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences =
                        getSharedPreferences("MisPreferencias", MODE_PRIVATE);

                txtNombre.setText(preferences.getString("nombre", "Alex"));
                txtEmail.setText(preferences.getString("email", "foo@bar.com"));
                checkActivo.setChecked(preferences.getBoolean("activo", true));
                txtEdad.setText(String.valueOf(preferences.getInt("edad", 100)));
            }
        });
    }

}
