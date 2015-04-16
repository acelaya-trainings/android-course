package com.empresa.imagebuttons;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.empresa.model.Country;

/**
 * Created by cta on 16/04/2015.
 */
public class CountryActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);

        Country c = (Country) getIntent().getExtras().getSerializable("country");
        EditText txtName = (EditText) findViewById(R.id.txtName);
        EditText txtPopulation = (EditText) findViewById(R.id.txtPopulation);
        CheckBox chkUe = (CheckBox) findViewById(R.id.chkUe);

        txtName.setText(c.getName());
        txtPopulation.setText(String.valueOf(c.getPopulation()));
        chkUe.setChecked(c.getBelongsUe());
    }
}
