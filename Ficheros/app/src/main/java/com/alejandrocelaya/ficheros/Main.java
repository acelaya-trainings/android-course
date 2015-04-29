package com.alejandrocelaya.ficheros;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button escribirBtn = (Button) findViewById(R.id.escribir);
        Button leerBtn = (Button) findViewById(R.id.leer);
        Button leerRawBtn = (Button) findViewById(R.id.leerRaw);

        final TextView function = (TextView) findViewById(R.id.textView);
        final TextView texto = (TextView) findViewById(R.id.textView2);

        escribirBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    OutputStreamWriter writer = new OutputStreamWriter(
                            new BufferedOutputStream(openFileOutput("prueba_int.txt", MODE_PRIVATE))
                    );
                    writer.write("Esto es un texto de prueba");
                    writer.close();
                    function.setText("Fichero creado");
                } catch (FileNotFoundException e) {
                    function.setText("Fichero no creado");
                    e.printStackTrace();
                } catch (IOException e) {
                    function.setText("Error al escribir en el fichero");
                    e.printStackTrace();
                }
            }
        });

        leerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(openFileInput("prueba_int.txt"))
                    );
                    String cadena = reader.readLine();
                    reader.close();
                    function.setText("Fichero leído");
                    texto.setText(cadena);
                } catch (FileNotFoundException e) {
                    function.setText("Fichero no encontrado");
                    e.printStackTrace();
                } catch (IOException e) {
                    function.setText("Error. El fichero no se puede leer");
                    e.printStackTrace();
                }
            }
        });

        leerRawBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    InputStream input = getResources().openRawResource(R.raw.prueba_raw);
                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                    String linea = reader.readLine();
                    reader.close();
                    function.setText("Fichero RAW leído");
                    texto.setText(linea);
                } catch (IOException e) {
                    function.setText("Error al leer el fichero");
                    e.printStackTrace();
                }
            }
        });
    }

}
