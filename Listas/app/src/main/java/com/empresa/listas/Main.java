package com.empresa.listas;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class Main extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setListAdapter(new MiArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                R.id.textView,
                getResources().getStringArray(R.array.animals)
        ));
    }

    private class MiArrayAdapter extends ArrayAdapter<String> {

        public MiArrayAdapter(Context context, int resource, int textViewResourceId, String[] objects) {
            super(context, resource, textViewResourceId, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater)
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = inflater.inflate(R.layout.list_items, parent, false);
            String[] items = getResources().getStringArray(R.array.animals);
            ImageView image = (ImageView) row.findViewById(R.id.imageView);
            TextView text = (TextView) row.findViewById(R.id.textView);
            Button button = (Button) row.findViewById(R.id.button);

            text.setText(items[position]);
            final int imageResource = "Cat".equals(items[position]) ? R.drawable.gatito : R.drawable.perrito;
            image.setImageResource(imageResource);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Main.this, ImageActivity.class);
                    i.putExtra("imageResource", imageResource);
                    startActivity(i);
                }
            });

            return row;
        }
    }
}
