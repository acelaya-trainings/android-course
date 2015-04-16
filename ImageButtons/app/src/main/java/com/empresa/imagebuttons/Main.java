package com.empresa.imagebuttons;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.empresa.model.Country;


public class Main extends ActionBarActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton btn = (ImageButton) findViewById(R.id.btnSpain);
        btn.setOnClickListener(this);
        btn = (ImageButton) findViewById(R.id.btnFrance);
        btn.setOnClickListener(this);
        btn = (ImageButton) findViewById(R.id.btnGermany);
        btn.setOnClickListener(this);
        btn = (ImageButton) findViewById(R.id.btnUsa);
        btn.setOnClickListener(this);
        btn = (ImageButton) findViewById(R.id.btnJapan);
        btn.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        int id = v.getId();
        Country c = new Country();
        Intent i = new Intent(this, CountryActivity.class);
        i.putExtra("country", c);

        if (id == R.id.btnSpain) {
            c.setBelongsUe(true);
            c.setName("Spain");
            c.setPopulation(45000000);
        } else if (id == R.id.btnFrance) {
            c.setBelongsUe(true);
            c.setName("France");
            c.setPopulation(46000000);
        } else if (id == R.id.btnGermany) {
            c.setBelongsUe(true);
            c.setName("Germanyn");
            c.setPopulation(47000000);
        } else if (id == R.id.btnJapan) {
            c.setBelongsUe(false);
            c.setName("Japan");
            c.setPopulation(48000000);
        } else if (id == R.id.btnUsa) {
            c.setBelongsUe(false);
            c.setName("USA");
            c.setPopulation(49000000);
        }

        startActivity(i);
    }
}
