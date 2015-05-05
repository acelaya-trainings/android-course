package com.ejercicio6;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by cta on 04/05/2015.
 */
public class ProductList extends Activity{

    Producto[] productos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista);

        // Show all the birthdays sorted by friend's name
        String URL = "content://com.ejercicio6.ProductoProvider/productos";
        Uri productosUri = Uri.parse(URL);
        Cursor c = getContentResolver().query(productosUri, null, null, null, "nombre");
        Producto result;
        int i = 0;
        productos = new Producto[c.getCount()];
        if (!c.moveToFirst()) {
            Toast.makeText(this, "No datos", Toast.LENGTH_LONG).show();
        }else{
            do{
                result = new Producto();
                result.setNombre(c.getString(c.getColumnIndex(ProductoProvider.NOMBRE)));
                result.setId(Integer.valueOf(c.getString(c.getColumnIndex(ProductoProvider.ID))));
                result.setCantidad(Integer.valueOf(c.getString(c.getColumnIndex(ProductoProvider.CANTIDAD))));
                result.setPrecio(Integer.valueOf(c.getString(c.getColumnIndex(ProductoProvider.PRECIO))));
                productos[i] = result;
                i++;
            } while (c.moveToNext());
        }
        //Recuperar datos
        ListView lista = (ListView) findViewById(R.id.listView);
        lista.setAdapter(new MiArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                R.id.texto,
                productos
        ));
    }


    private class MiArrayAdapter extends ArrayAdapter<Producto> {

        Producto[] objects;

        public MiArrayAdapter(Context context, int resource, int textViewResourceId, Producto[] objects) {
            super(context, resource, textViewResourceId, objects);
            this.objects = objects;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater)
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = inflater.inflate(R.layout.list_item,parent,false);
            TextView tv = (TextView) row.findViewById(R.id.texto);
            tv.setText(objects[position].toString());
            return row;
        }
    }
}
