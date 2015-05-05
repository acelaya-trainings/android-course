package com.ejercicio6;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class Main extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addProduct(View view) {
        // Add a new birthday record
        ContentValues values = new ContentValues();

        values.put(ProductoProvider.NOMBRE,
                ((EditText)findViewById(R.id.nombre)).getText().toString());

        values.put(ProductoProvider.PRECIO,
                ((EditText)findViewById(R.id.precio)).getText().toString());

        values.put(ProductoProvider.CANTIDAD,
                ((EditText)findViewById(R.id.cantidad)).getText().toString());

        Uri uri = getContentResolver().insert(
                ProductoProvider.CONTENT_URI, values);

        Toast.makeText(getBaseContext(),
                "Application: " + uri.toString() + " inserted!", Toast.LENGTH_LONG).show();
    }


    public void showAllProducts(View view) {
        Intent i = new Intent(this, ProductList.class);
        startActivity(i);
    }
}
